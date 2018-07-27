package com.chuanze.result;

public enum  ResultCode {

    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    NEED_LOGIN(10,"需要登陆"),
    ILLEGAL_ARGUMENT(2,"请求失败"),
    SERVER_ERROR(500,"服务器异常");

    private String desc;
    private int code;
    ResultCode(int code,String _desc){
        this.desc=_desc;
        this.code=code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
