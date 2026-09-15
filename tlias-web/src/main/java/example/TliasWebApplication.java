package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan//开启了Springboot对Servlet组件的支持
@SpringBootApplication
public class TliasWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebApplication.class, args);
    }

}
