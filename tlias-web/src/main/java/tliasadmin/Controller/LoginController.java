package tliasadmin.Controller;


import tliasadmin.Service.EmpService;
import tliasadmin.pojo.Emp;
import tliasadmin.pojo.Logininfo;
import tliasadmin.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController{

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("登录参数{}", emp);
        Logininfo login = empService.login(emp);
        if(login!=null){
            return Result.success(login);
        }
        return Result.error("用户名或密码错误");
    }
}