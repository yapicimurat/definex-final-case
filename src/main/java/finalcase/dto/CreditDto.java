package finalcase.dto;

import finalcase.dto.abs.BaseDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CreditDto extends BaseDto {
    private BigDecimal netValue;
    private LocalDate payStartDate;
    private LocalDate payEndDate;
    private CustomerDto customer;
    private ApplicationDto application;
}
