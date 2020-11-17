package com.zuiqiang.user.domain;

public class BookSort {
    private Integer sortId;
    private String sortName;

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    @Override
    public String toString() {
        return "BookSort{" +
                "sortId=" + sortId +
                ", sortName='" + sortName + '\'' +
                '}';
    }
}
