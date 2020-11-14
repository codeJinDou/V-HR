package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.HrService;
import org.javaboy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/15 12:30
 * @CreateTime: 2020-09-15 12:30
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;


    @GetMapping("/")
    public List<Hr> getAllHr(String keywords){
        return hrService.getAllHr(keywords);
    }

    @PutMapping("/")
    public RespBean updataHr(@RequestBody Hr hr){
        if (hrService.updataHr(hr) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("修改失败！");
    }

    @GetMapping("/roles")
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean gerAllRoles(Integer hrid,Integer[] rids){
        if (hrService.gerAllRoles(hrid,rids)){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHr(@PathVariable Integer id){
        if (hrService.deleteHr(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}

 
