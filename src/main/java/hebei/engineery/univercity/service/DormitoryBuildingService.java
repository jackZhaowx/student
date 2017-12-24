package hebei.engineery.univercity.service;

import hebei.engineery.univercity.domain.DormitoryBuilding;

import java.util.List;

public interface DormitoryBuildingService  {
    List<DormitoryBuilding> findAllByPageAndId(int i, Long id,Integer partPageSize);

    Integer findAllCountByParentId(Long id);

    List<DormitoryBuilding> findAllByPage(int i, Integer partPageSize);

    Integer findAllCount();

    DormitoryBuilding save(DormitoryBuilding building);
}
