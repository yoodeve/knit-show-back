package knitshow.fos.entity;

import lombok.*;

@Builder@Data@AllArgsConstructor@NoArgsConstructor
public class ContentEntity {
    private int contentId;
    private String userId;
    private String content;
    private String needleWeightId;
    private String needleTypeId;
    private String foTypeId;
}
