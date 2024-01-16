package knitshow.fos.service;

import knitshow.fos.dto.UserDto;
import knitshow.fos.entity.UserEntity;
import knitshow.fos.jwt.JwtProvider;
import knitshow.fos.repository.UserMapper;
import knitshow.fos.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;

    public boolean signup(UserDto userDto) {
        return userMapper.insertUser(userDto.toEntity("말랑말랑 홍합")) > 0;
    }
    public String signin(String token) {
        String slicedToken = jwtProvider.getToken(token);
        Authentication auth = jwtProvider.getAuthentication(token);
        PrincipalUser user = (PrincipalUser) auth.getPrincipal();
        return jwtProvider.generateToken(user.getUser());
    }
}
