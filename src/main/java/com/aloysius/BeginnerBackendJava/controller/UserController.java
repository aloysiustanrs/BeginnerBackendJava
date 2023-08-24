package com.aloysius.BeginnerBackendJava.controller;

import com.aloysius.BeginnerBackendJava.model.User;
import com.aloysius.BeginnerBackendJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUserByName(@PathVariable int userId) {
        if (userService.deleteUser(userId)) {
            return ResponseEntity.noContent().build(); // Return 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}