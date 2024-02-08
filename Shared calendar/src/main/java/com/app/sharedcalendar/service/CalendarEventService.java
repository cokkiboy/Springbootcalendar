package com.app.sharedcalendar.service;

import com.app.sharedcalendar.repository.CalendarEventRepository;
import com.app.sharedcalendar.repository.FriendshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarEventService {

    private final CalendarEventRepository eventRepository;

    private final FriendshipRepository friendshipRepository;

}
