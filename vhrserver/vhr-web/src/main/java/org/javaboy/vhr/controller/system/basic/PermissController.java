package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.MenuService;
import org.javaboy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/11 9:44
 * @CreateTime: 2020-09-11 09:44
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMenuByRoles(Integer rid){
        return menuService.getMenuByRoles(rid);
    }

    @PutMapping("/")
    public RespBean updataMenu(Integer rid,Integer[] mids){
        if (menuService.updataMenu(rid,mids)){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }


    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role) == 1){
            RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid){
        if (roleService.deleteRole(rid) == 1){
            RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}

 
