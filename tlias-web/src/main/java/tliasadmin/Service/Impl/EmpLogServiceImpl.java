package tliasadmin.Service.Impl;

import tliasadmin.Mapper.EmpLogMapper;
import tliasadmin.Service.EmpLogService;
import tliasadmin.pojo.EmpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)//无论如何都会创建一个并加入一个新的事务管理
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}