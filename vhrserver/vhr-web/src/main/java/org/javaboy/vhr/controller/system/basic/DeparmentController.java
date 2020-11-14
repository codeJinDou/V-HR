package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.Department;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/14 9:25
 * @CreateTime: 2020-09-14 09:25
 */
@RestController
@RequestMapping("/system/basic/department")
public class DeparmentController {

    @Autowired
    DeparmentService deparmentService;

    @GetMapping("/")
    public List<Department> getDeparmentAll(){
        return deparmentService.getDeparmentAll();
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep){
        deparmentService.addDep(dep);
        if (dep.getResult() == 1){
            return RespBean.ok("添加成功!",dep);
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id){
        Department dep = new Department();
        dep.setId(id);
        deparmentService.deleteDepById(dep);
        if (dep.getResult() == -2){
            return RespBean.error("该部门下面有子部门,删除失败！");
        }else if (dep.getResult() == -1){
            return RespBean.error("该部门下面有员工,删除失败!");
        }else if (dep.getResult() == 1){
             return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}

 
