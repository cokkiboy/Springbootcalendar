package com.app.sharedcalendar.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friendship {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String userId;

    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL )
    private List<User> friendList;

    public void addFriend(User user) {
        this.friendList.add(user);
    }

}
