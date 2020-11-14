package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.SalaryMapper;
import org.javaboy.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/25 15:16
 * @CreateTime: 2020-09-25 15:16
 */
@Service
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;

    public  List<Salary> getAllSalary() {
        return salaryMapper.getAllSalary();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer upSalaryById(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

    public Integer deleteSalary(Integer id) {
        Salary salary = new Salary();
        salary.setCreateDate(new Date());
        return salaryMapper.deleteByPrimaryKey(id);
    }
}

 
