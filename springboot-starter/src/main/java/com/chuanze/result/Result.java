package com.chuanze.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Result<T> {
    private int status;
    private String msg;
    private T data;

    public Result(int status) {
        this.status = status;
    }

    public Result(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public Result(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResultCode.SUCCESS.getCode();
    }
    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }
    public static <T> Result<T> createBySuccess(){
        return new Result<T>(ResultCode.SUCCESS.getCode());
    }

    public static <T> Result<T> createBySuccessMessage(String msg){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> createBySuccess(T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),data);
    }

    public static <T> Result<T> createBySuccess(String msg,T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> Result<T> createByError(){
        return new Result<T>(ResultCode.ERROR.getCode(),ResultCode.ERROR.getDesc());
    }


    public static <T> Result<T> createByErrorMessage(String errorMessage){
        return new Result<T>(ResultCode.ERROR.getCode(),errorMessage);
    }

    public static <T> Result<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new Result<T>(errorCode,errorMessage);
    }


}
