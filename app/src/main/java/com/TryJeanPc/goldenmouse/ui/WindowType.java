package com.TryJeanPc.goldenmouse.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/WindowType;", "", "<init>", "(Ljava/lang/String;I)V", "LARGE_FORM", "SHORT_FORM", "COMPACT", "SIDE_PANEL", "FULLSCREEN_EDITOR", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum WindowType {
    public static final enum WindowType COMPACT;
    public static final enum WindowType FULLSCREEN_EDITOR;
    public static final enum WindowType LARGE_FORM;
    public static final enum WindowType SHORT_FORM;
    public static final enum WindowType SIDE_PANEL;

    private static final WindowType[] $values() {
        return new WindowType[]{WindowType.LARGE_FORM, WindowType.SHORT_FORM, WindowType.COMPACT, WindowType.SIDE_PANEL, WindowType.FULLSCREEN_EDITOR};
    }

    static {
        WindowType.LARGE_FORM = new WindowType("LARGE_FORM", 0);
        WindowType.SHORT_FORM = new WindowType("SHORT_FORM", 1);
        WindowType.COMPACT = new WindowType("COMPACT", 2);
        WindowType.SIDE_PANEL = new WindowType("SIDE_PANEL", 3);
        WindowType.FULLSCREEN_EDITOR = new WindowType("FULLSCREEN_EDITOR", 4);
        WindowType[] v0 = WindowType.$values();
        WindowType.$VALUES = v0;
        WindowType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private WindowType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return WindowType.$ENTRIES;
    }

    public static WindowType valueOf(String arg1) {
        return Enum.valueOf(WindowType.class, arg1);
    }

    public static WindowType[] values() {
        return WindowType.$VALUES.clone();
    }
}

