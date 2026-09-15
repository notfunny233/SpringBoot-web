package example.Controller;



import example.Service.ReprotService;
import example.Service.StudentService;
import example.pojo.CountData;
import example.pojo.EmpGender;
import example.pojo.JobOption;
import example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("report")
@RestController
public class ReportController {

    @Autowired
    private ReprotService reportService;
    @Autowired
    private StudentService studentService;

    //统计员工职位人数
    @GetMapping("/empJobData")
    public Result empJobData(){
        log.info("返回员工信息统计数据");
        JobOption jobOption =reportService.empJobData();
        return Result.success(jobOption);
    }

    //统计员工性别人数
    @GetMapping("/empGenderData")
    public Result empGenderData(){
        log.info("返回员工性别统计数据");
        List<EmpGender> genderOption =reportService.empGenderData();
        return Result.success(genderOption);
    }

    @GetMapping("/studentDegreeData")
    public Result studentDegreeData(){
        log.info("返回学员学历姓名");
        List<Map<String,Integer>> DegreeData = studentService.studentDegreeData();
        return Result.success(DegreeData);

    }

    @GetMapping("/studentCountData")
    public Result studentCountData(){
        log.info("返回班级学员数量");
        CountData countData = studentService.studentCountData();
        return Result.success(countData);

    }
}
