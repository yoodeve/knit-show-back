package knitshow.fos.security;

import knitshow.fos.entity.UserEntity;
import lombok.Getter;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.ArrayList;
import java.util.Map;

@Getter
public class PrincipalUser extends DefaultOAuth2User {
    @Getter
    private UserEntity user;

    public PrincipalUser(UserEntity user, Map<String, Object> attributes, String nameAttributeKey) {
        super(new ArrayList<>(), attributes, nameAttributeKey);
        this.user = user;
    }

}
