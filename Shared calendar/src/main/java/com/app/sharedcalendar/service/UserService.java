package com.app.sharedcalendar.service;

import com.app.sharedcalendar.repository.UserRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;

}
