package hebei.engineery.univercity.repository;

import hebei.engineery.univercity.domain.DormitoryBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DormitoryBuildingRepository extends JpaRepository<DormitoryBuilding, Long>, JpaSpecificationExecutor {
    @Query(nativeQuery = true, value = "select * from dormitory_building where parent_id=?1 order by id asc limit ?2,?3")
    List<DormitoryBuilding> findAllByPageAndId(Long id, int i, Integer partPageSize);

    @Query(nativeQuery = true, value = "select count(*) from dormitory_building where parent_id=?1")
    Integer findAllCountByParentId(Long id);

    @Query(nativeQuery = true, value = "select * from dormitory_building order by parent_id asc limit ?1,?2")
    List<DormitoryBuilding> findAllByPage(int i, Integer partPageSize);

    @Query(nativeQuery = true, value = "select count(*) from dormitory_building")
    Integer findAllCount();
}
