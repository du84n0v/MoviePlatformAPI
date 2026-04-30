package com.movie.controller;

import com.movie.dto.User;
import com.movie.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.createStudent(user));
    }

    @GetMapping("/list")
    public ResponseEntity<?> Users(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/by-id/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.deleteUserById(userId));
    }

}
