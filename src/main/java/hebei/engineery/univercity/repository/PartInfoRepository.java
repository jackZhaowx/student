package hebei.engineery.univercity.repository;

import hebei.engineery.univercity.domain.PartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartInfoRepository extends JpaRepository<PartInfo,Long>,JpaSpecificationExecutor {
    @Query(nativeQuery = true,value = "select * from part_info order by id asc limit ?1,?2")
    List<PartInfo> findAllByPage(int start, Integer size);
    @Query(nativeQuery = true,value = "select count(*) from part_info")
    Integer findAllCount();
}
