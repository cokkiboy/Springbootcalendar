package com.app.sharedcalendar.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {


      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(nullable =false,length=100,unique = true )
      private  String email;


      private String name;

      private String password;




}
