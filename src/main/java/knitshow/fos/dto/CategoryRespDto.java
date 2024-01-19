package knitshow.fos.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data@Builder
public class CategoryRespDto {
    private String needleWeightList;
    private String needleTypeList;
    private String foTypeList;
}
