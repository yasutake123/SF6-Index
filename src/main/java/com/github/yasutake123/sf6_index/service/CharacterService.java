package com.github.yasutake123.sf6_index.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yasutake123.sf6_index.dto.CharacterData;
import com.github.yasutake123.sf6_index.dto.Move;

@Service
public class CharacterService {

    @Autowired
    private ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Move> getData() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:json/ALEX_v1.0.json");
        CharacterData characterData = objectMapper.readValue(resource.getInputStream(), CharacterData.class);
        return characterData.getSections().get(0).getMoves();
    }
}
