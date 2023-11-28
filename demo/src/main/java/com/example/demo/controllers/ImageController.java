package com.example.demo.controllers;

import com.example.demo.api.ApiResponseDto;
import com.example.demo.dto.ImageDtos.ImageDto;
import com.example.demo.service.GlobalImageFileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
@Tag(name = "GlobalFileController", description = "서비스 전반에 이용할 파일 컨트롤러")
@RestController
@RequestMapping("/v1/controller/file/image")
@RequiredArgsConstructor
public class ImageController {
    private final GlobalImageFileService globalImageFileService;

    @PostMapping(value = "/{folderName}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ApiResponseDto<ImageDto> uploadImage(@PathVariable String folderName,
                                                @RequestParam("file") MultipartFile file) throws IOException {
        return ApiResponseDto.success(HttpStatus.CREATED,
                globalImageFileService.uploadGlobalImageFile(file, folderName));
    }

    @PostMapping(value = "/images/{folderName}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ApiResponseDto<List<ImageDto>> uploadImages(@PathVariable String folderName,
                                                       @RequestParam("files") MultipartFile[] files) {
        return ApiResponseDto.success(HttpStatus.CREATED,
                globalImageFileService.uploadGlobalImageFiles(files, folderName));
    }

}

