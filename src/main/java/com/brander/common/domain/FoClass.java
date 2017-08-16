package com.brander.common.domain;

import java.util.Date;

public class FoClass {
    private Integer id;

    private Integer fid;

    private String nexus;

    private Integer depth;

    private String name;

    private Integer sort;

    private Date ctime;

    private Integer zcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getNexus() {
        return nexus;
    }

    public void setNexus(String nexus) {
        this.nexus = nexus == null ? null : nexus.trim();
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getZcount() {
        return zcount;
    }

    public void setZcount(Integer zcount) {
        this.zcount = zcount;
    }

    @Override
    public String toString() {
        return "FoClass{" +
                "id=" + id +
                ", fid=" + fid +
                ", nexus='" + nexus + '\'' +
                ", depth=" + depth +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", ctime=" + ctime +
                ", zcount=" + zcount +
                '}';
    }
}