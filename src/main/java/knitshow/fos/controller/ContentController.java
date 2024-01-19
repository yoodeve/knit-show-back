package knitshow.fos.controller;

import knitshow.fos.dto.ContentDto;
import knitshow.fos.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveContent(@RequestBody ContentDto dto) {
        System.out.println(dto);
        return ResponseEntity.ok().body(contentService.saveContent(dto));
    }

    @GetMapping("/content")
    public ResponseEntity<?> getContent() {
        return ResponseEntity.ok().body(contentService.getContentList());
    }

    @GetMapping("/content/category")
    public ResponseEntity<?> getCategoryList () {
        return ResponseEntity.ok().body(contentService.getCategoryList());
    }
}
