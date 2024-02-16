package com.app.sharedcalendar.controller;

import com.app.sharedcalendar.dto.FollowDTO;
import com.app.sharedcalendar.model.User;
import com.app.sharedcalendar.service.FollowService;
import com.app.sharedcalendar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FollowController {
    private final UserService userService;
    private final FollowService followService;



    /**
     * 친구 추가
     */
    @PostMapping("/users/follow/{friendName}")
    public ResponseEntity follow(Authentication authentication, @PathVariable("friendName") String friendName) {
        User from_user = userService.Finduser(authentication.getName());
        User to_user = userService.Finduser(friendName);
        followService.follow(from_user, to_user);
        return ResponseEntity.ok().build();
    }

    /**
     * 팔로잉 목록 조회
     */
    @GetMapping("/users/{userName}/following")
    public ResponseEntity<List<FollowDTO>> getFollowingList(@PathVariable("userName") String userName, Authentication auth) {
        User from_user = userService.findUser(userName);
        User requestUser=userService.findUser(auth.getName());
        return ResponseEntity.ok().body(followService.followingList(from_user, requestUser));
    }

    /**
     * 팔로워 목록 조회
     */
    @GetMapping("/users/{userName}/follower")
    public ResponseEntity<List<FollowDTO>> getFollowerList(@PathVariable("userName") String userName, Authentication auth) {
        User to_user = userService.findUser(userName);
        User requestUser=userService.findUser(auth.getName());
        return ResponseEntity.ok().body(followService.followerList(to_user, requestUser));
    }

    /**
     * 팔로우 취소
     */
    @DeleteMapping("/users/follow/{friendName}")
    public ResponseEntity<String> deleteFollow(Authentication authentication){
        return ResponseEntity.ok().body(followService.cancelFollow(userService.finduser(authentication.getName())));
    }

}



