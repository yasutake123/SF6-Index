package com.github.yasutake123.sf6_index.repository;

import com.github.yasutake123.sf6_index.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, String> {
}