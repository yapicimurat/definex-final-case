package finalcase.repository;

import finalcase.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> getCustomerByIdentityNumber(String identityNumber);
    Optional<Customer> getCustomerByIdentityNumberAndDateOfBirth(String identityNumber, LocalDate dateOfBirth);

}
