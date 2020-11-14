package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/16 15:30
 * @CreateTime: 2020-09-16 15:30
 */
@Service
public class EmployeeService {
    public static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;
    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##,00");

    public Integer upSalaryWtihEmoById(Integer eid, Integer sid) {
        return employeeMapper.upSalaryWtihEmoById(eid,sid);
    }


    public RespPageBean getEmployeeAll(Integer page, Integer size,Employee employee,Date[] beginDatescope) {
        if (page != null && size != null){
            page = (page -1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeAll(page,size,employee,beginDatescope);
        Long total = employeeMapper.getTotal(employee,beginDatescope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee emp) {
        Date beginContract = emp.getBeginContract();
        Date endContract = emp.getEndContract();
        double data = (Double.parseDouble(year.format(endContract)) - Double.parseDouble(year.format(beginContract))) * 12 - (Double.parseDouble(month.format(endContract)) -
                Double.parseDouble(month.format(beginContract)));
        emp.setContractTerm(Double.parseDouble(decimalFormat.format(data/12)));
        int result = employeeMapper.insertSelective(emp);
        if (result == 1){
            Employee employee = employeeMapper.getEmployeeById(emp.getId());
            rabbitTemplate.convertAndSend("Hello,mail,welcome",employee);
            log.info(employee.toString());
        }
        return result;
    }

    public Integer maxWordID() {
        return employeeMapper.maxWordID();
    }

    public Integer deleteEmps(Integer id) {
        return employeeMapper.deleteEmps(id);
    }

    public Integer updataEmps(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }

    public RespPageBean getAllEmpWithSalary(Integer page, Integer size) {
        if (page != null && size != null){
            page=(page -1)* size;
        }
        List<Employee> list = employeeMapper.getAllEmpWithSalary(page,size);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(employeeMapper.getTotal(null,null));
        return respPageBean;
    }
}

 
