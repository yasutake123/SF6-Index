package com.github.yasutake123.sf6_index.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.yasutake123.sf6_index.entity.CharacterEntity; // お使いのエンティティ名

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, String> {
    
    Optional<CharacterEntity> findByName(String name);
}