package finalcase.repository;

import finalcase.model.Application;
import finalcase.model.enums.ApplicationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;


public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> getApplicationsByResult(ApplicationResult result);

}
