package finalcase.service;

import finalcase.api.request.securitydeposit.SecurityDepositPostRequest;
import finalcase.model.Credit;
import finalcase.model.SecurityDeposit;
import finalcase.service.result.CreditOperationResult;

public interface CreditService{

    CreditOperationResult performCreditCheckOperation(int creditScore, double monthlyIncome,
                                                      SecurityDepositPostRequest securityDeposit);

    Credit create(Credit credit);
}
