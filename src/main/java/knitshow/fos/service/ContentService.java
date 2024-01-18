package knitshow.fos.service;

import knitshow.fos.dto.ContentDto;
import knitshow.fos.entity.ContentEntity;
import knitshow.fos.repository.ContentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentMapper contentMapper;

    public boolean saveContent (ContentDto dto) {
        ContentEntity entity = dto.toEntity();
        System.out.println(entity);
        return contentMapper.insertContent(entity) > 0;
    }
}
