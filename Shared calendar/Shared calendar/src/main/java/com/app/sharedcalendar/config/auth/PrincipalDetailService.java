package com.app.sharedcalendar.config.auth;


import com.app.sharedcalendar.model.User;
import com.app.sharedcalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal =userRepository.findByUsername(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당사용자를 찾을 수없습니다."+username);
                });

        return new PrincipalDetail(principal);
    }
}
