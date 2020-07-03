package com.trang2k.demo.response;

import com.trang2k.demo.models.BlogModel;

import java.util.List;

public class ResponseListBlogResult {

    Integer count;
    Integer currentPage;
    Integer lastPage;
    private List<BlogModel> lstBlogModel;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public List<BlogModel> getLstBlogModel() {
        return lstBlogModel;
    }

    public void setLstBlogModel(List<BlogModel> lstBlogModel) {
        this.lstBlogModel = lstBlogModel;
    }
}
