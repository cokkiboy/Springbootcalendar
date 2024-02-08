package com.app.sharedcalendar.model;


import jakarta.annotation.Nullable;
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



    @Nullable
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL )
    private List<User> friendList;

    @Nullable
    public void addFriend(User user) {
        this.friendList.add(user);
    }

}
