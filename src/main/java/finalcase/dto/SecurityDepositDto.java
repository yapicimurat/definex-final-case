package finalcase.dto;

import finalcase.dto.abs.BaseDto;
import finalcase.model.enums.SecurityDepositType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SecurityDepositDto extends BaseDto {
    private SecurityDepositType type;
    private BigDecimal value;
}
