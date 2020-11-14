package org.javaboy.vhr.utils;

import org.javaboy.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/15 12:27
 * @CreateTime: 2020-09-15 12:27
 */
public class HrUtils {

    public static Hr CurrentHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}

 
