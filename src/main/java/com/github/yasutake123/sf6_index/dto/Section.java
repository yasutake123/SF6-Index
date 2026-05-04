package com.github.yasutake123.sf6_index.dto;

import java.util.List;
    
public class Section {
    private String category;
    private List<Move> moves;

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public List<Move> getMoves() { return moves; }
    public void setMoves(List<Move> moves) { this.moves = moves; }
}