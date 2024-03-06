package com.app.sharedcalendar.controller;


import com.app.sharedcalendar.dto.ResponseDto;
import com.app.sharedcalendar.model.User;
import com.app.sharedcalendar.service.UserService;
import lombok.RequiredArgsConstructor;

import org.jetbrains.annotations.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {


   private    AuthenticationManager authenticationManager;


    private  final UserService userService;

    @PostMapping("/auth/login")
    public ResponseDto<Integer> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }


    @PostMapping("/auth/join")
    public ResponseDto<Integer> save(@RequestBody User user) {



        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/user")   //회원수정
    public ResponseDto<Integer> update(@RequestBody @NotNull User user){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        userService.Edit_member_information(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/user")   //회원 탈퇴
    public ResponseDto<Integer> delete(@RequestBody @NotNull User user){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        userService.delete(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
