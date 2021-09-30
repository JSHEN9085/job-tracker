package com.jshen.jobTracker.Services;

import com.jshen.jobTracker.dto.RegisterLoginRequest;
import com.jshen.jobTracker.models.User;
import com.jshen.jobTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void signup(RegisterLoginRequest registerLoginRequest){
        User user = new User();
        user.setUsername(registerLoginRequest.getUsername());
        user.setPassword(encodePassword( registerLoginRequest.getPassword()) );
        userRepository.save(user);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public void login(RegisterLoginRequest registerLoginRequest){

    }
}
