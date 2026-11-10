package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ShortcutManagerCompat {
    class Api25Impl {
        private Api25Impl() {
            super();
        }

        static String getShortcutInfoWithLowestRank(List arg5) {
            Iterator v5 = arg5.iterator();
            int v0 = -1;
            String v1 = null;
            while(v5.hasNext()) {
                Object v2 = v5.next();
                if(((ShortcutInfo)v2).getRank() <= v0) {
                    continue;
                }

                v1 = ((ShortcutInfo)v2).getId();
                v0 = ((ShortcutInfo)v2).getRank();
            }

            return v1;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ShortcutMatchFlags {
    }

    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 0x60;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 0x30;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver sShortcutInfoCompatSaver;

    static {
    }

    private ShortcutManagerCompat() {
        super();
    }

    public static boolean addDynamicShortcuts(Context arg5, List arg6) {
        List v1 = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(arg6, 1);
        if(Build$VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons(arg5, v1);
        }

        ArrayList v2 = new ArrayList();
        Iterator v3 = v1.iterator();
        while(v3.hasNext()) {
            v2.add(v3.next().toShortcutInfo());
        }

        if(!arg5.getSystemService(ShortcutManager.class).addDynamicShortcuts(((List)v2))) {
            return 0;
        }

        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg5).addShortcuts(v1);
        Iterator v5 = ShortcutManagerCompat.getShortcutInfoListeners(arg5).iterator();
        while(v5.hasNext()) {
            v5.next().onShortcutAdded(arg6);
        }

        return 1;
    }

    static boolean convertUriIconToBitmapIcon(Context arg5, ShortcutInfoCompat arg6) {
        if(arg6.mIcon == null) {
            return 0;
        }

        int v0 = arg6.mIcon.mType;
        int v3 = 6;
        if(v0 != v3 && v0 != 4) {
            return 1;
        }

        InputStream v5 = arg6.mIcon.getUriInputStream(arg5);
        if(v5 == null) {
            return 0;
        }

        Bitmap v5_1 = BitmapFactory.decodeStream(v5);
        if(v5_1 == null) {
            return 0;
        }

        IconCompat v5_2 = v0 == v3 ? IconCompat.createWithAdaptiveBitmap(v5_1) : IconCompat.createWithBitmap(v5_1);
        arg6.mIcon = v5_2;
        return 1;
    }

    static void convertUriIconsToBitmapIcons(Context arg3, List arg4) {
        Iterator v0 = new ArrayList(((Collection)arg4)).iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            if(ShortcutManagerCompat.convertUriIconToBitmapIcon(arg3, ((ShortcutInfoCompat)v1))) {
                continue;
            }

            arg4.remove(v1);
        }
    }

    public static Intent createShortcutResultIntent(Context arg1, ShortcutInfoCompat arg2) {
        Intent v1 = arg1.getSystemService(ShortcutManager.class).createShortcutResultIntent(arg2.toShortcutInfo());
        if(v1 == null) {
            v1 = new Intent();
        }

        return arg2.addToIntent(v1);
    }

    public static void disableShortcuts(Context arg1, List arg2, CharSequence arg3) {
        arg1.getSystemService(ShortcutManager.class).disableShortcuts(arg2, arg3);
        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg1).removeShortcuts(arg2);
        Iterator v1 = ShortcutManagerCompat.getShortcutInfoListeners(arg1).iterator();
        while(v1.hasNext()) {
            v1.next().onShortcutRemoved(arg2);
        }
    }

    public static void enableShortcuts(Context arg4, List arg5) {
        List v0 = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(arg5, 1);
        ArrayList v1 = new ArrayList(arg5.size());
        Iterator v2 = v0.iterator();
        while(v2.hasNext()) {
            v1.add(v2.next().mId);
        }

        arg4.getSystemService(ShortcutManager.class).enableShortcuts(((List)v1));
        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg4).addShortcuts(v0);
        Iterator v4 = ShortcutManagerCompat.getShortcutInfoListeners(arg4).iterator();
        while(v4.hasNext()) {
            v4.next().onShortcutAdded(arg5);
        }
    }

    public static List getDynamicShortcuts(Context arg4) {
        List v0 = arg4.getSystemService(ShortcutManager.class).getDynamicShortcuts();
        ArrayList v1 = new ArrayList(v0.size());
        Iterator v0_1 = v0.iterator();
        while(v0_1.hasNext()) {
            ((List)v1).add(new Builder(arg4, v0_1.next()).build());
        }

        return ((List)v1);
    }

    private static int getIconDimensionInternal(Context arg2, boolean arg3) {
        Object v0 = arg2.getSystemService("activity");
        int v0_1 = v0 == null || (((ActivityManager)v0).isLowRamDevice()) ? 1 : 0;
        v0_1 = v0_1 != 0 ? 0x30 : 0x60;
        v0_1 = Math.max(1, v0_1);
        DisplayMetrics v2 = arg2.getResources().getDisplayMetrics();
        float v2_1 = arg3 ? v2.xdpi : v2.ydpi;
        return ((int)((((float)v0_1)) * (v2_1 / 160f)));
    }

    public static int getIconMaxHeight(Context arg1) {
        Preconditions.checkNotNull(arg1);
        return arg1.getSystemService(ShortcutManager.class).getIconMaxHeight();
    }

    public static int getIconMaxWidth(Context arg1) {
        Preconditions.checkNotNull(arg1);
        return arg1.getSystemService(ShortcutManager.class).getIconMaxWidth();
    }

    public static int getMaxShortcutCountPerActivity(Context arg1) {
        Preconditions.checkNotNull(arg1);
        return arg1.getSystemService(ShortcutManager.class).getMaxShortcutCountPerActivity();
    }

    static List getShortcutInfoChangeListeners() {
        return ShortcutManagerCompat.sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(List arg5) {
        Iterator v5 = arg5.iterator();
        int v0 = -1;
        String v1 = null;
        while(v5.hasNext()) {
            Object v2 = v5.next();
            if(((ShortcutInfoCompat)v2).getRank() <= v0) {
                continue;
            }

            v1 = ((ShortcutInfoCompat)v2).getId();
            v0 = ((ShortcutInfoCompat)v2).getRank();
        }

        return v1;
    }

    private static List getShortcutInfoListeners(Context arg7) {
        if(ShortcutManagerCompat.sShortcutInfoChangeListeners == null) {
            ArrayList v0 = new ArrayList();
            PackageManager v1 = arg7.getPackageManager();
            Intent v2 = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            v2.setPackage(arg7.getPackageName());
            Iterator v1_1 = v1.queryIntentActivities(v2, 0x80).iterator();
            while(v1_1.hasNext()) {
                ActivityInfo v2_1 = v1_1.next().activityInfo;
                if(v2_1 == null) {
                }
                else {
                    Bundle v2_2 = v2_1.metaData;
                    if(v2_2 == null) {
                    }
                    else {
                        String v2_3 = v2_2.getString("androidx.core.content.pm.shortcut_listener_impl");
                        if(v2_3 == null) {
                        }
                        else {
                            try {
                                ((List)v0).add(Class.forName(v2_3, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, arg7));
                            }
                            catch(Exception ) {
                            }
                        }
                    }
                }
            }

            if(ShortcutManagerCompat.sShortcutInfoChangeListeners == null) {
                ShortcutManagerCompat.sShortcutInfoChangeListeners = ((List)v0);
            }
        }

        return ShortcutManagerCompat.sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver getShortcutInfoSaverInstance(Context arg5) {
        if(ShortcutManagerCompat.sShortcutInfoCompatSaver == null) {
            try {
                ShortcutManagerCompat.sShortcutInfoCompatSaver = Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, arg5);
                goto label_17;
            }
            catch(Exception ) {
            label_17:
                if(ShortcutManagerCompat.sShortcutInfoCompatSaver == null) {
                    ShortcutManagerCompat.sShortcutInfoCompatSaver = new NoopImpl();
                }
            }
        }

        return ShortcutManagerCompat.sShortcutInfoCompatSaver;
    }

    public static List getShortcuts(Context arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 30) {
            return ShortcutInfoCompat.fromShortcuts(arg3, arg3.getSystemService(ShortcutManager.class).getShortcuts(arg4));
        }

        Object v0 = arg3.getSystemService(ShortcutManager.class);
        ArrayList v1 = new ArrayList();
        if((arg4 & 1) != 0) {
            ((List)v1).addAll(((ShortcutManager)v0).getManifestShortcuts());
        }

        if((arg4 & 2) != 0) {
            ((List)v1).addAll(((ShortcutManager)v0).getDynamicShortcuts());
        }

        if((arg4 & 4) != 0) {
            ((List)v1).addAll(((ShortcutManager)v0).getPinnedShortcuts());
        }

        return ShortcutInfoCompat.fromShortcuts(arg3, ((List)v1));
    }

    public static boolean isRateLimitingActive(Context arg1) {
        Preconditions.checkNotNull(arg1);
        return arg1.getSystemService(ShortcutManager.class).isRateLimitingActive();
    }

    public static boolean isRequestPinShortcutSupported(Context arg1) {
        return arg1.getSystemService(ShortcutManager.class).isRequestPinShortcutSupported();
    }

    public static boolean pushDynamicShortcut(Context arg6, ShortcutInfoCompat arg7) {
        Iterator v0_2;
        List v4;
        Preconditions.checkNotNull(arg6);
        Preconditions.checkNotNull(arg7);
        if(Build$VERSION.SDK_INT <= 0x20 && (arg7.isExcludedFromSurfaces(1))) {
            Iterator v6 = ShortcutManagerCompat.getShortcutInfoListeners(arg6).iterator();
            while(v6.hasNext()) {
                v6.next().onShortcutAdded(Collections.singletonList(arg7));
            }

            return 1;
        }

        int v0 = ShortcutManagerCompat.getMaxShortcutCountPerActivity(arg6);
        if(v0 == 0) {
            return 0;
        }

        if(Build$VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconToBitmapIcon(arg6, arg7);
        }

        if(Build$VERSION.SDK_INT >= 30) {
            arg6.getSystemService(ShortcutManager.class).pushDynamicShortcut(arg7.toShortcutInfo());
        }
        else {
            Object v3 = arg6.getSystemService(ShortcutManager.class);
            if(((ShortcutManager)v3).isRateLimitingActive()) {
                return 0;
            }
            else {
                v4 = ((ShortcutManager)v3).getDynamicShortcuts();
                if(v4.size() >= v0) {
                    ((ShortcutManager)v3).removeDynamicShortcuts(Arrays.asList(new String[]{Api25Impl.getShortcutInfoWithLowestRank(v4)}));
                }

                ((ShortcutManager)v3).addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{arg7.toShortcutInfo()}));
            }
        }

        ShortcutInfoCompatSaver v3_1 = ShortcutManagerCompat.getShortcutInfoSaverInstance(arg6);
        try {
            v4 = v3_1.getShortcuts();
            if(v4.size() >= v0) {
                v3_1.removeShortcuts(Arrays.asList(new String[]{ShortcutManagerCompat.getShortcutInfoCompatWithLowestRank(v4)}));
            }

            v3_1.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{arg7}));
        }
        catch(Throwable v0_1) {
            Iterator v1 = ShortcutManagerCompat.getShortcutInfoListeners(arg6).iterator();
            while(v1.hasNext()) {
                v1.next().onShortcutAdded(Collections.singletonList(arg7));
            }

            ShortcutManagerCompat.reportShortcutUsed(arg6, arg7.getId());
            throw v0_1;
        }
        catch(Exception ) {
            v0_2 = ShortcutManagerCompat.getShortcutInfoListeners(arg6).iterator();
            while(v0_2.hasNext()) {
                v0_2.next().onShortcutAdded(Collections.singletonList(arg7));
            }

            ShortcutManagerCompat.reportShortcutUsed(arg6, arg7.getId());
            return 0;
        }

        v0_2 = ShortcutManagerCompat.getShortcutInfoListeners(arg6).iterator();
        while(v0_2.hasNext()) {
            v0_2.next().onShortcutAdded(Collections.singletonList(arg7));
        }

        ShortcutManagerCompat.reportShortcutUsed(arg6, arg7.getId());
        return 1;
    }

    public static void removeAllDynamicShortcuts(Context arg1) {
        arg1.getSystemService(ShortcutManager.class).removeAllDynamicShortcuts();
        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg1).removeAllShortcuts();
        Iterator v1 = ShortcutManagerCompat.getShortcutInfoListeners(arg1).iterator();
        while(v1.hasNext()) {
            v1.next().onAllShortcutsRemoved();
        }
    }

    public static void removeDynamicShortcuts(Context arg1, List arg2) {
        arg1.getSystemService(ShortcutManager.class).removeDynamicShortcuts(arg2);
        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg1).removeShortcuts(arg2);
        Iterator v1 = ShortcutManagerCompat.getShortcutInfoListeners(arg1).iterator();
        while(v1.hasNext()) {
            v1.next().onShortcutRemoved(arg2);
        }
    }

    public static void removeLongLivedShortcuts(Context arg2, List arg3) {
        if(Build$VERSION.SDK_INT < 30) {
            ShortcutManagerCompat.removeDynamicShortcuts(arg2, arg3);
            return;
        }

        arg2.getSystemService(ShortcutManager.class).removeLongLivedShortcuts(arg3);
        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg2).removeShortcuts(arg3);
        Iterator v2 = ShortcutManagerCompat.getShortcutInfoListeners(arg2).iterator();
        while(v2.hasNext()) {
            v2.next().onShortcutRemoved(arg3);
        }
    }

    private static List removeShortcutsExcludedFromSurface(List arg3, int arg4) {
        Objects.requireNonNull(arg3);
        if(Build$VERSION.SDK_INT > 0x20) {
            return arg3;
        }

        ArrayList v0 = new ArrayList(((Collection)arg3));
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            if(!((ShortcutInfoCompat)v1).isExcludedFromSurfaces(arg4)) {
                continue;
            }

            ((List)v0).remove(v1);
        }

        return ((List)v0);
    }

    public static void reportShortcutUsed(Context arg2, String arg3) {
        Preconditions.checkNotNull(arg2);
        Preconditions.checkNotNull(arg3);
        arg2.getSystemService(ShortcutManager.class).reportShortcutUsed(arg3);
        Iterator v2 = ShortcutManagerCompat.getShortcutInfoListeners(arg2).iterator();
        while(v2.hasNext()) {
            v2.next().onShortcutUsageReported(Collections.singletonList(arg3));
        }
    }

    public static boolean requestPinShortcut(Context arg2, ShortcutInfoCompat arg3, IntentSender arg4) {
        if(Build$VERSION.SDK_INT <= 0x20 && (arg3.isExcludedFromSurfaces(1))) {
            return 0;
        }

        return arg2.getSystemService(ShortcutManager.class).requestPinShortcut(arg3.toShortcutInfo(), arg4);
    }

    public static boolean setDynamicShortcuts(Context arg5, List arg6) {
        Preconditions.checkNotNull(arg5);
        Preconditions.checkNotNull(arg6);
        List v1 = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(arg6, 1);
        ArrayList v2 = new ArrayList(v1.size());
        Iterator v3 = v1.iterator();
        while(v3.hasNext()) {
            ((List)v2).add(v3.next().toShortcutInfo());
        }

        if(!arg5.getSystemService(ShortcutManager.class).setDynamicShortcuts(((List)v2))) {
            return 0;
        }

        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg5).removeAllShortcuts();
        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg5).addShortcuts(v1);
        Iterator v5 = ShortcutManagerCompat.getShortcutInfoListeners(arg5).iterator();
        while(v5.hasNext()) {
            Object v1_1 = v5.next();
            ((ShortcutInfoChangeListener)v1_1).onAllShortcutsRemoved();
            ((ShortcutInfoChangeListener)v1_1).onShortcutAdded(arg6);
        }

        return 1;
    }

    static void setShortcutInfoChangeListeners(List arg0) {
        ShortcutManagerCompat.sShortcutInfoChangeListeners = arg0;
    }

    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver arg0) {
        ShortcutManagerCompat.sShortcutInfoCompatSaver = arg0;
    }

    public static boolean updateShortcuts(Context arg5, List arg6) {
        List v1 = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(arg6, 1);
        if(Build$VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons(arg5, v1);
        }

        ArrayList v2 = new ArrayList();
        Iterator v3 = v1.iterator();
        while(v3.hasNext()) {
            v2.add(v3.next().toShortcutInfo());
        }

        if(!arg5.getSystemService(ShortcutManager.class).updateShortcuts(((List)v2))) {
            return 0;
        }

        ShortcutManagerCompat.getShortcutInfoSaverInstance(arg5).addShortcuts(v1);
        Iterator v5 = ShortcutManagerCompat.getShortcutInfoListeners(arg5).iterator();
        while(v5.hasNext()) {
            v5.next().onShortcutUpdated(arg6);
        }

        return 1;
    }
}

