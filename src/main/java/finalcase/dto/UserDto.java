package finalcase.dto;

import finalcase.model.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private RoleType roleType;

}
