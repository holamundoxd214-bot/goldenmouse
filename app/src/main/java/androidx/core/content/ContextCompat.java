package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import androidx.annotation.ReplaceWith;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public class ContextCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static Context createDeviceProtectedStorageContext(Context arg0) {
            return arg0.createDeviceProtectedStorageContext();
        }

        static File getDataDir(Context arg0) {
            return arg0.getDataDir();
        }

        static boolean isDeviceProtectedStorage(Context arg0) {
            return arg0.isDeviceProtectedStorage();
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static Intent registerReceiver(Context arg6, BroadcastReceiver arg7, IntentFilter arg8, String arg9, Handler arg10, int arg11) {
            if((arg11 & 4) != 0 && arg9 == null) {
                return arg6.registerReceiver(arg7, arg8, ContextCompat.obtainAndCheckReceiverPermission(arg6), arg10);
            }

            return arg6.registerReceiver(arg7, arg8, arg9, arg10, arg11 & 1);
        }

        static ComponentName startForegroundService(Context arg0, Intent arg1) {
            return arg0.startForegroundService(arg1);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Executor getMainExecutor(Context arg0) {
            return arg0.getMainExecutor();
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static Context createAttributionContext(Context arg0, String arg1) {
            return arg0.createAttributionContext(arg1);
        }

        static String getAttributionTag(Context arg0) {
            return arg0.getAttributionTag();
        }

        static Display getDisplayOrDefault(Context arg2) {
            Display v2;
            try {
                v2 = arg2.getDisplay();
                return v2;
            }
            catch(UnsupportedOperationException ) {
                Log.w("ContextCompat", "The context:" + v2 + " is not associated with any display. Return a fallback display instead.");
                return ((Context)v2).getSystemService(DisplayManager.class).getDisplay(0);
            }
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static Intent registerReceiver(Context arg0, BroadcastReceiver arg1, IntentFilter arg2, String arg3, Handler arg4, int arg5) {
            return arg0.registerReceiver(arg1, arg2, arg3, arg4, arg5);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface RegisterReceiverFlags {
    }

    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";

    protected ContextCompat() {
        super();
    }

    public static int checkSelfPermission(Context arg2, String arg3) {
        ObjectsCompat.requireNonNull(arg3, "permission must be non-null");
        if(Build$VERSION.SDK_INT < 33 && (TextUtils.equals("android.permission.POST_NOTIFICATIONS", ((CharSequence)arg3)))) {
            if(NotificationManagerCompat.from(arg2).areNotificationsEnabled()) {
                return 0;
            }
            else {
                return -1;
            }
        }

        return arg2.checkPermission(arg3, Process.myPid(), Process.myUid());
    }

    public static Context createAttributionContext(Context arg2, String arg3) {
        if(Build$VERSION.SDK_INT >= 30) {
            arg2 = Api30Impl.createAttributionContext(arg2, arg3);
        }

        return arg2;
    }

    public static Context createDeviceProtectedStorageContext(Context arg0) {
        return Api24Impl.createDeviceProtectedStorageContext(arg0);
    }

    public static String getAttributionTag(Context arg2) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getAttributionTag(arg2);
        }

        return null;
    }

    public static File getCodeCacheDir(Context arg0) {
        return arg0.getCodeCacheDir();
    }

    public static int getColor(Context arg0, int arg1) {
        return arg0.getColor(arg1);
    }

    public static ColorStateList getColorStateList(Context arg1, int arg2) {
        return ResourcesCompat.getColorStateList(arg1.getResources(), arg2, arg1.getTheme());
    }

    public static Context getContextForLanguage(Context arg3) {
        LocaleListCompat v0 = LocaleManagerCompat.getApplicationLocales(arg3);
        if(Build$VERSION.SDK_INT <= 0x20 && !v0.isEmpty()) {
            Configuration v1 = new Configuration(arg3.getResources().getConfiguration());
            ConfigurationCompat.setLocales(v1, v0);
            arg3 = arg3.createConfigurationContext(v1);
        }

        return arg3;
    }

    public static File getDataDir(Context arg0) {
        return Api24Impl.getDataDir(arg0);
    }

    public static Display getDisplayOrDefault(Context arg2) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getDisplayOrDefault(arg2);
        }

        return arg2.getSystemService("window").getDefaultDisplay();
    }

    public static Drawable getDrawable(Context arg0, int arg1) {
        return arg0.getDrawable(arg1);
    }

    @ReplaceWith(expression="context.getExternalCacheDirs()") @Deprecated public static File[] getExternalCacheDirs(Context arg0) {
        return arg0.getExternalCacheDirs();
    }

    @ReplaceWith(expression="context.getExternalFilesDirs(type)") @Deprecated public static File[] getExternalFilesDirs(Context arg0, String arg1) {
        return arg0.getExternalFilesDirs(arg1);
    }

    public static Executor getMainExecutor(Context arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getMainExecutor(arg2);
        }

        return ExecutorCompat.create(new Handler(arg2.getMainLooper()));
    }

    public static File getNoBackupFilesDir(Context arg0) {
        return arg0.getNoBackupFilesDir();
    }

    @ReplaceWith(expression="context.getObbDirs()") @Deprecated public static File[] getObbDirs(Context arg0) {
        return arg0.getObbDirs();
    }

    public static String getString(Context arg0, int arg1) {
        return ContextCompat.getContextForLanguage(arg0).getString(arg1);
    }

    public static Object getSystemService(Context arg0, Class arg1) {
        return arg0.getSystemService(arg1);
    }

    public static String getSystemServiceName(Context arg0, Class arg1) {
        return arg0.getSystemServiceName(arg1);
    }

    public static boolean isDeviceProtectedStorage(Context arg0) {
        return Api24Impl.isDeviceProtectedStorage(arg0);
    }

    static String obtainAndCheckReceiverPermission(Context arg4) {
        String v1 = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        String v0 = arg4.getApplicationContext().getPackageName() + v1;
        if(PermissionChecker.checkSelfPermission(arg4, v0) != 0) {
            if(Build$VERSION.SDK_INT >= 29) {
                v0 = arg4.getOpPackageName() + v1;
                if(PermissionChecker.checkSelfPermission(arg4, v0) == 0) {
                    return v0;
                }
            }

            throw new RuntimeException("Permission " + v0 + " is required by your application to receive broadcasts, please add it to your manifest");
        }

        return v0;
    }

    public static Intent registerReceiver(Context arg6, BroadcastReceiver arg7, IntentFilter arg8, int arg9) {
        return ContextCompat.registerReceiver(arg6, arg7, arg8, null, null, arg9);
    }

    public static Intent registerReceiver(Context arg6, BroadcastReceiver arg7, IntentFilter arg8, String arg9, Handler arg10, int arg11) {
        int v0 = arg11 & 1;
        if(v0 != 0) {
            if((arg11 & 4) == 0) {
            }
            else {
                throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
            }
        }

        if(v0 != 0) {
            arg11 |= 2;
        }

        int v5 = arg11;
        arg11 = v5 & 2;
        if(arg11 == 0) {
            if((v5 & 4) != 0) {
            }
            else {
                throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
            }
        }

        if(arg11 != 0) {
            if((v5 & 4) == 0) {
            }
            else {
                throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
            }
        }

        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.registerReceiver(arg6, arg7, arg8, arg9, arg10, v5);
        }

        return Api26Impl.registerReceiver(arg6, arg7, arg8, arg9, arg10, v5);
    }

    public static boolean startActivities(Context arg1, Intent[] arg2) {
        return ContextCompat.startActivities(arg1, arg2, null);
    }

    public static boolean startActivities(Context arg0, Intent[] arg1, Bundle arg2) {
        arg0.startActivities(arg1, arg2);
        return 1;
    }

    @ReplaceWith(expression="context.startActivity(intent, options)") @Deprecated public static void startActivity(Context arg0, Intent arg1, Bundle arg2) {
        arg0.startActivity(arg1, arg2);
    }

    public static void startForegroundService(Context arg0, Intent arg1) {
        Api26Impl.startForegroundService(arg0, arg1);
    }
}

