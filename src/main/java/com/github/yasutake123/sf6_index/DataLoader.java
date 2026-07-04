package com.github.yasutake123.sf6_index;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yasutake123.sf6_index.dto.CharacterJsonDto;
import com.github.yasutake123.sf6_index.entity.CharacterEntity;
import com.github.yasutake123.sf6_index.entity.SectionEntity;
import com.github.yasutake123.sf6_index.entity.MoveEntity;
import com.github.yasutake123.sf6_index.repository.CharacterRepository;
import com.github.yasutake123.sf6_index.repository.SectionRepository;
import com.github.yasutake123.sf6_index.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CharacterRepository characterRepository;
    
    @Autowired
    private SectionRepository sectionRepository;
    
    @Autowired
    private MoveRepository moveRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        // 1. 重複インポート防止ガード
        if (characterRepository.existsById("ALEX")) {
            System.out.println("--- ALEXのデータは既に存在するため、インポートをスキップします ---");
            return;
        }

        // 2. JSONファイルの読み込み
        InputStream inputStream = getClass().getResourceAsStream("/ALEX_v1.2.json");
        if (inputStream == null) {
            System.out.println("--- エラー: ALEX_v1.2.json が見つかりません ---");
            return;
        }
        CharacterJsonDto json = objectMapper.readValue(inputStream, CharacterJsonDto.class);

        // 3. Character Entityの作成と保存
        CharacterEntity character = new CharacterEntity();
        character.setId(json.character); // "ALEX"
        character.setName("アレックス");
        character.setVersion(json.version);
        characterRepository.save(character);

        // 4. セクション（カテゴリ）と技のループ処理
        for (CharacterJsonDto.SectionJsonDto secDto : json.sections) {
            SectionEntity section = new SectionEntity();
            section.setId(json.character + "_" + secDto.category);
            section.setCharacter(character);
            section.setCategory(secDto.category);
            sectionRepository.save(section);

            for (CharacterJsonDto.MoveJsonDto moveDto : secDto.moves) {
                MoveEntity move = new MoveEntity();
                
                // 基本識別子・情報
                move.setId(json.character + "_" + moveDto.input);
                move.setSection(section);
                move.setName(moveDto.name);
                move.setInput(moveDto.input);
                
                // 動作フレーム (motionFrame) のマッピング
                if (moveDto.motionFrame != null) {
                    move.setStartup(moveDto.motionFrame.startup);
                    move.setStartupVal(moveDto.motionFrame.startupVal);
                    move.setActive(moveDto.motionFrame.active);
                    move.setActiveVal(moveDto.motionFrame.activeVal);
                    move.setTotal(moveDto.motionFrame.total);
                    move.setTotalVal(moveDto.motionFrame.totalVal);
                }
                
                // 硬直差 (advantage) のマッピング
                if (moveDto.advantage != null) {
                    move.setHitAdvantage(moveDto.advantage.hit);
                    move.setHitAdvantageVal(moveDto.advantage.hitVal);
                    move.setGuardAdvantage(moveDto.advantage.guard);
                    move.setGuardAdvantageVal(moveDto.advantage.guardVal);
                }
                
                // ドライブゲージ (driveGauge) のマッピング
                if (moveDto.driveGauge != null) {
                    move.setDriveHit(moveDto.driveGauge.hit);
                    move.setDriveBlock(moveDto.driveGauge.block);
                    move.setDrivePunish(moveDto.driveGauge.punish);
                }
                
                // その他の属性・パラメータ
                move.setIsDown(moveDto.isDown);
                move.setDamage(moveDto.damage);
                move.setCancel(moveDto.cancel);
                move.setAttribute(moveDto.attribute);
                move.setCorrection(moveDto.correction);
                move.setSaGaugeGain(moveDto.saGaugeGain);
                move.setNotes(moveDto.notes);
                
                moveRepository.save(move);
            }
        }
        System.out.println("--- JSONデータのインポートが完了しました ---");
    }
}