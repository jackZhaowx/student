package hebei.engineery.univercity.repository;

import hebei.engineery.univercity.domain.LoginRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoginRecordRepository extends JpaRepository<LoginRecord,Long>,JpaSpecificationExecutor{
    LoginRecord findOneByUserId(Long id);
}
