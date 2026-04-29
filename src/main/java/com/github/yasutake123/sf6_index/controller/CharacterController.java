package com.github.yasutake123.sf6_index.controller;

import org.springframework.web.bind.annotation.RestController;  // コントローラーを定義するために使用する
import org.springframework.web.bind.annotation.GetMapping;      // メソッドをマッピングするために使用する
import org.springframework.beans.factory.annotation.Autowired;  // 依存性注入を行うために使用する

import org.springframework.core.io.ResourceLoader;              // 本（ファイル）の場所を指定する
import org.springframework.core.io.Resource;                    // 本の名前を決める
import org.springframework.util.StreamUtils;                    // 本を読んでもらう

import java.nio.charset.StandardCharsets;                       // 文字コードを指定する(UTF-8)
import java.io.IOException;                                     // ファイルを読み込む際に発生するErrorを投げる

@RestController
public class CharacterController {

    // この@Autowiredは、Springが自動的にResourceLoaderを注入するために使用する
    @Autowired
    private ResourceLoader resourceLoader;

    // データベースからデータを取得する
    @GetMapping("/alex-data")
    public String getAlexJson() throws IOException {
        // "classpath:"は、src/main/resourcesフォルダーからファイルを読み込むためのプレフィックス
        Resource resource = resourceLoader.getResource("classpath:json/ALEX_v1.0.json");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}