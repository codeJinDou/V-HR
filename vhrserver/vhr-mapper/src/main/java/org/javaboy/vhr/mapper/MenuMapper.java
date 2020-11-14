package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Menu;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MenuMapper {


      List<Menu> getMenusHrById(Integer hrid);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);


    List<Menu> getAllMenusWithRoles();

    List<Menu> getAllMenus();

    List<Integer> getMenuByRoles(@PathVariable Integer rid);

}