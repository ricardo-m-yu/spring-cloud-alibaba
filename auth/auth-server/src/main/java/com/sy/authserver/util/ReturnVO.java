package com.sy.authserver.util;

import java.io.Serializable;


public final class ReturnVO<T> implements Serializable {
    private int code = 200;
    private String message = "SUCCESS";
    private T data;

    private ReturnVO() {
    }

    public static <T> ReturnVO<T> success() {
        ReturnVO<T> r = new ReturnVO<>();
        return r;
    }

    public static <T> ReturnVO<T> success(T data) {
        ReturnVO<T> r = new ReturnVO<>();
        r.data = data;
        return r;
    }


    public static <T> ReturnVO<T> failed(String message) {
        ReturnVO<T> r = new ReturnVO<>();
        r.code = 500;
        r.message = message;
        r.data = null;
        return r;
    }


    public static <T> ReturnVO<T> failed(int code, String message) {
        ReturnVO<T> r = new ReturnVO<>();
        r.code = code;
        r.message = message;
        return r;
    }

    public static <T> ReturnVO<T> failed(int code, String message, T data) {
        ReturnVO<T> r = new ReturnVO<>();
        r.code = code;
        r.message = message;
        r.data = data;
        return r;
    }


    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }
}
