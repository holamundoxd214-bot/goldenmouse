package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputState;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "CONNECTED", "DISCONNECTED", "ERROR", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum InputState {
    public static final enum InputState CONNECTED;
    public static final enum InputState DISCONNECTED;
    public static final enum InputState ERROR;
    public static final enum InputState WAITING;

    private static final InputState[] $values() {
        return new InputState[]{InputState.WAITING, InputState.CONNECTED, InputState.DISCONNECTED, InputState.ERROR};
    }

    static {
        InputState.WAITING = new InputState("WAITING", 0);
        InputState.CONNECTED = new InputState("CONNECTED", 1);
        InputState.DISCONNECTED = new InputState("DISCONNECTED", 2);
        InputState.ERROR = new InputState("ERROR", 3);
        InputState[] v0 = InputState.$values();
        InputState.$VALUES = v0;
        InputState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private InputState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return InputState.$ENTRIES;
    }

    public static InputState valueOf(String arg1) {
        return Enum.valueOf(InputState.class, arg1);
    }

    public static InputState[] values() {
        return InputState.$VALUES.clone();
    }
}

