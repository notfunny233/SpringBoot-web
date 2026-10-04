package tliasadmin.Service;

import com.github.pagehelper.PageInfo;
import tliasadmin.pojo.LogQueryParam;
import tliasadmin.pojo.OperateLog;
import tliasadmin.pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> Page(LogQueryParam logQueryParam);
}
