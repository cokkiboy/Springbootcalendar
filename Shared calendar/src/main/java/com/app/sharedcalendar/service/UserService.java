package com.app.sharedcalendar.service;

import com.app.sharedcalendar.model.Roletype;
import com.app.sharedcalendar.model.User;
import com.app.sharedcalendar.repository.UserRepository;


import lombok.RequiredArgsConstructor;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;  //@Autowired 지양

    private  final BCryptPasswordEncoder bCryptPasswordEncoder; // 스프링 시큐티리 통해서 비밀번호 해쉬화해주는


    @Transactional
    public void  join(@NotNull User user){
      String rawPassword =user.getPassword();  //비밀번호를 입력한거
      String encPassword =bCryptPasswordEncoder.encode(rawPassword); //해쉬처리해준다
      user.setPassword(encPassword);
      user.setRoletype(Roletype.USER);
  userRepository.save(user);
    }   //회원가입 구성완료

    
}
