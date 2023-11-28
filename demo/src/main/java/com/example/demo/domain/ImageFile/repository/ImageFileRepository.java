package com.example.demo.domain.ImageFile.repository;

import com.example.demo.db.entity.ImageFileEntity;

import java.util.List;
import java.util.Optional;

public interface ImageFileRepository {
    ImageFileEntity save(ImageFileEntity imageFileEntity);
    Optional<ImageFileEntity> findById(Long id);
    List<ImageFileEntity> saveAll(List<ImageFileEntity> imageFileEntities);
}
