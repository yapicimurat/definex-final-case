package finalcase.model;

import finalcase.model.abs.BaseModel;
import finalcase.model.enums.RoleType;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseModel{
    private RoleType type;
}
