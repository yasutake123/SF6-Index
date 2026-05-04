package com.github.yasutake123.sf6_index.dto;

import java.util.List;

public class CharacterData {
    private String version;
    private String character;
    private List<Section> sections;

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public String getCharacter() { return character; }
    public void setCharacter(String character) { this.character = character; }
    
    public List<Section> getSections() { return sections; }
    public void setSections(List<Section> sections) { this.sections = sections; }
}

