package com.github.yasutake123.sf6_index.controller;

import com.github.yasutake123.sf6_index.dto.CharacterData;
import com.github.yasutake123.sf6_index.dto.Move;

import org.springframework.web.bind.annotation.RestController;  // コントローラーを定義するために使用する
import org.springframework.web.bind.annotation.GetMapping;      // メソッドをマッピングするために使用する
import org.springframework.beans.factory.annotation.Autowired;  // 依存性注入を行うために使用する

import org.springframework.core.io.ResourceLoader;              // 本（ファイル）の場所を指定する
import org.springframework.core.io.Resource;                    // 本の名前を決める
import org.springframework.util.StreamUtils;                    // 本を読んでもらう

import java.nio.charset.StandardCharsets;                       // 文字コードを指定する(UTF-8)
import java.io.IOException;                                     // ファイルを読み込む際に発生するErrorを投げる

import com.fasterxml.jackson.databind.ObjectMapper; // 変換器(json -> java)：文字列からjavaが使えるデータ構造に変換する（パースする）

import java.util.List;


@RestController
public class CharacterController {

    // この@Autowiredは、Springが自動的にResourceLoaderを注入するために使用する
    @Autowired
    private ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Jsonファイルを文字列のまま取得する
    @GetMapping("/alex-data")
    public String getAlexJson() throws IOException {
        // "classpath:"は、src/main/resourcesフォルダーからファイルを読み込むためのプレフィックス
        Resource resource = resourceLoader.getResource("classpath:json/ALEX_v1.0.json");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    // Alexのデータを取得する
    @GetMapping("/alex-data/json")
    public Object getAlexData() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:json/ALEX_v1.0.json");

        CharacterData characterData = objectMapper.readValue(resource.getInputStream(), CharacterData.class);
        List<Move> moves = characterData.getSections().get(0).getMoves();
        return moves;
    }
}