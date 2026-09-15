package example.Service;

import com.github.pagehelper.PageInfo;
import example.pojo.LogQueryParam;
import example.pojo.OperateLog;
import example.pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> Page(LogQueryParam logQueryParam);
}
