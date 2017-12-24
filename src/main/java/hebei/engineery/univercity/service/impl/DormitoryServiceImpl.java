package hebei.engineery.univercity.service.impl;

import hebei.engineery.univercity.domain.Dormitory;
import hebei.engineery.univercity.repository.DormitoryRepository;
import hebei.engineery.univercity.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    DormitoryRepository dormitoryRepository;
    @Override
    public Dormitory findOne(Long id) {
        return dormitoryRepository.findOne(id);
    }
}
