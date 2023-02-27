package finalcase.model;

import finalcase.model.abs.BaseModel;
import finalcase.model.enums.ApplicationResult;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application extends BaseModel{
    private Double monthlyIncome;
    private ApplicationResult result;

    //MODEL ASSOCIATIONS
    @ManyToOne
    private Customer customer;

    @OneToOne(
            mappedBy = "application",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private SecurityDeposit securityDeposit;

    @OneToOne(
            mappedBy = "application",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Credit credit;
}
