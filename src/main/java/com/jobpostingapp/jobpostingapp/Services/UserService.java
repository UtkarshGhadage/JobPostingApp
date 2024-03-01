package com.jobpostingapp.jobpostingapp.Services;

import com.jobpostingapp.jobpostingapp.Models.User;
import com.jobpostingapp.jobpostingapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
