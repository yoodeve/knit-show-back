package knitshow.fos.controller;

import knitshow.fos.dto.PrincipalRespDto;
import knitshow.fos.dto.UserDto;
import knitshow.fos.entity.UserEntity;
import knitshow.fos.security.PrincipalUser;
import knitshow.fos.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/oauth2/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(authService.signup(userDto));
    }
    @PostMapping("/oauth2/signin")
    public ResponseEntity<?> signin(@RequestBody String token) {
        return ResponseEntity.ok(authService.signin(token));
    }
    @GetMapping("/auth/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader(value = "Authorization") String token) {
        boolean flag = token != "" ? true : false;
        return ResponseEntity.ok(flag);
    }
    @GetMapping("/account/principal")
    public ResponseEntity<?> getPrincipal() {

        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = principalUser.getUser();
        PrincipalRespDto principalRespDto = user.toDto();

        return ResponseEntity.ok(principalRespDto);
    }
}
