package com.TryJeanPc.goldenmouse.input;

import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u0005J\u0006\u0010\u001B\u001A\u00020\u0018J\u0006\u0010\u001C\u001A\u00020\u0018J\u0006\u0010\u001D\u001A\u00020\u0018J\u0006\u0010\u001E\u001A\u00020\u0018R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/input/ContextCaptureTrace;", "", "<init>", "()V", "TAG", "", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "lastCloseReason", "getLastCloseReason", "()Ljava/lang/String;", "setLastCloseReason", "(Ljava/lang/String;)V", "lastRel", "Ljava/util/concurrent/atomic/AtomicLong;", "lastFrame", "recoveryStarted", "motionPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "transition", "", "stage", "detail", "awaitFrame", "relReceived", "motionAccepted", "rendered", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ContextCaptureTrace {
    public static final int $stable = 0;
    public static final ContextCaptureTrace INSTANCE = null;
    public static final String TAG = "GOLDEN_CONTEXT_TRACE";
    private static volatile boolean enabled;
    private static volatile String lastCloseReason;
    private static final AtomicLong lastFrame;
    private static final AtomicLong lastRel;
    private static final AtomicBoolean motionPending;
    private static final AtomicLong recoveryStarted;

    static {
        ContextCaptureTrace.INSTANCE = new ContextCaptureTrace();
        ContextCaptureTrace.lastCloseReason = "none";
        ContextCaptureTrace.lastRel = new AtomicLong();
        ContextCaptureTrace.lastFrame = new AtomicLong();
        ContextCaptureTrace.recoveryStarted = new AtomicLong();
        ContextCaptureTrace.motionPending = new AtomicBoolean();
        ContextCaptureTrace.$stable = 8;
    }

    private ContextCaptureTrace() {
        super();
    }

    public final void awaitFrame() {
        if(ContextCaptureTrace.enabled) {
            ContextCaptureTrace.motionPending.set(false);
            ContextCaptureTrace.recoveryStarted.set(System.nanoTime());
        }
    }

    public final boolean getEnabled() {
        return ContextCaptureTrace.enabled;
    }

    public final String getLastCloseReason() {
        return ContextCaptureTrace.lastCloseReason;
    }

    public final void motionAccepted() {
        if(ContextCaptureTrace.enabled) {
            ContextCaptureTrace.motionPending.set(true);
        }
    }

    public final void relReceived() {
        if(ContextCaptureTrace.enabled) {
            ContextCaptureTrace.lastRel.set(System.nanoTime());
        }
    }

    public final void rendered() {
        if(!ContextCaptureTrace.enabled) {
        }
        else {
            long v0 = System.nanoTime();
            ContextCaptureTrace.lastFrame.set(v0);
            if(!ContextCaptureTrace.motionPending.getAndSet(false)) {
            }
            else {
                long v5 = ContextCaptureTrace.recoveryStarted.getAndSet(0);
                if(v5 != 0) {
                    this.transition("FIRST_RENDER", "recoveryMs=" + (v0 - v5) / 1000000);
                }
            }
        }
    }

    public final void setEnabled(boolean arg1) {
        ContextCaptureTrace.enabled = arg1;
    }

    public final void setLastCloseReason(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<set-?>");
        ContextCaptureTrace.lastCloseReason = arg1;
    }

    public final void transition(String arg11, String arg12) {
        Intrinsics.checkNotNullParameter(arg11, "stage");
        Intrinsics.checkNotNullParameter(arg12, "detail");
        if(ContextCaptureTrace.enabled) {
            Log.i("GOLDEN_CONTEXT_TRACE", "monoMs=" + System.nanoTime() / 1000000 + " elapsedRealtimeMs=" + SystemClock.elapsedRealtime() + " stage=" + arg11 + " " + arg12 + " lastRelMs=" + ContextCaptureTrace.lastRel.get() / 1000000 + " lastFrameMs=" + ContextCaptureTrace.lastFrame.get() / 1000000);
        }
    }
}

