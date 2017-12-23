package hebei.engineery.univercity.repository;

import hebei.engineery.univercity.domain.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community,Long>,JpaSpecificationExecutor {
    @Query(nativeQuery = true,value = "select * from community order by id asc limit ?1,?2")
    List<Community> findAllByPage(int start, Integer size);
    @Query(nativeQuery = true,value = "select count(*) from community")
    Integer findAllCount();
}
