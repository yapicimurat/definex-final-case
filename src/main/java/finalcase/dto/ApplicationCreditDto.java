package finalcase.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ApplicationCreditDto {
    private BigDecimal netValue;
    private LocalDate payStartDate;
    private LocalDate payEndDate;
    private CustomerDto customer;
}
