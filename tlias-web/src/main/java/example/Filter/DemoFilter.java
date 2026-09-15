package example.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter("/*")//拦截所有请求
public class DemoFilter implements Filter {

    //初始化方法，只在Web服务器启动的时候执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化方法");
    }

    //过滤方法，拦截到请求后执行，执行多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到请求");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);

    }

    //销毁方法释放资源，只在Web服务器关闭的时候执行，只执行一次
    @Override
    public void destroy() {
        log.info("销毁方法");
    }
}

