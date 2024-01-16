package knitshow.fos.dto;

import knitshow.fos.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data@AllArgsConstructor@RequiredArgsConstructor@Builder
public class UserDto {
    private String oauth2Id;
    private int provider;

    public UserEntity toEntity(String nickname) {
        return UserEntity.builder()
                .oauth2Id(oauth2Id)
                .providerId(provider)
                .nickname(nickname)
                .build();
    }
}
