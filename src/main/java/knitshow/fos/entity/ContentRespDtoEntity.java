package knitshow.fos.entity;

import knitshow.fos.dto.ContentRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContentRespDtoEntity {
    private int contentId;
    private String nickname;
    private String content;
    private String needleSize;
    private String needleTypeName;
    private String foTypeName;

    public ContentRespDto toDto () {
        return ContentRespDto.builder()
                .contentId(contentId)
                .nickname(nickname)
                .content(content)
                .needleSize(needleSize)
                .needleTypeName(needleTypeName)
                .foTypeName(foTypeName)
                .build();
    }
}
