package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;

public abstract class AppCompatDelegate {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static LocaleList localeListForLanguageTags(String arg0) {
            return LocaleList.forLanguageTags(arg0);
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static LocaleList localeManagerGetApplicationLocales(Object arg0) {
            return ((LocaleManager)arg0).getApplicationLocales();
        }

        static void localeManagerSetApplicationLocales(Object arg0, LocaleList arg1) {
            ((LocaleManager)arg0).setApplicationLocales(arg1);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface NightMode {
    }

    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    @Deprecated public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;
    @Deprecated public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    private static final ArraySet sActivityDelegates;
    private static final Object sActivityDelegatesLock;
    private static final Object sAppLocalesStorageSyncLock;
    private static int sDefaultNightMode;
    private static Boolean sIsAutoStoreLocalesOptedIn;
    private static boolean sIsFrameworkSyncChecked;
    private static LocaleListCompat sRequestedAppLocales;
    static SerialExecutor sSerialExecutorForLocalesStorage;
    private static LocaleListCompat sStoredAppLocales;

    static {
        AppCompatDelegate.sSerialExecutorForLocalesStorage = new SerialExecutor(new ThreadPerTaskExecutor());
        AppCompatDelegate.sDefaultNightMode = -100;
        AppCompatDelegate.sRequestedAppLocales = null;
        AppCompatDelegate.sStoredAppLocales = null;
        AppCompatDelegate.sIsAutoStoreLocalesOptedIn = null;
        AppCompatDelegate.sIsFrameworkSyncChecked = false;
        AppCompatDelegate.sActivityDelegates = new ArraySet();
        AppCompatDelegate.sActivityDelegatesLock = new Object();
        AppCompatDelegate.sAppLocalesStorageSyncLock = new Object();
    }

    AppCompatDelegate() {
        super();
    }

    static void addActiveDelegate(AppCompatDelegate arg3) {
        Object v0 = AppCompatDelegate.sActivityDelegatesLock;
        __monitor_enter(v0);
        try {
            AppCompatDelegate.removeDelegateFromActives(arg3);
            AppCompatDelegate.sActivityDelegates.add(new WeakReference(arg3));
            __monitor_exit(v0);
            return;
        label_10:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_10;
        }

        throw v3;
    }

    public abstract void addContentView(View arg1, ViewGroup$LayoutParams arg2);

    boolean applyAppLocales() {
        return 0;
    }

    public abstract boolean applyDayNight();

    private static void applyDayNightToActiveDelegates() {
        Object v0 = AppCompatDelegate.sActivityDelegatesLock;
        __monitor_enter(v0);
        try {
            Iterator v1_1 = AppCompatDelegate.sActivityDelegates.iterator();
            while(v1_1.hasNext()) {
                Object v2 = v1_1.next().get();
                if(v2 == null) {
                    continue;
                }

                ((AppCompatDelegate)v2).applyDayNight();
            }

            __monitor_exit(v0);
            return;
        label_14:
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            goto label_14;
        }

        throw v1;
    }

    private static void applyLocalesToActiveDelegates() {
        Iterator v0 = AppCompatDelegate.sActivityDelegates.iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next().get();
            if(v1 == null) {
                continue;
            }

            ((AppCompatDelegate)v1).applyAppLocales();
        }
    }

    void asyncExecuteSyncRequestedAndStoredLocales(Context arg2) {
        AppCompatDelegate.sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda1(arg2));
    }

    @Deprecated public void attachBaseContext(Context arg1) {
    }

    public Context attachBaseContext2(Context arg1) {
        this.attachBaseContext(arg1);
        return arg1;
    }

    public static AppCompatDelegate create(Dialog arg1, AppCompatCallback arg2) {
        return new AppCompatDelegateImpl(arg1, arg2);
    }

    public static AppCompatDelegate create(Activity arg1, AppCompatCallback arg2) {
        return new AppCompatDelegateImpl(arg1, arg2);
    }

    public static AppCompatDelegate create(Context arg1, Activity arg2, AppCompatCallback arg3) {
        return new AppCompatDelegateImpl(arg1, arg2, arg3);
    }

    public static AppCompatDelegate create(Context arg1, Window arg2, AppCompatCallback arg3) {
        return new AppCompatDelegateImpl(arg1, arg2, arg3);
    }

    public abstract View createView(View arg1, String arg2, Context arg3, AttributeSet arg4);

    public abstract View findViewById(int arg1);

    public static LocaleListCompat getApplicationLocales() {
        if(BuildCompat.isAtLeastT()) {
            Object v0 = AppCompatDelegate.getLocaleManagerForApplication();
            if(v0 != null) {
                return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(v0));
            }
        }
        else {
            LocaleListCompat v0_1 = AppCompatDelegate.sRequestedAppLocales;
            if(v0_1 != null) {
                return v0_1;
            }
        }

        return LocaleListCompat.getEmptyLocaleList();
    }

    public Context getContextForDelegate() {
        return null;
    }

    public static int getDefaultNightMode() {
        return AppCompatDelegate.sDefaultNightMode;
    }

    public abstract Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    static Object getLocaleManagerForApplication() {
        Context v1_1;
        Iterator v0 = AppCompatDelegate.sActivityDelegates.iterator();
        do {
        label_2:
            if(!v0.hasNext()) {
                return null;
            }

            Object v1 = v0.next().get();
            if(v1 == null) {
                goto label_2;
            }

            v1_1 = ((AppCompatDelegate)v1).getContextForDelegate();
        }
        while(v1_1 == null);

        return v1_1.getSystemService("locale");
    }

    public abstract MenuInflater getMenuInflater();

    static LocaleListCompat getRequestedAppLocales() {
        return AppCompatDelegate.sRequestedAppLocales;
    }

    static LocaleListCompat getStoredAppLocales() {
        return AppCompatDelegate.sStoredAppLocales;
    }

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int arg1);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    static boolean isAutoStorageOptedIn(Context arg1) {
        if(AppCompatDelegate.sIsAutoStoreLocalesOptedIn == null) {
            try {
                ServiceInfo v1 = AppLocalesMetadataHolderService.getServiceInfo(arg1);
                if(v1.metaData == null) {
                    goto label_17;
                }

                AppCompatDelegate.sIsAutoStoreLocalesOptedIn = Boolean.valueOf(v1.metaData.getBoolean("autoStoreLocales"));
            }
            catch(PackageManager$NameNotFoundException ) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                AppCompatDelegate.sIsAutoStoreLocalesOptedIn = Boolean.valueOf(false);
            }
        }

    label_17:
        return AppCompatDelegate.sIsAutoStoreLocalesOptedIn.booleanValue();
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    public abstract boolean isHandleNativeActionModesEnabled();

    static void lambda$asyncExecuteSyncRequestedAndStoredLocales$0(Context arg0) {
        AppCompatDelegate.syncRequestedAndStoredLocales(arg0);
    }

    static void lambda$syncRequestedAndStoredLocales$1(Context arg0) {
        AppLocalesStorageHelper.syncLocalesToFramework(arg0);
        AppCompatDelegate.sIsFrameworkSyncChecked = true;
    }

    public abstract void onConfigurationChanged(Configuration arg1);

    public abstract void onCreate(Bundle arg1);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle arg1);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle arg1);

    public abstract void onStart();

    public abstract void onStop();

    static void removeActivityDelegate(AppCompatDelegate arg1) {
        Object v0 = AppCompatDelegate.sActivityDelegatesLock;
        __monitor_enter(v0);
        try {
            AppCompatDelegate.removeDelegateFromActives(arg1);
            __monitor_exit(v0);
            return;
        label_6:
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            goto label_6;
        }

        throw v1;
    }

    private static void removeDelegateFromActives(AppCompatDelegate arg3) {
        Object v0 = AppCompatDelegate.sActivityDelegatesLock;
        __monitor_enter(v0);
        try {
            Iterator v1 = AppCompatDelegate.sActivityDelegates.iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next().get();
                if((((AppCompatDelegate)v2)) != arg3 && v2 != null) {
                    continue;
                }

                v1.remove();
            }

            __monitor_exit(v0);
            return;
        label_15:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_15;
        }

        throw v3;
    }

    public abstract boolean requestWindowFeature(int arg1);

    static void resetStaticRequestedAndStoredLocales() {
        AppCompatDelegate.sRequestedAppLocales = null;
        AppCompatDelegate.sStoredAppLocales = null;
    }

    public static void setApplicationLocales(LocaleListCompat arg1) {
        Object v0;
        Objects.requireNonNull(arg1);
        if(BuildCompat.isAtLeastT()) {
            v0 = AppCompatDelegate.getLocaleManagerForApplication();
            if(v0 != null) {
                Api33Impl.localeManagerSetApplicationLocales(v0, Api24Impl.localeListForLanguageTags(arg1.toLanguageTags()));
                return;
            }
        }
        else if(!arg1.equals(AppCompatDelegate.sRequestedAppLocales)) {
            v0 = AppCompatDelegate.sActivityDelegatesLock;
            __monitor_enter(v0);
            try {
                AppCompatDelegate.sRequestedAppLocales = arg1;
                AppCompatDelegate.applyLocalesToActiveDelegates();
                __monitor_exit(v0);
                return;
            label_19:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_19;
            }

            throw v1;
        }
    }

    public static void setCompatVectorFromResourcesEnabled(boolean arg0) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(arg0);
    }

    public abstract void setContentView(int arg1);

    public abstract void setContentView(View arg1);

    public abstract void setContentView(View arg1, ViewGroup$LayoutParams arg2);

    public static void setDefaultNightMode(int arg1) {
        if(arg1 != -1 && arg1 != 0 && arg1 != 1 && arg1 != 2 && arg1 != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
            return;
        }

        if(AppCompatDelegate.sDefaultNightMode != arg1) {
            AppCompatDelegate.sDefaultNightMode = arg1;
            AppCompatDelegate.applyDayNightToActiveDelegates();
        }
    }

    public abstract void setHandleNativeActionModesEnabled(boolean arg1);

    static void setIsAutoStoreLocalesOptedIn(boolean arg0) {
        AppCompatDelegate.sIsAutoStoreLocalesOptedIn = Boolean.valueOf(arg0);
    }

    public abstract void setLocalNightMode(int arg1);

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher arg1) {
    }

    public abstract void setSupportActionBar(Toolbar arg1);

    public void setTheme(int arg1) {
    }

    public abstract void setTitle(CharSequence arg1);

    public abstract ActionMode startSupportActionMode(Callback arg1);

    static void syncRequestedAndStoredLocales(Context arg3) {
        if(!AppCompatDelegate.isAutoStorageOptedIn(arg3)) {
        }
        else if(!BuildCompat.isAtLeastT()) {
            goto label_12;
        }
        else if(!AppCompatDelegate.sIsFrameworkSyncChecked) {
            AppCompatDelegate.sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda0(arg3));
        }

        return;
    label_12:
        Object v0 = AppCompatDelegate.sAppLocalesStorageSyncLock;
        __monitor_enter(v0);
        try {
            LocaleListCompat v1 = AppCompatDelegate.sRequestedAppLocales;
            if(v1 == null) {
                v1 = AppCompatDelegate.sStoredAppLocales;
                if(v1 == null) {
                    v1 = LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(arg3));
                    AppCompatDelegate.sStoredAppLocales = v1;
                }

                if(v1.isEmpty()) {
                    __monitor_exit(v0);
                    return;
                }

                AppCompatDelegate.sRequestedAppLocales = AppCompatDelegate.sStoredAppLocales;
            }
            else {
                if(v1.equals(AppCompatDelegate.sStoredAppLocales)) {
                    goto label_35;
                }

                v1 = AppCompatDelegate.sRequestedAppLocales;
                AppCompatDelegate.sStoredAppLocales = v1;
                AppLocalesStorageHelper.persistLocales(arg3, v1.toLanguageTags());
            }

        label_35:
            __monitor_exit(v0);
            return;
        label_38:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_38;
        }

        throw v3;
    }
}

