package com.github.yasutake123.sf6_index.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yasutake123.sf6_index.dto.Combo;

@Service
public class ComboService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Path COMBO_PATH = Paths.get("src/main/resources/json/ALEX_combos.json");

    public List<Combo> getCombo() throws IOException {
        Combo[] combos = objectMapper.readValue(Files.newInputStream(COMBO_PATH), Combo[].class);
        return new ArrayList<>(Arrays.asList(combos));
    }

    public void addCombo(Combo newCombo) throws IOException {   
        List<Combo> combos = getCombo();
        combos.add(newCombo);   

        try (BufferedWriter writer = Files.newBufferedWriter(COMBO_PATH)) {
            objectMapper.writeValue(writer, combos);
        }
    }
}
