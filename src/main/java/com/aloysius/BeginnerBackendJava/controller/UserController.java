package com.aloysius.BeginnerBackendJava.controller;

import com.aloysius.BeginnerBackendJava.model.User;
import com.aloysius.BeginnerBackendJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("userList", allUsers);
        return "home";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name,@RequestParam int age,@RequestParam String email) {
        userService.addUser(new User(name,age,email));
        return "redirect:/";
    }


}