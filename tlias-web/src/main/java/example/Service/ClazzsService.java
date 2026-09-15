package example.Service;

import example.pojo.Clazz;
import example.pojo.ClazzQueryParam;
import example.pojo.PageResult;

import java.util.List;

public interface ClazzsService {
    PageResult<Clazz> getclasslist(ClazzQueryParam clazzQueryParam);

    void deleteClazz(String id);

    void saveClazz(Clazz clazz);

    Clazz getClazzbyID(Integer id);

    void updateClazz(Clazz clazz);

    List<Clazz> findall();
}
