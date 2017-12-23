package hebei.engineery.univercity.service;

import hebei.engineery.univercity.domain.Community;

import java.util.List;

public interface CommunityService {
    List<Community> findAllByPage(int i, Integer partPageSize);

    Integer findAllCount();
}
