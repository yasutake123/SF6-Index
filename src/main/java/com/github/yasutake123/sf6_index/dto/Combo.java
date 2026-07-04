package com.github.yasutake123.sf6_index.dto;

public class Combo {
    private String recipe;
    private Integer damage;
    private Integer driveGauge;
    private Integer saGaugeGain;
    private String notes;

    public String getRecipe() { return recipe; }
    public void setRecipe(String recipe) { this.recipe = recipe; }

    public Integer getDamage() { return damage; }
    public void setDamage(Integer damage) { this.damage = damage; }

    public Integer getDriveGauge() { return driveGauge; }
    public void setDriveGauge(Integer driveGauge) { this.driveGauge = driveGauge; }

    public Integer getSaGaugeGain() { return saGaugeGain; }
    public void setSaGaugeGain(Integer saGaugeGain) { this.saGaugeGain = saGaugeGain; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
