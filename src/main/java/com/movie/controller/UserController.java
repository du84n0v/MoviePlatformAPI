package com.movie.controller;

import com.movie.dto.User;
import com.movie.enums.Roles;
import com.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createStudent(user);
    }

    @GetMapping("/list")
    public List<User> getUsers(){
        return users;
    }

    @GetMapping("/by-id/{userId}")
    public User getUserById(@PathVariable Integer userId){
        for(User user :users){
            if(user.getId() == userId) return user;
        }
        return null;
    }

    @DeleteMapping("/delete/{userId}")
    public Boolean deleteUserById(@PathVariable Integer userId){
        return users.removeIf(user -> user.getId() == userId);
    }

}
