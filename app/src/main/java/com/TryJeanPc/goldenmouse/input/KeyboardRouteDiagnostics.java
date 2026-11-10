package com.TryJeanPc.goldenmouse.input;

import android.util.Log;
import com.TryJeanPc.goldenmouse.engine.InputSessionManager$Snapshot;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001:B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0016\u001A\u00020\u00172\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0006\u0010\u0019\u001A\u00020\u0017J\u001E\u0010\u001A\u001A\u00020\u00172\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001C2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DJ\u001E\u0010\u001F\u001A\u00020\u00172\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020$J:\u0010%\u001A\u00020\u00172\u0006\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u000E2\n\b\u0002\u0010)\u001A\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\u0005J\u0016\u0010-\u001A\u00020\u00172\u0006\u0010.\u001A\u00020$2\u0006\u0010/\u001A\u00020$J\'\u00100\u001A\u0002H1\"\u0004\b\u0000\u001012\u0006\u0010(\u001A\u00020\u000E2\f\u00102\u001A\b\u0012\u0004\u0012\u0002H103¢\u0006\u0002\u00104J\u0019\u00105\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020706H\u0000¢\u0006\u0002\b8J@\u00109\u001A\u00020\u00172\u0006\u0010&\u001A\u00020\'2\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u000E2\n\b\u0002\u0010)\u001A\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\u0005H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001A\u0004\u0018\u00010\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u0005@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006;"}, d2={"Lcom/TryJeanPc/goldenmouse/input/KeyboardRouteDiagnostics;", "", "<init>", "()V", "TAG", "", "MAX_LOG_RECORDS", "", "counts", "Ljava/util/concurrent/atomic/AtomicLongArray;", "records", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentKey", "Ljava/lang/ThreadLocal;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "aimInputs", "", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "value", "lastDropReason", "getLastDropReason$app", "()Ljava/lang/String;", "profile", "", "inputs", "captureStarted", "selection", "devices", "", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "selectedKeyboard", "rawKey", "session", "Lcom/TryJeanPc/goldenmouse/input/DeviceCaptureSession;", "code", "recognized", "", "key", "stage", "Lcom/TryJeanPc/goldenmouse/input/KeyboardRouteDiagnostics$Stage;", "event", "state", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Snapshot;", "reason", "detail", "callback", "before", "after", "withKey", "T", "operation", "Lkotlin/Function0;", "(Lcom/TryJeanPc/goldenmouse/input/InputEvent;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "snapshot", "", "", "snapshot$app", "record", "Stage", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class KeyboardRouteDiagnostics {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/input/KeyboardRouteDiagnostics$Stage;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_SELECTION", "CAPTURE_STARTED", "RAW_KEY_SEEN", "RAW_KEY_REJECTED", "PARSED_KEY", "CAPTURE_EMIT", "CORE_KEY", "SESSION_INGRESS", "SESSION_QUEUED", "SESSION_DROP", "SESSION_DELIVER", "EDITOR_CAPTURE", "MAPPER_RESULT", "AIM_CALLBACK", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Stage {
        public static final enum Stage AIM_CALLBACK;
        public static final enum Stage CAPTURE_EMIT;
        public static final enum Stage CAPTURE_STARTED;
        public static final enum Stage CORE_KEY;
        public static final enum Stage DEVICE_SELECTION;
        public static final enum Stage EDITOR_CAPTURE;
        public static final enum Stage MAPPER_RESULT;
        public static final enum Stage PARSED_KEY;
        public static final enum Stage RAW_KEY_REJECTED;
        public static final enum Stage RAW_KEY_SEEN;
        public static final enum Stage SESSION_DELIVER;
        public static final enum Stage SESSION_DROP;
        public static final enum Stage SESSION_INGRESS;
        public static final enum Stage SESSION_QUEUED;

        private static final Stage[] $values() {
            return new Stage[]{Stage.DEVICE_SELECTION, Stage.CAPTURE_STARTED, Stage.RAW_KEY_SEEN, Stage.RAW_KEY_REJECTED, Stage.PARSED_KEY, Stage.CAPTURE_EMIT, Stage.CORE_KEY, Stage.SESSION_INGRESS, Stage.SESSION_QUEUED, Stage.SESSION_DROP, Stage.SESSION_DELIVER, Stage.EDITOR_CAPTURE, Stage.MAPPER_RESULT, Stage.AIM_CALLBACK};
        }

        static {
            Stage.DEVICE_SELECTION = new Stage("DEVICE_SELECTION", 0);
            Stage.CAPTURE_STARTED = new Stage("CAPTURE_STARTED", 1);
            Stage.RAW_KEY_SEEN = new Stage("RAW_KEY_SEEN", 2);
            Stage.RAW_KEY_REJECTED = new Stage("RAW_KEY_REJECTED", 3);
            Stage.PARSED_KEY = new Stage("PARSED_KEY", 4);
            Stage.CAPTURE_EMIT = new Stage("CAPTURE_EMIT", 5);
            Stage.CORE_KEY = new Stage("CORE_KEY", 6);
            Stage.SESSION_INGRESS = new Stage("SESSION_INGRESS", 7);
            Stage.SESSION_QUEUED = new Stage("SESSION_QUEUED", 8);
            Stage.SESSION_DROP = new Stage("SESSION_DROP", 9);
            Stage.SESSION_DELIVER = new Stage("SESSION_DELIVER", 10);
            Stage.EDITOR_CAPTURE = new Stage("EDITOR_CAPTURE", 11);
            Stage.MAPPER_RESULT = new Stage("MAPPER_RESULT", 12);
            Stage.AIM_CALLBACK = new Stage("AIM_CALLBACK", 13);
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
    public static final KeyboardRouteDiagnostics INSTANCE = null;
    private static final int MAX_LOG_RECORDS = 0xC0;
    public static final String TAG = "GOLDEN_KEYBOARD_ROUTE";
    private static volatile Set aimInputs;
    private static final AtomicLongArray counts;
    private static final ThreadLocal currentKey;
    private static volatile String lastDropReason;
    private static final AtomicInteger records;

    static {
        KeyboardRouteDiagnostics.INSTANCE = new KeyboardRouteDiagnostics();
        KeyboardRouteDiagnostics.counts = new AtomicLongArray(Stage.getEntries().size());
        KeyboardRouteDiagnostics.records = new AtomicInteger();
        KeyboardRouteDiagnostics.currentKey = new ThreadLocal();
        KeyboardRouteDiagnostics.aimInputs = SetsKt.emptySet();
        KeyboardRouteDiagnostics.$stable = 8;
    }

    private KeyboardRouteDiagnostics() {
        super();
    }

    public final void callback(boolean arg9, boolean arg10) {
        KeyboardRouteDiagnostics.record$default(this, Stage.AIM_CALLBACK, KeyboardRouteDiagnostics.currentKey.get(), null, null, "before=" + arg9 + " after=" + arg10, 12, null);
    }

    public final void captureStarted() {
        KeyboardRouteDiagnostics.records.set(0);
        KeyboardRouteDiagnostics.record$default(this, Stage.CAPTURE_STARTED, null, null, null, null, 30, null);
    }

    public final String getLastDropReason$app() {
        return KeyboardRouteDiagnostics.lastDropReason;
    }

    public final void key(Stage arg2, InputEvent arg3, Snapshot arg4, String arg5, String arg6) {
        Intrinsics.checkNotNullParameter(arg2, "stage");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(!(arg3 instanceof KeyDown) && !(arg3 instanceof KeyUp)) {
            return;
        }

        this.record(arg2, arg3, arg4, arg5, arg6);
    }

    public static void key$default(KeyboardRouteDiagnostics arg1, Stage arg2, InputEvent arg3, Snapshot arg4, String arg5, String arg6, int arg7, Object arg8) {
        Snapshot v0 = null;
        if((arg7 & 4) != 0) {
            arg4 = v0;
        }

        if((arg7 & 8) != 0) {
            arg5 = ((String)v0);
        }

        if((arg7 & 16) != 0) {
            arg6 = ((String)v0);
        }

        arg1.key(arg2, arg3, arg4, arg5, arg6);
    }

    public final void profile(Set arg1) {
        Intrinsics.checkNotNullParameter(arg1, "inputs");
        KeyboardRouteDiagnostics.aimInputs = CollectionsKt.toSet(((Iterable)arg1));
    }

    public final void rawKey(DeviceCaptureSession arg9, String arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg9, "session");
        Intrinsics.checkNotNullParameter(arg10, "code");
        Stage v11 = arg11 ? Stage.RAW_KEY_SEEN : Stage.RAW_KEY_REJECTED;
        Stage v1 = v11;
        String v11_1 = arg9.getDescriptor().getPath();
        CaptureMode v0 = arg9.getCaptureMode();
        InputState v9 = arg9.getState();
        arg10 = StringsKt.startsWith$default(arg10, "KEY_", false, 2, null) ? "symbolic" : "numeric-or-unknown";
        KeyboardRouteDiagnostics.record$default(this, v1, null, null, null, "node=" + v11_1 + " requestedMode=" + v0 + " state=" + v9 + " format=" + arg10, 14, null);
    }

    private final void record(Stage arg7, InputEvent arg8, Snapshot arg9, String arg10, String arg11) {
        String v0_2;
        String v1_1;
        String v6_1;
        KeyboardRouteDiagnostics.counts.incrementAndGet(arg7.ordinal());
        if(arg7 == Stage.SESSION_DROP) {
            KeyboardRouteDiagnostics.lastDropReason = arg10;
        }

        int v0 = KeyboardRouteDiagnostics.records.get();
        while(true) {
            int v1 = 0xC0;
            if(v0 < v1) {
                AtomicInteger v2 = KeyboardRouteDiagnostics.records;
                if(!v2.compareAndSet(v0, v0 + 1)) {
                    v0 = v2.get();
                    continue;
                }
            }

            break;
        }

        if(v0 >= v1) {
            return;
        }

        try {
            Object v0_1 = null;
            if((arg8 instanceof KeyDown)) {
                v6_1 = arg8.getKeyName();
            }
            else if((arg8 instanceof KeyUp)) {
                v6_1 = arg8.getKeyName();
            }
            else {
                v6_1 = ((String)v0_1);
            }

            boolean v3 = v6_1 == null || !KeyboardRouteDiagnostics.aimInputs.contains(InputBinding.Companion.keyboard(v6_1)) ? false : true;
            if(v6_1 != null) {
                v1_1 = (v3) || (SetsKt.setOf(new String[]{"F1", "W", "A", "S", "D"}).contains(v6_1)) ? v6_1 : ((String)v0_1);
                if(v1_1 == null) {
                    goto label_70;
                }

                v0_2 = v1_1;
            }
            else {
            label_70:
                if(v6_1 == null) {
                    goto label_73;
                }

                v0_2 = "OTHER_KEY";
            }

        label_73:
            JSONObject v6_2 = new JSONObject().put("stage", arg7.name());
            if(arg8 != null) {
                JSONObject v7 = v6_2.put("sequence", arg8.getSequenceNumber()).put("eventNanos", arg8.getTimestampNanos());
                v1_1 = "node";
                String v2_1 = arg8.getDevicePath();
                if(v2_1 == null) {
                    v2_1 = "unknown";
                }

                v7 = v7.put(v1_1, v2_1);
                v1_1 = "edge";
                String v8 = (arg8 instanceof KeyDown) ? "DOWN" : "UP";
                v7.put(v1_1, v8).put("configuredAim", v3).put("key", v0_1);
            }

            if(arg9 != null) {
                v6_2.put("session", arg9.getSessionId()).put("state", arg9.getState().name()).put("mouseConnected", arg9.getMouseConnected()).put("keyboardConnected", arg9.getKeyboardConnected()).put("keyboardRequired", arg9.getKeyboardRequired()).put("profileLoaded", arg9.getProfileLoaded()).put("mapperReady", arg9.getMapperReady()).put("cameraReady", arg9.getCameraReady()).put("injectorReady", arg9.getInjectorReady()).put("backend", arg9.getBackend().name()).put("editor", arg9.getEditor()).put("cleanupPending", arg9.getCleanupPending());
            }

            if(arg10 != null) {
                v6_2.put("reason", arg10);
            }

            if(arg11 != null) {
                v6_2.put("detail", arg11);
            }

            Result.constructor-impl(Integer.valueOf(Log.i("GOLDEN_KEYBOARD_ROUTE", v6_2.toString())));
            return;
        }
        catch(Throwable v6) {
            Result.constructor-impl(ResultKt.createFailure(v6));
            return;
        }
    }

    static void record$default(KeyboardRouteDiagnostics arg1, Stage arg2, InputEvent arg3, Snapshot arg4, String arg5, String arg6, int arg7, Object arg8) {
        InputEvent v0 = null;
        if((arg7 & 2) != 0) {
            arg3 = v0;
        }

        if((arg7 & 4) != 0) {
            arg4 = ((Snapshot)v0);
        }

        if((arg7 & 8) != 0) {
            arg5 = ((String)v0);
        }

        if((arg7 & 16) != 0) {
            arg6 = ((String)v0);
        }

        arg1.record(arg2, arg3, arg4, arg5, arg6);
    }

    public final void selection(List arg10, InputDeviceDescriptor arg11) {
        String v10_1;
        Intrinsics.checkNotNullParameter(arg10, "devices");
        Stage v2 = Stage.DEVICE_SELECTION;
        int v0 = arg10.size();
        int v3 = 0;
        if(!(arg10 instanceof Collection) || !arg10.isEmpty()) {
            Iterator v10 = ((Iterable)arg10).iterator();
            while(v10.hasNext()) {
                if(!v10.next().getRoles().contains(InputDeviceRole.KEYBOARD)) {
                    continue;
                }

                ++v3;
                if(v3 >= 0) {
                    continue;
                }

                CollectionsKt.throwCountOverflow();
            }
        }
        else {
        }

        if(arg11 != null) {
            v10_1 = arg11.getPath();
            if(v10_1 == null) {
                goto label_26;
            }
        }
        else {
        label_26:
            v10_1 = "none";
        }

        KeyboardRouteDiagnostics.record$default(this, v2, null, null, null, "nodes=" + v0 + " keyboardNodes=" + v3 + " selectedKeyboard=" + v10_1, 14, null);
    }

    public final Map snapshot$app() {
        EnumEntries v4 = Stage.getEntries();
        LinkedHashMap v0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v4), 10)), 16));
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            Object v1 = v4_1.next();
            ((Map)v0).put(v1, Long.valueOf(KeyboardRouteDiagnostics.counts.get(v1.ordinal())));
        }

        return ((Map)v0);
    }

    public final Object withKey(InputEvent arg2, Function0 arg3) {
        Object v2;
        Intrinsics.checkNotNullParameter(arg2, "event");
        Intrinsics.checkNotNullParameter(arg3, "operation");
        if(!(arg2 instanceof KeyDown) && !(arg2 instanceof KeyUp)) {
            return arg3.invoke();
        }

        ThreadLocal v1 = KeyboardRouteDiagnostics.currentKey;
        Object v0 = v1.get();
        v1.set(arg2);
        try {
            v2 = arg3.invoke();
            if(v0 != null) {
                goto label_17;
            }
        }
        catch(Throwable v1_1) {
            ThreadLocal v2_1 = KeyboardRouteDiagnostics.currentKey;
            if(v0 == null) {
                v2_1.remove();
            }
            else {
                v2_1.set(v0);
            }

            throw v1_1;
        }

        v1.remove();
        return v2;
    label_17:
        v1.set(v0);
        return v2;
    }
}

