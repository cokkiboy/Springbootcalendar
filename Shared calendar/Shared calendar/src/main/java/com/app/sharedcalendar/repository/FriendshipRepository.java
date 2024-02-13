package com.app.sharedcalendar.repository;

import com.app.sharedcalendar.model.Friendship;
import com.app.sharedcalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    Optional<Friendship> findByUserId(Long userId);

    List<Friendship> findByuser(User user);

}
