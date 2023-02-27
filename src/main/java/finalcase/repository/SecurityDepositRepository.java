package finalcase.repository;


import finalcase.model.SecurityDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface SecurityDepositRepository extends JpaRepository<SecurityDeposit, UUID> {
}
