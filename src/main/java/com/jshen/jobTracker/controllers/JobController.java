package com.jshen.jobTracker.controllers;

import com.jshen.jobTracker.Services.JobService;
import com.jshen.jobTracker.dto.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity newJobApplication(@RequestBody JobDto jobDto){
        jobService.jobApplication(jobDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
