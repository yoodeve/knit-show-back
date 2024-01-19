package knitshow.fos.entity;

import knitshow.fos.dto.CategoryRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder@Data@NoArgsConstructor@AllArgsConstructor
public class ContentCategoryEntity {
    private String needleWeightList;
    private String needleTypeList;
    private String foTypeList;

    public CategoryRespDto toDto() {
        return CategoryRespDto.builder()
                .needleWeightList(needleWeightList)
                .needleTypeList(needleTypeList)
                .foTypeList(foTypeList)
                .build();
    }

}
