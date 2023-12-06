package com.example.demo.db.repository;

import com.example.demo.db.entity.IdeaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaRepository extends JpaRepository<IdeaEntity, Long> {
}
