package com.wst.bean;

public class SystemException extends RuntimeException {
    private String code ;

    public SystemException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SystemException{" +
                "code='" + code + '\'' +
                '}';
    }
}
