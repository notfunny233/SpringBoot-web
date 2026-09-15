package example.Mapper;


import example.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Logmapper {

    @Select("select * from operate_log")
    List<OperateLog> loglist();
}
