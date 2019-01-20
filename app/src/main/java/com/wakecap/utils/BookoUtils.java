package com.wakecap.utils;

import android.app.Activity;
import android.content.Intent;

public class BookoUtils {

    /**
     * lunch main activity
     *
     * @param activity
     * @param c
     */
    public static void launchMainActivity(Activity activity, Class<?> c) {
        Intent intent = new Intent(activity, c);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }
}
