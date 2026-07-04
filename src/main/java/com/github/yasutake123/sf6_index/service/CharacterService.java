package com.github.yasutake123.sf6_index.service;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.yasutake123.sf6_index.dto.Move;
import com.github.yasutake123.sf6_index.dto.Section;
import com.github.yasutake123.sf6_index.repository.CharacterRepository;
// ⬇️ 技データを取得するためのリポジトリをインポートしてください
import com.github.yasutake123.sf6_index.repository.MoveRepository; 

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private MoveRepository moveRepository; // ⭕ 技用リポジトリを注入

    /** DBからデータを取得し、従来のList<Move>の形式に変換して返す */
    public List<Move> getData() throws IOException {
        List<Section> sections = getSections();
        if (!sections.isEmpty()) {
            return sections.get(0).getMoves();
        }
        return new ArrayList<>();
    }
    
    public List<Section> getSections() throws IOException {
        // 1. DBからすべてのエンティティを取得
        var allMoveEntities = moveRepository.findAll(); 

        // 2. 画面に渡す全体のリストを準備
        List<Section> dtoSections = new ArrayList<>();
        
        // とりあえず1つのセクションにまとめます（必要に応じてentityのsectionIdで分割してください）
        Section defaultSection = new Section();
        defaultSection.setCategory("NORMAL MOVES"); 
        
        List<Move> dtoMoves = new ArrayList<>();
        
        for (var entity : allMoveEntities) {
            Move dtoMove = new Move();
            
            // ─── 1階部分：基本情報のマッピング ───
            dtoMove.setName(entity.getName());
            dtoMove.setInput(entity.getInput());
            dtoMove.setIsDown(entity.isIsDown());
            dtoMove.setDamage(entity.getDamage());
            dtoMove.setCancel(entity.getCancel());
            dtoMove.setAttribute(entity.getAttribute());
            dtoMove.setCorrection(entity.getCorrection());
            dtoMove.setSaGaugeGain(entity.getSaGaugeGain());
            dtoMove.setNotes(entity.getNotes());
            
            // ─── 2階部分：MotionFrame（動作フレーム）の組み立て ───
            // 画面エラー「move.motionFrame.startup」の原因はここが未作成だったことです！
            com.github.yasutake123.sf6_index.dto.MotionFrame motion = new com.github.yasutake123.sf6_index.dto.MotionFrame();
            motion.setStartup(entity.getStartup()); // "4" や "6" など
            motion.setActive(entity.getActive());   // "4-5" など
            motion.setTotal(entity.getTotal());     // "9" や "13" など
            dtoMove.setMotionFrame(motion); // 親の Move にセット
            
            // ─── 2階部分：Advantage（硬直差）の組み立て ───
            com.github.yasutake123.sf6_index.dto.Advantage adv = new com.github.yasutake123.sf6_index.dto.Advantage();
            adv.setHit(entity.getHitAdvantage());        // "5" や "1" など
            adv.setGuard(entity.getGuardAdvantage());    // "-1" や "-5" など
            dtoMove.setAdvantage(adv); // 親の Move にセット

            // ─── 2階部分：DriveGauge（ドライブゲージ量）の組み立て ───
            com.github.yasutake123.sf6_index.dto.DriveGauge drive = new com.github.yasutake123.sf6_index.dto.DriveGauge();
            drive.setHit(entity.getDriveHit());
            drive.setBlock(entity.getDriveBlock());
            drive.setPunish(entity.getDrivePunish());
            dtoMove.setDriveGauge(drive); // 親の Move にセット

            dtoMoves.add(dtoMove);
        }
        
        defaultSection.setMoves(dtoMoves);
        dtoSections.add(defaultSection);
        
        return dtoSections;
    }
}