package org.javaboy.vhr.model;

import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/16 16:25
 * @CreateTime: 2020-09-16 16:25
 */
public class RespPageBean {

    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}

 
