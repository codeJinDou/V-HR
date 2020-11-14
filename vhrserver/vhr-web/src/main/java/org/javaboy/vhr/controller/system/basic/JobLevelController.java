package org.javaboy.vhr.controller.system.basic;



import org.javaboy.vhr.model.JobLevel;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/10 11:37
 * @CreateTime: 2020-09-10 11:37
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getJobLevelsAll(){
        return (List<JobLevel>) jobLevelService.getJobLevelsAll();
    }

    @PostMapping("/")
    public RespBean addJobLevle(@RequestBody JobLevel jobLevel){
        if (jobLevelService.addJobLevle(jobLevel) == 1){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updataJoblevle(@RequestBody JobLevel jobLevel){
        if (jobLevelService.updataJoblevle(jobLevel) == 1){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失敗!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJoblevel(@PathVariable Integer id){
        if (jobLevelService.deleteJoblevel(id) == 1){
            return RespBean.ok("删除成功！");
        }
            return RespBean.error("刪除失敗！");
    }

    @DeleteMapping("/")
    public RespBean deleteJoblevelByIds(Integer[] ids){
        if (jobLevelService.deleteJoblevelByIds(ids) == ids.length){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除成功！");
    }
}

 
