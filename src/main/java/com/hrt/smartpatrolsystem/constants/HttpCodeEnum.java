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
    SUCCESS(1,"操作成功"),
    // 登录段1~50
    ERROR(0,"操作失败");

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
