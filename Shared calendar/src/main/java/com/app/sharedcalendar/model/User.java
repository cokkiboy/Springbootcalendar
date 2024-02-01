package com.app.sharedcalendar.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {


      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(nullable =false,length=100,unique = true )
      private String  username;  //변수이름 똑바로짓자 이거떄문에 오류뜸



      private  String email;




      private String password;




}
