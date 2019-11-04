package com.shop.upload.controller;

import com.shop.item.ResponseEntity;
import com.shop.upload.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Resource
    private UploadService uploadService;

    @PostMapping("/image")
    public ResponseEntity<String> image(@RequestParam("file") MultipartFile multipartFile) {
        String path = uploadService.image(multipartFile);
        if (StringUtils.isEmpty(path)) {
            return ResponseEntity.status(ResponseEntity.Status.BAD_REQUEST);
        }

        return ResponseEntity.ok(path);
    }

}
