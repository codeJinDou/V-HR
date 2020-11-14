package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Politicsstatus;
import org.javaboy.vhr.mapper.PoliticsstatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/18 14:03
 * @CreateTime: 2020-09-18 14:03
 */
@Service
public class PoliticsstatusService {

    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPosta() {
        return politicsstatusMapper.getAllPosta();
    }
}

 
