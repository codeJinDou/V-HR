package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.ChatMsg;
import org.javaboy.vhr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/27 9:22
 * @CreateTime: 2020-09-27 09:22
 */
@Controller
public class WsController{

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void hander(Authentication authentication, ChatMsg chatMsg){
        Hr hr = (Hr) authentication.getPrincipal();
        chatMsg.setFromNickname(hr.getName());
        chatMsg.setFrom(hr.getUsername());
        chatMsg.getDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(),"/queue/chat",chatMsg);
    }
}

 
