package com.hrt.smartpatrolsystem.common.vos;

import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: ReponseResult
 * Package: com.hrt.smartpatrolsystem.common.dtos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/29 - 13:20
 * @Version: v1.0
 */

public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;


    public ResponseResult() {
        this.code = 1;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }

    public static ResponseResult okResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, msg);
    }

    public static ResponseResult okResult(Object data) {
        ResponseResult result = setHttpCodeEnum(HttpCodeEnum.SUCCESS, HttpCodeEnum.SUCCESS.getMsg());
        if(data!=null) {
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult errorResult(HttpCodeEnum enums){
        return setHttpCodeEnum(enums,enums.getMsg());
    }

    public static ResponseResult errorResult(HttpCodeEnum enums, String msg){
        return setHttpCodeEnum(enums,msg);
    }

    public static ResponseResult setHttpCodeEnum(HttpCodeEnum enums){
        return okResult(enums.getCode(),enums.getMsg());
    }

    private static ResponseResult setHttpCodeEnum(HttpCodeEnum enums, String msg){
        return okResult(enums.getCode(),msg);
    }
    public ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
