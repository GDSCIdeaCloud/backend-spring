package com.example.demo.db.repository;

import com.example.demo.db.entity.ImageFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlobalImageRepository extends JpaRepository<ImageFileEntity,Long> {

}

