package com.github.yasutake123.sf6_index.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MotionFrame {
    private String startup;
    private String active;
    private String total;
    @JsonProperty("startup_val")
    private Integer startupVal;
    @JsonProperty("active_val")
    private Integer activeVal;
    @JsonProperty("total_val")
    private Integer totalVal;

    public String getStartup() { return startup; }
    public void setStartup(String startup) { this.startup = startup; }
    
    public String getActive() { return active; }
    public void setActive(String active) { this.active = active; }
    
    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }

    public Integer getStartupVal() { return startupVal; }
    public void setStartupVal(Integer startupVal) { this.startupVal = startupVal; }
    
    public Integer getActiveVal() { return activeVal; }
    public void setActiveVal(Integer activeVal) { this.activeVal = activeVal; }
    
    public Integer getTotalVal() { return totalVal; }
    public void setTotalVal(Integer totalVal) { this.totalVal = totalVal; }
}