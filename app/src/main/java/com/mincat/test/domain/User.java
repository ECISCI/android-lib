package com.mincat.test.domain;

/**
 * @author Mings
 */

public class User {

    private int code;

    private ResultData data;

    private String info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultData getData() {
        return data;
    }

    public void setData(ResultData data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "User{" + "code=" + code + ", data=" + data + ", info='" + info + '\'' + '}';
    }
}
