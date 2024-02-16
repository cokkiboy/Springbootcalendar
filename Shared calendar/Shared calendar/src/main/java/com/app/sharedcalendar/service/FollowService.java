package com.app.sharedcalendar.service;

import com.app.sharedcalendar.FollowException;
import com.app.sharedcalendar.dto.FollowDTO;
import com.app.sharedcalendar.model.ErrorCode;
import com.app.sharedcalendar.model.Follow;
import com.app.sharedcalendar.model.User;
import com.app.sharedcalendar.repository.FollowRepository;
import com.app.sharedcalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public String follow(User from_user, User to_user) {
        // 자기 자신 follow 안됨
        if (from_user == to_user)
            throw new FollowException(ErrorCode.INVALID_REQUEST, "자기 자신을 follow할 수 없습니다.");
        // 중복 follow x
        if (followRepository.findFollow(from_user, to_user).isPresent())
            throw new FollowException(ErrorCode.FOLLOW_DUPLICATED, "이미 follow했습니다.");
        Follow follow = Follow.builder()
                .toUser(to_user)
                .fromUser(from_user)
                .build();
        followRepository.save(follow);
        return "Success";
    }
    //following 리스트
    public List<FollowDTO> followingList(User selectedUser, User requestUser) {
        List<Follow> list = followRepository.findByFromUser(selectedUser);
        List<FollowDTO> followList = new ArrayList<>();
        for (Follow f : list) {
            followList.add(userRepository.findByUsername(f.getToUser().getUsername())
                    .orElseThrow().tofollow(findStatus(f.getToUser(), requestUser)));
        }
        return followList;
    }

    //follower list
    public List<FollowDTO> followerList(User selectedUser, User requestUser) {
        List<Follow> list = followRepository.findByToUser(selectedUser);
        List<FollowDTO> followerList = new ArrayList<>();
        for (Follow f : list) {
            followerList.add(userRepository.findByUsername(f.getFromUser().getUsername())
                    .orElseThrow().tofollow(findStatus(f.getFromUser(), requestUser)));
        }
        return followerList;
    }
    //A와 B의 follow관계 찾기
    private String findStatus(User selectedUser, User requestUser) {
        if (selectedUser.getUsername() == requestUser.getUsername())
            return "self";
        if (followRepository.findFollow(requestUser, selectedUser).isEmpty())
            return "none";

        return "following";
    }
    public String cancelFollow(User user) {
        followRepository.deleteFollowByFromUser(user);
        return "Success";
    }
}
