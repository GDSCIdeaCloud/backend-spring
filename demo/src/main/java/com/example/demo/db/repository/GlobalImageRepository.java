package com.example.demo.db.repository;

import com.example.demo.db.entity.ImageFileEntity;
import com.example.demo.domain.ImageFile.repository.ImageFileRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlobalImageRepository extends JpaRepository<ImageFileEntity,Long> , ImageFileRepository {
    @Override
    default List<ImageFileEntity> saveAll(List<ImageFileEntity> imageFileEntities) {
        return imageFileEntities.stream().map(entity -> save(entity)).collect(Collectors.toList());
    }

    @Override
    ImageFileEntity save(ImageFileEntity imageFileEntity);
}

