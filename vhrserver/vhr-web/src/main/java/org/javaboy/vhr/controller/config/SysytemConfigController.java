package org.javaboy.vhr.controller.config;

import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/5/30 22:17
 * @CreateTime: 2020-05-30 22:17
 */
@RestController
@RequestMapping(value = "/system/config")
public class SysytemConfigController {

    @Autowired
    MenuService menuService;
    @GetMapping("/menu")
    public List<Menu> getMenusHrById(){
        return menuService.getMenusHrById();
    }
}

 
