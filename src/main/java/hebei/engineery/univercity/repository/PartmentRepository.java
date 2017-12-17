package hebei.engineery.univercity.repository;

import hebei.engineery.univercity.domain.Partment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PartmentRepository extends JpaRepository<Partment,Long>,JpaSpecificationExecutor {
}
