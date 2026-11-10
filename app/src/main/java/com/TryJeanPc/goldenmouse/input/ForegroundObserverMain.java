package com.TryJeanPc.goldenmouse.input;

import android.app.ActivityManager$RunningTaskInfo;
import android.content.ComponentName;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\tJ\n\u0010\n\u001A\u0004\u0018\u00010\bH\u0002J\n\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0002J\n\u0010\r\u001A\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u0011H\u0002R\u000E\u0010\u000E\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/input/ForegroundObserverMain;", "", "<init>", "()V", "main", "", "args", "", "", "([Ljava/lang/String;)V", "topPackage", "topTask", "Landroid/app/ActivityManager$RunningTaskInfo;", "focusedTaskContext", "DESCRIPTOR", "description", "error", "", "CONTEXT", "STATE", "REGISTERED", "DIAGNOSTIC", "ERROR", "HEARTBEAT", "UNKNOWN", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ForegroundObserverMain {
    public static final int $stable = 0;
    public static final String CONTEXT = "GOLDEN_FOREGROUND_CONTEXT|";
    private static final String DESCRIPTOR = "android.app.IProcessObserver";
    public static final String DIAGNOSTIC = "GOLDEN_FOREGROUND_DIAGNOSTIC|";
    public static final String ERROR = "GOLDEN_FOREGROUND_ERROR|";
    public static final String HEARTBEAT = "GOLDEN_FOREGROUND_ALIVE";
    public static final ForegroundObserverMain INSTANCE = null;
    public static final String REGISTERED = "GOLDEN_FOREGROUND_REGISTERED|";
    public static final String STATE = "GOLDEN_FOREGROUND_STATE|";
    public static final String UNKNOWN = "GOLDEN_FOREGROUND_UNKNOWN";

    static {
        ForegroundObserverMain.INSTANCE = new ForegroundObserverMain();
    }

    private ForegroundObserverMain() {
        super();
    }

    public static final String access$description(ForegroundObserverMain arg0, Throwable arg1) {
        return arg0.description(arg1);
    }

    public static final void access$main$publish(ForegroundRegistry arg0) {
        ForegroundObserverMain.main$publish(arg0);
    }

    private final String description(Throwable arg7) {
        Throwable v6 = arg7.getCause();
        if(v6 == null) {
        }
        else {
            arg7 = v6;
        }

        String v6_1 = arg7.getClass().getSimpleName();
        String v7 = arg7.getMessage();
        if(v7 == null) {
            v7 = "";
        }

        return StringsKt.take(StringsKt.replace$default(v6_1 + ": " + v7, '\n', ' ', false, 4, null), 0xF0);
    }

    private final String focusedTaskContext() {
        ActivityManager$RunningTaskInfo v5 = this.topTask();
        String v0 = null;
        if(v5 == null) {
            return v0;
        }

        Class v1 = v5.getClass();
        if(v1.getField("displayId").getInt(v5) == 0 && (v1.getField("isFocused").getBoolean(v5)) && (v1.getField("isVisible").getBoolean(v5)) && !v1.getField("isSleeping").getBoolean(v5)) {
            Object v2 = v1.getMethod("getWindowingMode").invoke(v5);
            if((v2 instanceof Integer)) {
            }
            else {
                v2 = v0;
            }

            if(v2 == null) {
                return v0;
            }

            if(((Integer)v2).intValue() != 1) {
                return v0;
            }

            int v1_1 = v1.getField("topActivityType").getInt(v5);
            if(1 > v1_1) {
                return v0;
            }

            if(v1_1 >= 3) {
                return v0;
            }

            if(v1_1 == 2 && !v5.baseIntent.hasCategory("android.intent.category.HOME")) {
                return v0;
            }

            ComponentName v5_1 = v5.topActivity;
            if(v5_1 == null) {
                return v0;
            }

            String v5_2 = v5_1.getPackageName();
            if(v5_2 == null) {
                return v0;
            }

            return v5_2 + "|" + v1_1;
        }

        return v0;
    }

    @JvmStatic public static final void main(String[] arg17) {
        Unit v7_2;
        Future v3_2;
        Object v0_3;
        Future v0_2;
        Object v12_2;
        ForegroundRegistry v10;
        Class v9_1;
        Object v4_1;
        Class v3_1;
        ForegroundObserverMain$$ExternalSyntheticLambda4 v1_1;
        int v8;
        String v0 = "GOLDEN_FOREGROUND_REGISTERED|uid=";
        String v1 = "GOLDEN_FOREGROUND_DIAGNOSTIC|phase=register-request uid=";
        String v2 = "GOLDEN_FOREGROUND_DIAGNOSTIC|phase=activity-manager uid=";
        String v3 = "Observer requires shell/root; actual uid=";
        String v4 = "GOLDEN_FOREGROUND_DIAGNOSTIC|phase=process-start uid=";
        Intrinsics.checkNotNullParameter(arg17, "args");
        ExecutorService v5 = Executors.newSingleThreadExecutor(new ForegroundObserverMain$$ExternalSyntheticLambda0());
        String v6 = "identity";
        Object v7 = null;
        try {
            v8 = Process.myUid();
            System.out.println(v4 + v8 + " pid=" + Process.myPid());
            if(v8 != 2000) {
                goto label_26;
            }

            goto label_39;
        }
        catch(Throwable v0_1) {
            goto label_229;
        }

    label_26:
        if(v8 == 0) {
        }
        else {
            try {
                throw new IllegalStateException(v3 + v8.toString());
            }
            catch(Throwable v0_1) {
                v1_1 = ((ForegroundObserverMain$$ExternalSyntheticLambda4)v7);
                goto label_230;
            }
        }

        try {
        label_39:
            v6 = "activity-manager";
            v3_1 = Class.forName("android.app.IActivityManager");
            v4_1 = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault").invoke(v7);
            Intrinsics.checkNotNull(v4_1, "null cannot be cast to non-null type android.os.IInterface");
            IBinder v9 = v4_1.asBinder();
            if(!v9.isBinderAlive()) {
                goto label_223;
            }

            System.out.println(v2 + v8 + " binderAlive=true");
            AtomicBoolean v2_1 = new AtomicBoolean(true);
            v9.linkToDeath(new ForegroundObserverMain$$ExternalSyntheticLambda1(v2_1), 0);
            v9_1 = Class.forName("android.app.IProcessObserver");
            Class v12 = Class.forName("android.app.IProcessObserver$Stub");
            int v13 = ForegroundObserverMain.main$transaction(v12, "onForegroundActivitiesChanged");
            int v12_1 = ForegroundObserverMain.main$transaction(v12, "onProcessDied");
            v6 = "package-manager";
            v10 = new ForegroundRegistry(new ForegroundObserverMain$$ExternalSyntheticLambda2(Class.forName("android.content.pm.IPackageManager").getMethod("getPackagesForUid", Integer.TYPE), Class.forName("android.app.AppGlobals").getMethod("getPackageManager").invoke(v7)));
            v7 = new Object();
            ForegroundObserverMain$main$callback$1 v11 = new ForegroundObserverMain$main$callback$1(v7, v13, v10, v12_1);
            v12_2 = Proxy.newProxyInstance(v9_1.getClassLoader(), new Class[]{v9_1}, new ForegroundObserverMain$$ExternalSyntheticLambda3(v11));
            Intrinsics.checkNotNull(v12_2, "null cannot be cast to non-null type android.os.IInterface");
            v11.attachInterface(v12_2, "android.app.IProcessObserver");
            __monitor_enter(v7);
        }
        catch(Throwable v0_1) {
            goto label_229;
        }

        try {
            v6 = "register-process-observer";
            System.out.println(v1 + v8 + " permission=android.permission.SET_ACTIVITY_WATCHER");
            v3_1.getMethod("registerProcessObserver", v9_1).invoke(v4_1, v12_2);
            v1_1 = new ForegroundObserverMain$$ExternalSyntheticLambda4(v3_1, v9_1, v4_1, v12_2);
        }
        catch(Throwable v0_1) {
            v1_1 = null;
            goto label_219;
        }

        try {
            System.out.println(v0 + v8 + " pid=" + Process.myPid());
            v6 = "initial-query";
            v5.submit(new ForegroundObserverMain$$ExternalSyntheticLambda5(v7, v10, v10.revision()));
            goto label_150;
        }
        catch(Throwable v0_1) {
        }

        try {
        label_219:
            __monitor_exit(v7);
            throw v0_1;
        label_150:
            __monitor_exit(v7);
            v6 = "observing";
            int v10_1 = 0;
            v0_2 = null;
            while(true) {
            label_154:
                if((v2_1.get()) && !System.out.checkError()) {
                    if(v0_2 == null) {
                        v0_2 = v5.submit(new ForegroundObserverMain$$ExternalSyntheticLambda6());
                    }

                    Thread.sleep(750);
                    if(v0_2.isDone()) {
                        v0_3 = v0_2.get();
                        v3_2 = null;
                    }
                    else {
                        v3_2 = v0_2;
                        v0_3 = null;
                    }

                    long v7_1 = v0_3 != null ? ((Pair)v0_3).getFirst().longValue() : SystemClock.elapsedRealtime();
                    v0_3 = v0_3 != null ? ((Pair)v0_3).getSecond() : null;
                    if(v0_3 == null) {
                        v0 = "";
                    }

                    System.out.println("GOLDEN_FOREGROUND_CONTEXT|" + v7_1 + "|" + (((String)v0_3)));
                    ++v10_1;
                    if(v10_1 % 7 == 0) {
                        System.out.println("GOLDEN_FOREGROUND_ALIVE");
                    }

                    break;
                }

                goto label_204;
            }
        }
        catch(Throwable v0_1) {
            goto label_222;
        }

        v0_2 = v3_2;
        goto label_154;
    label_204:
        v5.shutdownNow();
        try {
            ((Function0)v1_1).invoke();
            Result.constructor-impl(Unit.INSTANCE);
            return;
        }
        catch(Throwable v0_1) {
            goto label_213;
        }

    label_222:
        goto label_230;
        try {
        label_223:
            throw new IllegalStateException("ActivityManager Binder is not alive".toString());
        }
        catch(Throwable v0_1) {
        label_229:
            v1_1 = null;
        }

        try {
        label_230:
            System.out.println("GOLDEN_FOREGROUND_ERROR|phase=" + v6 + ": " + ForegroundObserverMain.INSTANCE.description(v0_1));
        }
        catch(Throwable v0_1) {
            Throwable v2_2 = v0_1;
            v5.shutdownNow();
            try {
                if(v1_1 != null) {
                    ((Function0)v1_1).invoke();
                    v7_2 = Unit.INSTANCE;
                }
                else {
                    v7 = null;
                }

                Result.constructor-impl(v7);
            }
            catch(Throwable v0_1) {
                Result.constructor-impl(ResultKt.createFailure(v0_1));
            }

            throw v2_2;
        }

        v5.shutdownNow();
        try {
            if(v1_1 != null) {
                ((Function0)v1_1).invoke();
                v7_2 = Unit.INSTANCE;
            }
            else {
                v7 = null;
            }

            Result.constructor-impl(v7);
        }
        catch(Throwable v0_1) {
        label_213:
            Result.constructor-impl(ResultKt.createFailure(v0_1));
        }
    }

    static final Thread main$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenTaskContextRead");
        v0.setDaemon(true);
        return v0;
    }

    static final void main$lambda$13$lambda$12(Object arg4, ForegroundRegistry arg5, long arg6) {
        Object v0_2;
        ForegroundObserverMain v0 = ForegroundObserverMain.INSTANCE;
        try {
            v0_2 = Result.constructor-impl(v0.topPackage());
        }
        catch(Throwable v0_1) {
            v0_2 = Result.constructor-impl(ResultKt.createFailure(v0_1));
        }

        Throwable v1 = Result.exceptionOrNull-impl(v0_2);
        if(v1 != null) {
            System.out.println("GOLDEN_FOREGROUND_DIAGNOSTIC|Consulta inicial: " + ForegroundObserverMain.INSTANCE.description(v1));
        }

        if(Result.isFailure-impl(v0_2)) {
            v0_2 = null;
        }

        __monitor_enter(arg4);
        if(v0_2 != null) {
            try {
                if(arg5.seedIfUnchanged(((String)v0_2), arg6)) {
                    ForegroundObserverMain.main$publish(arg5);
                    goto label_37;
                label_29:
                    if(arg5.revision() == arg6) {
                        System.out.println("GOLDEN_FOREGROUND_DIAGNOSTIC|Observador registrado, pero sin paquete inicial confirmado");
                        System.out.println("GOLDEN_FOREGROUND_UNKNOWN");
                    }
                }

            label_37:
                goto label_38;
            }
            catch(Throwable v5) {
                __monitor_exit(arg4);
                throw v5;
            }
        }
        else {
            goto label_29;
        }

        goto label_37;
    label_38:
        __monitor_exit(arg4);
    }

    static final Unit main$lambda$13$lambda$8(Class arg2, Class arg3, Object arg4, Object arg5) {
        arg2.getMethod("unregisterProcessObserver", arg3).invoke(arg4, arg5);
        return Unit.INSTANCE;
    }

    static final Pair main$lambda$15() {
        Object v0_2;
        ForegroundObserverMain v0 = ForegroundObserverMain.INSTANCE;
        try {
            v0_2 = Result.constructor-impl(v0.focusedTaskContext());
        }
        catch(Throwable v0_1) {
            v0_2 = Result.constructor-impl(ResultKt.createFailure(v0_1));
        }

        if(Result.isFailure-impl(v0_2)) {
            v0_2 = null;
        }

        return TuplesKt.to(Long.valueOf(SystemClock.elapsedRealtime()), v0_2);
    }

    static final void main$lambda$4(AtomicBoolean arg1) {
        arg1.set(false);
        System.out.println("GOLDEN_FOREGROUND_ERROR|phase=activity-manager-death: ActivityManager died");
    }

    static final Set main$lambda$6(Method arg9, Object arg10, int arg11) {
        Object v9 = arg9.invoke(arg10, Integer.valueOf(arg11));
        if((v9 instanceof String[])) {
        }
        else {
            v9 = null;
        }

        if(v9 != null) {
            Set v9_1 = ArraysKt.toSet(((Object[])v9));
            if(v9_1 != null) {
                System.out.println("GOLDEN_FOREGROUND_DIAGNOSTIC|phase=packages uid=" + arg11 + " packages=" + CollectionsKt.joinToString$default(CollectionsKt.sorted(v9_1), ",", null, null, 0, null, null, 62, null));
                return v9_1;
            }
        }

        throw new IllegalStateException("No packages for UID " + arg11);
    }

    static final Object main$lambda$7(ForegroundObserverMain$main$callback$1 arg2, Object arg3, Method arg4, Object[] arg5) {
        String v4 = arg4.getName();
        Object v0 = null;
        if(v4 != null) {
            switch(v4.hashCode()) {
                case -1776922004: {
                    goto label_30;
                }
                case -1772511108: {
                    goto label_25;
                }
                case -1295482945: {
                    goto label_13;
                }
                case 147696667: {
                    goto label_6;
                }
            }

            return v0;
        label_6:
            if(!v4.equals("hashCode")) {
            }
            else {
                return Integer.valueOf(System.identityHashCode(arg3));
            label_25:
                if(!v4.equals("asBinder")) {
                }
                else {
                    return arg2;
                label_13:
                    if(!v4.equals("equals")) {
                    }
                    else {
                        if(arg5 != null) {
                            v0 = ArraysKt.firstOrNull(arg5);
                        }

                        boolean v2 = arg3 == v0 ? true : false;
                        return Boolean.valueOf(v2);
                    label_30:
                        if(!v4.equals("toString")) {
                            return v0;
                        }

                        return "GoldenProcessObserver";
                    }
                }
            }
        }

        return v0;
    }

    private static final void main$publish(ForegroundRegistry arg9) {
        System.out.println("GOLDEN_FOREGROUND_STATE|" + CollectionsKt.joinToString$default(CollectionsKt.sorted(arg9.current()), ",", null, null, 0, null, null, 62, null));
    }

    private static final int main$transaction(Class arg2, String arg3) {
        Field v2 = arg2.getDeclaredField("TRANSACTION_" + arg3);
        v2.setAccessible(true);
        return v2.getInt(null);
    }

    private final String topPackage() {
        ActivityManager$RunningTaskInfo v0 = this.topTask();
        if(v0 != null) {
            ComponentName v0_1 = v0.topActivity;
            if(v0_1 != null) {
                return v0_1.getPackageName();
            }
        }

        return null;
    }

    private final ActivityManager$RunningTaskInfo topTask() {
        Class v8 = Class.forName("android.app.IActivityTaskManager");
        Class v0 = Class.forName("android.app.ActivityTaskManager");
        Boolean v2 = Boolean.valueOf(false);
        Object v4 = null;
        Object v8_1 = v8.getMethod("getTasks", Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Integer.TYPE).invoke(v0.getMethod("getService").invoke(v4), Integer.valueOf(1), v2, v2, Integer.valueOf(0));
        if((v8_1 instanceof List)) {
        }
        else {
            v8_1 = v4;
        }

        v8_1 = v8_1 != null ? CollectionsKt.firstOrNull(((List)v8_1)) : v4;
        if((v8_1 instanceof ActivityManager$RunningTaskInfo)) {
            return ((ActivityManager$RunningTaskInfo)v8_1);
        }

        return ((ActivityManager$RunningTaskInfo)v4);
    }
}

