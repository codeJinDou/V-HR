package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Department;
import org.javaboy.vhr.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/14 9:28
 * @CreateTime: 2020-09-14 09:28
 */
@Service
public class DeparmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getDeparmentAll() {
        return departmentMapper.getDeparmentAllByDepartId(-1);
    }

    public Integer addDep(Department dep) {
        dep.setEnabled(true);
        return departmentMapper.addDep(dep);
    }

    public void deleteDepById(Department dep) {
         departmentMapper.deleteDepById(dep);
    }

    public List<Department> addDeps() {
        return departmentMapper.addDeps();
    }

    public List<Department> getDeparmentAllWithChildren() {
        return departmentMapper.getDeparmentAllWithChildren();
    }
}

 
