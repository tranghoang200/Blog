package com.trang2k.demo.response;

public class ResponseListLog {

    private String ErrorMessage;
    private ResponseListLogResult responseLogResult;

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public ResponseListLogResult getResponseLogResult() {
        return responseLogResult;
    }

    public void setResponseLogResult(ResponseListLogResult responseLogResult) {
        this.responseLogResult = responseLogResult;
    }

}
