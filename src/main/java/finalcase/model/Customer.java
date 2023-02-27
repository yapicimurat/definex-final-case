package finalcase.model;

import finalcase.model.abs.BaseModel;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends BaseModel {
    @Column(name = "identityNumber", unique = true)
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer creditScore = 0;
    private LocalDate dateOfBirth;

    //MODEL ASSOCIATIONS
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Application> applications;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private Wealth wealth;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Credit> credits;

}
