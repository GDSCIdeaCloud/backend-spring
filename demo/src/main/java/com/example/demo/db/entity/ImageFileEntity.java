package com.example.demo.db.entity;

import com.example.demo.domain.ImageFile.model.ImageFile;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@Getter
@NoArgsConstructor
@Entity(name = "imageFile")
public class ImageFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long imageFileId;
    @Transient
    private MultipartFile file;
    private String fileName;
    private String fileType;
    private Long fileSize;
    private String folderName;

    public ImageFileEntity(MultipartFile file, String fileName, String folderName) {
        this.fileName = fileName;
        this.fileType = file.getContentType();
        this.fileSize = file.getSize();
        this.folderName = folderName;
    }
    public ImageFileEntity(ImageFile imageFile) {
        this.fileName = imageFile.getFileName();
        this.fileType = imageFile.getFileType();
        this.fileSize = imageFile.getFileSize();
        this.folderName = imageFile.getFolderName();
    }
}
