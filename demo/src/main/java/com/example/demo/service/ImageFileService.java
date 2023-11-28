package com.example.demo.service;

import com.example.demo.domain.ImageFile.ImageFileHandle;
import com.example.demo.dto.ImageDtos.ImageDto;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageFileService {
    private final ImageFileHandle imageFileHandle;
    public ImageFileService(ImageFileHandle imageFileHandle){
        this.imageFileHandle = imageFileHandle;
    }

    public String uploadImageFile(MultipartFile file, String folderName) {
        return imageFileHandle.uploadImageFile(file,folderName).getFileName();
    }
    public List<ImageDto> uploadImageFiles(MultipartFile[] files, String folderName) {
        return imageFileHandle.uploadImageFiles(files,folderName).stream().map(ImageDto::new).toList();
    }

    public void deleteImage(String fileName,String folderName) {
        imageFileHandle.deleteImage(fileName,folderName);
    }

}
