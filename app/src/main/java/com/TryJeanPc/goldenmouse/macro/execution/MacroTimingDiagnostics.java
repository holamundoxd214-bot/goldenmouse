package com.TryJeanPc.goldenmouse.macro.execution;

import android.os.SystemClock;
import android.util.Log;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyDown;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyUp;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u000E\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingDiagnostics;", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingSink;", "<init>", "()V", "TAG", "", "enabled", "", "record", "", "event", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingRecord;", "raw", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroTimingDiagnostics implements MacroTimingSink {
    public static final int $stable = 0;
    public static final MacroTimingDiagnostics INSTANCE = null;
    public static final String TAG = "GOLDEN_MACRO_TIMING";

    static {
        MacroTimingDiagnostics.INSTANCE = new MacroTimingDiagnostics();
    }

    private MacroTimingDiagnostics() {
        super();
    }

    public boolean enabled() {
        return Log.isLoggable("GOLDEN_MACRO_TIMING", 3);
    }

    public final void raw(InputEvent arg6) {
        String v5;
        Intrinsics.checkNotNullParameter(arg6, "event");
        boolean v0 = arg6 instanceof KeyDown;
        if(!v0 && !(arg6 instanceof KeyUp) && !(arg6 instanceof MouseButton)) {
        }
        else if(!this.enabled()) {
        }
        else {
            if(v0) {
                v5 = "KEY_DOWN:" + arg6.getKeyName();
            }
            else if((arg6 instanceof KeyUp)) {
                v5 = "KEY_UP:" + arg6.getKeyName();
            }
            else if((arg6 instanceof MouseButton)) {
                v5 = "MOUSE:" + arg6.getButton() + ":" + arg6.getPressed();
            }
            else {
                return;
            }

            Log.d("GOLDEN_MACRO_TIMING", "event=RAW input=" + v5 + " receivedMs=" + SystemClock.uptimeMillis() + " sequence=" + arg6.getSequenceNumber());
        }
    }

    public void record(MacroTimingRecord arg26) {
        MacroTimingRecord v1 = arg26;
        Intrinsics.checkNotNullParameter(v1, "event");
        Identity v0 = v1.getIdentity();
        long v2 = v0.getExecution();
        String v4 = v0.getComponent();
        String v5 = v0.getProfile();
        long v6 = v0.getSession();
        long v8 = v1.getRound();
        Long v0_1 = v1.getActionId();
        String v10 = v1.getEvent();
        long v11 = v1.getScheduledMs();
        Long v13 = v1.getSendMs();
        long v14 = v1.getAckMs();
        Long v16 = v1.getSendMs();
        Long v17 = null;
        Long v1_1 = v16 != null ? Long.valueOf(v16.longValue() - v1.getScheduledMs()) : v17;
        v16 = arg26.getSendMs();
        if(v16 != null) {
            v17 = Long.valueOf(arg26.getAckMs() - ((Number)v16).longValue());
        }

        Log.d("GOLDEN_MACRO_TIMING", "execution=" + v2 + " component=" + v4 + " profile=" + v5 + " session=" + v6 + " round=" + v8 + " action=" + v0_1 + " event=" + v10 + " scheduledMs=" + v11 + " sendMs=" + v13 + " ackMs=" + v14 + " delayMs=" + v1_1 + " ackWaitMs=" + v17 + " pointer=" + arg26.getPointerId() + " reservation=" + arg26.getReservation() + " reserveStartMs=" + arg26.getReserveStartMs() + " reserveEndMs=" + arg26.getReserveEndMs() + " accepted=" + arg26.getAccepted() + " reason=" + arg26.getReason());
    }
}

