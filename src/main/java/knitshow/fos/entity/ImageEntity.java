package knitshow.fos.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageEntity {
    private int contentId;
    private String imageUrl;
}
