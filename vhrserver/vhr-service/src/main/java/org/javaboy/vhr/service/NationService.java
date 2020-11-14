package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Nation;
import org.javaboy.vhr.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/18 14:00
 * @CreateTime: 2020-09-18 14:00
 */
@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNation() {
        return nationMapper.getAllNation();
    }
}

 
