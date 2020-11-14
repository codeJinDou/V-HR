package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
  /*  Long getTotal(@Param("keywords") String keywords);*/
    Long getTotal(@Param("emp") Employee employee, @Param("beginDatescope") Date[] beginDatescope);

   List<Employee> getEmployeeAll(@Param("page") Integer page, @Param("size") Integer size,@Param("emp") Employee employee,
                                  @Param("beginDatescope") Date[] beginDatescope);

  /*  List<Employee> getEmployeeAll(@Param("page") Integer page, @Param("size") Integer size,@Param("keywords") String keywords);*/



    Integer maxWordID();


    Integer deleteEmps(@Param("id") Integer id);

    Integer addEmps(List<Employee> list);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmpWithSalary(@Param("page") Integer page,@Param("size") Integer size);

    Integer upSalaryWtihEmoById(@Param("eid") Integer eid,@Param("sid") Integer sid);
}