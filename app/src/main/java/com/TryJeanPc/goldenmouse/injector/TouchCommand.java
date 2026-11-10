package com.TryJeanPc.goldenmouse.injector;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001(B;\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001D\u001A\u00020\bHÆ\u0003J\t\u0010\u001E\u001A\u00020\nHÆ\u0003J\u0010\u0010\u001F\u001A\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0018JL\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001A\u00020\bHÖ\u0001J\t\u0010&\u001A\u00020\'HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "", "action", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand$Action;", "x", "", "y", "pointerId", "", "timestamp", "", "expectedContactEpoch", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchCommand$Action;FFIJLjava/lang/Long;)V", "getAction", "()Lcom/TryJeanPc/goldenmouse/injector/TouchCommand$Action;", "getX", "()F", "getY", "getPointerId", "()I", "getTimestamp", "()J", "getExpectedContactEpoch", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/TryJeanPc/goldenmouse/injector/TouchCommand$Action;FFIJLjava/lang/Long;)Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "equals", "", "other", "hashCode", "toString", "", "Action", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TouchCommand {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchCommand$Action;", "", "<init>", "(Ljava/lang/String;I)V", "ACTION_DOWN", "ACTION_MOVE", "ACTION_UP", "ACTION_CANCEL", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Action {
        public static final enum Action ACTION_CANCEL;
        public static final enum Action ACTION_DOWN;
        public static final enum Action ACTION_MOVE;
        public static final enum Action ACTION_UP;

        private static final Action[] $values() {
            return new Action[]{Action.ACTION_DOWN, Action.ACTION_MOVE, Action.ACTION_UP, Action.ACTION_CANCEL};
        }

        static {
            Action.ACTION_DOWN = new Action("ACTION_DOWN", 0);
            Action.ACTION_MOVE = new Action("ACTION_MOVE", 1);
            Action.ACTION_UP = new Action("ACTION_UP", 2);
            Action.ACTION_CANCEL = new Action("ACTION_CANCEL", 3);
            Action[] v0 = Action.$values();
            Action.$VALUES = v0;
            Action.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Action(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Action.$ENTRIES;
        }

        public static Action valueOf(String arg1) {
            return Enum.valueOf(Action.class, arg1);
        }

        public static Action[] values() {
            return Action.$VALUES.clone();
        }
    }

    public static final int $stable;
    private final Action action;
    private final Long expectedContactEpoch;
    private final int pointerId;
    private final long timestamp;
    private final float x;
    private final float y;

    static {
    }

    public TouchCommand(Action arg10, float arg11, float arg12, int arg13, long arg14, Long arg16, int arg17, DefaultConstructorMarker arg18) {
        Long v8 = (arg17 & 0x20) != 0 ? null : arg16;
        this(arg10, arg11, arg12, arg13, arg14, v8);
    }

    public TouchCommand(Action arg2, float arg3, float arg4, int arg5, long arg6, Long arg8) {
        Intrinsics.checkNotNullParameter(arg2, "action");
        super();
        this.action = arg2;
        this.x = arg3;
        this.y = arg4;
        this.pointerId = arg5;
        this.timestamp = arg6;
        this.expectedContactEpoch = arg8;
    }

    public final Action component1() {
        return this.action;
    }

    public final float component2() {
        return this.x;
    }

    public final float component3() {
        return this.y;
    }

    public final int component4() {
        return this.pointerId;
    }

    public final long component5() {
        return this.timestamp;
    }

    public final Long component6() {
        return this.expectedContactEpoch;
    }

    public final TouchCommand copy(Action arg9, float arg10, float arg11, int arg12, long arg13, Long arg15) {
        Intrinsics.checkNotNullParameter(arg9, "action");
        return new TouchCommand(arg9, arg10, arg11, arg12, arg13, arg15);
    }

    public static TouchCommand copy$default(TouchCommand arg0, Action arg1, float arg2, float arg3, int arg4, long arg5, Long arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.action;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.x;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.y;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.pointerId;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.timestamp;
        }

        if((arg8 & 0x20) != 0) {
            arg7 = arg0.expectedContactEpoch;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg7);
    }

    public boolean equals(Object arg8) {
        if(this == (((TouchCommand)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TouchCommand)) {
            return 0;
        }

        if(this.action != ((TouchCommand)arg8).action) {
            return 0;
        }

        if(Float.compare(this.x, ((TouchCommand)arg8).x) != 0) {
            return 0;
        }

        if(Float.compare(this.y, ((TouchCommand)arg8).y) != 0) {
            return 0;
        }

        if(this.pointerId != ((TouchCommand)arg8).pointerId) {
            return 0;
        }

        if(this.timestamp != ((TouchCommand)arg8).timestamp) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.expectedContactEpoch, ((TouchCommand)arg8).expectedContactEpoch)) {
            return 0;
        }

        return 1;
    }

    public final Action getAction() {
        return this.action;
    }

    public final Long getExpectedContactEpoch() {
        return this.expectedContactEpoch;
    }

    public final int getPointerId() {
        return this.pointerId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        int v0 = ((((this.action.hashCode() * 0x1F + Float.hashCode(this.x)) * 0x1F + Float.hashCode(this.y)) * 0x1F + Integer.hashCode(this.pointerId)) * 0x1F + Long.hashCode(this.timestamp)) * 0x1F;
        Long v3 = this.expectedContactEpoch;
        int v3_1 = v3 == null ? 0 : v3.hashCode();
        return v0 + v3_1;
    }

    public String toString() {
        return "TouchCommand(action=" + this.action + ", x=" + this.x + ", y=" + this.y + ", pointerId=" + this.pointerId + ", timestamp=" + this.timestamp + ", expectedContactEpoch=" + this.expectedContactEpoch + ")";
    }
}

