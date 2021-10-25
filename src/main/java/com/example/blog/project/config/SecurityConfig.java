package com.example.blog.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity  // 스프링 시큐리티 설정들을 활성화 시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()    // 권한이 없는 사용자가 페이지를 이동하려고 하면 로그인 페이지로 이동
                    .loginPage("/auth/user/login")    // 해당하는 로그인 페이지 URL로 이동
                    //.loginProcessingUrl("/auth/api/v1/user/login")
                    .defaultSuccessUrl("/");   // 로그인이 성공하면 해당 URL로 이동
    }
}
