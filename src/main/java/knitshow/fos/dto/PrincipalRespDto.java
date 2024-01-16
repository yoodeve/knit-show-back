package knitshow.fos.dto;

import lombok.Builder;
import lombok.Data;

@Data@Builder
public class PrincipalRespDto {
    private int userId;
    private String oauth2Id;
    private String nickname;
    private int providerId;
    private String email;
}
