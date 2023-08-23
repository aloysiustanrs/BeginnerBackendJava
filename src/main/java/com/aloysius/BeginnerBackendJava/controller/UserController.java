package com.aloysius.BeginnerBackendJava.controller;

import com.aloysius.BeginnerBackendJava.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("userList", userList);
        return "home";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name,@RequestParam int age,@RequestParam String email) {
        userList.add(new User(name,age,email));
        return "redirect:/";
    }


}