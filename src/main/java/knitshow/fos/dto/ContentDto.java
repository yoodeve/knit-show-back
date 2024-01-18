package knitshow.fos.dto;

import knitshow.fos.entity.ContentEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentDto {
    private String userId;
    private String content;
    private String needleTypeId;
    private String needleWeightId;
    private String foTypeId;

    public ContentEntity toEntity() {
        return ContentEntity.builder()
                .userId(userId)
                .content(content)
                .needleWeightId(needleWeightId)
                .needleTypeId(needleTypeId)
                .foTypeId(foTypeId)
                .build();
    }
}
