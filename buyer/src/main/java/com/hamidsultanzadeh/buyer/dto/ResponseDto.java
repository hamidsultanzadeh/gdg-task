package com.hamidsultanzadeh.buyer.dto;

public class ResponseDto {

    private Integer errorCode;
    private String message;
    private Object obj;

    public ResponseDto() {
    }

    public ResponseDto(Integer errorCode, String message, Object obj) {
        this.errorCode = errorCode;
        this.message = message;
        this.obj = obj;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
