package hebei.engineery.univercity.service.impl;

import hebei.engineery.univercity.domain.Community;
import hebei.engineery.univercity.repository.CommunityRepository;
import hebei.engineery.univercity.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    CommunityRepository communityRepository;
    @Override
    public List<Community> findAllByPage(int i, Integer partPageSize) {
        return communityRepository.findAllByPage((i-1)*partPageSize,partPageSize);
    }

    @Override
    public Integer findAllCount() {
        return communityRepository.findAllCount();
    }
}
