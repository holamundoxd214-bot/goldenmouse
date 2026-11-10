package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "", "<init>", "(Ljava/lang/String;I)V", "MOUSE", "KEYBOARD", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum InputDeviceRole {
    public static final enum InputDeviceRole KEYBOARD;
    public static final enum InputDeviceRole MOUSE;

    private static final InputDeviceRole[] $values() {
        return new InputDeviceRole[]{InputDeviceRole.MOUSE, InputDeviceRole.KEYBOARD};
    }

    static {
        InputDeviceRole.MOUSE = new InputDeviceRole("MOUSE", 0);
        InputDeviceRole.KEYBOARD = new InputDeviceRole("KEYBOARD", 1);
        InputDeviceRole[] v0 = InputDeviceRole.$values();
        InputDeviceRole.$VALUES = v0;
        InputDeviceRole.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private InputDeviceRole(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return InputDeviceRole.$ENTRIES;
    }

    public static InputDeviceRole valueOf(String arg1) {
        return Enum.valueOf(InputDeviceRole.class, arg1);
    }

    public static InputDeviceRole[] values() {
        return InputDeviceRole.$VALUES.clone();
    }
}

