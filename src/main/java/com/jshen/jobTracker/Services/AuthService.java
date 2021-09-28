package com.jshen.jobTracker.Services;

import com.jshen.jobTracker.dto.RegisterRequest;
import com.jshen.jobTracker.models.User;

public class AuthService {
    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());

    }
}
