package finalcase.model;

import finalcase.model.abs.BaseModel;
import finalcase.model.enums.SecurityDepositType;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurityDeposit extends BaseModel {
    private SecurityDepositType type;
    private Double value;

    //MODEL ASSOCIATIONS
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicationId")
    private Application application;

}
