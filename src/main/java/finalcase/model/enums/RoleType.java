package finalcase.model.enums;

import lombok.Getter;

@Getter
public enum RoleType {
    ADMIN("ADMIN"),
    NORMAL("NORMAL");

    private String roleName;
    private RoleType(String roleName){
        this.roleName = roleName;
    }


}
