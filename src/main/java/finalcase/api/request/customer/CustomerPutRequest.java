package finalcase.api.request.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPutRequest {
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String phone;
}
