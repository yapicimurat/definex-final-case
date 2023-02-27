package finalcase.dto;

import finalcase.dto.abs.BaseDto;
import finalcase.model.enums.ApplicationResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationDto extends BaseDto {
    private ApplicationResult result;
    private SecurityDepositDto securityDeposit;
    private ApplicationCreditDto credit;

}
