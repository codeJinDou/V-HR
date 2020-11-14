package org.javaboy.vhr.service;

import org.javaboy.vhr.model.JobLevel;
import org.javaboy.vhr.mapper.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/10 11:41
 * @CreateTime: 2020-09-10 11:41
 */
@Service
public class JobLevelService {
    @Autowired
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getJobLevelsAll() {
        return jobLevelMapper.getJobLevelsAll();
    }

    public Integer addJobLevle(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updataJoblevle(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJoblevel(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJoblevelByIds(Integer[] ids) {
        return jobLevelMapper.deleteJoblevelByIds(ids);
    }
}

 
