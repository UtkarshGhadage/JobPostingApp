package com.jobpostingapp.jobpostingapp.Controllers;

import com.jobpostingapp.jobpostingapp.CustomExceptions.EmailAlreadyExistsException;
import com.jobpostingapp.jobpostingapp.Models.User;
import com.jobpostingapp.jobpostingapp.Repository.UserRepository;
import com.jobpostingapp.jobpostingapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("User Already Exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public Boolean loginUser(@RequestBody User user ){

        User registered = userService.getUser(user.getId());
        if(registered != null){
            if(passwordEncoder.matches(registered.getPassword(), userService.getUser(user.getId()).getPassword())){
                return true;
            }
        }


        return false;
    }
}
