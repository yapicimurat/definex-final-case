package finalcase.service.impl;

import finalcase.api.request.securitydeposit.SecurityDepositPostRequest;
import finalcase.constant.Credit;
import finalcase.model.SecurityDeposit;
import finalcase.model.enums.ApplicationResult;
import finalcase.repository.CreditRepository;
import finalcase.service.CreditService;
import finalcase.service.result.CreditOperationResult;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public CreditOperationResult performCreditCheckOperation(int creditScore, double monthlyIncome,
                                                             SecurityDepositPostRequest securityDeposit) {
        final CreditOperationResult creditOperationResult = new CreditOperationResult();

        if(creditScore < 500){
            creditOperationResult.setResult(ApplicationResult.REJECTED);
            return creditOperationResult;
        }

        creditOperationResult.setResult(ApplicationResult.ACCEPTED);

        if(creditScore < 1000){

            if(monthlyIncome < 5000){

                creditOperationResult.setCreditLimit(10000.0);
                if(Optional.ofNullable(securityDeposit).isPresent()){
                    creditOperationResult.setCreditLimit(10000.0 + securityDeposit.getValue() * 0.10);
                }

            }else if(monthlyIncome > 5000 && monthlyIncome < 10000){

                creditOperationResult.setCreditLimit(20000.0);
                if(Optional.ofNullable(securityDeposit).isPresent()){
                    creditOperationResult.setCreditLimit(20000.0 + securityDeposit.getValue() * 0.20);
                }
            }
            else if(monthlyIncome > 10000){
                final double calculatedValue = monthlyIncome * Credit.CREDIT_LIMIT_MULTIPLIER / 2;

                creditOperationResult.setCreditLimit(calculatedValue);
                if(Optional.ofNullable(securityDeposit).isPresent()){
                    creditOperationResult.setCreditLimit(calculatedValue + securityDeposit.getValue() * 0.25);
                }
            }
        }
        else{
            final double calculatedValue = monthlyIncome * Credit.CREDIT_LIMIT_MULTIPLIER;

            creditOperationResult.setCreditLimit(calculatedValue);

            if(Optional.ofNullable(securityDeposit).isPresent()){
                creditOperationResult.setCreditLimit(calculatedValue + securityDeposit.getValue() * 0.5);
            }
        }

        return creditOperationResult;
    }

    @Override
    public finalcase.model.Credit create(finalcase.model.Credit credit) {
        return creditRepository.save(credit);
    }
}
