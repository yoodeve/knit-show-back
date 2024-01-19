package knitshow.fos.repository;

import knitshow.fos.dto.ContentDto;
import knitshow.fos.entity.ContentEntity;
import knitshow.fos.entity.ContentRespDtoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {
    public int insertContent(ContentEntity content);
    public List<ContentRespDtoEntity> getContentList();
}
