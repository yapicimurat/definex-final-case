package finalcase.api.request.user;

import finalcase.model.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private RoleType roleType;
}
