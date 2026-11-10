package com.TryJeanPc.goldenmouse.macro.editor;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u000B\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000F¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;", "", "label", "", "defaultDurationMs", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;J)V", "getLabel", "()Ljava/lang/String;", "getDefaultDurationMs", "()J", "TAP", "SWIPE", "DELAY", "LONG_PRESS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum MacroActionType {
    public static final enum MacroActionType DELAY;
    public static final enum MacroActionType LONG_PRESS;
    public static final enum MacroActionType SWIPE;
    public static final enum MacroActionType TAP;
    private final long defaultDurationMs;
    private final String label;

    private static final MacroActionType[] $values() {
        return new MacroActionType[]{MacroActionType.TAP, MacroActionType.SWIPE, MacroActionType.DELAY, MacroActionType.LONG_PRESS};
    }

    static {
        MacroActionType.TAP = new MacroActionType("TAP", 0, "Toque", 50);
        MacroActionType.SWIPE = new MacroActionType("SWIPE", 1, "Deslizar", 300);
        MacroActionType.DELAY = new MacroActionType("DELAY", 2, "Delay", 200);
        MacroActionType.LONG_PRESS = new MacroActionType("LONG_PRESS", 3, "Long press", 500);
        MacroActionType[] v0 = MacroActionType.$values();
        MacroActionType.$VALUES = v0;
        MacroActionType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private MacroActionType(String arg1, int arg2, String arg3, long arg4) {
        super(arg1, arg2);
        this.label = arg3;
        this.defaultDurationMs = arg4;
    }

    public final long getDefaultDurationMs() {
        return this.defaultDurationMs;
    }

    public static EnumEntries getEntries() {
        return MacroActionType.$ENTRIES;
    }

    public final String getLabel() {
        return this.label;
    }

    public static MacroActionType valueOf(String arg1) {
        return Enum.valueOf(MacroActionType.class, arg1);
    }

    public static MacroActionType[] values() {
        return MacroActionType.$VALUES.clone();
    }
}

