package com.github.yasutake123.sf6_index.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.yasutake123.sf6_index.entity.MoveEntity; // お使いのMoveEntityのクラス名

@Repository
public interface MoveRepository extends JpaRepository<MoveEntity, String> {
    // 基本的なCRUD操作（findAllなど）はこれだけで自動的に使えます
}