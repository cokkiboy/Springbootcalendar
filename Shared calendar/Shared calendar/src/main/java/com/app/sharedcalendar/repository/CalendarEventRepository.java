package com.app.sharedcalendar.repository;

import com.app.sharedcalendar.model.CalendarEvent;
import com.app.sharedcalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarEventRepository extends JpaRepository<CalendarEvent,Long> {

    List<CalendarEvent> findByUser(User user);
}
