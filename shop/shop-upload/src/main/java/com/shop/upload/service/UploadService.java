package com.shop.upload.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {

    // 图片后缀
    private static final List<String> sImageSuffix = Arrays.asList("image/jpeg", "image/gif", "image/png");

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String image(MultipartFile multipartFile) {
        String suffix = StringUtils.join(sImageSuffix, ",");
        if (!StringUtils.contains(suffix, multipartFile.getContentType())) {
            logger.error("{} -> 图片格式错误：{}", multipartFile.getOriginalFilename(), multipartFile.getContentType());
            return null;
        }

        try {
            BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
            if (bufferedImage == null) {
                logger.error("{} -> 图片内容错误", multipartFile.getOriginalFilename());
                return null;
            }

//            multipartFile.transferTo(new File("C:\\Users\\peng\\Desktop\\", multipartFile.getOriginalFilename()));
            return multipartFile.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其他错误
        return null;
    }
}
