package finalcase.api.request.securitydeposit;

import finalcase.model.enums.SecurityDepositType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SecurityDepositPostRequest {
    private SecurityDepositType type;
    private Double value;
}
