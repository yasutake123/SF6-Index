package com.github.yasutake123.sf6_index.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "moves")
public class MoveEntity {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity section;

    private String name;
    private String input;
    
    private String startup;
    @Column(name = "startup_val")
    private int startupVal;
    
    private String active;
    @Column(name = "active_val")
    private int activeVal;
    
    private String total;
    @Column(name = "total_val")
    private int totalVal;
    
    @Column(name = "hit_advantage")
    private String hitAdvantage;
    @Column(name = "hit_advantage_val")
    private int hitAdvantageVal;
    
    @Column(name = "guard_advantage")
    private String guardAdvantage;
    @Column(name = "guard_advantage_val")
    private int guardAdvantageVal;
    
    @Column(name = "is_down")
    private boolean isDown;
    
    private String damage;
    private String cancel;
    private String attribute;
    private String correction;
    
    @Column(name = "drive_hit")
    private int driveHit;
    @Column(name = "drive_block")
    private int driveBlock;
    @Column(name = "drive_punish")
    private int drivePunish;
    
    @Column(name = "sa_gauge_gain")
    private String saGaugeGain;
    
    private String notes;

    // --- 以下、DataLoaderで必要になるゲッター・セッター ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public SectionEntity getSection() { return section; }
    public void setSection(SectionEntity section) { this.section = section; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getInput() { return input; }
    public void setInput(String input) { this.input = input; }
    public String getStartup() { return startup; }
    public void setStartup(String startup) { this.startup = startup; }
    public int getStartupVal() { return startupVal; }
    public void setStartupVal(int startupVal) { this.startupVal = startupVal; }
    public String getActive() { return active; }
    public void setActive(String active) { this.active = active; }
    public int getActiveVal() { return activeVal; }
    public void setActiveVal(int activeVal) { this.activeVal = activeVal; }
    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }
    public int getTotalVal() { return totalVal; }
    public void setTotalVal(int totalVal) { this.totalVal = totalVal; }
    public String getHitAdvantage() { return hitAdvantage; }
    public void setHitAdvantage(String hitAdvantage) { this.hitAdvantage = hitAdvantage; }
    public int getHitAdvantageVal() { return hitAdvantageVal; }
    public void setHitAdvantageVal(int hitAdvantageVal) { this.hitAdvantageVal = hitAdvantageVal; }
    public String getGuardAdvantage() { return guardAdvantage; }
    public void setGuardAdvantage(String guardAdvantage) { this.guardAdvantage = guardAdvantage; }
    public int getGuardAdvantageVal() { return guardAdvantageVal; }
    public void setGuardAdvantageVal(int guardAdvantageVal) { this.guardAdvantageVal = guardAdvantageVal; }
    public boolean isIsDown() { return isDown; }
    public void setIsDown(boolean isDown) { this.isDown = isDown; }
    public String getDamage() { return damage; }
    public void setDamage(String damage) { this.damage = damage; }
    public String getCancel() { return cancel; }
    public void setCancel(String cancel) { this.cancel = cancel; }
    public String getAttribute() { return attribute; }
    public void setAttribute(String attribute) { this.attribute = attribute; }
    public String getCorrection() { return correction; }
    public void setCorrection(String correction) { this.correction = correction; }
    public int getDriveHit() { return driveHit; }
    public void setDriveHit(int driveHit) { this.driveHit = driveHit; }
    public int getDriveBlock() { return driveBlock; }
    public void setDriveBlock(int driveBlock) { this.driveBlock = driveBlock; }
    public int getDrivePunish() { return drivePunish; }
    public void setDrivePunish(int drivePunish) { this.drivePunish = drivePunish; }
    public String getSaGaugeGain() { return saGaugeGain; }
    public void setSaGaugeGain(String saGaugeGain) { this.saGaugeGain = saGaugeGain; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}