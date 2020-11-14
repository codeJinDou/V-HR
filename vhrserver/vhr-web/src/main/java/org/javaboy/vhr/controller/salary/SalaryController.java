package org.javaboy.vhr.controller.salary;

import com.alibaba.druid.sql.visitor.functions.If;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Salary;
import org.javaboy.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/25 15:14
 * @CreateTime: 2020-09-25 15:14
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {

    @Autowired
    SalaryService salaryService;
    @GetMapping("/")
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary){
        if (salaryService.addSalary(salary) == 1){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean upSalaryById(@RequestBody Salary salary){
        if (salaryService.upSalaryById(salary) == 1){
            return RespBean.ok("修改成功!");
        }
        return RespBean.error("修改失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable Integer id){
        if (salaryService.deleteSalary(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}

 
