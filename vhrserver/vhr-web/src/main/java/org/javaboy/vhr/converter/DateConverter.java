package org.javaboy.vhr.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/23 16:05
 * @CreateTime: 2020-09-23 16:05
 */
@Component
public class DateConverter implements Converter<String, Date> {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String source) {
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

 
