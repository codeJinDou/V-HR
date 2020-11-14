package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.mapper.MenuMapper;
import org.javaboy.vhr.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/5/30 22:21
 * @CreateTime: 2020-05-30 22:21
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Integer> getMenuByRoles(Integer rid) {
        return menuMapper.getMenuByRoles(rid);
    }

    public List<Menu> getMenusHrById() {
        return menuMapper.getMenusHrById(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    public List<Menu> getAllMenusWithRoles(){
       return menuMapper.getAllMenusWithRoles();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @Transactional
    public boolean updataMenu(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteMenuByRid(rid);
        if (mids.length == 0 || mids == null){
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid,mids);
        return result == mids.length;
    }
}

 
