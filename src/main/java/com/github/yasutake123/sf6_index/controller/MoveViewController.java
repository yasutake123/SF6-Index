package com.github.yasutake123.sf6_index.controller;

import com.github.yasutake123.sf6_index.service.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.io.IOException;

@Controller
public class MoveViewController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/table-Alex")
    public String showMoves(Model model) throws IOException{
        model.addAttribute("sections", characterService.getSections());
        return "index";
    }
    
    @GetMapping("/filter-table-Alex")
    public String filterMoves(@RequestParam("keyword") String keyword, 
                            @RequestParam(required = false) Integer minGuard, 
                            Model model) throws IOException{
        model.addAttribute("sections", characterService.searchMovesByName(keyword, minGuard));
        model.addAttribute("keyword", keyword);
        model.addAttribute("minGuard", minGuard);
        return "index";
    }
    
}
