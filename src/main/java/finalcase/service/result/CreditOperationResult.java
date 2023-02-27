package finalcase.service.result;

import finalcase.model.enums.ApplicationResult;
import lombok.Data;

@Data
public class CreditOperationResult{
    private ApplicationResult result;
    private Double creditLimit;
}