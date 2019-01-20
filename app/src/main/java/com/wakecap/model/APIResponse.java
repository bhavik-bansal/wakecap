package com.wakecap.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wakecap.rest.HttpResultType;

/**
 * Created by bhavik on 18/11/16.
 */

public class APIResponse<T> {
    private int status;
    private String message;
    private T data;
    private HttpResultType result;


    private APIResponse(@NonNull HttpResultType result, @Nullable T data,
                        @Nullable String message) {
        this.result = result;
        this.data = data;
        this.message = message;
    }

    private APIResponse(@NonNull HttpResultType result,
                        @Nullable String message) {
        this.result = result;
        this.message = message;
    }

    public static <T> APIResponse<T> success(@NonNull APIResponse<T> data) {
        return new APIResponse<>(HttpResultType.SUCCESS, data.getData(), data.getMessage());
    }

    public static <T> APIResponse<T> error(String msg, @Nullable T data) {
        return new APIResponse<>(HttpResultType.ERROR, data, msg);
    }

    public static APIResponse loading() {
        return new APIResponse(HttpResultType.LOADING, null);
    }

    public HttpResultType getResult() {
        return result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
