package com.app.sharedcalendar.service;

import com.app.sharedcalendar.model.CalendarEvent;

import com.app.sharedcalendar.repository.CalendarEventRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CalendarEventService {

    private final CalendarEventRepository eventRepository;


    // 일정을 저장합니다.
    public void saveEvent(CalendarEvent event) {
        // 저장된 일정을 조회합니다.
        CalendarEvent savedEvent = eventRepository.save(event);
    }


    // 친구들끼리 공유한 일정을 수정합니다.
    public void updateSharedEvent(CalendarEvent event) {
        // 일정 엔터티를 찾습니다.
        CalendarEvent existingEvent = eventRepository.findById(event.getId())
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다."));

        // 기존 일정을 업데이트합니다.
        existingEvent.setTitle(event.getTitle());
        existingEvent.setStart(event.getStart());
        existingEvent.setEnd(event.getEnd());

        // 업데이트된 일정을 저장합니다.
        eventRepository.save(existingEvent);
    }

    // 친구들끼리 공유한 일정을 삭제합니다.
    public void deleteSharedEvent(Long eventId) {
        // 일정 엔터티를 찾습니다.
        CalendarEvent existingEvent = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다."));

        // 찾은 일정을 삭제합니다.
        eventRepository.delete(existingEvent);
    }
}
