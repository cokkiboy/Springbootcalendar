package com.app.sharedcalendar.repository;

import com.app.sharedcalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long> {

    Optional<User> findByUsername(String username);

}
