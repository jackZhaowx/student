package hebei.engineery.univercity.service;

import hebei.engineery.univercity.domain.PartInfo;
import hebei.engineery.univercity.web.response.PartResult;

import java.util.List;

public interface PartInfoService {
    List<PartInfo> findAllByPage(int i, Integer partPageSize);

    Integer findAllCount();
}
