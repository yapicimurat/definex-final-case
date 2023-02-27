package finalcase.model;

import finalcase.model.abs.BaseModel;
import finalcase.model.enums.RoleType;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private RoleType roleType;
}
