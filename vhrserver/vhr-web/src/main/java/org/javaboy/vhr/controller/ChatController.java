package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/27 8:28
 * @CreateTime: 2020-09-27 08:28
 */
@RestController
@RequestMapping("/chat")
public class ChatController {


    @Autowired
    HrService hrService;

    @GetMapping("/")
    public List<Hr> getChatCurrentUser(){
        return hrService.getChatCurrentUser();
    }
}

 
