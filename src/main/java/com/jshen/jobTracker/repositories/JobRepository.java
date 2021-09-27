package com.jshen.jobTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jshen.jobTracker.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
