package androidx.core.app;

import android.app.ActivityManager;
import androidx.annotation.ReplaceWith;

public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
        super();
    }

    @ReplaceWith(expression="activityManager.isLowRamDevice()") @Deprecated public static boolean isLowRamDevice(ActivityManager arg0) {
        return arg0.isLowRamDevice();
    }
}

