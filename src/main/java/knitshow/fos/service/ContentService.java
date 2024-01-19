package knitshow.fos.service;

import knitshow.fos.dto.ContentDto;
import knitshow.fos.dto.ContentRespDto;
import knitshow.fos.entity.ContentEntity;
import knitshow.fos.repository.ContentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentMapper contentMapper;

    public boolean saveContent (ContentDto dto) {
        ContentEntity entity = dto.toEntity();
        System.out.println(entity);
        return contentMapper.insertContent(entity) > 0;
    }

    public List<ContentRespDto> getContentList () {
        List<ContentRespDto> list = new ArrayList<>();
        contentMapper.getContentList().forEach(con -> {
            list.add(con.toDto());
        });
        return list;
    }
}
