package com.app.sharedcalendar.model;


import com.app.sharedcalendar.dto.FollowDTO;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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


    @Nullable
    @Column(nullable =false,length=100,unique = true )
    private String  username;  //변수이름 똑바로짓자 이거떄문에 오류뜸

    @Nullable
    @Column(nullable = false ,length = 100)  //널값을 지양한다
    private  String email;


    @Nullable
    @Column(nullable = false, length = 100)
    private String password;

    @Nullable
    @Enumerated(EnumType.STRING)
    private Roletype roletype;


    @CreationTimestamp
    private Timestamp createDate;

    //팔로우
    @OneToMany(mappedBy = "from_user", fetch = FetchType.LAZY)
    private List<Follow> followings;

    @OneToMany(mappedBy = "to_user", fetch = FetchType.LAZY)
    private List<Follow> followers;


 public FollowDTO tofollow(String status) {
     return FollowDTO.builder()
             .status(status)
             .build();
 }
}
