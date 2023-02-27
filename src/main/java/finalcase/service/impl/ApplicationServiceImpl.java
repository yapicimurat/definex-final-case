package finalcase.service.impl;

import finalcase.api.request.application.ApplicationPostRequest;
import finalcase.api.request.customer.CustomerApplicationResultGetRequest;
import finalcase.api.response.DataResponse;
import finalcase.api.response.SuccessDataResponse;
import finalcase.constant.ApplicationResultMessages;
import finalcase.constant.CustomerResultMessages;
import finalcase.dto.ApplicationDto;
import finalcase.model.Application;
import finalcase.model.Credit;
import finalcase.model.Customer;
import finalcase.model.SecurityDeposit;
import finalcase.model.enums.ApplicationResult;
import finalcase.repository.ApplicationRepository;
import finalcase.repository.CustomerRepository;
import finalcase.service.ApplicationService;
import finalcase.service.CreditService;
import finalcase.service.result.CreditOperationResult;
import finalcase.util.CustomerHelper;
import finalcase.util.GlobalHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CustomerRepository customerRepository;
    private final CustomerHelper customerHelper;
    private final CreditService creditService;
    private final ModelMapper modelMapper;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  CustomerRepository customerRepository,
                                  CustomerHelper customerHelper,
                                  CreditService creditService,
                                  ModelMapper modelMapper) {
        this.applicationRepository = applicationRepository;
        this.customerRepository = customerRepository;
        this.customerHelper = customerHelper;
        this.creditService = creditService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public DataResponse<ApplicationDto> create(ApplicationPostRequest request) {
        final Application application = new Application();
        final Customer customer = customerHelper.getByIdentityNumber(request.getIdentityNumber());

        if(Optional.ofNullable(request.getSecurityDepositPostRequest()).isPresent()){
            final SecurityDeposit securityDeposit = new SecurityDeposit();

            securityDeposit.setType(request.getSecurityDepositPostRequest().getType());
            securityDeposit.setValue(request.getSecurityDepositPostRequest().getValue());
            application.setSecurityDeposit(securityDeposit);
            securityDeposit.setApplication(application);
        }

        final CreditOperationResult creditOperationResult = creditService.performCreditCheckOperation(customer.getCreditScore(),
                request.getMonthlyIncome(),
                        request.getSecurityDepositPostRequest());

        application.setMonthlyIncome(request.getMonthlyIncome());
        application.setResult(creditOperationResult.getResult());

        //APPLICATION | CUSTOMER
        //customer.getApplications().add(application);
        application.setCustomer(customer);

        customerRepository.save(customer);

        if(creditOperationResult.getResult() == ApplicationResult.ACCEPTED){

            final Credit credit = new Credit();

            credit.setApplication(application);
            credit.setCustomer(customer);
            credit.setNetValue(creditOperationResult.getCreditLimit());
            credit.setPayStartDate(LocalDate.now());
            credit.setPayEndDate(LocalDate.now().plusYears(1));

            creditService.create(credit);
        }

        final Application savedApplication = applicationRepository.save(application);
        final ApplicationDto applicationDto = modelMapper.map(savedApplication, ApplicationDto.class);

        return new SuccessDataResponse<>(applicationDto, ApplicationResultMessages.APPLICATION_SUCCESS);
    }

    @Override
    public DataResponse<List<ApplicationDto>> getApplicationResultsByCustomerIdentityNumberAndDateOfBirth(
            CustomerApplicationResultGetRequest request
    ) {
        final Customer customer = customerHelper.getCustomerByIdentityNumberAndDateOfBirth(request.getIdentityNumber(),
                request.getDateOfBirth());
        final List<Application> applications = customer.getApplications();
        final List<ApplicationDto> applicationDtos = GlobalHelper.listDtoConverter(modelMapper, applications,
                ApplicationDto.class);

        return new SuccessDataResponse<>(applicationDtos, CustomerResultMessages.APPLICATION_RESULT_LIST_SUCCESS);
    }


}
