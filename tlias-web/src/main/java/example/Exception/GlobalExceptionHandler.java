package example.Exception;

import example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice//标识这个类是全局异常处理器，对所有@RestController控制器生效。
public class GlobalExceptionHandler {
    @ExceptionHandler//异常处理的方法
    public Result handleException(Exception e){//Exception所有异常
        log.error("全局异常处理器，拦截到异常", e);
        return Result.error("对不起,服务器异常,请稍后重试");
    }
}
