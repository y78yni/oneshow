package com.oneshow.commom.Model;

import io.swagger.models.auth.In;

public class PageModel {
    private Integer pageIndex=1;
    private Integer pageSize=10;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
