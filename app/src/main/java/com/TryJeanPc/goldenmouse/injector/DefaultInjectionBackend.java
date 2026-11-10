package com.TryJeanPc.goldenmouse.injector;

import android.util.Log;
import com.TryJeanPc.goldenmouse.activation.ActivationManager;
import com.TryJeanPc.goldenmouse.activation.ActivationStatus;
import com.TryJeanPc.goldenmouse.shizuku.GoldenInputServiceConnection;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0010\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0010\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\"\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00102\b\b\u0002\u0010\u001A\u001A\u00020\u0010H\u0002J(\u0010\u001B\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u0010H\u0002J\n\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\u001E\u001A\u00020\u001FJ\n\u0010 \u001A\u0004\u0018\u00010\u0001H\u0002R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u000E\u0010!\u001A\u00020\"X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/DefaultInjectionBackend;", "Lcom/TryJeanPc/goldenmouse/injector/InjectionBackend;", "<init>", "()V", "delegate", "delegateLock", "", "selectionGeneration", "", "disconnectedRegistry", "contactRegistryIdentity", "getContactRegistryIdentity", "()Ljava/lang/Object;", "synchronousTransportLock", "Ljava/util/concurrent/locks/ReentrantLock;", "supportsAsyncMoves", "", "getSupportsAsyncMoves", "()Z", "execute", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "executeMove", "executeConfirmed", "dispatch", "move", "confirmed", "executeOn", "backend", "backendOrSelect", "close", "", "selectBackend", "TAG", "", "SHIZUKU_CONNECT_TIMEOUT_MS", "ShizukuBackend", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class DefaultInjectionBackend implements InjectionBackend {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/DefaultInjectionBackend$ShizukuBackend;", "Lcom/TryJeanPc/goldenmouse/injector/InjectionBackend;", "<init>", "()V", "contactRegistryIdentity", "", "getContactRegistryIdentity", "()Ljava/lang/Object;", "execute", "", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class ShizukuBackend implements InjectionBackend {
        public static final ShizukuBackend INSTANCE;

        static {
            ShizukuBackend.INSTANCE = new ShizukuBackend();
        }

        private ShizukuBackend() {
            super();
        }

        public boolean execute(TouchCommand arg3) {
            Intrinsics.checkNotNullParameter(arg3, "command");
            if(!GoldenInputServiceConnection.INSTANCE.isConnected() && !GoldenInputServiceConnection.INSTANCE.awaitConnected(500)) {
                return 0;
            }

            return GoldenInputServiceConnection.INSTANCE.execute(arg3);
        }

        public boolean executeConfirmed(TouchCommand arg1) {
            return InjectionBackend.super.executeConfirmed(arg1);
        }

        public boolean executeMove(TouchCommand arg1) {
            return InjectionBackend.super.executeMove(arg1);
        }

        public long getConfirmedCancelEpoch() {
            return InjectionBackend.super.getConfirmedCancelEpoch();
        }

        public Object getContactRegistryIdentity() {
            return GoldenInputServiceConnection.INSTANCE.contactRegistryIdentity$app();
        }

        public boolean getSupportsAsyncMoves() {
            return InjectionBackend.super.getSupportsAsyncMoves();
        }
    }

    public static final int $stable = 0;
    public static final DefaultInjectionBackend INSTANCE = null;
    private static final long SHIZUKU_CONNECT_TIMEOUT_MS = 500;
    private static final String TAG = "GOLDEN_INJECTOR";
    private static InjectionBackend delegate;
    private static final Object delegateLock;
    private static final Object disconnectedRegistry;
    private static long selectionGeneration;
    private static final ReentrantLock synchronousTransportLock;

    static {
        DefaultInjectionBackend.INSTANCE = new DefaultInjectionBackend();
        DefaultInjectionBackend.delegateLock = new Object();
        DefaultInjectionBackend.disconnectedRegistry = new Object();
        DefaultInjectionBackend.synchronousTransportLock = new ReentrantLock(true);
        DefaultInjectionBackend.$stable = 8;
    }

    private DefaultInjectionBackend() {
        super();
    }

    private final InjectionBackend backendOrSelect() {
        InjectionBackend v1;
        Object v0 = DefaultInjectionBackend.delegateLock;
        __monitor_enter(v0);
        try {
            v1 = DefaultInjectionBackend.delegate;
            if(v1 == null) {
                goto label_6;
            }
        }
        catch(Throwable v6) {
            goto label_28;
        }

        __monitor_exit(v0);
        return v1;
        try {
        label_6:
            long v1_1 = DefaultInjectionBackend.selectionGeneration;
        }
        catch(Throwable v6) {
        label_28:
            __monitor_exit(v0);
            throw v6;
        }

        __monitor_exit(v0);
        InjectionBackend v6_1 = this.selectBackend();
        InjectionBackend v3 = null;
        if(v6_1 == null) {
            return v3;
        }

        __monitor_enter(v0);
        try {
            if(DefaultInjectionBackend.selectionGeneration != v1_1) {
                v6_1 = v3;
            }
            else {
                v1 = DefaultInjectionBackend.delegate;
                if(v1 == null) {
                    DefaultInjectionBackend.delegate = v6_1;
                }
                else {
                    goto label_21;
                }
            }

            goto label_22;
        }
        catch(Throwable v6) {
            __monitor_exit(v0);
            throw v6;
        }

    label_21:
        v6_1 = v1;
    label_22:
        __monitor_exit(v0);
        return v6_1;
    }

    public final void close() {
        String v0_3;
        InjectionBackend v0_1;
        Object v5 = DefaultInjectionBackend.delegateLock;
        __monitor_enter(v5);
        try {
            v0_1 = DefaultInjectionBackend.delegate;
            ++DefaultInjectionBackend.selectionGeneration;
            DefaultInjectionBackend.delegate = null;
            KadbInjectionBackend.INSTANCE.close();
        }
        catch(Throwable v0) {
            __monitor_exit(v5);
            throw v0;
        }

        __monitor_exit(v5);
        String v5_1 = "GOLDEN_INJECTOR";
        if(v0_1 != null) {
            Class v0_2 = v0_1.getClass();
            if(v0_2 != null) {
                v0_3 = v0_2.getSimpleName();
                if(v0_3 == null) {
                    goto label_19;
                }
            }
            else {
                goto label_19;
            }
        }
        else {
        label_19:
            v0_3 = "none";
        }

        Log.i(v5_1, "Backend cerrado delegate=" + v0_3);
    }

    private final boolean dispatch(TouchCommand arg7, boolean arg8, boolean arg9) {
        boolean v6_2;
        ReentrantLock v1_1;
        InjectionBackend v2;
        String v0 = "No hay backend de inyección disponible";
        Object v1 = DefaultInjectionBackend.delegateLock;
        __monitor_enter(v1);
        try {
            v2 = DefaultInjectionBackend.delegate;
        }
        catch(Throwable v6) {
            __monitor_exit(v1);
            throw v6;
        }

        __monitor_exit(v1);
        if(v2 != null && (v2.getSupportsAsyncMoves())) {
            return this.executeOn(v2, arg7, arg8, arg9);
        }

        if(arg8) {
            v1_1 = DefaultInjectionBackend.synchronousTransportLock;
            if(!v1_1.isLocked() && !v1_1.hasQueuedThreads()) {
                goto label_19;
            }

            InjectionDiagnostics.INSTANCE.recordControlBlockedMove();
        }

    label_19:
        long v2_1 = 0;
        long v4 = GgPerformanceDiagnostics.INSTANCE.isGgConfirmed(arg7, arg9) ? GgPerformanceDiagnostics.INSTANCE.start() : v2_1;
        v1_1 = DefaultInjectionBackend.synchronousTransportLock;
        v1_1.lock();
        if(v4 != v2_1) {
            try {
                GgPerformanceDiagnostics.INSTANCE.transportGateAcquired(v4);
            label_32:
                v2 = this.backendOrSelect();
                if(v2 != null) {
                    goto label_44;
                }

                String v6_1 = "GOLDEN_INJECTOR";
                String v7 = arg8 ? " para MOVE" : "";
                Log.e(v6_1, v0.concat(v7));
                goto label_41;
            }
            catch(Throwable v6) {
                goto label_49;
            }
        }

        goto label_32;
    label_41:
        v1_1.unlock();
        return 0;
        try {
        label_44:
            v6_2 = this.executeOn(v2, arg7, arg8, arg9);
        }
        catch(Throwable v6) {
        label_49:
            DefaultInjectionBackend.synchronousTransportLock.unlock();
            throw v6;
        }

        v1_1.unlock();
        return v6_2;
    }

    static boolean dispatch$default(DefaultInjectionBackend arg0, TouchCommand arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        return arg0.dispatch(arg1, arg2, false);
    }

    public boolean execute(TouchCommand arg8) {
        Intrinsics.checkNotNullParameter(arg8, "command");
        return DefaultInjectionBackend.dispatch$default(this, arg8, false, false, 4, null);
    }

    public boolean executeConfirmed(TouchCommand arg3) {
        Intrinsics.checkNotNullParameter(arg3, "command");
        return this.dispatch(arg3, false, true);
    }

    public boolean executeMove(TouchCommand arg8) {
        Intrinsics.checkNotNullParameter(arg8, "command");
        return DefaultInjectionBackend.dispatch$default(this, arg8, true, false, 4, null);
    }

    private final boolean executeOn(InjectionBackend arg7, TouchCommand arg8, boolean arg9, boolean arg10) {
        GgMeasuredBackend v0;
        String v1 = "GOLDEN_INJECTOR";
        if(arg8.getAction() == Action.ACTION_DOWN && arg8.getPointerId() == 0) {
            Log.i(v1, "Mouse DOWN backend=" + arg7.getClass().getSimpleName() + " async=" + arg7.getSupportsAsyncMoves());
        }

        boolean v6 = GgPerformanceDiagnostics.INSTANCE.isGgConfirmed(arg8, arg10);
        if(!v6) {
            v0 = GgMeasuredBackend.OTHER;
        }
        else if(arg7 == KadbInjectionBackend.INSTANCE) {
            v0 = GgMeasuredBackend.KADB;
        }
        else if(arg7 == ShizukuBackend.INSTANCE) {
            v0 = GgMeasuredBackend.SHIZUKU;
        }
        else {
            v0 = GgMeasuredBackend.OTHER;
        }

        long v2 = 0;
        long v4 = v6 ? GgPerformanceDiagnostics.INSTANCE.backendStarted(v0) : v2;
        if(arg10) {
            try {
                v6 = arg7.executeConfirmed(arg8);
                goto label_47;
            label_43:
                if(arg9) {
                    v6 = arg7.executeMove(arg8);
                }
                else {
                    v6 = arg7.execute(arg8);
                    goto label_47;
                label_42:
                    goto label_62;
                }
            }
            catch(Throwable v6_1) {
                goto label_42;
            }
        }
        else {
            goto label_43;
        label_62:
            if(v4 != v2) {
                GgPerformanceDiagnostics.INSTANCE.backendFinished(v4, v0, false);
            }

            throw v6_1;
        }

    label_47:
        if(v4 != v2) {
            GgPerformanceDiagnostics.INSTANCE.backendFinished(v4, v0, v6);
        }

        if(arg8.getAction() == Action.ACTION_DOWN && arg8.getPointerId() == 0) {
            Log.i(v1, "Mouse DOWN backend result=" + v6);
        }

        return v6;
    }

    public long getConfirmedCancelEpoch() {
        return InjectionBackend.super.getConfirmedCancelEpoch();
    }

    public Object getContactRegistryIdentity() {
        Object v0_2;
        Object v1 = DefaultInjectionBackend.delegateLock;
        __monitor_enter(v1);
        try {
            InjectionBackend v0_1 = DefaultInjectionBackend.delegate;
            if(v0_1 != null) {
                v0_2 = v0_1.getContactRegistryIdentity();
                if(v0_2 == null) {
                    goto label_6;
                }
            }
            else {
            label_6:
                v0_2 = DefaultInjectionBackend.disconnectedRegistry;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_2;
    }

    public boolean getSupportsAsyncMoves() {
        boolean v1;
        Object v3 = DefaultInjectionBackend.delegateLock;
        __monitor_enter(v3);
        try {
            InjectionBackend v0_1 = DefaultInjectionBackend.delegate;
            v1 = false;
            if(v0_1 != null) {
                if(!v0_1.getSupportsAsyncMoves()) {
                    goto label_9;
                }

                goto label_8;
            }

            goto label_9;
        }
        catch(Throwable v0) {
            __monitor_exit(v3);
            throw v0;
        }

    label_8:
        v1 = true;
    label_9:
        __monitor_exit(v3);
        return v1;
    }

    private final InjectionBackend selectBackend() {
        String v1 = "Backend de inyección: KADB";
        long v3 = 0;
        String v5 = "GOLDEN_INJECTOR";
        Object v6 = null;
        if(ActivationManager.INSTANCE.getStatus().getValue() == ActivationStatus.ACTIVE_KADB && (KadbInjectionBackend.connect$default(KadbInjectionBackend.INSTANCE, v3, 1, v6))) {
            Log.i(v5, v1);
            return KadbInjectionBackend.INSTANCE;
        }

        if(GoldenInputServiceConnection.INSTANCE.awaitConnected(500)) {
            Log.i(v5, "Backend de inyección: Shizuku");
            return ShizukuBackend.INSTANCE;
        }

        if(KadbInjectionBackend.connect$default(KadbInjectionBackend.INSTANCE, v3, 1, v6)) {
            Log.i(v5, v1);
            return KadbInjectionBackend.INSTANCE;
        }

        return ((InjectionBackend)v6);
    }
}

