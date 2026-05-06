package com.github.yasutake123.sf6_index.service;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yasutake123.sf6_index.dto.CharacterData;
import com.github.yasutake123.sf6_index.dto.Move;
import com.github.yasutake123.sf6_index.dto.Section;

@Service
public class CharacterService {

    @Autowired
    private ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Move> getData() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:json/ALEX_v1.2.json");
        CharacterData characterData = objectMapper.readValue(resource.getInputStream(), CharacterData.class);
        return characterData.getSections().get(0).getMoves();
    }
    
    public List<Section> getSections() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:json/ALEX_v1.2.json");
        CharacterData characterData = objectMapper.readValue(resource.getInputStream(), CharacterData.class);
        return characterData.getSections();
    }
    
    /** keyword が null / 空ならフィルタせず全件。それ以外は名前の部分一致（大文字小文字無視）。 */
    public List<Section> searchMovesByName(String keyword) throws IOException {
        List<Section> allSections = getSections();
        List<Section> matchedSections = new ArrayList<>();
        
        if (keyword == null || keyword.isEmpty()) {
            return List.copyOf(allSections);
        }
        
        String needle = keyword.toLowerCase();
        for (Section section : allSections) {

            List<Move> matchedMoves = new ArrayList<>();
            for (Move m : section.getMoves()) {
                if (m.getName().toLowerCase().contains(needle)) {
                    matchedMoves.add(m);
                }
            }
            
            if (!matchedMoves.isEmpty()) {
                Section filteredSection = new Section();
                filteredSection.setCategory(section.getCategory());
                filteredSection.setMoves(matchedMoves);
                matchedSections.add(filteredSection);
            }
        }
        return matchedSections;
    }
}
