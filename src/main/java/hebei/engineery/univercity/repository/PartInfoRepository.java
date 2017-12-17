package hebei.engineery.univercity.repository;

import hebei.engineery.univercity.domain.PartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PartInfoRepository extends JpaRepository<PartInfo,Long>,JpaSpecificationExecutor {
}
