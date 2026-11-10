package com.TryJeanPc.goldenmouse.macro.editor;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroRunMode;", "", "<init>", "(Ljava/lang/String;I)V", "ONCE", "LOOP", "HOLD", "PRESS_RELEASE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum MacroRunMode {
    public static final enum MacroRunMode HOLD;
    public static final enum MacroRunMode LOOP;
    public static final enum MacroRunMode ONCE;
    public static final enum MacroRunMode PRESS_RELEASE;

    private static final MacroRunMode[] $values() {
        return new MacroRunMode[]{MacroRunMode.ONCE, MacroRunMode.LOOP, MacroRunMode.HOLD, MacroRunMode.PRESS_RELEASE};
    }

    static {
        MacroRunMode.ONCE = new MacroRunMode("ONCE", 0);
        MacroRunMode.LOOP = new MacroRunMode("LOOP", 1);
        MacroRunMode.HOLD = new MacroRunMode("HOLD", 2);
        MacroRunMode.PRESS_RELEASE = new MacroRunMode("PRESS_RELEASE", 3);
        MacroRunMode[] v0 = MacroRunMode.$values();
        MacroRunMode.$VALUES = v0;
        MacroRunMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private MacroRunMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return MacroRunMode.$ENTRIES;
    }

    public static MacroRunMode valueOf(String arg1) {
        return Enum.valueOf(MacroRunMode.class, arg1);
    }

    public static MacroRunMode[] values() {
        return MacroRunMode.$VALUES.clone();
    }
}

