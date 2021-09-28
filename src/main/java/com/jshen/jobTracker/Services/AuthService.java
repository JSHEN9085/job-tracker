package com.jshen.jobTracker.Services;

import com.jshen.jobTracker.dto.RegisterRequest;
import com.jshen.jobTracker.models.User;
import com.jshen.jobTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(encodePassword( registerRequest.getPassword()) );
        userRepository.save(user);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
