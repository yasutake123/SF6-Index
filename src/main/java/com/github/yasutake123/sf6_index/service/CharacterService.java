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
    public List<Move> searchMovesByName(String keyword) throws IOException {
        List<Move> all = getData();
        List<Move> matched = new ArrayList<>();

        if (keyword == null || keyword.isEmpty()) {
            return List.copyOf(all);
        }

        String needle = keyword.toLowerCase();
        for (Move m : all) {
            String name = m.getName();
            if (name == null || name.isEmpty()) {
                continue;
            }
            if (name.toLowerCase().contains(needle)) {
                matched.add(m);
            }
        }
        return matched;
    }
}
