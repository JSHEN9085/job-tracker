package com.jshen.jobTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jshen.jobTracker.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
