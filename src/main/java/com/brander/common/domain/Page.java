package com.brander.common.domain;

/**
 * 分页属性类，会被实现分页的类继承
 */
public class Page {

    private Integer page = 1;

    private Integer rows = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
