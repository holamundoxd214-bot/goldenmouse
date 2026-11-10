package com.TryJeanPc.goldenmouse.input;

import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001A\u00020\u000BJ \u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001A\u00020\u0006J*\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u0006R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseReportRate;", "", "<init>", "()V", "samples", "Ljava/util/ArrayDeque;", "", "device", "", "session", "reset", "", "record", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseMove;", "selectedPath", "sessionId", "reading", "Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$Reading;", "path", "connected", "", "now", "State", "Reading", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseReportRate {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000BJ$\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$Reading;", "", "state", "Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$State;", "hz", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$State;Ljava/lang/Integer;)V", "getState", "()Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$State;", "getHz", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$State;Ljava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$Reading;", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Reading {
        public static final int $stable;
        private final Integer hz;
        private final State state;

        static {
        }

        public Reading(State arg2, Integer arg3) {
            Intrinsics.checkNotNullParameter(arg2, "state");
            super();
            this.state = arg2;
            this.hz = arg3;
        }

        public Reading(State arg1, Integer arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 2) != 0) {
                arg2 = null;
            }

            this(arg1, arg2);
        }

        public final State component1() {
            return this.state;
        }

        public final Integer component2() {
            return this.hz;
        }

        public final Reading copy(State arg1, Integer arg2) {
            Intrinsics.checkNotNullParameter(arg1, "state");
            return new Reading(arg1, arg2);
        }

        public static Reading copy$default(Reading arg0, State arg1, Integer arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.state;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.hz;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Reading)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Reading)) {
                return 0;
            }

            if(this.state != ((Reading)arg5).state) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.hz, ((Reading)arg5).hz)) {
                return 0;
            }

            return 1;
        }

        public final Integer getHz() {
            return this.hz;
        }

        public final State getState() {
            return this.state;
        }

        public int hashCode() {
            int v0 = this.state.hashCode() * 0x1F;
            Integer v1 = this.hz;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return v0 + v1_1;
        }

        public String toString() {
            return "Reading(state=" + this.state + ", hz=" + this.hz + ")";
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$State;", "", "<init>", "(Ljava/lang/String;I)V", "NO_CAPTURE", "IDLE", "MEASURING", "OBSERVED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum State {
        public static final enum State IDLE;
        public static final enum State MEASURING;
        public static final enum State NO_CAPTURE;
        public static final enum State OBSERVED;

        private static final State[] $values() {
            return new State[]{State.NO_CAPTURE, State.IDLE, State.MEASURING, State.OBSERVED};
        }

        static {
            State.NO_CAPTURE = new State("NO_CAPTURE", 0);
            State.IDLE = new State("IDLE", 1);
            State.MEASURING = new State("MEASURING", 2);
            State.OBSERVED = new State("OBSERVED", 3);
            State[] v0 = State.$values();
            State.$VALUES = v0;
            State.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private State(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return State.$ENTRIES;
        }

        public static State valueOf(String arg1) {
            return Enum.valueOf(State.class, arg1);
        }

        public static State[] values() {
            return State.$VALUES.clone();
        }
    }

    public static final int $stable = 8;
    private String device;
    private final ArrayDeque samples;
    private long session;

    static {
    }

    public MouseReportRate() {
        super();
        this.samples = new ArrayDeque();
        this.session = -1;
    }

    public final Reading reading(String arg5, long arg6, boolean arg8, long arg9) {
        Reading v5_3;
        Reading v7_1;
        __monitor_enter(this);
        int v0 = 2;
        Integer v1 = null;
        if(arg8) {
            if(arg5 == null) {
            }
            else {
                try {
                    if(Intrinsics.areEqual(arg5, this.device)) {
                        if(arg6 != this.session) {
                        }
                        else {
                            if(!this.samples.isEmpty()) {
                                Object v5_1 = this.samples.getLast();
                                Intrinsics.checkNotNullExpressionValue(v5_1, "getLast(...)");
                                if(arg9 - ((Number)v5_1).longValue() > 500000000) {
                                }
                                else {
                                    long v5_2 = this.samples.getLast().longValue();
                                    Object v7 = this.samples.getFirst();
                                    Intrinsics.checkNotNullExpressionValue(v7, "getFirst(...)");
                                    v5_2 -= ((Number)v7).longValue();
                                    if(this.samples.size() >= 8) {
                                        if(v5_2 < 250000000) {
                                        }
                                        else {
                                            v7_1 = new Reading(State.OBSERVED, Integer.valueOf(MathKt.roundToInt((((double)(this.samples.size() - 1))) * 1000000000 / (((double)v5_2)))));
                                            goto label_53;
                                        }
                                    }

                                    goto label_55;
                                }
                            }

                            goto label_60;
                        }
                    }

                    goto label_65;
                }
                catch(Throwable v5) {
                    goto label_78;
                }

            label_53:
                __monitor_exit(this);
                return v7_1;
                try {
                label_55:
                    v5_3 = new Reading(State.MEASURING, v1, v0, ((DefaultConstructorMarker)v1));
                }
                catch(Throwable v5) {
                    goto label_78;
                }

                __monitor_exit(this);
                return v5_3;
                try {
                label_60:
                    v5_3 = new Reading(State.IDLE, v1, v0, ((DefaultConstructorMarker)v1));
                }
                catch(Throwable v5) {
                    goto label_78;
                }

                __monitor_exit(this);
                return v5_3;
                try {
                label_65:
                    this.reset();
                    v5_3 = new Reading(State.IDLE, v1, v0, ((DefaultConstructorMarker)v1));
                }
                catch(Throwable v5) {
                    goto label_78;
                }

                __monitor_exit(this);
                return v5_3;
            }
        }

        try {
            this.reset();
            v5_3 = new Reading(State.NO_CAPTURE, v1, v0, ((DefaultConstructorMarker)v1));
        }
        catch(Throwable v5) {
            try {
            label_78:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_78;
            }

            throw v5;
        }

        __monitor_exit(this);
        return v5_3;
    }

    public static Reading reading$default(MouseReportRate arg7, String arg8, long arg9, boolean arg11, long arg12, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg12 = System.nanoTime();
        }

        return arg7.reading(arg8, arg9, arg11, arg12);
    }

    public final void record(MouseMove arg3, String arg4, long arg5) {
        Object v5;
        long v3_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "event");
            if(arg4 != null && (Intrinsics.areEqual(arg3.getDevicePath(), arg4))) {
                if(arg3.getDeltaX() == 0 && arg3.getDeltaY() == 0) {
                    goto label_67;
                }

                if(!Intrinsics.areEqual(this.device, arg4) || this.session != arg5) {
                    this.reset();
                    this.device = arg4;
                    this.session = arg5;
                }

                v3_1 = arg3.getTimestampNanos();
                if(!this.samples.isEmpty() && v3_1 <= this.samples.getLast().longValue()) {
                    goto label_28;
                }

                goto label_30;
            }

            goto label_67;
        }
        catch(Throwable v3) {
            goto label_70;
        }

    label_28:
        __monitor_exit(this);
        return;
        try {
        label_30:
            if(!this.samples.isEmpty()) {
                v5 = this.samples.getLast();
                Intrinsics.checkNotNullExpressionValue(v5, "getLast(...)");
                if(v3_1 - ((Number)v5).longValue() > 500000000) {
                    this.samples.clear();
                }
            }

            this.samples.addLast(Long.valueOf(v3_1));
            while(true) {
            label_46:
                if(this.samples.size() <= 0x2000) {
                    if(!this.samples.isEmpty()) {
                        v5 = this.samples.getFirst();
                        Intrinsics.checkNotNullExpressionValue(v5, "getFirst(...)");
                        if(v3_1 - ((Number)v5).longValue() > 1000000000) {
                            break;
                        }
                    }

                    goto label_62;
                }

                goto label_64;
            }
        }
        catch(Throwable v3) {
            goto label_70;
        }

        goto label_64;
    label_62:
        __monitor_exit(this);
        return;
        try {
        label_64:
            this.samples.removeFirst();
            goto label_46;
        }
        catch(Throwable v3) {
            try {
            label_70:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_70;
            }

            throw v3;
        }

    label_67:
        __monitor_exit(this);
    }

    public final void reset() {
        __monitor_enter(this);
        try {
            this.samples.clear();
            this.device = null;
            this.session = -1;
        }
        catch(Throwable v0) {
            try {
            label_10:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_10;
            }

            throw v0;
        }

        __monitor_exit(this);
    }
}

