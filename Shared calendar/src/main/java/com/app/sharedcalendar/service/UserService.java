package com.app.sharedcalendar.service;

import com.app.sharedcalendar.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private  final UserRepository userRepository;

}
