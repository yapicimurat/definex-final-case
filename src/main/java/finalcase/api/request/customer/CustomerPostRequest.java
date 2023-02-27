package finalcase.api.request.customer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerPostRequest {
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer creditScore;
    private LocalDate dateOfBirth;

}
