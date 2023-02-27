package finalcase.service.impl;

import finalcase.api.request.customer.CustomerPostRequest;
import finalcase.api.request.customer.CustomerPutRequest;
import finalcase.api.response.BaseResponse;
import finalcase.api.response.DataResponse;
import finalcase.api.response.SuccessDataResponse;
import finalcase.api.response.SuccessResponse;
import finalcase.constant.CustomerResultMessages;
import finalcase.dto.ApplicationDto;
import finalcase.dto.CustomerDto;
import finalcase.dto.SecurityDepositDto;
import finalcase.exception.NotFoundException;
import finalcase.model.Application;
import finalcase.model.Customer;
import finalcase.model.SecurityDeposit;
import finalcase.model.Wealth;
import finalcase.model.enums.Currency;
import finalcase.repository.CustomerRepository;
import finalcase.repository.WealthRepository;
import finalcase.service.CustomerService;
import finalcase.util.CustomerHelper;
import finalcase.util.GlobalHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerHelper customerHelper;
    private final WealthRepository wealthRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            CustomerHelper customerHelper, WealthRepository wealthRepository,
            ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.customerHelper = customerHelper;
        this.wealthRepository = wealthRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public DataResponse<CustomerDto> create(CustomerPostRequest request) {
        final Customer customer = new Customer();

        customer.setIdentityNumber(request.getIdentityNumber());
        customer.setCreditScore(request.getCreditScore());
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhone(request.getPhone());
        customer.setDateOfBirth(request.getDateOfBirth());
        customer.setCreatedAt(LocalDateTime.now());

        final Customer savedCustomer = customerRepository.save(customer);
        final Wealth wealth = new Wealth();

        wealth.setCustomer(savedCustomer);
        wealth.setBalance(0.0);
        wealth.setCurrency(Currency.TRY);
        wealthRepository.save(wealth);

        final CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);

        return new SuccessDataResponse<>(customerDto, CustomerResultMessages.CREATE_SUCCESS);
    }

    @Override
    public DataResponse<CustomerDto> update(CustomerPutRequest request) {
        final Customer customer = customerHelper.getByIdentityNumber(request.getIdentityNumber());

        customer.setFirstName(request.getFirstName());
        customer.setFirstName(request.getLastName());
        customer.setPhone(request.getLastName());

        final Customer savedCustomer = customerRepository.save(customer);
        final CustomerDto customerDto = modelMapper.map(savedCustomer, CustomerDto.class);

        return new SuccessDataResponse<>(customerDto, CustomerResultMessages.UPDATE_SUCCESS);
    }

    @Override
    public BaseResponse delete(String identityNumber) {
        final Customer customer = customerHelper.getByIdentityNumber(identityNumber);

        customerRepository.delete(customer);

        return new SuccessResponse(CustomerResultMessages.DELETE_SUCCESS);
    }

    @Override
    public DataResponse<List<ApplicationDto>> getApplicationResultByIdentityNumberAndDateOfBirth(String identityNumber,
                                                                                           LocalDate dateOfBirth) {
        final Customer customer = customerRepository.getCustomerByIdentityNumberAndDateOfBirth(identityNumber, dateOfBirth)
                .orElseThrow(() -> new NotFoundException(CustomerResultMessages.APPLICATION_RESULT_LIST_ERROR));

        final List<Application> applicationList = customer.getApplications();
        final List<ApplicationDto> applicationDtoList = GlobalHelper.listDtoConverter(modelMapper,
                applicationList, ApplicationDto.class);

        return new SuccessDataResponse<>(applicationDtoList, CustomerResultMessages.APPLICATION_RESULT_LIST_SUCCESS);
    }

    @Override
    public DataResponse<List<SecurityDepositDto>> getSecurityDepositsByIdentityNumber(String identityNumber) {
        final Customer customer = customerHelper.getByIdentityNumber(identityNumber);
        final List<SecurityDeposit> securityDepositList = customer.getApplications()
                .stream().map(Application::getSecurityDeposit).collect(Collectors.toList());
        final List<SecurityDepositDto> securityDepositDtoList = GlobalHelper.listDtoConverter(modelMapper,
                securityDepositList, SecurityDepositDto.class);

        return new SuccessDataResponse<>(securityDepositDtoList, CustomerResultMessages.SECURITY_DEPOSITS_LIST_SUCCESS);
    }

}
