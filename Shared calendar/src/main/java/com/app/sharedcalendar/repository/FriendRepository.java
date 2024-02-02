package com.app.sharedcalendar.repository;

import com.app.sharedcalendar.model.Friend;
import com.app.sharedcalendar.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



public interface FriendRepository extends JpaRepository<Friend,Long> {

    List<Friend> findByUser(User user);
    List<Friend> findByFriend(User friend);
    Optional<Friend> findByUserAndFriend(User user, User friend);

  /*  Java8에서는 Optional<T> 클래스를 사용해 NPE를 방지할 수 있도록 도와준다. Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로, 참조하더라도 NPE가 발생하지 않도록 도와준다. Optional 클래스는 아래와 같은 value에 값을 저장하기 때문에 값이 null이더라도 바로 NPE NPE(NullPointerException)
  가 발생하지 않으며, 클래스이기 때문에 각종 메소드를 제공해준다.
   */

}
