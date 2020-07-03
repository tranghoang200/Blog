package com.trang2k.demo.response;

public class ResponseListBlog {

    private String ErrorMessage;
    private ResponseListBlogResult responseListBlogResult;

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public ResponseListBlogResult getResponseListBlogResult() {
        return responseListBlogResult;
    }

    public void setResponseListBlogResult(ResponseListBlogResult responseListBlogResult) {
        this.responseListBlogResult = responseListBlogResult;
    }

}
