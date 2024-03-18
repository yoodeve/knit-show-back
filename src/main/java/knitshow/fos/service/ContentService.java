package knitshow.fos.service;

import knitshow.fos.dto.ContentDto;
import knitshow.fos.dto.ContentRespDto;
import knitshow.fos.dto.ImageReqDto;
import knitshow.fos.entity.ContentEntity;
import knitshow.fos.entity.ImageEntity;
import knitshow.fos.repository.ContentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentMapper contentMapper;

    public boolean saveContent (ContentDto dto) {
        ContentEntity entity = dto.toEntity();
        return contentMapper.insertContent(entity) > 0;
    }

    public boolean saveImage (ImageReqDto dto) {
        ImageEntity entity = dto.toEntity();
        return contentMapper.insertImage(entity) > 0;
    }

    public List<ContentRespDto> getContentList () {
        List<ContentRespDto> list = new ArrayList<>();
        contentMapper.getContentList().forEach(con -> {
            list.add(con.toDto());
        });
        return list;
    }

    public Map<String, Object> getCategoryList () {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("needleWeight", contentMapper.getWeightList());
        resultMap.put("needleType", contentMapper.getTypeList());
        resultMap.put("foType", contentMapper.getFoTypeList());
        return resultMap;
    }
}
