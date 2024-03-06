package com.app.sharedcalendar.controller;


import com.app.sharedcalendar.model.CalendarEvent;
import com.app.sharedcalendar.service.CalendarEventService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CalendarEventController {


    private final CalendarEventService calendarEventService;



    @PostMapping("/save")
    public ResponseEntity<String> saveEvent(@RequestBody CalendarEvent event) {
        calendarEventService.saveEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event saved successfully");
    }

    @PutMapping("/update/{eventId}")
    public ResponseEntity<String> updateEvent(@PathVariable Long eventId, @RequestBody CalendarEvent event) {
        event.setId(eventId);
        calendarEventService.updateSharedEvent(event);
        return ResponseEntity.ok("Event updated successfully");
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        calendarEventService.deleteSharedEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }



}
