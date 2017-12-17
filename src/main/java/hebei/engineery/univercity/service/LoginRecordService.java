package hebei.engineery.univercity.service;

import hebei.engineery.univercity.domain.LoginRecord;

public interface LoginRecordService {
    LoginRecord findOneByUserId(Long id);

    void save(LoginRecord loginRecord);
}
