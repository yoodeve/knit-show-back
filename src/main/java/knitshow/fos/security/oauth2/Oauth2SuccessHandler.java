package knitshow.fos.security.oauth2;

import knitshow.fos.entity.UserEntity;
import knitshow.fos.jwt.JwtProvider;
import knitshow.fos.repository.UserMapper;
import knitshow.fos.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class Oauth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        String oauth2Id = principalUser.getName();
        UserEntity user = userMapper.findUserByOAuth2Id(oauth2Id);
        String provider = principalUser.getAttributes().get("providerId").toString();
        if(user == null) {
            response.sendRedirect("http://localhost:3000/#/signup/redirect" +
                    "?oauth2Id=" + oauth2Id +
                    "&provider=" + provider);
            return;
        }
        String token = jwtProvider.generateToken(user);

        response.sendRedirect("http://localhost:3000/#/signup/redirect?token=" + URLEncoder.encode(token, StandardCharsets.UTF_8)); // 프론트 처리
    }
}
