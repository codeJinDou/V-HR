package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.*;
import org.javaboy.vhr.utils.POIutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/16 15:28
 * @CreateTime: 2020-09-16 15:28
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NationService nationService;

    @Autowired
    PoliticsstatusService politicsstatusService;

    @Autowired
    JobLevelService jobLevelService;

    @Autowired
    PositionService positionService;

    @Autowired
    private DeparmentService deparmentService;
   @GetMapping("/")
    public RespPageBean getEmployeeAll(@RequestParam(defaultValue ="1") Integer page,@RequestParam(defaultValue="10") Integer size,Employee employee,Date[] beginDatescope){
        return employeeService.getEmployeeAll(page,size,employee,beginDatescope);
    }
/*    @GetMapping("/")
    public RespPageBean getEmployeeAll(@RequestParam(defaultValue ="1") Integer page,@RequestParam(defaultValue="10") Integer size,String keywords){
        return employeeService.getEmployeeAll(page,size,keywords);
    }*/

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee emp){
        if (employeeService.addEmp(emp) == 1){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @GetMapping("/nations/")
    public List<Nation> getAllNation(){
        return nationService.getAllNation();
    }

    @GetMapping("/politicsstatus/")
    public List<Politicsstatus> getAllPosta(){
        return politicsstatusService.getAllPosta();
    }

    @GetMapping("/joblevels/")
    public List<JobLevel> getJobLevelsAll(){
        return jobLevelService.getJobLevelsAll();
    }

    @GetMapping("/positions/")
    public List<Position> getAllPos(){
        return positionService.getAllPosition();
    }

    @GetMapping("/maxWorkID/")
    public String maxWordID(){
        return String.format("%08d",employeeService.maxWordID()+1);
    }

    @GetMapping("/deps/")
    public List<Department> addDeps(){
        return deparmentService.addDeps();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmps(@PathVariable("id") Integer id){
        if (employeeService.deleteEmps(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    public RespBean updataEmps(@RequestBody Employee employee){
            if (employeeService.updataEmps(employee) == 1){
                return RespBean.ok("编辑成功！");
            }
            return RespBean.error("编辑失败！");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> ExportEx(){
        List<Employee> list = employeeService.getEmployeeAll(null,null,null,null).getData();
        return POIutils.export2ex(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIutils.excel2Employee(file,nationService.getAllNation(),politicsstatusService.getAllPosta(),
                deparmentService.getDeparmentAllWithChildren(), positionService.getAllPosition(),jobLevelService.getJobLevelsAll());

        if (employeeService.addEmps(list) == list.size()){
            return RespBean.ok("添加成功!");
        }
        return RespBean.ok("添加失败!");
    }
}

 
