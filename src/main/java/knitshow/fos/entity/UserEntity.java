package knitshow.fos.entity;

import knitshow.fos.dto.PrincipalRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    private int userId;
    private String oauth2Id;
    private String nickname;
    private int providerId;
    private String email;

    public PrincipalRespDto toDto() {
        return PrincipalRespDto.builder()
                .userId(userId)
                .oauth2Id(oauth2Id)
                .nickname(nickname)
                .providerId(providerId)
                .build();
    }
}
