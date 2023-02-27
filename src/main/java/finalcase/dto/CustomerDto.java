package finalcase.dto;

import finalcase.dto.abs.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerDto extends BaseDto {
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer creditScore;
    private LocalDate dateOfBirth;
}
