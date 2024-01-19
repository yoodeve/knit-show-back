package knitshow.fos.dto;

import knitshow.fos.entity.ContentRespDtoEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentRespDto {
    private int contentId;
    private String nickname;
    private String content;
    private String needleSize;
    private String needleTypeName;
    private String foTypeName;

    public ContentRespDtoEntity toEntity () {
        return ContentRespDtoEntity.builder()
                .contentId(contentId)
                .nickname(nickname)
                .content(content)
                .needleSize(needleSize)
                .needleTypeName(needleTypeName)
                .foTypeName(foTypeName)
                .build();
    }

}
