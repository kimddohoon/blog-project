package com.example.blog.project.service;

import com.example.blog.project.domain.user.User;
import com.example.blog.project.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//private final UserRepository userRepository: 생성자 주입을 받기위해 @RequiredArgsConstructor 사용
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(User user) {
        return userRepository.save(user).getId();
    }
}