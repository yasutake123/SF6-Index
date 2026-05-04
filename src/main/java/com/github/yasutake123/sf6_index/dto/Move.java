package com.github.yasutake123.sf6_index.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Move {
    private String name;
    private String input;
    @JsonProperty("motion_frame")
    private MotionFrame motionFrame;
    private Advantage advantage;
    private String damage;
    private String cancel;
    private String attribute;
    private String correction;
    @JsonProperty("drive_gauge")
    private DriveGauge driveGauge;
    @JsonProperty("sa_gauge_gain")
    private String saGaugeGain;
    private String notes;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getInput() { return input; }
    public void setInput(String input) { this.input = input; }

    public MotionFrame getMotionFrame() { return motionFrame; }
    public void setMotionFrame(MotionFrame motionFrame) { this.motionFrame = motionFrame; }
    
    public Advantage getAdvantage() { return advantage; }
    public void setAdvantage(Advantage advantage) { this.advantage = advantage; }
    
    public String getDamage() { return damage; }
    public void setDamage(String damage) { this.damage = damage; }
    
    public String getCancel() { return cancel; }
    public void setCancel(String cancel) { this.cancel = cancel; }
    
    public String getAttribute() { return attribute; }
    public void setAttribute(String attribute) { this.attribute = attribute; }
    
    public DriveGauge getDriveGauge() { return driveGauge; }
    public void setDriveGauge(DriveGauge driveGauge) { this.driveGauge = driveGauge; }
    
    public String getSaGaugeGain() { return saGaugeGain; }
    public void setSaGaugeGain(String saGaugeGain) { this.saGaugeGain = saGaugeGain; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getCorrection() { return correction; }
    public void setCorrection(String correction) { this.correction = correction; }
}
