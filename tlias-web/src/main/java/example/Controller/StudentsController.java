package example.Controller;


import example.Service.StudentService;
import example.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result findStu(StudentQueryParam studentQueryParam){
        log.info("分页查询学生");
        //调用Service
        PageResult<Students> student = studentService.findStudent(studentQueryParam);
        return Result.success(student);
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result deleteStu(@PathVariable String ids){
        log.info("批量删除学生");
        // 逗号分割字符串，转Integer List
        List<Integer> idslist = Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        log.info("批量删除学生，ids:{}",ids);
        studentService.deleteStudents(idslist);
        return Result.success();

    }
    @PostMapping
    public Result saveStu(@RequestBody Students students){
        log.info("新增学生");
        studentService.insertStudent(students);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result getStubyId(@PathVariable Integer id){
        log.info("查询回显");
        Students stu=studentService.getstubyId(id);
        return Result.success(stu);

    }
    @PutMapping
    public Result updataStu(@RequestBody Students stu){
        log.info("更新学生数据");
        studentService.updatestu(stu);
        return Result.success();

    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id,
                            @PathVariable Integer score){
        studentService.deductScore(id,score);
        return Result.success();

    }

}
