package finalcase.api.request.application;

import finalcase.api.request.securitydeposit.SecurityDepositPostRequest;
import lombok.Data;

@Data
public class ApplicationPostRequest {
    private String identityNumber;
    private SecurityDepositPostRequest securityDepositPostRequest;
    private Double monthlyIncome;
}
