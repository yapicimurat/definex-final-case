package finalcase.model;

import finalcase.model.abs.BaseModel;
import finalcase.model.enums.Currency;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wealth extends BaseModel {
    private Double balance;
    private Currency currency;


    //MODEL ASSOCIATIONS
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
