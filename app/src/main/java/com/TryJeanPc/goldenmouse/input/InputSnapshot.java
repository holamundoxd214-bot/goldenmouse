package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputSnapshot;", "", "mouse", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceStatus;", "keyboard", "state", "Lcom/TryJeanPc/goldenmouse/input/InputState;", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/InputDeviceStatus;Lcom/TryJeanPc/goldenmouse/input/InputDeviceStatus;Lcom/TryJeanPc/goldenmouse/input/InputState;)V", "getMouse", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceStatus;", "getKeyboard", "getState", "()Lcom/TryJeanPc/goldenmouse/input/InputState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class InputSnapshot {
    public static final int $stable = 8;
    private final InputDeviceStatus keyboard;
    private final InputDeviceStatus mouse;
    private final InputState state;

    static {
    }

    public InputSnapshot(InputDeviceStatus arg8, InputDeviceStatus arg9, InputState arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 1) != 0) {
            arg8 = new InputDeviceStatus(false, null, null, null, 15, null);
        }

        if((arg11 & 2) != 0) {
            arg9 = new InputDeviceStatus(false, null, null, null, 15, null);
        }

        if((arg11 & 4) != 0) {
            arg10 = InputState.WAITING;
        }

        this(arg8, arg9, arg10);
    }

    public InputSnapshot(InputDeviceStatus arg2, InputDeviceStatus arg3, InputState arg4) {
        Intrinsics.checkNotNullParameter(arg2, "mouse");
        Intrinsics.checkNotNullParameter(arg3, "keyboard");
        Intrinsics.checkNotNullParameter(arg4, "state");
        super();
        this.mouse = arg2;
        this.keyboard = arg3;
        this.state = arg4;
    }

    public InputSnapshot() {
        this(null, null, null, 7, null);
    }

    public final InputDeviceStatus component1() {
        return this.mouse;
    }

    public final InputDeviceStatus component2() {
        return this.keyboard;
    }

    public final InputState component3() {
        return this.state;
    }

    public final InputSnapshot copy(InputDeviceStatus arg1, InputDeviceStatus arg2, InputState arg3) {
        Intrinsics.checkNotNullParameter(arg1, "mouse");
        Intrinsics.checkNotNullParameter(arg2, "keyboard");
        Intrinsics.checkNotNullParameter(arg3, "state");
        return new InputSnapshot(arg1, arg2, arg3);
    }

    public static InputSnapshot copy$default(InputSnapshot arg0, InputDeviceStatus arg1, InputDeviceStatus arg2, InputState arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.mouse;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.keyboard;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.state;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((InputSnapshot)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof InputSnapshot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.mouse, ((InputSnapshot)arg5).mouse)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.keyboard, ((InputSnapshot)arg5).keyboard)) {
            return 0;
        }

        if(this.state != ((InputSnapshot)arg5).state) {
            return 0;
        }

        return 1;
    }

    public final InputDeviceStatus getKeyboard() {
        return this.keyboard;
    }

    public final InputDeviceStatus getMouse() {
        return this.mouse;
    }

    public final InputState getState() {
        return this.state;
    }

    public int hashCode() {
        return (this.mouse.hashCode() * 0x1F + this.keyboard.hashCode()) * 0x1F + this.state.hashCode();
    }

    public String toString() {
        return "InputSnapshot(mouse=" + this.mouse + ", keyboard=" + this.keyboard + ", state=" + this.state + ")";
    }
}

