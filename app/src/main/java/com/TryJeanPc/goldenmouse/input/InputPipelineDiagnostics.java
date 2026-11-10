package com.TryJeanPc.goldenmouse.input;

import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CJ\u000E\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\u001E\u001A\u00020\u001A2\b\b\u0002\u0010\u001F\u001A\u00020 J\u000E\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020\u0007J\u001E\u0010#\u001A\u00020\u001A2\u0006\u0010\"\u001A\u00020\u00072\u0006\u0010$\u001A\u00020 2\u0006\u0010%\u001A\u00020\u0007J.\u0010&\u001A\u00020\u001A2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020 2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020+2\u0006\u0010%\u001A\u00020\u0007J\u0019\u0010-\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0.H\u0000¢\u0006\u0002\b/J\u000E\u00100\u001A\u00020\u001A2\u0006\u00101\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u000E\u0010\f\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputPipelineDiagnostics;", "", "<init>", "()V", "TAG", "", "enabled", "", "getEnabled$app", "()Z", "setEnabled$app", "(Z)V", "autonomous", "counts", "Ljava/util/concurrent/atomic/AtomicLongArray;", "lastRefresh", "Ljava/util/concurrent/atomic/AtomicLong;", "lastReport", "movesInFlight", "controlsInFlight", "backendMaxNanos", "remoteMask", "remoteAction", "remoteCameraXMilliPixels", "remoteCameraYMilliPixels", "count", "", "stage", "Lcom/TryJeanPc/goldenmouse/input/InputPipelineDiagnostics$Stage;", "setAutonomous", "refreshIfDue", "now", "", "backendStarted", "move", "backendFinished", "start", "accepted", "remoteResult", "action", "", "mask", "dx", "", "dy", "snapshot", "", "snapshot$app", "reportIfDue", "context", "Stage", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class InputPipelineDiagnostics {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001F\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001Bj\u0002\b\u001Cj\u0002\b\u001Dj\u0002\b\u001Ej\u0002\b\u001F¨\u0006 "}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputPipelineDiagnostics$Stage;", "", "<init>", "(Ljava/lang/String;I)V", "RAW", "CORE", "ENGINE_INACTIVE", "AIM", "AIM_INACTIVE", "QUEUED", "REJECT_DISABLED", "REJECT_SESSION", "DISPATCH_STALE", "STALE_EPOCH", "REGISTRY_LOST", "BACKEND_MOVE_OK", "BACKEND_CONTROL_OK", "BACKEND_FAIL", "REMOTE_COMMAND", "REMOTE_ATTEMPT", "REMOTE_OK", "REMOTE_FAIL", "RAW_KEY", "RAW_BUTTON", "DELIVERED_KEY", "DELIVERED_BUTTON", "COMMAND_DOWN", "DOWN_ACK_OK", "DOWN_ACK_FAIL", "CURSOR_CALLBACK", "GAME_KEY_DISPATCH", "EDITOR_RAW_BINDING", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Stage {
        public static final enum Stage AIM;
        public static final enum Stage AIM_INACTIVE;
        public static final enum Stage BACKEND_CONTROL_OK;
        public static final enum Stage BACKEND_FAIL;
        public static final enum Stage BACKEND_MOVE_OK;
        public static final enum Stage COMMAND_DOWN;
        public static final enum Stage CORE;
        public static final enum Stage CURSOR_CALLBACK;
        public static final enum Stage DELIVERED_BUTTON;
        public static final enum Stage DELIVERED_KEY;
        public static final enum Stage DISPATCH_STALE;
        public static final enum Stage DOWN_ACK_FAIL;
        public static final enum Stage DOWN_ACK_OK;
        public static final enum Stage EDITOR_RAW_BINDING;
        public static final enum Stage ENGINE_INACTIVE;
        public static final enum Stage GAME_KEY_DISPATCH;
        public static final enum Stage QUEUED;
        public static final enum Stage RAW;
        public static final enum Stage RAW_BUTTON;
        public static final enum Stage RAW_KEY;
        public static final enum Stage REGISTRY_LOST;
        public static final enum Stage REJECT_DISABLED;
        public static final enum Stage REJECT_SESSION;
        public static final enum Stage REMOTE_ATTEMPT;
        public static final enum Stage REMOTE_COMMAND;
        public static final enum Stage REMOTE_FAIL;
        public static final enum Stage REMOTE_OK;
        public static final enum Stage STALE_EPOCH;

        private static final Stage[] $values() {
            return new Stage[]{Stage.RAW, Stage.CORE, Stage.ENGINE_INACTIVE, Stage.AIM, Stage.AIM_INACTIVE, Stage.QUEUED, Stage.REJECT_DISABLED, Stage.REJECT_SESSION, Stage.DISPATCH_STALE, Stage.STALE_EPOCH, Stage.REGISTRY_LOST, Stage.BACKEND_MOVE_OK, Stage.BACKEND_CONTROL_OK, Stage.BACKEND_FAIL, Stage.REMOTE_COMMAND, Stage.REMOTE_ATTEMPT, Stage.REMOTE_OK, Stage.REMOTE_FAIL, Stage.RAW_KEY, Stage.RAW_BUTTON, Stage.DELIVERED_KEY, Stage.DELIVERED_BUTTON, Stage.COMMAND_DOWN, Stage.DOWN_ACK_OK, Stage.DOWN_ACK_FAIL, Stage.CURSOR_CALLBACK, Stage.GAME_KEY_DISPATCH, Stage.EDITOR_RAW_BINDING};
        }

        static {
            Stage.RAW = new Stage("RAW", 0);
            Stage.CORE = new Stage("CORE", 1);
            Stage.ENGINE_INACTIVE = new Stage("ENGINE_INACTIVE", 2);
            Stage.AIM = new Stage("AIM", 3);
            Stage.AIM_INACTIVE = new Stage("AIM_INACTIVE", 4);
            Stage.QUEUED = new Stage("QUEUED", 5);
            Stage.REJECT_DISABLED = new Stage("REJECT_DISABLED", 6);
            Stage.REJECT_SESSION = new Stage("REJECT_SESSION", 7);
            Stage.DISPATCH_STALE = new Stage("DISPATCH_STALE", 8);
            Stage.STALE_EPOCH = new Stage("STALE_EPOCH", 9);
            Stage.REGISTRY_LOST = new Stage("REGISTRY_LOST", 10);
            Stage.BACKEND_MOVE_OK = new Stage("BACKEND_MOVE_OK", 11);
            Stage.BACKEND_CONTROL_OK = new Stage("BACKEND_CONTROL_OK", 12);
            Stage.BACKEND_FAIL = new Stage("BACKEND_FAIL", 13);
            Stage.REMOTE_COMMAND = new Stage("REMOTE_COMMAND", 14);
            Stage.REMOTE_ATTEMPT = new Stage("REMOTE_ATTEMPT", 15);
            Stage.REMOTE_OK = new Stage("REMOTE_OK", 16);
            Stage.REMOTE_FAIL = new Stage("REMOTE_FAIL", 17);
            Stage.RAW_KEY = new Stage("RAW_KEY", 18);
            Stage.RAW_BUTTON = new Stage("RAW_BUTTON", 19);
            Stage.DELIVERED_KEY = new Stage("DELIVERED_KEY", 20);
            Stage.DELIVERED_BUTTON = new Stage("DELIVERED_BUTTON", 21);
            Stage.COMMAND_DOWN = new Stage("COMMAND_DOWN", 22);
            Stage.DOWN_ACK_OK = new Stage("DOWN_ACK_OK", 23);
            Stage.DOWN_ACK_FAIL = new Stage("DOWN_ACK_FAIL", 24);
            Stage.CURSOR_CALLBACK = new Stage("CURSOR_CALLBACK", 25);
            Stage.GAME_KEY_DISPATCH = new Stage("GAME_KEY_DISPATCH", 26);
            Stage.EDITOR_RAW_BINDING = new Stage("EDITOR_RAW_BINDING", 27);
            Stage[] v0 = Stage.$values();
            Stage.$VALUES = v0;
            Stage.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Stage(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Stage.$ENTRIES;
        }

        public static Stage valueOf(String arg1) {
            return Enum.valueOf(Stage.class, arg1);
        }

        public static Stage[] values() {
            return Stage.$VALUES.clone();
        }
    }

    public static final int $stable = 0;
    public static final InputPipelineDiagnostics INSTANCE = null;
    public static final String TAG = "GOLDEN_INPUT_TRACE";
    private static volatile boolean autonomous;
    private static final AtomicLong backendMaxNanos;
    private static final AtomicLong controlsInFlight;
    private static final AtomicLongArray counts;
    private static volatile boolean enabled;
    private static final AtomicLong lastRefresh;
    private static final AtomicLong lastReport;
    private static final AtomicLong movesInFlight;
    private static final AtomicLong remoteAction;
    private static final AtomicLong remoteCameraXMilliPixels;
    private static final AtomicLong remoteCameraYMilliPixels;
    private static final AtomicLong remoteMask;

    static {
        InputPipelineDiagnostics.INSTANCE = new InputPipelineDiagnostics();
        InputPipelineDiagnostics.counts = new AtomicLongArray(Stage.getEntries().size());
        InputPipelineDiagnostics.lastRefresh = new AtomicLong();
        InputPipelineDiagnostics.lastReport = new AtomicLong();
        InputPipelineDiagnostics.movesInFlight = new AtomicLong();
        InputPipelineDiagnostics.controlsInFlight = new AtomicLong();
        InputPipelineDiagnostics.backendMaxNanos = new AtomicLong();
        InputPipelineDiagnostics.remoteMask = new AtomicLong();
        InputPipelineDiagnostics.remoteAction = new AtomicLong();
        InputPipelineDiagnostics.remoteCameraXMilliPixels = new AtomicLong();
        InputPipelineDiagnostics.remoteCameraYMilliPixels = new AtomicLong();
        InputPipelineDiagnostics.$stable = 8;
    }

    private InputPipelineDiagnostics() {
        super();
    }

    public final void backendFinished(boolean arg3, long arg4, boolean arg6) {
        Stage v3;
        long v0 = 0;
        if(arg4 == v0) {
        }
        else {
            AtomicLong v2 = arg3 ? InputPipelineDiagnostics.movesInFlight : InputPipelineDiagnostics.controlsInFlight;
            v2.decrementAndGet();
            AtomicLongArray v2_1 = InputPipelineDiagnostics.counts;
            if(!arg6) {
                v3 = Stage.BACKEND_FAIL;
            }
            else if(arg3) {
                v3 = Stage.BACKEND_MOVE_OK;
            }
            else {
                v3 = Stage.BACKEND_CONTROL_OK;
            }

            v2_1.incrementAndGet(v3.ordinal());
            long v2_2 = RangesKt.coerceAtLeast(System.nanoTime() - arg4, v0);
            do {
                AtomicLong v4 = InputPipelineDiagnostics.backendMaxNanos;
                long v5 = v4.get();
                if(v2_2 <= v5) {
                    return;
                }

                if(!v4.compareAndSet(v5, v2_2)) {
                    continue;
                }

                return;
            }
            while(true);
        }
    }

    public final long backendStarted(boolean arg1) {
        if(!InputPipelineDiagnostics.enabled) {
            return 0;
        }

        AtomicLong v0 = arg1 ? InputPipelineDiagnostics.movesInFlight : InputPipelineDiagnostics.controlsInFlight;
        v0.incrementAndGet();
        return System.nanoTime();
    }

    public final void count(Stage arg1) {
        Intrinsics.checkNotNullParameter(arg1, "stage");
        if(InputPipelineDiagnostics.enabled) {
            InputPipelineDiagnostics.counts.incrementAndGet(arg1.ordinal());
        }
    }

    public final boolean getEnabled$app() {
        return InputPipelineDiagnostics.enabled;
    }

    public final void refreshIfDue(long arg7) {
        AtomicLong v6 = InputPipelineDiagnostics.lastRefresh;
        long v0 = v6.get();
        if(arg7 - v0 >= 1000000000) {
            if(!v6.compareAndSet(v0, arg7)) {
            }
            else {
                boolean v6_1 = (InputPipelineDiagnostics.autonomous) || (Log.isLoggable("GOLDEN_INPUT_TRACE", 3)) ? true : false;
                InputPipelineDiagnostics.enabled = v6_1;
            }
        }
    }

    public static void refreshIfDue$default(InputPipelineDiagnostics arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = System.nanoTime();
        }

        arg0.refreshIfDue(arg1);
    }

    public final void remoteResult(int arg3, long arg4, float arg6, float arg7, boolean arg8) {
        if(!InputPipelineDiagnostics.enabled) {
        }
        else {
            Stage v0 = arg8 ? Stage.REMOTE_OK : Stage.REMOTE_FAIL;
            this.count(v0);
            InputPipelineDiagnostics.remoteAction.set(((long)arg3));
            InputPipelineDiagnostics.remoteMask.set(arg4);
            if(!arg8) {
                return;
            }

            InputPipelineDiagnostics.remoteCameraXMilliPixels.addAndGet(((long)(arg6 * 1000f)));
            InputPipelineDiagnostics.remoteCameraYMilliPixels.addAndGet(((long)(arg7 * 1000f)));
        }
    }

    public final void reportIfDue(String arg10) {
        Intrinsics.checkNotNullParameter(arg10, "context");
        long v0 = System.nanoTime();
        this.refreshIfDue(v0);
        if(!InputPipelineDiagnostics.enabled) {
        }
        else {
            AtomicLong v2 = InputPipelineDiagnostics.lastReport;
            long v3 = v2.get();
            if(v0 - v3 >= 1000000000) {
                if(!v2.compareAndSet(v3, v0)) {
                }
                else {
                    Log.i("GOLDEN_INPUT_TRACE", arg10 + " " + CollectionsKt.joinToString$default(this.snapshot$app().entrySet(), " ", null, null, 0, null, new InputPipelineDiagnostics$$ExternalSyntheticLambda0(), 30, null));
                }
            }
        }
    }

    static final CharSequence reportIfDue$lambda$2(Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg2.getKey() + "=" + arg2.getValue();
    }

    public final void setAutonomous(boolean arg1) {
        boolean v0 = InputPipelineDiagnostics.autonomous;
        InputPipelineDiagnostics.autonomous = arg1;
        if(arg1) {
            InputPipelineDiagnostics.enabled = true;
            return;
        }

        if(v0) {
            InputPipelineDiagnostics.enabled = false;
        }
    }

    public final void setEnabled$app(boolean arg1) {
        InputPipelineDiagnostics.enabled = arg1;
    }

    public final Map snapshot$app() {
        LinkedHashMap v5 = new LinkedHashMap();
        Iterator v0 = Stage.getEntries().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            v5.put(((Stage)v1).name(), Long.valueOf(InputPipelineDiagnostics.counts.get(((Stage)v1).ordinal())));
        }

        v5.put("movesInFlight", Long.valueOf(InputPipelineDiagnostics.movesInFlight.get()));
        v5.put("controlsInFlight", Long.valueOf(InputPipelineDiagnostics.controlsInFlight.get()));
        v5.put("backendMaxUs", Long.valueOf(InputPipelineDiagnostics.backendMaxNanos.get() / 1000));
        v5.put("remoteMask", Long.valueOf(InputPipelineDiagnostics.remoteMask.get()));
        v5.put("remoteAction", Long.valueOf(InputPipelineDiagnostics.remoteAction.get()));
        v5.put("remoteCameraXMilliPixels", Long.valueOf(InputPipelineDiagnostics.remoteCameraXMilliPixels.get()));
        v5.put("remoteCameraYMilliPixels", Long.valueOf(InputPipelineDiagnostics.remoteCameraYMilliPixels.get()));
        return ((Map)v5);
    }
}

