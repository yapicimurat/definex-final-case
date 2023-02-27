package finalcase.repository;

import finalcase.model.Application;
import finalcase.model.Credit;
import finalcase.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CreditRepository extends JpaRepository<Credit, UUID> {
    List<Credit> getAllByCustomer(Customer customer);
    Optional<Credit> getByApplication(Application application);
    Optional<Credit> findById(UUID id);
    List<Credit> getAllByNetValueGreaterThan(BigDecimal value);
    List<Credit> getAllByNetValueLessThan(BigDecimal value);

}
