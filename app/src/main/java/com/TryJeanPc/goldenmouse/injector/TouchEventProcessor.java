package com.TryJeanPc.goldenmouse.injector;

import android.util.Log;
import android.view.InputDevice;
import android.view.MotionEvent$PointerCoords;
import android.view.MotionEvent$PointerProperties;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u001BJ\u000E\u0010\u001C\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020\u000EJ\'\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u000E2\b\u0010 \u001A\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001A\u00020#H\u0002R\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001A\u001E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\tj\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00150\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000E\u0010\u0017\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchEventProcessor;", "", "eventInjector", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "activePointers", "Ljava/util/LinkedHashMap;", "", "Lcom/TryJeanPc/goldenmouse/injector/TouchEventProcessor$PointerState;", "Lkotlin/collections/LinkedHashMap;", "gestureDownTime", "", "lastEventTime", "properties", "", "Landroid/view/MotionEvent$PointerProperties;", "[Landroid/view/MotionEvent$PointerProperties;", "coordinates", "Landroid/view/MotionEvent$PointerCoords;", "[Landroid/view/MotionEvent$PointerCoords;", "controlSequence", "touchscreenDeviceId", "execute", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "cancelAll", "eventTime", "inject", "action", "releasedPointerId", "(IJLjava/lang/Integer;)Z", "resetState", "", "PointerState", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TouchEventProcessor {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchEventProcessor$Companion;", "", "<init>", "()V", "TAG", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchEventProcessor$PointerState;", "", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class PointerState {
        private float x;
        private float y;

        public PointerState(float arg1, float arg2) {
            super();
            this.x = arg1;
            this.y = arg2;
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final PointerState copy(float arg1, float arg2) {
            return new PointerState(arg1, arg2);
        }

        public static PointerState copy$default(PointerState arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.x;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.y;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((PointerState)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof PointerState)) {
                return 0;
            }

            if(Float.compare(this.x, ((PointerState)arg5).x) != 0) {
                return 0;
            }

            if(Float.compare(this.y, ((PointerState)arg5).y) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y);
        }

        public final void setX(float arg1) {
            this.x = arg1;
        }

        public final void setY(float arg1) {
            this.y = arg1;
        }

        public String toString() {
            return "PointerState(x=" + this.x + ", y=" + this.y + ")";
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Action.values().length];
            try {
                v0[Action.ACTION_CANCEL.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Action.ACTION_DOWN.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Action.ACTION_MOVE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Action.ACTION_UP.ordinal()] = 4;
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

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final String TAG = "GOLDEN_MOUSE_DOWN";
    private final LinkedHashMap activePointers;
    private long controlSequence;
    private final MotionEvent$PointerCoords[] coordinates;
    private final Function1 eventInjector;
    private long gestureDownTime;
    private long lastEventTime;
    private final MotionEvent$PointerProperties[] properties;
    private final int touchscreenDeviceId;

    static {
        TouchEventProcessor.Companion = new Companion(null);
        TouchEventProcessor.$stable = 8;
    }

    public TouchEventProcessor(Function1 arg7) {
        Integer v7_2;
        Intrinsics.checkNotNullParameter(arg7, "eventInjector");
        super();
        this.eventInjector = arg7;
        this.activePointers = new LinkedHashMap();
        int v7 = 0x20;
        MotionEvent$PointerProperties[] v0 = new MotionEvent$PointerProperties[v7];
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < v7; ++v2) {
            MotionEvent$PointerProperties v4 = new MotionEvent$PointerProperties();
            v4.toolType = 1;
            v0[v2] = v4;
        }

        this.properties = v0;
        MotionEvent$PointerCoords[] v0_1 = new MotionEvent$PointerCoords[v7];
        for(v2 = 0; v2 < v7; ++v2) {
            MotionEvent$PointerCoords v4_1 = new MotionEvent$PointerCoords();
            v4_1.size = 1f;
            v0_1[v2] = v4_1;
        }

        this.coordinates = v0_1;
        int[] v7_1 = InputDevice.getDeviceIds();
        Intrinsics.checkNotNullExpressionValue(v7_1, "getDeviceIds(...)");
        int v0_2 = v7_1.length;
        while(v1 < v0_2) {
            v2 = v7_1[v1];
            InputDevice v4_2 = InputDevice.getDevice(v2);
            if(v4_2 != null && (v4_2.supportsSource(0x1002))) {
                v7_2 = Integer.valueOf(v2);
                goto label_49;
            }

            ++v1;
        }

        v7_2 = null;
    label_49:
        v7 = v7_2 != null ? v7_2.intValue() : -1;
        this.touchscreenDeviceId = v7;
    }

    public final boolean cancelAll(long arg4) {
        boolean v4_1;
        String v0 = "CANCEL result=";
        __monitor_enter(this);
        try {
            if(!this.activePointers.isEmpty()) {
                goto label_11;
            }

            Log.i("GOLDEN_MOUSE_DOWN", "CANCEL skipped: local pointers empty; no event sent to InputManager");
        }
        catch(Throwable v4) {
            goto label_32;
        }

        __monitor_exit(this);
        return 1;
        try {
        label_11:
            v4_1 = this.inject(3, RangesKt.coerceAtLeast(arg4, this.gestureDownTime), null);
            if(v4_1) {
                this.resetState();
            }

            Log.i("GOLDEN_MOUSE_DOWN", v0 + v4_1 + " remaining=" + this.activePointers.keySet());
        }
        catch(Throwable v4) {
            try {
            label_32:
                __monitor_exit(this);
            }
            catch(Throwable v4) {
                goto label_32;
            }

            throw v4;
        }

        __monitor_exit(this);
        return v4_1;
    }

    public final boolean execute(TouchCommand arg19) {
        boolean v2_5;
        Object v2_1;
        int v7;
        int v6;
        int v3_1;
        boolean v0_2;
        int v17;
        boolean v16;
        TouchCommand v5;
        TouchEventProcessor v1 = this;
        String v0 = "processor after seq=";
        String v2 = "Mouse DOWN rejected reason=pointer_already_active active=";
        String v3 = "processor before seq=";
        __monitor_enter(this);
        try {
            v5 = arg19;
            Intrinsics.checkNotNullParameter(v5, "command");
            if(v5.getAction() != Action.ACTION_MOVE) {
            }
            else {
                goto label_13;
            }
        }
        catch(Throwable v0_1) {
            goto label_231;
        }

        int v4 = 1;
        goto label_14;
    label_13:
        v4 = 0;
    label_14:
        long v9 = v1.controlSequence;
        if(v4 != 0) {
            ++v9;
            try {
                v1.controlSequence = v9;
            label_19:
                if(v4 != 0) {
                    v16 = false;
                    v17 = v4;
                    Log.i("GOLDEN_MOUSE_DOWN", v3 + v9 + " action=" + v5.getAction() + " pointer=" + v5.getPointerId() + " active=" + v1.activePointers.keySet() + " x=" + v5.getX() + " y=" + v5.getY() + " time=" + v5.getTimestamp());
                }
                else {
                    v17 = v4;
                    v16 = false;
                }

                if(v5.getAction() != Action.ACTION_CANCEL) {
                    goto label_63;
                }

                v0_2 = v1.cancelAll(v5.getTimestamp());
                goto label_61;
            }
            catch(Throwable v0_1) {
                goto label_231;
            }
        }

        goto label_19;
    label_61:
        __monitor_exit(this);
        return v0_2;
        try {
        label_63:
            if(v5.getPointerId() >= 0) {
                goto label_67;
            }
        }
        catch(Throwable v0_1) {
            goto label_231;
        }

        __monitor_exit(this);
        return v16;
        try {
        label_67:
            float v4_1 = 3.402823E+38f;
            if(Math.abs(v5.getX()) <= v4_1 && Math.abs(v5.getY()) <= v4_1) {
                v3_1 = WhenMappings.$EnumSwitchMapping$0[v5.getAction().ordinal()];
                if(v3_1 != 1) {
                    v4 = 4;
                    v6 = 3;
                    v7 = 2;
                    if(v3_1 != v7) {
                        if(v3_1 != v6) {
                            if(v3_1 == v4) {
                            }
                            else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }

                        v2_1 = v1.activePointers.get(Integer.valueOf(v5.getPointerId()));
                        if(v2_1 != null) {
                            goto label_97;
                        }

                        goto label_95;
                    }
                    else {
                        goto label_102;
                    }
                }
                else {
                    goto label_224;
                }
            }

            goto label_228;
        }
        catch(Throwable v0_1) {
            goto label_231;
        }

    label_95:
        __monitor_exit(this);
        return v16;
        try {
        label_97:
            ((PointerState)v2_1).setX(v5.getX());
            ((PointerState)v2_1).setY(v5.getY());
            goto label_139;
        label_102:
            if(v1.activePointers.size() < v1.properties.length) {
                goto label_109;
            }
        }
        catch(Throwable v0_1) {
            goto label_231;
        }

        __monitor_exit(this);
        return v16;
        try {
        label_109:
            if(!v1.activePointers.containsKey(Integer.valueOf(v5.getPointerId()))) {
                goto label_126;
            }

            if(v5.getPointerId() == 0) {
                Log.e("GOLDEN_MOUSE_DOWN", v2 + v1.activePointers.keySet());
            }
        }
        catch(Throwable v0_1) {
            goto label_231;
        }

        __monitor_exit(this);
        return v16;
        try {
        label_126:
            if(v1.activePointers.isEmpty()) {
                v1.gestureDownTime = v5.getTimestamp();
            }

            v1.activePointers.put(Integer.valueOf(v5.getPointerId()), new PointerState(v5.getX(), v5.getY()));
        label_139:
            Set v2_2 = v1.activePointers.keySet();
            Intrinsics.checkNotNullExpressionValue(v2_2, "<get-keys>(...)");
            int v2_3 = CollectionsKt.indexOf(((Iterable)v2_2), Integer.valueOf(v5.getPointerId()));
            v3_1 = WhenMappings.$EnumSwitchMapping$0[v5.getAction().ordinal()];
            if(v3_1 == 1) {
                v7 = v6;
            }
            else if(v3_1 != v7) {
                if(v3_1 != v6) {
                    if(v3_1 != v4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    else if(v1.activePointers.size() == 1) {
                        v7 = 1;
                    }
                    else {
                        v7 = v2_3 << 8 | 6;
                    }
                }
            }
            else if(v1.activePointers.size() == 1) {
                v7 = ((int)v16);
            }
            else {
                v7 = v2_3 << 8 | 5;
            }

            long v2_4 = RangesKt.coerceAtLeast(v5.getTimestamp(), v1.gestureDownTime);
            Integer v8 = null;
            TouchCommand v4_2 = v5.getAction() == Action.ACTION_UP ? v5 : ((TouchCommand)v8);
            if(v4_2 != null) {
                v8 = Integer.valueOf(v4_2.getPointerId());
            }

            v2_5 = v1.inject(v7, v2_4, v8);
            if((v2_5) && v5.getAction() == Action.ACTION_UP) {
                v1.activePointers.remove(Integer.valueOf(v5.getPointerId()));
                if(v1.activePointers.isEmpty()) {
                    v1.gestureDownTime = 0;
                }
            }

            if(v17 != 0) {
                Log.i("GOLDEN_MOUSE_DOWN", v0 + v9 + " action=" + v5.getAction() + " injected=" + v2_5 + " active=" + v1.activePointers.keySet());
            }
        }
        catch(Throwable v0_1) {
            goto label_231;
        }

        __monitor_exit(this);
        return v2_5;
        try {
        label_224:
            v0_2 = v1.cancelAll(v5.getTimestamp());
        }
        catch(Throwable v0_1) {
            try {
            label_231:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_231;
            }

            throw v0_1;
        }

        __monitor_exit(this);
        return v0_2;
    label_228:
        __monitor_exit(this);
        return v16;
    }

    private final boolean inject(int arg19, long arg20, Integer arg22) {
        boolean v0_2;
        Function1 v1_2;
        MotionEvent v20;
        int v6;
        int v15;
        long v12;
        long v10;
        Set v9_1;
        long v7_1;
        MotionEvent v2_3;
        int v2_2;
        float v5_1;
        TouchEventProcessor v0 = this;
        int v7 = v0.activePointers.size();
        int v1 = 0;
        if(v7 != 0) {
            if(v7 > v0.properties.length) {
            }
            else {
                Iterator v2 = v0.activePointers.entrySet().iterator();
                int v3;
                for(v3 = 0; v2.hasNext(); ++v3) {
                    Object v4 = v2.next();
                    int v5 = ((Map$Entry)v4).getKey().intValue();
                    v4 = ((Map$Entry)v4).getValue();
                    v0.properties[v3].id = v5;
                    v0.coordinates[v3].x = ((PointerState)v4).getX();
                    v0.coordinates[v3].y = ((PointerState)v4).getY();
                    MotionEvent$PointerCoords v4_1 = v0.coordinates[v3];
                    if(arg22 == null) {
                        goto label_38;
                    }
                    else if(v5 == arg22.intValue()) {
                        v5_1 = 0f;
                    }
                    else {
                    label_38:
                        v5_1 = 1f;
                    }

                    v4_1.pressure = v5_1;
                }

                long v4_2 = Math.max(arg20, Math.max(v0.gestureDownTime, v0.lastEventTime));
                v0.lastEventTime = v4_2;
                long v2_1 = v0.gestureDownTime;
                MotionEvent$PointerProperties[] v8 = v0.properties;
                MotionEvent$PointerCoords[] v9 = v0.coordinates;
                int v14 = v0.touchscreenDeviceId;
                if(arg19 == 3) {
                    v1 = 0x20;
                }

                MotionEvent v1_1 = MotionEvent.obtain(v2_1, v4_2, arg19, v7, v8, v9, 0, 0, 1f, 1f, v14, 0, 0x1002, v1);
                try {
                    v2_2 = v1_1.getActionMasked();
                }
                catch(Throwable v0_1) {
                    v2_3 = v1_1;
                    goto label_145;
                }

                String v3_1 = " pointers=";
                String v4_3 = "INPUTMANAGER seq=";
                String v5_2 = "GOLDEN_MOUSE_DOWN";
                if(v2_2 != 2) {
                    try {
                        v7_1 = v0.controlSequence;
                        v2_2 = v1_1.getActionMasked();
                        v9_1 = v0.activePointers.keySet();
                        v10 = v1_1.getDownTime();
                        v12 = v1_1.getEventTime();
                        v14 = v1_1.getDeviceId();
                        v15 = v1_1.getSource();
                        v6 = v1_1.getFlags();
                        v20 = v1_1;
                        goto label_81;
                    }
                    catch(Throwable v0_1) {
                        try {
                            v20 = v1_1;
                            goto label_141;
                        label_81:
                            Log.i(v5_2, v4_3 + v7_1 + " action=" + v2_2 + v3_1 + v9_1 + " downTime=" + v10 + " eventTime=" + v12 + " deviceId=" + v14 + " source=" + v15 + " flags=" + v6);
                            goto label_112;
                        label_111:
                            v20 = v1_1;
                        label_112:
                            v1_2 = v0.eventInjector;
                            Intrinsics.checkNotNull(v20);
                            v2_3 = v20;
                            goto label_115;
                        }
                        catch(Throwable v0_1) {
                            goto label_141;
                        }
                    }
                }
                else {
                    goto label_111;
                }

                goto label_112;
            label_141:
                v2_3 = v20;
                goto label_145;
                try {
                label_115:
                    Object v1_3 = v1_2.invoke(v2_3);
                    boolean v6_1 = v1_3.booleanValue();
                    if(v2_3.getActionMasked() != 2) {
                        Log.i(v5_2, v4_3 + v0.controlSequence + " result=" + v6_1 + v3_1 + v0.activePointers.keySet());
                    }

                    v0_2 = ((Boolean)v1_3).booleanValue();
                    goto label_136;
                }
                catch(Throwable v0_1) {
                }

            label_145:
                v2_3.recycle();
                throw v0_1;
            label_136:
                v2_3.recycle();
                return v0_2;
            }
        }

        return 0;
    }

    private final void resetState() {
        this.activePointers.clear();
        this.gestureDownTime = 0;
        this.lastEventTime = 0;
    }
}

