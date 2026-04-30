package com.movie.service;

import com.movie.dto.User;
import com.movie.enums.Roles;
import com.movie.exeption.EmailAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();


    public User createStudent(User user) {
        for(User uu :users){
            if(uu.getEmail().equals(user.getEmail())){
                throw new EmailAlreadyExistException("This email already exist");
            }
        }
        user.setId();
        user.setRole(Roles.USER);
        users.add(user);
        return user;
    }
}
