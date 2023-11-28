package com.example.demo.service;

import com.example.demo.db.entity.ImageFileEntity;
import com.example.demo.domain.ImageFile.repository.ImageFileRepository;
import com.example.demo.dto.ImageDtos.ImageDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
@RequiredArgsConstructor
@Transactional
@Service
public class GlobalImageFileService {
    private final ImageFileRepository imageFileRepository;
    private final ImageFileService imageFileService;
    @Transactional(readOnly = true)
    public ImageDto getGlobalImageFileById(Long id) {
        ImageFileEntity imageFileEntity = imageFileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Image not found for id: " + id));
        return new ImageDto(imageFileEntity);
    }

    public ImageDto uploadGlobalImageFile(MultipartFile file, String folderName) {
        String fileName = imageFileService.uploadImageFile(file,folderName);
        ImageFileEntity imageFileEntity = new ImageFileEntity(file,fileName,folderName);
        imageFileRepository.save(imageFileEntity);
        return new ImageDto(imageFileEntity);
    }

    public List<ImageDto> uploadGlobalImageFiles(MultipartFile[] files, String folderName) {
        List<ImageDto> uploadImageFiles= imageFileService.uploadImageFiles(files,folderName);
        List<ImageFileEntity> uploadedFiles = uploadImageFiles.stream().map(i->new ImageFileEntity(i.toImageFile())).toList();
        imageFileRepository.saveAll(uploadedFiles);
        return uploadImageFiles;
    }
}
