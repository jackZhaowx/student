package hebei.engineery.univercity.service.impl;

import hebei.engineery.univercity.domain.User;
import hebei.engineery.univercity.repository.UserRepository;
import hebei.engineery.univercity.service.UserService;
import hebei.engineery.univercity.utils.MD5Util;
import hebei.engineery.univercity.web.request.UserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/10.
 */
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findOne(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public String save(UserFormBean userFormBean) throws Exception {
        User user = userRepository.findOneByUserName(userFormBean.getUsername());
        if (user != null) {
            return "NOTNULL";
        } else {
            User uu = new User();
            uu.setUserName(userFormBean.getUsername());
            uu.setPassword(MD5Util.getMD5(userFormBean.getPassword()));
            uu.setNickName(userFormBean.getNickname());
            uu.setCreateTime(new Date());
            userRepository.save(uu);
            return "OK";
        }
    }

    @Override
    public User findOneByUserNameAndPassword(UserFormBean userFormBean) throws Exception {
        return userRepository.findOneByUserNameAndPassword(userFormBean.getUsername(),MD5Util.getMD5(userFormBean.getPassword()));
    }
}
