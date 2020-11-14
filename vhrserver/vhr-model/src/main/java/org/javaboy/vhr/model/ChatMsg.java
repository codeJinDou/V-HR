package org.javaboy.vhr.model;

import org.springframework.stereotype.Controller;

import java.util.Date;


/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/27 9:17
 * @CreateTime: 2020-09-27 09:17
 */
@Controller
public class ChatMsg {
    private String from;
    private String to;
    private String content;
    private Date date;
    private String fromNickname;

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate(Date date) {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

 
