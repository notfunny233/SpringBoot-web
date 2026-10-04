package tliasadmin.Service;

import tliasadmin.pojo.PageResult;
import tliasadmin.pojo.Policy;
import tliasadmin.pojo.PolicyQueryParam;

import java.util.List;

public interface PolicyService {

    PageResult<Policy> page(PolicyQueryParam policyQueryParam);//分页条件查询
    void save(Policy policy);
    void del(List<Integer> ids);
    Policy getById(Integer id);
    void update(Policy policy);
}
