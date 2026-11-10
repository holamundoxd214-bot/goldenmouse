package com.TryJeanPc.goldenmouse.mapper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/InputBindingSource;", "", "<init>", "(Ljava/lang/String;I)V", "KEYBOARD", "MOUSE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum InputBindingSource {
    public static final enum InputBindingSource KEYBOARD;
    public static final enum InputBindingSource MOUSE;

    private static final InputBindingSource[] $values() {
        return new InputBindingSource[]{InputBindingSource.KEYBOARD, InputBindingSource.MOUSE};
    }

    static {
        InputBindingSource.KEYBOARD = new InputBindingSource("KEYBOARD", 0);
        InputBindingSource.MOUSE = new InputBindingSource("MOUSE", 1);
        InputBindingSource[] v0 = InputBindingSource.$values();
        InputBindingSource.$VALUES = v0;
        InputBindingSource.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private InputBindingSource(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return InputBindingSource.$ENTRIES;
    }

    public static InputBindingSource valueOf(String arg1) {
        return Enum.valueOf(InputBindingSource.class, arg1);
    }

    public static InputBindingSource[] values() {
        return InputBindingSource.$VALUES.clone();
    }
}

