package com.github.yasutake123.sf6_index.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Advantage {
    private String hit;
    private String guard;
    @JsonProperty("hit_val")
    private Integer hitVal;
    @JsonProperty("guard_val")
    private Integer guardVal;

    public String getHit() { return hit; }
    public void setHit(String hit) { this.hit = hit; }

    public String getGuard() { return guard; }
    public void setGuard(String guard) { this.guard = guard; }

    public Integer getHitVal() { return hitVal; }
    public void setHitVal(Integer hitVal) { this.hitVal = hitVal; }

    public Integer getGuardVal() { return guardVal; }
    public void setGuardVal(Integer guardVal) { this.guardVal = guardVal; }
}