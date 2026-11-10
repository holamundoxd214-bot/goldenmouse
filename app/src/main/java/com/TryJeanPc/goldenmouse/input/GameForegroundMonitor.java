package com.TryJeanPc.goldenmouse.input;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\b\u0012*\u0001&\b\u0001\u0018\u0000 62\u00060\u0001j\u0002`\u0002:\u00016B3\u0012\u0014\b\u0002\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010(\u001A\u00020\u00062\u0006\u0010)\u001A\u00020\fJ\u001C\u0010*\u001A\u00020\u00062\u0014\u0010+\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00060\u0004J\b\u0010,\u001A\u00020\u0006H\u0002J\u0010\u0010-\u001A\u00020\u00062\u0006\u0010.\u001A\u00020\u001AH\u0002J!\u0010/\u001A\u00020\u00062\b\u00100\u001A\u0004\u0018\u00010\b2\b\b\u0002\u00101\u001A\u00020\u001FH\u0002¢\u0006\u0002\u00102J\b\u00103\u001A\u00020\u0006H\u0016J\u0012\u00104\u001A\u00020\u00062\b\u00105\u001A\u0004\u0018\u00010\u0013H\u0002R\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0007\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0017\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u001C\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001DR\u001E\u0010 \u001A\u00020\u001F2\u0006\u0010\u001E\u001A\u00020\u001F@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0016\u0010#\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\'¨\u00067"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GameForegroundMonitor;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "contextChanged", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/input/GameForegroundObservation;", "", "changed", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "monitorId", "", "main", "Landroid/os/Handler;", "generation", "Ljava/util/concurrent/atomic/AtomicLong;", "attempt", "stream", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "worker", "Ljava/lang/Thread;", "observerRegistered", "readyCallback", "lastFailure", "lastReceived", "", "selected", "lastState", "Ljava/lang/Boolean;", "value", "Lcom/TryJeanPc/goldenmouse/input/ForegroundState;", "foregroundState", "getForegroundState", "()Lcom/TryJeanPc/goldenmouse/input/ForegroundState;", "contextPackages", "", "watchdog", "com/TryJeanPc/goldenmouse/input/GameForegroundMonitor$watchdog$1", "Lcom/TryJeanPc/goldenmouse/input/GameForegroundMonitor$watchdog$1;", "select", "packageName", "whenObservationReady", "callback", "notifyObservationReady", "observe", "token", "publish", "state", "source", "(Ljava/lang/Boolean;Lcom/TryJeanPc/goldenmouse/input/ForegroundState;)V", "close", "closeStreamAsync", "old", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameForegroundMonitor implements AutoCloseable {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GameForegroundMonitor$Companion;", "", "<init>", "()V", "TAG", "", "START_COMMAND", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final String START_COMMAND = "APK_PATH=$(pm path com.TryJeanPc.goldenmouse | head -n 1 | cut -d: -f2); export CLASSPATH=$APK_PATH; exec app_process /system/bin com.TryJeanPc.goldenmouse.input.ForegroundObserverMain 2>&1";
    private static final String TAG = "GOLDEN_FOREGROUND";
    private final AtomicLong attempt;
    private final Function1 changed;
    private final Function1 contextChanged;
    private Set contextPackages;
    private volatile ForegroundState foregroundState;
    private final AtomicLong generation;
    private String lastFailure;
    private volatile long lastReceived;
    private Boolean lastState;
    private final Handler main;
    private final String monitorId;
    private boolean observerRegistered;
    private Function1 readyCallback;
    private String selected;
    private volatile CaptureStream stream;
    private final GameForegroundMonitor$watchdog$1 watchdog;
    private volatile Thread worker;

    static {
        GameForegroundMonitor.Companion = new Companion(null);
        GameForegroundMonitor.$stable = 8;
    }

    public GameForegroundMonitor(Function1 arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "contextChanged");
        Intrinsics.checkNotNullParameter(arg3, "changed");
        super();
        this.contextChanged = arg2;
        this.changed = arg3;
        String v2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
        this.monitorId = v2;
        this.main = new Handler(Looper.getMainLooper());
        this.generation = new AtomicLong();
        this.attempt = new AtomicLong();
        this.foregroundState = ForegroundState.RECOVERING;
        this.watchdog = new GameForegroundMonitor$watchdog$1(this);
    }

    public GameForegroundMonitor(Function1 arg1, Function1 arg2, int arg3, DefaultConstructorMarker arg4) {
        GameForegroundMonitor$$ExternalSyntheticLambda1 v1;
        if((arg3 & 1) != 0) {
            v1 = new GameForegroundMonitor$$ExternalSyntheticLambda1();
        }

        this(((Function1)v1), arg2);
    }

    static final Unit _init_$lambda$0(GameForegroundObservation arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public static final void access$closeStreamAsync(GameForegroundMonitor arg0, CaptureStream arg1) {
        arg0.closeStreamAsync(arg1);
    }

    public static final AtomicLong access$getAttempt$p(GameForegroundMonitor arg0) {
        return arg0.attempt;
    }

    public static final long access$getLastReceived$p(GameForegroundMonitor arg2) {
        return arg2.lastReceived;
    }

    public static final Handler access$getMain$p(GameForegroundMonitor arg0) {
        return arg0.main;
    }

    public static final String access$getSelected$p(GameForegroundMonitor arg0) {
        return arg0.selected;
    }

    public static final CaptureStream access$getStream$p(GameForegroundMonitor arg0) {
        return arg0.stream;
    }

    public static final void access$notifyObservationReady(GameForegroundMonitor arg0) {
        arg0.notifyObservationReady();
    }

    public static final void access$publish(GameForegroundMonitor arg0, Boolean arg1, ForegroundState arg2) {
        arg0.publish(arg1, arg2);
    }

    public static final void access$setLastFailure$p(GameForegroundMonitor arg0, String arg1) {
        arg0.lastFailure = arg1;
    }

    public static final void access$setObserverRegistered$p(GameForegroundMonitor arg0, boolean arg1) {
        arg0.observerRegistered = arg1;
    }

    public void close() {
        this.generation.incrementAndGet();
        this.attempt.incrementAndGet();
        String v0 = null;
        this.selected = v0;
        this.foregroundState = ForegroundState.RECOVERING;
        this.observerRegistered = false;
        this.readyCallback = ((Function1)v0);
        this.lastFailure = v0;
        this.main.removeCallbacks(this.watchdog);
        Thread v1 = this.worker;
        if(v1 != null) {
            v1.interrupt();
        }

        this.worker = ((Thread)v0);
        CaptureStream v1_1 = this.stream;
        this.stream = ((CaptureStream)v0);
        this.closeStreamAsync(v1_1);
    }

    private final void closeStreamAsync(CaptureStream arg3) {
        if(arg3 != null) {
            Thread v0 = new Thread(new GameForegroundMonitor$$ExternalSyntheticLambda8(this, arg3), "GoldenForegroundClose");
            v0.setDaemon(true);
            v0.start();
        }
    }

    static final void closeStreamAsync$lambda$13(GameForegroundMonitor arg0, CaptureStream arg1) {
        try {
            arg1.close();
            Result.constructor-impl(Unit.INSTANCE);
            return;
        }
        catch(Throwable v0) {
            Result.constructor-impl(ResultKt.createFailure(v0));
            return;
        }
    }

    public final ForegroundState getForegroundState() {
        return this.foregroundState;
    }

    private final void notifyObservationReady() {
        if(this.selected != null) {
            boolean v0 = this.observerRegistered;
            if(!v0 && this.lastFailure == null) {
                return;
            }

            Function1 v1 = this.readyCallback;
            Function1 v2 = null;
            this.readyCallback = v2;
            if(v1 == null) {
                return;
            }

            if(v0) {
            }
            else {
                String v2_1 = this.lastFailure;
            }

            v1.invoke(v2);
        }
    }

    private final void observe(long arg25) {
        Object v12_3;
        boolean v16;
        long v2_2;
        String v2_1;
        Handler v14_1;
        int v12_2;
        String v6_1;
        int v0_2;
        boolean v14;
        Unit v12_1;
        String v17;
        Throwable v6;
        CaptureStream v13;
        long v4;
        GameForegroundMonitor v1 = this;
        String v7 = "GOLDEN_FOREGROUND_STATE|";
        String v8 = "GOLDEN_FOREGROUND_CONTEXT|";
        String v9 = "GOLDEN_FOREGROUND_DIAGNOSTIC|";
        String v10 = "GOLDEN_FOREGROUND_ERROR|";
        String v11 = "GOLDEN_FOREGROUND";
        while(true) {
            if(v1.generation.get() != arg25) {
                return;
            }

            if(Thread.currentThread().isInterrupted()) {
                return;
            }

            v4 = v1.attempt.incrementAndGet();
            CaptureStream v12 = null;
            try {
                v13 = DefaultBackendSupervisor.INSTANCE.openStream("APK_PATH=$(pm path com.TryJeanPc.goldenmouse | head -n 1 | cut -d: -f2); export CLASSPATH=$APK_PATH; exec app_process /system/bin com.TryJeanPc.goldenmouse.input.ForegroundObserverMain 2>&1");
            }
            catch(Throwable v0) {
                v6 = v0;
                v13 = null;
                break;
            }
            catch(Exception v0_1) {
                v17 = v8;
                v13 = null;
                goto label_221;
            }

            try {
                if(v1.generation.get() == arg25) {
                    goto label_41;
                }
            }
            catch(Exception v0_1) {
                goto label_212;
            }
            catch(Throwable v0) {
                goto label_260;
            }

            v1.main.post(new GameForegroundMonitor$$ExternalSyntheticLambda2(v1, arg25, v4));
            if(v1.stream == v13) {
                v1.stream = v12;
            }

            try {
                if(v13 != null) {
                    v13.close();
                    v12_1 = Unit.INSTANCE;
                }

                Result.constructor-impl(v12_1);
            }
            catch(Throwable v0) {
                Result.constructor-impl(ResultKt.createFailure(v0));
            }

            return;
            try {
            label_41:
                v1.lastReceived = SystemClock.uptimeMillis();
                v1.stream = v13;
                v14 = false;
                v0_2 = 0;
                while(true) {
                label_46:
                    if(v1.generation.get() == arg25 && v1.attempt.get() == v4) {
                        v6_1 = v13.readLine();
                        if(v6_1 != null) {
                            int v15 = 2;
                            if(!StringsKt.startsWith$default(v6_1, v10, v14, v15, v12)) {
                                if(StringsKt.startsWith$default(v6_1, v9, v14, v15, v12)) {
                                    Log.i(v11, StringsKt.removePrefix(v6_1, v9));
                                    goto label_80;
                                }
                                else if(!StringsKt.startsWith$default(v6_1, "GOLDEN_FOREGROUND_", v14, v15, v12)) {
                                    int v2 = v0_2 + 1;
                                    if(v0_2 < 3) {
                                        Log.w(v11, "Salida del observador: " + StringsKt.take(v6_1, 0xF0));
                                    }

                                    v12_2 = v2;
                                }
                                else {
                                label_80:
                                    v12_2 = v0_2;
                                }

                                if(Intrinsics.areEqual(v6_1, "GOLDEN_FOREGROUND_ALIVE")) {
                                    v1.lastReceived = SystemClock.uptimeMillis();
                                }

                                if(StringsKt.startsWith$default(v6_1, "GOLDEN_FOREGROUND_REGISTERED|", v14, v15, null)) {
                                    v1.lastReceived = SystemClock.uptimeMillis();
                                    v1.main.post(new GameForegroundMonitor$$ExternalSyntheticLambda3(v1, arg25, v4, v6_1));
                                }

                                if(Intrinsics.areEqual(v6_1, "GOLDEN_FOREGROUND_UNKNOWN")) {
                                    v1.lastReceived = SystemClock.uptimeMillis();
                                    v1.main.post(new GameForegroundMonitor$$ExternalSyntheticLambda4(v1, arg25, v4));
                                }

                                if(StringsKt.startsWith$default(v6_1, v8, false, v15, null)) {
                                    v1.lastReceived = SystemClock.uptimeMillis();
                                    String v0_3 = StringsKt.removePrefix(v6_1, v8);
                                    v14_1 = v1.main;
                                    v2_1 = v6_1;
                                    v6_1 = v0_3;
                                    v17 = v8;
                                    v8 = v2_1;
                                    v2_2 = arg25;
                                    break;
                                }
                                else {
                                    goto label_127;
                                }
                            }
                            else {
                                goto label_173;
                            }
                        }
                        else {
                            goto label_180;
                        }
                    }

                    goto label_187;
                }
            }
            catch(Exception v0_1) {
                goto label_212;
            }
            catch(Throwable v0) {
                goto label_260;
            }

            try {
                v14_1.post(new GameForegroundMonitor$$ExternalSyntheticLambda5(v1, v2_2, v4, v6_1));
                goto label_129;
            label_127:
                v17 = v8;
                v8 = v6_1;
            label_129:
                if(StringsKt.startsWith$default(v8, v7, false, v15, null)) {
                    v1.lastReceived = SystemClock.uptimeMillis();
                    String v18 = StringsKt.removePrefix(v8, v7);
                    char[] v0_4 = new char[1];
                    v16 = false;
                    v0_4[0] = ',';
                    List v0_5 = StringsKt.split$default(((CharSequence)v18), v0_4, false, 0, 6, null);
                    ArrayList v2_3 = new ArrayList();
                    Iterator v0_6 = ((Iterable)v0_5).iterator();
                    while(v0_6.hasNext()) {
                        Object v3 = v0_6.next();
                        if(StringsKt.isBlank(v3)) {
                            continue;
                        }

                        ((Collection)v2_3).add(v3);
                    }

                    v1.main.post(new GameForegroundMonitor$$ExternalSyntheticLambda6(v1, arg25, v4, CollectionsKt.toSet(((Iterable)v2_3))));
                }
                else {
                    v16 = false;
                }

                v0_2 = v12_2;
                v14 = v16;
                v8 = v17;
                v12_3 = null;
                goto label_46;
            label_173:
                v17 = v8;
                throw new IllegalStateException(StringsKt.removePrefix(v6_1, v10));
            label_180:
                v17 = v8;
                throw new IllegalStateException("El canal del observador terminó sin mantener la observación");
            }
            catch(Throwable v0) {
            label_260:
                v6 = v0;
                break;
            }
            catch(Exception v0_1) {
                goto label_221;
            label_187:
                v17 = v8;
                v1.main.post(new GameForegroundMonitor$$ExternalSyntheticLambda2(v1, arg25, v4));
                if(v1.stream == v13) {
                    v1.stream = null;
                }

                try {
                    if(v13 != null) {
                        v13.close();
                        v12_1 = Unit.INSTANCE;
                        goto label_204;
                    }

                    v12_3 = null;
                    goto label_204;
                }
                catch(Throwable v0) {
                    goto label_209;
                }

            label_212:
                v17 = v8;
                try {
                label_221:
                    v2_1 = v0_1.getMessage();
                    if(v2_1 == null) {
                        v2_1 = v0_1.getClass().getSimpleName();
                    }

                    Log.e(v11, "Observador privilegiado no disponible: " + v2_1, ((Throwable)v0_1));
                    v1.main.post(new GameForegroundMonitor$$ExternalSyntheticLambda7(v1, arg25, v4, v2_1));
                }
                catch(Throwable v0) {
                    goto label_260;
                }

                v1.main.post(new GameForegroundMonitor$$ExternalSyntheticLambda2(v1, arg25, v4));
                if(v1.stream == v13) {
                    v1.stream = null;
                }

                try {
                    if(v13 == null) {
                        goto label_253;
                    }

                    v13.close();
                    v12_1 = Unit.INSTANCE;
                    goto label_204;
                }
                catch(Throwable v0) {
                    goto label_209;
                }

            label_253:
                v12_3 = null;
                try {
                label_204:
                    Result.constructor-impl(v12_1);
                }
                catch(Throwable v0) {
                label_209:
                    Result.constructor-impl(ResultKt.createFailure(v0));
                }

                v2_2 = 3000;
                try {
                    Thread.sleep(v2_2);
                    v8 = v17;
                    continue;
                }
                catch(InterruptedException ) {
                    return;
                }
            }
        }

        v1.main.post(new GameForegroundMonitor$$ExternalSyntheticLambda2(v1, arg25, v4));
        CaptureStream v2_4 = null;
        if(v1.stream == v13) {
            v1.stream = v2_4;
        }

        try {
            if(v13 != null) {
                v13.close();
                v12_1 = Unit.INSTANCE;
            }
            else {
                v12_3 = v2_4;
            }

            Result.constructor-impl(v12_1);
        }
        catch(Throwable v0) {
            Result.constructor-impl(ResultKt.createFailure(v0));
        }

        throw v6;
    }

    static final void observe$lambda$3(GameForegroundMonitor arg2, long arg3, long arg5, String arg7) {
        if(arg2.generation.get() == arg3 && arg2.attempt.get() == arg5) {
            arg2.observerRegistered = true;
            arg2.lastFailure = null;
            Log.i("GOLDEN_FOREGROUND", "phase=registered target=" + arg2.selected + " " + StringsKt.removePrefix(arg7, "GOLDEN_FOREGROUND_REGISTERED|"));
            arg2.notifyObservationReady();
        }
    }

    static final void observe$lambda$4(GameForegroundMonitor arg2, long arg3, long arg5) {
        if(arg2.generation.get() == arg3 && arg2.attempt.get() == arg5) {
            GameForegroundMonitor.publish$default(arg2, null, null, 2, null);
            Log.w("GOLDEN_FOREGROUND", "phase=initial-unknown target=" + arg2.selected + "; se esperan callbacks privilegiados para confirmar el juego");
        }
    }

    static final void observe$lambda$5(GameForegroundMonitor arg8, long arg9, long arg11, String arg13) {
        if(arg8.generation.get() == arg9 && arg8.attempt.get() == arg11 && (arg8.observerRegistered)) {
            Function1 v0 = arg8.contextChanged;
            com.TryJeanPc.goldenmouse.input.GameForegroundObservation$Companion v1 = GameForegroundObservation.Companion;
            String v2 = arg8.selected;
            if(v2 == null) {
            }
            else {
                v0.invoke(v1.parse(v2, arg8.monitorId + ":" + arg9 + ":" + arg11, arg13, SystemClock.elapsedRealtime(), arg8.contextPackages));
            }
        }
    }

    static final void observe$lambda$7(GameForegroundMonitor arg2, long arg3, long arg5, Set arg7) {
        if(arg2.generation.get() == arg3 && arg2.attempt.get() == arg5 && (arg2.observerRegistered)) {
            Log.i("GOLDEN_FOREGROUND", "source=process-observer target=" + arg2.selected + " present=" + CollectionsKt.contains(arg7, arg2.selected) + " packages=" + arg7);
            arg2.contextPackages = arg7;
            GameForegroundMonitor.publish$default(arg2, Boolean.valueOf(CollectionsKt.contains(arg7, arg2.selected)), null, 2, null);
        }
    }

    static final void observe$lambda$8(GameForegroundMonitor arg2, long arg3, long arg5, String arg7) {
        if(arg2.generation.get() == arg3 && arg2.attempt.get() == arg5) {
            arg2.observerRegistered = false;
            arg2.publish(null, ForegroundState.RECOVERING);
            arg2.lastFailure = arg7;
            arg2.notifyObservationReady();
        }
    }

    static final void observe$lambda$9(GameForegroundMonitor arg2, long arg3, long arg5) {
        if(arg2.generation.get() == arg3 && arg2.attempt.get() == arg5) {
            arg2.observerRegistered = false;
            arg2.publish(null, ForegroundState.RECOVERING);
        }
    }

    private final void publish(Boolean arg11, ForegroundState arg12) {
        if(this.foregroundState != arg12) {
            Log.i("GOLDEN_FOREGROUND", "phase=observation-state state=" + arg12 + " target=" + this.selected);
        }

        this.foregroundState = arg12;
        if(arg11 == null) {
            this.contextPackages = null;
        }

        if(arg11 == null) {
            String v1 = this.selected;
            if(v1 != null) {
                this.contextChanged.invoke(new GameForegroundObservation(v1, this.monitorId + ":" + this.generation.get() + ":" + this.attempt.get(), SystemClock.elapsedRealtime(), null, null, null, 0x20, null));
            }
        }

        if(Intrinsics.areEqual(this.lastState, arg11)) {
            return;
        }

        this.lastState = arg11;
        this.changed.invoke(arg11);
    }

    static void publish$default(GameForegroundMonitor arg0, Boolean arg1, ForegroundState arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            if(Intrinsics.areEqual(arg1, Boolean.valueOf(true))) {
                arg2 = ForegroundState.GAME;
            }
            else if(Intrinsics.areEqual(arg1, Boolean.valueOf(false))) {
                arg2 = ForegroundState.OTHER;
            }
            else if(arg1 == null) {
                arg2 = ForegroundState.UNKNOWN;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        arg0.publish(arg1, arg2);
    }

    public final void select(String arg6) {
        Intrinsics.checkNotNullParameter(arg6, "packageName");
        if(Intrinsics.areEqual(this.selected, arg6)) {
            return;
        }

        this.close();
        this.selected = arg6;
        this.lastState = null;
        this.changed.invoke(null);
        long v0 = this.generation.incrementAndGet();
        Log.i("GOLDEN_FOREGROUND", "phase=observer-start target=" + this.selected);
        this.main.postDelayed(this.watchdog, 5000);
        Thread v6 = new Thread(new GameForegroundMonitor$$ExternalSyntheticLambda0(this, v0), "GoldenForeground");
        v6.setDaemon(true);
        v6.start();
        this.worker = v6;
    }

    static final void select$lambda$1(GameForegroundMonitor arg0, long arg1) {
        arg0.observe(arg1);
    }

    public final void whenObservationReady(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "callback");
        this.readyCallback = arg5;
        Log.i("GOLDEN_FOREGROUND", "phase=observation-wait target=" + this.selected + " observerRegistered=" + this.observerRegistered + " error=" + this.lastFailure);
        this.notifyObservationReady();
    }
}

