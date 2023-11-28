package com.example.demo.domain.ImageFile;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface ImageFileHandle {
    ImageFile uploadImageFile(MultipartFile file, String folderName);
    List<ImageFile> uploadImageFiles(MultipartFile[] file, String folderName);
    void deleteImage(String fileName, String folderName);
}
