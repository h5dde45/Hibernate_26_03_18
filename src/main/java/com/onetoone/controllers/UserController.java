package com.onetoone.controllers;

import com.onetoone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "users")
    public String getAllUsers(Model model){
        model.addAttribute("listUsers", userService.getAllUsers());
        model.addAttribute("listPassports", userService.getAllPassports());
        return "users";
    }
}
