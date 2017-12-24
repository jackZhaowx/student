package hebei.engineery.univercity.repository;

import hebei.engineery.univercity.domain.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DormitoryRepository extends JpaRepository<Dormitory,Long>,JpaSpecificationExecutor {
}
