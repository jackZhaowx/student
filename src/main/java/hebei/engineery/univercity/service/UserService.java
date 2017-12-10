package hebei.engineery.univercity.service;

import hebei.engineery.univercity.domain.User;
import hebei.engineery.univercity.web.request.UserFormBean;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/12/10.
 */
public interface UserService {
    User findOne(Long userId);

    String save(UserFormBean userFormBean) throws Exception;

    User findOneByUserNameAndPassword(UserFormBean userFormBean) throws Exception;
}
