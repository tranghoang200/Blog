package com.trang2k.demo.response;

import com.trang2k.demo.models.LogModel;

import java.util.List;

public class ResponseListLogResult {

    private List<LogModel> lstLogModel;

    public List<LogModel> getLstLogModel() {
        return lstLogModel;
    }

    public void setLstLogModel(List<LogModel> lstLogModel) {
        this.lstLogModel = lstLogModel;
    }

}
