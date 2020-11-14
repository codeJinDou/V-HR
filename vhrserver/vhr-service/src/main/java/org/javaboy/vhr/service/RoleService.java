package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/11 9:44
 * @CreateTime: 2020-09-11 09:44
 */
@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+ role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRole(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}

 
