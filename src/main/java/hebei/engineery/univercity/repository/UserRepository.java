package hebei.engineery.univercity.repository;

import hebei.engineery.univercity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Administrator on 2017/12/10.
 */
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor {
    User findOneByUserName(String username);
    User findOneByUserNameAndPassword(String username, String password);
}
