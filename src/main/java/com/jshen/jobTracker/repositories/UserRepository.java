package com.jshen.jobTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jshen.jobTracker.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
