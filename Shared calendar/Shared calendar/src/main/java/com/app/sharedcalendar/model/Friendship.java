package com.app.sharedcalendar.model;




import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @OneToMany(mappedBy = "friendship", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Friend> friends = new ArrayList<>();

    public void addFriend(User user, String fromNickname, String toNickname) {
        Friend friend = new Friend(user, this, fromNickname, toNickname);
        friends.add(friend);
        user.getFriends().add(friend);
    }

    public void removeFriend(Friend friend) {
        friends.remove(friend);
        friend.getUser().getFriends().remove(friend);
        friend.setUser(null);
        friend.setFriendship(null);
    }
}