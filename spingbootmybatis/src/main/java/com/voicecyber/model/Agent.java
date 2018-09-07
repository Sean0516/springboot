package com.voicecyber.model;

import java.util.Date;

public class Agent {
    private Long id;

    private String agentid;

    private String staffName;

    private String description;

    private Long organizationId;

    private String password;

    private Date effectiveTime;

    private Date expiredTime;

    private Long logincount;

    private Date lastlogintime;

    private Short failcount;

    private Date lastfailtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Long getLogincount() {
        return logincount;
    }

    public void setLogincount(Long logincount) {
        this.logincount = logincount;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Short getFailcount() {
        return failcount;
    }

    public void setFailcount(Short failcount) {
        this.failcount = failcount;
    }

    public Date getLastfailtime() {
        return lastfailtime;
    }

    public void setLastfailtime(Date lastfailtime) {
        this.lastfailtime = lastfailtime;
    }
}