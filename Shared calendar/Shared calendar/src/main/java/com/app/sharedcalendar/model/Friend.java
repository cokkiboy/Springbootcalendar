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
    @JoinColumn(name = "friendship_id")
    private Friendship friendship;

    private String fromNickname;

    private String toNickname;

    public Friend(User user, Friendship friendship, String fromNickname, String toNickname) {
        this.user = user;
        this.friendship = friendship;
        this.fromNickname = fromNickname;
        this.toNickname = toNickname;
    }
}
