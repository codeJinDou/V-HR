package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Department;

import java.util.List;

public interface DepartmentMapper {



    List<Department> getDeparmentAllWithChildren();

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getDeparmentAllByDepartId(Integer pid);

    Integer addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> addDeps();
}