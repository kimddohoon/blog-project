package com.example.blog.project.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //sequence, auto_increment

    @Column(nullable = false, length = 30)
    private String username; //아이디

    @Column(nullable = false, length = 100)
    private String password; //비밀번호

    @Column(nullable = false, length = 50)
    private String email; // 이메일

    @Column(nullable = false, length = 50)
    private String phone; // 전화번호

    @Column(nullable = false, length = 50)
    private String address; // 거주지

//    @Column(nullable = false, length = 50)
//    private String address; // 주민번호
//
//    @Column(nullable = false, length = 50)
//    private int sex; // 성별




    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
