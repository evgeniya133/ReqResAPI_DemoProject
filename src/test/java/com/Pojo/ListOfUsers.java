package com.Pojo;

import java.util.List;

public class ListOfUsers {
    private List<Data> data;
    private Support support;
    private int page;
    private int per_page;
    private int total;
    private int total_pages;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    @Override
    public String toString() {
        return "ListOfUsers{" +
                "data=" + data +
                ", support=" + support +
                ", page=" + page +
                ", per_page=" + per_page +
                ", total=" + total +
                ", total_pages=" + total_pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfUsers)) return false;
        ListOfUsers that = (ListOfUsers) o;
        return page == that.page &&
                per_page == that.per_page &&
                total == that.total &&
                total_pages == that.total_pages &&
                data.equals(that.data) &&
                support.equals(that.support);
    }
}
