package com.app.sharedcalendar.config;

import com.app.sharedcalendar.config.auth.PrincipalDetailService;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final PrincipalDetailService principalDetailService;

    public SecurityConfig(PrincipalDetailService principalDetailService) {
        this.principalDetailService = principalDetailService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        return authenticationManagerBuilder.userDetailsService(principalDetailService).passwordEncoder(passwordEncoder()).build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSecurity disable = http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .dispatcherTypeMatchers("/", "/auth/login", "/auth/join").permitAll() // 인증 없이 접근 가능한 URL 설정
                        .anyRequest().authenticated()) // 나머지 요청은 인증 필요
                .formLogin(formLogin -> formLogin
                        .loginPage("/auth/loginForm") // 로그인 페이지 설정
                        .defaultSuccessUrl("/home") // 로그인 성공 후 이동할 페이지 설정
                        .permitAll()) // 로그인 페이지는 모든 사용자에게 접근 가능
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃 URL 설정
                        .logoutSuccessUrl("/auth/loginForm") // 로그아웃 성공 후 이동할 페이지 설정
                        .permitAll()) // 로그아웃은 모든 사용자에게 접근 가능
                .csrf().disable();// CSRF 보호 비활성화

        return http.build();
    }
}
