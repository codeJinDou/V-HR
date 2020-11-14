package org.javaboy.vhr.controller.salary;

import org.javaboy.vhr.model.EmpSalary;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.Salary;
import org.javaboy.vhr.service.EmpSalaryService;
import org.javaboy.vhr.service.EmployeeService;
import org.javaboy.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/26 10:36
 * @CreateTime: 2020-09-26 10:36
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class empSalaryController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getAllEmpWithSalary(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size){
        return employeeService.getAllEmpWithSalary(page,size);
    }

    @GetMapping("/salary")
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @PutMapping("/")
    public RespBean upSalaryWtihEmoById(Integer eid,Integer sid){
        Integer result = employeeService.upSalaryWtihEmoById(eid,sid);
        if (result == 1 || result == 2){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败!");
    }

}

 
