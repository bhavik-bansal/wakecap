package com.wakecap.utils;


/**
 * Created by bhavikbansal on 7/8/17.
 */

public class Config {

    private static final boolean isDebug = true;
    private static String url = "https://pilot.wakecap.com";

    public static boolean isDebug() {
        return isDebug;
    }

    public static String getBaseUrl() {
        return url;
    }

}
