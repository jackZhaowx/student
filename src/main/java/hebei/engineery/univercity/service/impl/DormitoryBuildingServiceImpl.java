package hebei.engineery.univercity.service.impl;

import hebei.engineery.univercity.domain.DormitoryBuilding;
import hebei.engineery.univercity.repository.DormitoryBuildingRepository;
import hebei.engineery.univercity.service.DormitoryBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class DormitoryBuildingServiceImpl implements DormitoryBuildingService {
    @Autowired
    DormitoryBuildingRepository dormitoryBuildingRepository;

    @Override
    public List<DormitoryBuilding> findAllByPageAndId(int i, Long id, Integer partPageSize) {
        return dormitoryBuildingRepository.findAllByPageAndId(id, (i - 1) * partPageSize, partPageSize);
    }

    @Override
    public Integer findAllCountByParentId(Long id) {
        return dormitoryBuildingRepository.findAllCountByParentId(id);
    }

    @Override
    public List<DormitoryBuilding> findAllByPage(int i, Integer partPageSize) {
        return dormitoryBuildingRepository.findAllByPage((i - 1) * partPageSize, partPageSize);
    }

    @Override
    public Integer findAllCount() {
        return dormitoryBuildingRepository.findAllCount();
    }

    @Override
    public DormitoryBuilding save(DormitoryBuilding building) {
        return dormitoryBuildingRepository.save(building);
    }
}
