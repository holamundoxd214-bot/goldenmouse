package com.TryJeanPc.goldenmouse.macro;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0007\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\b\b\u0002\u0010\u0018\u001A\u00020\r2\b\b\u0002\u0010\u0019\u001A\u00020\rJ@\u0010\u001A\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\r2\u0006\u0010\u001B\u001A\u00020\rH\u0002J\u000E\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\fJ\u0010\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\fH\u0002J\u0006\u0010\u001E\u001A\u00020\u0011R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Lcom/TryJeanPc/goldenmouse/macro/TurboEngine;", "", "touchInjector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;)V", "handlerThread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "activeTokens", "", "", "", "tokenCounter", "lock", "startTurbo", "", "controlId", "pointerId", "", "x", "", "y", "intervalMs", "holdMs", "scheduleNextCycle", "token", "stopTurbo", "stopTurboInternal", "close", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TurboEngine {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/TurboEngine$Companion;", "", "<init>", "()V", "TAG", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final String TAG = "GOLDEN_TURBO";
    private final Map activeTokens;
    private final Handler handler;
    private final HandlerThread handlerThread;
    private final Object lock;
    private long tokenCounter;
    private final TouchInjector touchInjector;

    static {
        TurboEngine.Companion = new Companion(null);
        TurboEngine.$stable = 8;
    }

    public TurboEngine(TouchInjector arg2) {
        Intrinsics.checkNotNullParameter(arg2, "touchInjector");
        super();
        this.touchInjector = arg2;
        HandlerThread v2 = new HandlerThread("GoldenTurboEngine");
        v2.start();
        this.handlerThread = v2;
        this.handler = new Handler(v2.getLooper());
        this.activeTokens = new LinkedHashMap();
        this.lock = new Object();
    }

    public final void close() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.activeTokens.clear();
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        this.handler.removeCallbacksAndMessages(null);
        this.handlerThread.quitSafely();
        Log.d("GOLDEN_TURBO", "TurboEngine cerrado");
    }

    private final void scheduleNextCycle(String arg14, int arg15, float arg16, float arg17, long arg18, long arg20, long arg22) {
        this.handler.post(new TurboEngine$$ExternalSyntheticLambda0(this, arg22, arg15, arg16, arg17, arg20, arg14, arg18));
    }

    static final void scheduleNextCycle$lambda$6(TurboEngine arg13, long arg14, int arg16, float arg17, float arg18, long arg19, String arg21, long arg22) {
        float v11;
        float v10;
        int v2_1;
        TouchInjector v0_3;
        String v7;
        Object v2 = arg13.lock;
        __monitor_enter(v2);
        try {
            v7 = arg21;
            Object v0_1 = arg13.activeTokens.get(v7);
            __monitor_exit(v2);
            if(v0_1 != null) {
                goto label_8;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v2);
            throw v0;
        }

        return;
    label_8:
        if(((Long)v0_1).longValue() != arg14) {
            return;
        }

        try {
            v0_3 = arg13.touchInjector;
            v2_1 = arg16;
            v10 = arg17;
            v11 = arg18;
        }
        catch(Exception v0_2) {
            v2_1 = arg16;
            v10 = arg17;
            v11 = arg18;
            goto label_23;
        }

        try {
            v0_3.pointerDown(v2_1, v10, v11);
            goto label_31;
        }
        catch(Exception v0_2) {
        }

    label_23:
        Log.e("GOLDEN_TURBO", "Turbo: Error en ACTION_DOWN: " + v0_2.getMessage());
    label_31:
        arg13.handler.postDelayed(new TurboEngine$$ExternalSyntheticLambda2(arg13, v2_1, arg22, arg19, v7, arg14, v10, v11), RangesKt.coerceAtLeast(arg19, 10));
    }

    static final void scheduleNextCycle$lambda$6$lambda$5(TurboEngine arg15, int arg16, long arg17, long arg19, String arg21, long arg22, float arg24, float arg25) {
        int v1_1;
        TouchInjector v0_4;
        String v2 = arg21;
        Object v1 = arg15.lock;
        __monitor_enter(v1);
        try {
            Object v0_1 = arg15.activeTokens.get(v2);
            if(v0_1 == null) {
                goto label_11;
            }
            else if(((Long)v0_1).longValue() != arg22) {
                goto label_11;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        int v0_2 = 1;
        goto label_12;
    label_11:
        v0_2 = 0;
    label_12:
        int v3 = v0_2;
        __monitor_exit(v1);
        try {
            v0_4 = arg15.touchInjector;
            v1_1 = arg16;
        }
        catch(Exception v0_3) {
            v1_1 = arg16;
            goto label_22;
        }

        try {
            v0_4.pointerUp(v1_1);
            goto label_30;
        }
        catch(Exception v0_3) {
        }

    label_22:
        Log.e("GOLDEN_TURBO", "Turbo: Error en ACTION_UP: " + v0_3.getMessage());
    label_30:
        if(v3 != 0) {
            arg15.handler.postDelayed(new TurboEngine$$ExternalSyntheticLambda1(arg15, v2, v1_1, arg24, arg25, arg17, arg19, arg22), RangesKt.coerceAtLeast(arg17 - arg19, 10));
        }
        else {
            Log.d("GOLDEN_TURBO", "Turbo DETENIDO (mid-cycle) controlId=" + v2);
        }
    }

    static final void scheduleNextCycle$lambda$6$lambda$5$lambda$4(TurboEngine arg0, String arg1, int arg2, float arg3, float arg4, long arg5, long arg7, long arg9) {
        arg0.scheduleNextCycle(arg1, arg2, arg3, arg4, arg5, arg7, arg9);
    }

    public final void startTurbo(String arg13, int arg14, float arg15, float arg16, long arg17, long arg19) {
        long v9;
        Intrinsics.checkNotNullParameter(arg13, "controlId");
        Object v2 = this.lock;
        __monitor_enter(v2);
        try {
            this.stopTurboInternal(arg13);
            v9 = this.tokenCounter + 1;
            this.tokenCounter = v9;
            this.activeTokens.put(arg13, Long.valueOf(v9));
        }
        catch(Throwable v0) {
            __monitor_exit(v2);
            throw v0;
        }

        __monitor_exit(v2);
        Log.d("GOLDEN_TURBO", "Turbo INICIADO controlId=" + arg13 + " pointerId=" + arg14 + " pos=[" + arg15 + "," + arg16 + "] interval=" + arg17 + "ms");
        this.scheduleNextCycle(arg13, arg14, arg15, arg16, arg17, arg19, v9);
    }

    public static void startTurbo$default(TurboEngine arg11, String arg12, int arg13, float arg14, float arg15, long arg16, long arg18, int arg20, Object arg21) {
        long v7 = (arg20 & 16) != 0 ? 80 : arg16;
        long v9 = (arg20 & 0x20) != 0 ? 45 : arg18;
        arg11.startTurbo(arg12, arg13, arg14, arg15, v7, v9);
    }

    public final void stopTurbo(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "controlId");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.stopTurboInternal(arg3);
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        Log.d("GOLDEN_TURBO", "Turbo DETENIDO controlId=" + arg3);
    }

    private final void stopTurboInternal(String arg1) {
        this.activeTokens.remove(arg1);
    }
}

