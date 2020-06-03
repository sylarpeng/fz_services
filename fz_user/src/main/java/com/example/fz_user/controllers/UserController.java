package com.example.fz_user.controllers;

import com.example.fz_user.entities.User;
import com.example.fz_user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String addUser(User user){
        int count=userService.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("{id}")
    public User getUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @RequestMapping("/list")
    public String findAllUser(Model model){
        List<User> allUser = userService.findAllUser();
        model.addAttribute("allUser",allUser);
        return "userList";
    }

    @RequestMapping("/view")
    public String findUserById(@RequestParam int id,Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "userDetail";
    }

    @RequestMapping("/del")
    public String delUser(@RequestParam int id) {
        int count = userService.delUser(id);
        return "redirect:/user/list";
    }
}
