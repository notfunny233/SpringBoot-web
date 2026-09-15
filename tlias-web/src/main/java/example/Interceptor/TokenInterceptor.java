package example.Interceptor;

import example.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求的URL如果是login直接放行
        String requestURI = request.getRequestURI();
        if(requestURI.contains("login")){
            log.info("登录请求");
            return true;
        }
        //获取请求头中的Token
        String token = request.getHeader("token");

        //检验token是否为空，空则返回401
        if(token==null||token.isEmpty()){
            log.info("token为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//401
            return false;
        }
        //检验token，返回结果
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("非法令牌");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//401
            return false;
        }
        //通过所有检测且不为login请求
        //放行
        log.info("放行");
        return true;
    }



}
