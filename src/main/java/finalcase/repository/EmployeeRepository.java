package finalcase.repository;

import finalcase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface EmployeeRepository extends JpaRepository<User, UUID> {
}
