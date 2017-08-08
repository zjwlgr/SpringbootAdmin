package com.brander.common.domain;

public class FoManager {
    private Integer id;

    private String username;

    private String password;

    private String uname;

    private Integer groupId;

    private Boolean locking;

    private Integer number;

    private String loginIp;

    private Integer loginTime;

    private Integer ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Boolean getLocking() {
        return locking;
    }

    public void setLocking(Boolean locking) {
        this.locking = locking;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Integer getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Integer loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "FoManager{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uname='" + uname + '\'' +
                ", groupId=" + groupId +
                ", locking=" + locking +
                ", number=" + number +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", ctime=" + ctime +
                '}';
    }
}