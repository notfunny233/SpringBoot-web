package example.Config;

import example.Interceptor.DemoInterceptor;
import example.Interceptor.TokenInterceptor;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//标识这是配置类，底层封装了@Component
//@Configuration
//public class Webconfig implements WebMvcConfigurer {

   /* @Autowired
    private DemoInterceptor demoInterceptor;//注入拦截器*/
//
//    @Autowired
//    private TokenInterceptor tokenInterceptor;//注入拦截器
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");//拦截所有请求
//    }
//}
