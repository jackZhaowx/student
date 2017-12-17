package hebei.engineery.univercity.service.impl;

import hebei.engineery.univercity.service.PartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
public class PartmentServiceImpl implements PartmentService {
}
