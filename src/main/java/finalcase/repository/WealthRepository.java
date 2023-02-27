package finalcase.repository;

import finalcase.model.Wealth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface WealthRepository extends JpaRepository<Wealth, UUID> {
}
