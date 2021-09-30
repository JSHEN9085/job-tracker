package com.jshen.jobTracker.controllers;

import com.jshen.jobTracker.Services.AuthService;
import com.jshen.jobTracker.dto.RegisterLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterLoginRequest registerLoginRequest){
        authService.signup(registerLoginRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public void login(@RequestBody RegisterLoginRequest RegisterLoginRequest){

    }
}
