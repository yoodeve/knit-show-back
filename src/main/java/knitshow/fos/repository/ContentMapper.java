package knitshow.fos.repository;

import knitshow.fos.entity.ContentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentMapper {
    public int insertContent(ContentEntity content);
}
