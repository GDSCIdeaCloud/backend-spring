package com.example.demo.dto;

import com.example.demo.db.entity.ImageFileEntity;
import com.example.demo.domain.ImageFile.model.ImageFile;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class ImageDtos {
    @Getter
    @NoArgsConstructor
    public static class ImageDto {
        private String fileName;
        private String fileType;
        private Long fileSize;
        private String folderName;

        public ImageDto(ImageFile image) {
            this.folderName = image.getFolderName();
            this.fileName = image.getFileName();
            this.fileType = image.getFileType();
            this.fileSize = image.getFileSize();
        }
        public ImageDto(ImageFileEntity image) {
            this.folderName = image.getFolderName();
            this.fileName = image.getFileName();
            this.fileType = image.getFileType();
            this.fileSize = image.getFileSize();
        }

        public ImageFile toImageFile() {
            return new ImageFile(this.fileName,this.fileType,this.fileSize,this.folderName);
        }
    }

}
