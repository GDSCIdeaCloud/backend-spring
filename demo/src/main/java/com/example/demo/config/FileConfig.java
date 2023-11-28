package com.example.demo.config;

import com.example.demo.domain.ImageFile.ImageFileHandle;
import com.example.demo.service.S3ImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {
    private final S3ImageService s3ImageService;

    public FileConfig(S3ImageService s3ImageService) {
        this.s3ImageService = s3ImageService;
    }

    @Bean
    public ImageFileHandle imageFileHandle() {
        return s3ImageService;
    }
}
