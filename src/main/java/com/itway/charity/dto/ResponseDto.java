package com.itway.charity.dto;

public class ResponseDto {

    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object object;

    private ResponseDto(){

    }

    public ResponseDto(String succesMessage,Object object){
        this.successMessage=succesMessage;
        this.object=object;
    }

    public ResponseDto(Integer errorCode,String errorMessage,Object object){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.object=object;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
