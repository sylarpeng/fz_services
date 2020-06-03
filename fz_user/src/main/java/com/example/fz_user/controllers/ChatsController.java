package com.example.fz_user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatsController {

    @RequestMapping("/chats")
    public String chats(){
        return "chats";
    }
}
