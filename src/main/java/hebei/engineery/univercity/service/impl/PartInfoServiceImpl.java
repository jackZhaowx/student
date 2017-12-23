package hebei.engineery.univercity.service.impl;

import hebei.engineery.univercity.domain.PartInfo;
import hebei.engineery.univercity.repository.PartInfoRepository;
import hebei.engineery.univercity.service.PartInfoService;
import hebei.engineery.univercity.web.response.PartResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class PartInfoServiceImpl implements PartInfoService {
    @Autowired
    PartInfoRepository partInfoRepository;
    @Override
    public List<PartInfo> findAllByPage(int i, Integer partPageSize) {
        return partInfoRepository.findAllByPage((i-1)*partPageSize,partPageSize);
    }

    @Override
    public Integer findAllCount() {
        return partInfoRepository.findAllCount();
    }
}
