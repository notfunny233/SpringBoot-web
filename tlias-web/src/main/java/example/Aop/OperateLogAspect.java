package example.Aop;

import example.Mapper.OperateLogMapper;
import example.pojo.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;


    @Pointcut("@annotation(example.anno.Log)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 记录开始时间
        long start = System.currentTimeMillis();

        // 2. 执行目标方法
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            // 方法抛出异常依然继续记录日志（你也可以选择异常不保存日志）
            throw e;
        }

        // 3. 计算耗时
        long end = System.currentTimeMillis();
        long costTime = end - start;

        // 4. 封装OperateLog实体
        OperateLog operateLog = new OperateLog();
        // 操作人ID：从登录上下文获取，示例为ThreadLocal，替换成你项目的登录工具类
        operateLog.setOperateEmpId(getCurrentEmpId());
        operateLog.setOperateTime(LocalDateTime.now());

        // 获取目标类全类名
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        // 获取方法名
        operateLog.setMethodName(joinPoint.getSignature().getName());
        // 方法参数，转JSON字符串，截断2000字符
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        // 返回值转JSON，截断2000字符
        operateLog.setReturnValue(result != null ? result.toString() : "void");

        operateLog.setCostTime(costTime);

        // 插入数据库
        log.info("记录的操作日志{}",operateLog);
        operateLogMapper.insert(operateLog);

        return result;
    }

    /**
     * 获取当前登录用户ID，根据你项目实际修改！
     * 示例：ThreadLocal工具类存放登录用户信息
     */
    private Integer getCurrentEmpId() {
        // return UserContext.getEmpId();
        return 1; // 临时写死测试，上线替换成真实登录ID
    }
}
