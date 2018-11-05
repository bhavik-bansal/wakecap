package com.booko.utils;


import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by bhavikbansal on 7/8/17.
 */

public class Config {

    private static final boolean isDebug = true;
    private static String url = "https://api.booko.com";

    public static HttpLoggingInterceptor.Level getLoggingInterceptor() {
        if (isDebug) {
            return HttpLoggingInterceptor.Level.BODY;
        } else {
            return HttpLoggingInterceptor.Level.NONE;
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static String getBaseUrl() {
        return url;
    }

}
