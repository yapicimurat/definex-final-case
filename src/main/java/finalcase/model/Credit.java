package finalcase.model;

import finalcase.model.abs.BaseModel;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credit extends BaseModel {
    private Double netValue;
    private LocalDate payStartDate;
    private LocalDate payEndDate;


    //MODEL ASSOCIATIONS
    @ManyToOne
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicationId")
    private Application application;

}
