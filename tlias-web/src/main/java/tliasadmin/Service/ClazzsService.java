package tliasadmin.Service;

import tliasadmin.pojo.Clazz;
import tliasadmin.pojo.ClazzQueryParam;
import tliasadmin.pojo.PageResult;

import java.util.List;

public interface ClazzsService {
    PageResult<Clazz> getclasslist(ClazzQueryParam clazzQueryParam);

    void deleteClazz(String id);

    void saveClazz(Clazz clazz);

    Clazz getClazzbyID(Integer id);

    void updateClazz(Clazz clazz);

    List<Clazz> findall();
}
