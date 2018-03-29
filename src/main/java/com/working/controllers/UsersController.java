package com.working.controllers;

import com.working.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "listUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", usersService.getAllUsers());
        return "listusers";
    }
}
