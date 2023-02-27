package finalcase.api.request.customer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerApplicationResultGetRequest {
    private String identityNumber;
    private LocalDate dateOfBirth;
}
