package knitshow.fos.repository;

import knitshow.fos.dto.ContentDto;
import knitshow.fos.dto.ContentRespDto;
import knitshow.fos.entity.ContentCategoryEntity;
import knitshow.fos.entity.ContentEntity;
import knitshow.fos.entity.ContentRespDtoEntity;
import knitshow.fos.entity.ImageEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContentMapper {
    public int insertContent(ContentEntity content);
    public List<ContentRespDtoEntity> getContentList();
    public List<String> getWeightList();
    public List<String> getTypeList();
    public List<String> getFoTypeList();
    public int insertImage(ImageEntity entity);
}
