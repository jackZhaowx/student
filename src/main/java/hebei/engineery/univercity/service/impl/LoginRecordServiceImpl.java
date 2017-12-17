package hebei.engineery.univercity.service.impl;

import hebei.engineery.univercity.domain.LoginRecord;
import hebei.engineery.univercity.repository.LoginRecordRepository;
import hebei.engineery.univercity.service.LoginRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class LoginRecordServiceImpl implements LoginRecordService {
    @Autowired
    LoginRecordRepository loginRecordRepository;

    @Override
    public LoginRecord findOneByUserId(Long id) {
        return loginRecordRepository.findOneByUserId(id);
    }

    @Override
    public void save(LoginRecord loginRecord) {
        loginRecordRepository.save(loginRecord);
    }
}
