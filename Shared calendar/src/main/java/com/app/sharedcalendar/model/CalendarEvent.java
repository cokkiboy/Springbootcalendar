package com.app.sharedcalendar.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalendarEvent {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id;


     @Lob
     private  String title;

     private LocalDateTime start;

     private  LocalDateTime end;

     @ManyToOne(fetch=FetchType.LAZY)
     @JoinColumn(name = "user_id")
     private  User user;

}
