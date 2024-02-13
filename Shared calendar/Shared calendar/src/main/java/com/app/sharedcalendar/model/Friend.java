package com.app.sharedcalendar.model;




import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private User friend;

    private String fromNickname;

    private String toNickname;

    public Friend(User user, User friend, String fromNickname, String toNickname) {
        this.user = user;
        this.friend = friend;
        this.fromNickname = fromNickname;
        this.toNickname = toNickname;
    }
}
