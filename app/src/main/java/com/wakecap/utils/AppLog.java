package com.wakecap.utils;

import android.util.Log;

/**
 * Created by Bhavik on 3/11/15.
 */
public class AppLog {
    private static boolean debug = true;

    public static void e(String tag, String message) {
        if (debug) {
            Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Exception e) {
        if (debug) {
            Log.e(tag, message, e);
        }
    }

    public static void w(String tag, String message) {
        if (debug) {
            Log.w(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (debug) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (debug) {
            Log.i(tag, message);
        }
    }

    public static void wtf(String tag, String message) {
        if (debug) {
            Log.wtf(tag, message);
        }
    }

    public static void wtf(String tag, String message, Exception e) {
        if (debug) {
            Log.wtf(tag, message, e);
        }
    }

    public static void e(String tag, int value) {
        AppLog.e(tag, String.valueOf(value));
    }

    public static void e(String tag, float value) {
        AppLog.e(tag, String.valueOf(value));
    }

    public static void e(String tag, double value) {
        AppLog.e(tag, String.valueOf(value));
    }

    public static void e(String tag, boolean value) {
        AppLog.e(tag, String.valueOf(value));
    }

    public static void w(String tag, int value) {
        AppLog.w(tag, String.valueOf(value));
    }

    public static void w(String tag, float value) {
        AppLog.w(tag, String.valueOf(value));
    }

    public static void w(String tag, double value) {
        AppLog.w(tag, String.valueOf(value));
    }

    public static void w(String tag, boolean value) {
        AppLog.w(tag, String.valueOf(value));
    }

    public static void d(String tag, int value) {
        AppLog.d(tag, String.valueOf(value));
    }

    public static void d(String tag, float value) {
        AppLog.d(tag, String.valueOf(value));
    }

    public static void d(String tag, double value) {
        AppLog.d(tag, String.valueOf(value));
    }

    public static void d(String tag, boolean value) {
        AppLog.d(tag, String.valueOf(value));
    }

    public static void i(String tag, int value) {
        AppLog.i(tag, String.valueOf(value));
    }

    public static void i(String tag, float value) {
        AppLog.i(tag, String.valueOf(value));
    }

    public static void i(String tag, double value) {
        AppLog.i(tag, String.valueOf(value));
    }

    public static void i(String tag, boolean value) {
        AppLog.i(tag, String.valueOf(value));
    }

    public static void wtf(String tag, int value) {
        AppLog.wtf(tag, String.valueOf(value));
    }

    public static void wtf(String tag, float value) {
        AppLog.wtf(tag, String.valueOf(value));
    }

    public static void wtf(String tag, double value) {
        AppLog.wtf(tag, String.valueOf(value));
    }

    public static void wtf(String tag, boolean value) {
        AppLog.wtf(tag, String.valueOf(value));
    }

    public static void enableLogging() {
        debug = true;
    }
}
