package com.github.yasutake123.sf6_index.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sections")
public class SectionEntity {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private CharacterEntity character;

    private String category;

    // ゲッター・セッター
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public CharacterEntity getCharacter() { return character; }
    public void setCharacter(CharacterEntity character) { this.character = character; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}