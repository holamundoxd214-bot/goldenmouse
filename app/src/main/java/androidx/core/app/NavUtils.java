package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.Build$VERSION;
import android.util.Log;
import androidx.annotation.ReplaceWith;

public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    private NavUtils() {
        super();
    }

    public static Intent getParentActivityIntent(Activity arg3) {
        Intent v0 = arg3.getParentActivityIntent();
        if(v0 != null) {
            return v0;
        }

        String v0_1 = NavUtils.getParentActivityName(arg3);
        Intent v1 = null;
        if(v0_1 == null) {
            return v1;
        }

        ComponentName v2 = new ComponentName(((Context)arg3), v0_1);
        try {
            if(NavUtils.getParentActivityName(((Context)arg3), v2) == null) {
                return Intent.makeMainActivity(v2);
            }

            return new Intent().setComponent(v2);
        }
        catch(PackageManager$NameNotFoundException ) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName \'" + v0_1 + "\' in manifest");
            return v1;
        }
    }

    public static Intent getParentActivityIntent(Context arg2, ComponentName arg3) throws PackageManager$NameNotFoundException {
        String v0 = NavUtils.getParentActivityName(arg2, arg3);
        if(v0 == null) {
            return null;
        }

        ComponentName v1 = new ComponentName(arg3.getPackageName(), v0);
        if(NavUtils.getParentActivityName(arg2, v1) == null) {
            return Intent.makeMainActivity(v1);
        }

        return new Intent().setComponent(v1);
    }

    public static Intent getParentActivityIntent(Context arg1, Class arg2) throws PackageManager$NameNotFoundException {
        String v2 = NavUtils.getParentActivityName(arg1, new ComponentName(arg1, arg2));
        if(v2 == null) {
            return null;
        }

        ComponentName v0 = new ComponentName(arg1, v2);
        if(NavUtils.getParentActivityName(arg1, v0) == null) {
            return Intent.makeMainActivity(v0);
        }

        return new Intent().setComponent(v0);
    }

    public static String getParentActivityName(Activity arg1) {
        try {
            return NavUtils.getParentActivityName(((Context)arg1), arg1.getComponentName());
        }
        catch(PackageManager$NameNotFoundException v1) {
            throw new IllegalArgumentException(((Throwable)v1));
        }
    }

    public static String getParentActivityName(Context arg3, ComponentName arg4) throws PackageManager$NameNotFoundException {
        PackageManager v0 = arg3.getPackageManager();
        int v1 = Build$VERSION.SDK_INT >= 29 ? 0x100C0280 : 0xC0280;
        ActivityInfo v4 = v0.getActivityInfo(arg4, v1);
        String v0_1 = v4.parentActivityName;
        if(v0_1 != null) {
            return v0_1;
        }

        String v1_1 = null;
        if(v4.metaData == null) {
            return v1_1;
        }

        String v4_1 = v4.metaData.getString("android.support.PARENT_ACTIVITY");
        if(v4_1 == null) {
            return v1_1;
        }

        if(v4_1.charAt(0) == 46) {
            return arg3.getPackageName() + v4_1;
        }

        return v4_1;
    }

    public static void navigateUpFromSameTask(Activity arg3) {
        Intent v0 = NavUtils.getParentActivityIntent(arg3);
        if(v0 != null) {
            NavUtils.navigateUpTo(arg3, v0);
            return;
        }

        throw new IllegalArgumentException("Activity " + arg3.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    @ReplaceWith(expression="sourceActivity.navigateUpTo(upIntent)") @Deprecated public static void navigateUpTo(Activity arg0, Intent arg1) {
        arg0.navigateUpTo(arg1);
    }

    @ReplaceWith(expression="sourceActivity.shouldUpRecreateTask(targetIntent)") @Deprecated public static boolean shouldUpRecreateTask(Activity arg0, Intent arg1) {
        return arg0.shouldUpRecreateTask(arg1);
    }
}

