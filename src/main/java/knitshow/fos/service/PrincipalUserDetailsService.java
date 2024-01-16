package knitshow.fos.service;

import knitshow.fos.security.PrincipalUser;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PrincipalUserDetailsService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = new HashMap<>();

        switch (userRequest.getClientRegistration().getClientName()) {
            case "Naver":
                attributes.putAll((Map<String, Object>) oAuth2User.getAttributes().get("response"));
                break;
            case "Kakao":
                attributes.putAll(oAuth2User.getAttributes());
                break;
        }

        int provider = userRequest.getClientRegistration().getClientName().equals("Naver") ? 1 : 2;
        attributes.put("providerId", provider);

        return new PrincipalUser(null, attributes, "id");
    }
}
