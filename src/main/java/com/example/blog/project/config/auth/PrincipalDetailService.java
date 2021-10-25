package com.example.blog.project.config.auth;

import com.example.blog.project.domain.user.User;
import com.example.blog.project.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal =  userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. " + username));
        return new PrincipalDetail(principal);
    }
    // UserDetailsService를 상속받게 되면 오버라이딩을 해야하는데 이 메소드는 DB에 username이 있는지 확인하는 메소드
    // PrincipalDetail(principal)을 리턴을 하게 되면 시큐리티의 세션에 유저 정보가 저장
}
