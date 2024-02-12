package com.app.sharedcalendar.repository;

import com.app.sharedcalendar.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    Optional<Friendship> findByUserId(String userId);
}
