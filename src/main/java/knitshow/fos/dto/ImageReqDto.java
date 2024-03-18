package knitshow.fos.dto;

import knitshow.fos.entity.ImageEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageReqDto {
    private int contentId = 0;
    private String imageUrl;

    public ImageEntity toEntity() {
        ++contentId;
        return ImageEntity.builder()
                .contentId(contentId)
                .imageUrl(imageUrl)
                .build();
    }
}
