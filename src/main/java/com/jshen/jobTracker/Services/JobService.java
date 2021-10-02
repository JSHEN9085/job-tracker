package com.jshen.jobTracker.Services;

import com.jshen.jobTracker.dto.JobDto;
import com.jshen.jobTracker.models.Job;
import com.jshen.jobTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    public void jobApplication(JobDto jobDto){
        Job job = new Job();
        job.setTitle(jobDto.getTitle());
        job.setLink(jobDto.getLink());
        job.setApplicationDate(jobDto.getApplicationDate());
        job.setUser(authService.getCurrentUser());

    }
}
