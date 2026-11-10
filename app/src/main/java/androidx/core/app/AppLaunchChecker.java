package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class AppLaunchChecker {
    private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";
    private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";

    @Deprecated public AppLaunchChecker() {
        super();
    }

    public static boolean hasStartedFromLauncher(Context arg2) {
        return arg2.getSharedPreferences("android.support.AppLaunchChecker", 0).getBoolean("startedFromLauncher", false);
    }

    public static void onActivityCreate(Activity arg4) {
        SharedPreferences v0 = arg4.getSharedPreferences("android.support.AppLaunchChecker", 0);
        String v2 = "startedFromLauncher";
        if(v0.getBoolean(v2, false)) {
        }
        else {
            Intent v4 = arg4.getIntent();
            if(v4 == null) {
            }
            else if("android.intent.action.MAIN".equals(v4.getAction())) {
                if(!v4.hasCategory("android.intent.category.LAUNCHER") && !v4.hasCategory("android.intent.category.LEANBACK_LAUNCHER")) {
                    return;
                }

                v0.edit().putBoolean(v2, true).apply();
            }
        }
    }
}

