package com.jshen.jobTracker.Services;

import com.jshen.jobTracker.dto.RegisterRequest;
import com.jshen.jobTracker.models.User;
import com.jshen.jobTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;


    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        userRepository.save(user);
    }
}
