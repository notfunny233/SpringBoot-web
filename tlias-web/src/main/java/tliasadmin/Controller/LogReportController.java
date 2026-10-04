package tliasadmin.Controller;

import com.github.pagehelper.PageInfo;
import tliasadmin.Service.LogService;
import tliasadmin.anno.RequiresPermission;
import tliasadmin.pojo.LogQueryParam;
import tliasadmin.pojo.OperateLog;
import tliasadmin.pojo.PageResult;
import tliasadmin.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log/page")
public class LogReportController {

    @Autowired
    private LogService logService;

    @RequiresPermission("log:list")
    @GetMapping
    public Result LogPage(LogQueryParam logQueryParam){
        log.info("日志分页查询");
        PageResult<OperateLog> logpageInfo = logService.Page(logQueryParam);
        return Result.success(logpageInfo);

    }
}
