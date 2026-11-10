package com.TryJeanPc.goldenmouse;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.PowerManager;
import android.provider.Settings;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J$\u0010\b\u001A\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\t0\nH\u0082\b¢\u0006\u0002\u0010\u000BJ\u001C\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012JB\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00122\u0014\b\u0002\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00140\u00162\u0014\b\u0002\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00180\u0016¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/PermissionChecks;", "", "<init>", "()V", "read", "Lcom/TryJeanPc/goldenmouse/PermissionState;", "context", "Landroid/content/Context;", "readSystemValue", "T", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "settingsIntents", "", "Landroid/content/Intent;", "packageName", "", "destination", "Lcom/TryJeanPc/goldenmouse/PermissionSettings;", "openSettings", "", "canResolve", "Lkotlin/Function1;", "launch", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class PermissionChecks {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[PermissionSettings.values().length];
            try {
                v0[PermissionSettings.OVERLAY.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[PermissionSettings.BACKGROUND.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[PermissionSettings.BATTERY.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[PermissionSettings.POWER_SAVER.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable;
    public static final PermissionChecks INSTANCE;

    static {
        PermissionChecks.INSTANCE = new PermissionChecks();
    }

    private PermissionChecks() {
        super();
    }

    public final boolean openSettings(Context arg2, PermissionSettings arg3, Function1 arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        Intrinsics.checkNotNullParameter(arg4, "canResolve");
        Intrinsics.checkNotNullParameter(arg5, "launch");
        String v2 = arg2.getPackageName();
        Intrinsics.checkNotNullExpressionValue(v2, "getPackageName(...)");
        Iterator v1 = this.settingsIntents(v2, arg3).iterator();
        do {
            if(!v1.hasNext()) {
                return 0;
            }

            Object v2_1 = v1.next();
            try {
                if(!arg4.invoke(v2_1).booleanValue()) {
                    continue;
                }

                arg5.invoke(v2_1);
                v1 = null;
                return 1;
            }
            catch(SecurityException ) {
                continue;
            }
        }
        while(true);

        return 0;
    }

    public static boolean openSettings$default(PermissionChecks arg0, Context arg1, PermissionSettings arg2, Function1 arg3, Function1 arg4, int arg5, Object arg6) {
        PermissionChecks$$ExternalSyntheticLambda1 v4;
        PermissionChecks$$ExternalSyntheticLambda0 v3;
        if((arg5 & 4) != 0) {
            v3 = new PermissionChecks$$ExternalSyntheticLambda0(arg1);
        }

        if((arg5 & 8) != 0) {
            v4 = new PermissionChecks$$ExternalSyntheticLambda1(arg1);
        }

        return arg0.openSettings(arg1, arg2, ((Function1)v3), ((Function1)v4));
    }

    static final boolean openSettings$lambda$6(Context arg1, Intent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        if(arg2.resolveActivity(arg1.getPackageManager()) != null) {
            return 1;
        }

        return 0;
    }

    static final Unit openSettings$lambda$7(Context arg1, Intent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        arg1.startActivity(arg2);
        return Unit.INSTANCE;
    }

    public final PermissionState read(Context arg5) {
        Boolean v5;
        Boolean v2_1;
        Boolean v1;
        Object v0;
        Intrinsics.checkNotNullParameter(arg5, "context");
        Boolean v4 = null;
        try {
            v0 = arg5.getSystemService(PowerManager.class);
        }
        catch(RuntimeException ) {
            v0 = v4;
        }

        try {
            v1 = Boolean.valueOf(Settings.canDrawOverlays(arg5));
        }
        catch(RuntimeException ) {
            v1 = v4;
        }

        if(Build$VERSION.SDK_INT >= 28) {
            try {
                Object v2 = arg5.getSystemService(ActivityManager.class);
                if(v2 != null) {
                    v2_1 = Boolean.valueOf(((ActivityManager)v2).isBackgroundRestricted());
                }
                else {
                    goto label_20;
                }
            }
            catch(RuntimeException ) {
            label_20:
                v2_1 = v4;
            }
        }
        else {
            goto label_20;
        }

        if(v0 != null) {
            try {
                v5 = Boolean.valueOf(((PowerManager)v0).isIgnoringBatteryOptimizations(arg5.getPackageName()));
            }
            catch(RuntimeException ) {
            label_26:
                v5 = v4;
            }
        }
        else {
            goto label_26;
        }

        if(v0 != null) {
            try {
                v4 = Boolean.valueOf(((PowerManager)v0).isPowerSaveMode());
                goto label_30;
            }
            catch(RuntimeException ) {
            label_30:
                return new PermissionState(v1, v2_1, v5, v4);
            }
        }

        goto label_30;
    }

    private final Object readSystemValue(Function0 arg1) {
        try {
            return arg1.invoke();
        }
        catch(RuntimeException ) {
            return null;
        }
    }

    public final List settingsIntents(String arg5, PermissionSettings arg6) {
        List v5_1;
        Intrinsics.checkNotNullParameter(arg5, "packageName");
        Intrinsics.checkNotNullParameter(arg6, "destination");
        Uri v4 = Uri.parse("package:" + arg5);
        int v5 = WhenMappings.$EnumSwitchMapping$0[arg6.ordinal()];
        int v6 = 2;
        if(v5 == 1) {
            v5_1 = CollectionsKt.createListBuilder();
            String v3 = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
            if(Build$VERSION.SDK_INT < 30) {
                v5_1.add(new Intent(v3, v4));
            }

            v5_1.add(new Intent(v3));
            v5_1 = CollectionsKt.build(v5_1);
        }
        else if(v5 == v6) {
            v5_1 = CollectionsKt.emptyList();
        }
        else if(v5 == 3) {
            v5_1 = CollectionsKt.listOf(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
        }
        else if(v5 == 4) {
            v5_1 = CollectionsKt.listOf(new Intent("android.settings.BATTERY_SAVER_SETTINGS"));
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        Intent[] v6_1 = new Intent[v6];
        v6_1[0] = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", v4);
        v6_1[1] = new Intent("android.settings.SETTINGS");
        return CollectionsKt.plus(((Collection)v5_1), CollectionsKt.listOf(((Object[])v6_1)));
    }
}

