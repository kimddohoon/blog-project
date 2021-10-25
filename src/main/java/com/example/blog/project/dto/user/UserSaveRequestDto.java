package com.example.blog.project.dto.user;

import com.example.blog.project.domain.user.Role;
import com.example.blog.project.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private Role role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .phone(phone)
                .address(address)
                .role(Role.USER)
                .build();
    }
}