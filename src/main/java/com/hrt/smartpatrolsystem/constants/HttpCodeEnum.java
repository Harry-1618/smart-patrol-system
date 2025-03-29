package com.hrt.smartpatrolsystem.constants;

/**
 * ClassName: HttpCodeEnum
 * Package: com.hrt.smartpatrolsystem.constants
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/29 - 14:37
 * @Version: v1.0
 */
public enum HttpCodeEnum {

    // 成功段固定为200
    SUCCESS(200,"操作成功"),
    // 登录段1~50
    NEED_LOGIN(1,"需要登录后操作"),
    LOGIN_PASSWORD_ERROR(2,"密码错误");

    int code;

    String msg;

    HttpCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
