package com.jshen.jobTracker.Services;

import com.jshen.jobTracker.dto.RegisterLoginRequest;
import com.jshen.jobTracker.models.User;
import com.jshen.jobTracker.repositories.UserRepository;
import com.jshen.jobTracker.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private JwtProvider jwtProvider;

    public void signup(RegisterLoginRequest registerLoginRequest){
        User user = new User();
        user.setUsername(registerLoginRequest.getUsername());
        user.setPassword(encodePassword( registerLoginRequest.getPassword()) );
        userRepository.save(user);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public String login(RegisterLoginRequest registerLoginRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(registerLoginRequest.getUsername(),
                registerLoginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return jwtProvider.generateToken(authenticate);
    }
}
