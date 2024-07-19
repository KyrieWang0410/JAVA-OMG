package com.example.common;


/**
 * @author kyrie.Wang
 */

public enum EnumTaskEnable {


    START("2", "开启"),
    STOP("0", "关闭");


    private final String code;


    private final String msg;


    EnumTaskEnable(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }
}
