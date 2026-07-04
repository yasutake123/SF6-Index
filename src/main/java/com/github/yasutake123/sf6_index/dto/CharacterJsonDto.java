package com.github.yasutake123.sf6_index.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// 1. これが一番外側の親クラス（public）
public class CharacterJsonDto {
    public String version;
    public String character;
    public List<SectionJsonDto> sections;

    // --- 2. カテゴリの階層（必ず CharacterJsonDto の【内側】に書く） ---
    public static class SectionJsonDto {
        public String category;
        public List<MoveJsonDto> moves;
    }

    // --- 3. 技（Move）の階層 ---
    public static class MoveJsonDto {
        public String name;
        public String input;
        
        @JsonProperty("motion_frame")
        public MotionFrameDto motionFrame;
        
        public AdvantageDto advantage;
        
        @JsonProperty("is_down")
        public boolean isDown;
        
        public String damage;
        public String cancel;
        public String attribute;
        public String correction;
        
        @JsonProperty("drive_gauge")
        public DriveGaugeDto driveGauge;
        
        @JsonProperty("sa_gauge_gain")
        public String saGaugeGain;
        
        public String notes;
    }

    // --- 4. 動作フレーム ---
    public static class MotionFrameDto {
        public String startup;
        @JsonProperty("startup_val")
        public int startupVal;
        
        public String active;
        @JsonProperty("active_val")
        public int activeVal;
        
        public String total;
        @JsonProperty("total_val")
        public int totalVal;
    }

    // --- 5. 硬直差 ---
    public static class AdvantageDto {
        public String hit;
        @JsonProperty("hit_val")
        public int hitVal;
        
        public String guard;
        @JsonProperty("guard_val")
        public int guardVal;
    }

    // --- 6. ドライブゲージ ---
    public static class DriveGaugeDto {
        public int hit;
        public int block;
        public int punish;
    }
} // 👈 ここが一番外側のクラスの閉じ括弧。これより下にクラスを書いてはいけません