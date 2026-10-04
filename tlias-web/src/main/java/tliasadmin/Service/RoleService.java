package tliasadmin.Service;

import tliasadmin.pojo.PageResult;
import tliasadmin.pojo.Role;
import tliasadmin.pojo.RoleQueryParam;

import java.util.List;

public interface RoleService {

    PageResult<Role> page(RoleQueryParam roleQueryParam);//分页条件查询
    void save(Role role);
    void del(List<Integer> ids);
    Role getById(Integer id);
    void update(Role role);
    List<Role> findall();
}
