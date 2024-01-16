package knitshow.fos.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import knitshow.fos.entity.UserEntity;
import knitshow.fos.repository.UserMapper;
import knitshow.fos.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    private final Key key;
    private final UserMapper userMapper;

    public JwtProvider(@Value("${jwt.secret}") String secret,
                        @Autowired UserMapper userMapper) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.userMapper = userMapper;
    }

    public String generateToken(UserEntity user) {
        int userId = user.getUserId();
        int providerId = user.getProviderId();
        String oauth2Id = user.getOauth2Id();
        String nickname = user.getNickname();
        Date expiryDate = new Date(new Date().getTime() + (1000 * 60* 50* 24));

        return Jwts.builder()
                .setSubject("token")
                .setExpiration(expiryDate)
                .claim("providerId", providerId)
                .claim("nickname", nickname)
                .claim("oauth2Id", oauth2Id)
                .claim("userId", userId)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getToken(String bearerToken){

        if(!StringUtils.hasText(bearerToken)) {
            return null;
        }
        return bearerToken.substring("Bearer ".length());
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        if (claims == null) {
            return null;
        }
        UserEntity user = userMapper.findUserByOAuth2Id(claims.get("oauth2Id").toString());
        if(user == null) {
            return null;
        }
        HashMap<String, Object> attrs = new HashMap<>();
        attrs.put("id", claims.get("oauth2Id").toString());
        PrincipalUser principalUser = new PrincipalUser(user, attrs, "id");
        return new UsernamePasswordAuthenticationToken(principalUser, null, principalUser.getAuthorities());
    }
}
