package com.example.demo.domain.ImageFile.model;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class ImageFile {
    protected MultipartFile file;
    protected String fileName;
    protected String fileType;
    protected Long fileSize;
    protected String folderName;
    public ImageFile(String fileName, String fileType, Long fileSize, String folderName) {
        this.file = null;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.folderName = folderName;
    }

    public ImageFile(MultipartFile file, String fileName, String fileType, Long fileSize, String folderName) {
        this.file = file;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.folderName = folderName;
    }
}
