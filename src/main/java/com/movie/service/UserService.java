package com.movie.service;

import com.movie.dto.User;
import com.movie.dto.UserActivityDto;
import com.movie.enums.Roles;
import com.movie.exeption.EmailAlreadyExistException;
import com.movie.exeption.UserNotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    @Autowired
    private MovieService movieService;
    @Autowired
    private ReviewService reviewService;


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

    public User getUserById(Integer userId) {
        for (User user : users) {
            if(user.getId().equals(userId)) return user;
        }
        throw new UserNotFoundException("User Not Found");
    }

    public Boolean deleteUserById(Integer userId) {
        for (User user : users) {
            if(user.getId().equals(userId)){
                users.remove(user);
                return true;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public UserActivityDto getUserActivity(Integer userId) {
        getUserById(userId);
        return new UserActivityDto(reviewService.getUserReviewNumber(userId), movieService.getUserMovieNumber(userId));
    }
}
