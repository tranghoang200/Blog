package com.trang2k.demo.response;

public class ResponseBlog {

    private String ErrorMessage;
    private ResponseBlogResult responseBlogResult;

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public ResponseBlogResult getResponseBlogResult() {
        return responseBlogResult;
    }

    public void setResponseBlogResult(ResponseBlogResult responseBlogResult) {
        this.responseBlogResult = responseBlogResult;
    }

}
