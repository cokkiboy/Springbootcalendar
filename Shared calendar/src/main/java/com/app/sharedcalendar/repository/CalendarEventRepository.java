package com.app.sharedcalendar.repository;

import com.app.sharedcalendar.model.CalendarEvent;
import com.app.sharedcalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
    List<CalendarEvent> findByUser(User user);

}
