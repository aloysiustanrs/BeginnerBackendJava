package com.aloysius.BeginnerBackendJava.service;

import com.aloysius.BeginnerBackendJava.model.User;
import com.aloysius.BeginnerBackendJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User newUser){
        userRepository.save(newUser);
    }

    public boolean deleteUser(int id){

        if (id == -1) {
            return false; // User not found
        }

        userRepository.deleteById(id);
        return true; // User deleted successfully
    }
}
