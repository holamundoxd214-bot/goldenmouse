package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/input/CaptureMode;", "", "<init>", "(Ljava/lang/String;I)V", "SHARED", "EXCLUSIVE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum CaptureMode {
    public static final enum CaptureMode EXCLUSIVE;
    public static final enum CaptureMode SHARED;

    private static final CaptureMode[] $values() {
        return new CaptureMode[]{CaptureMode.SHARED, CaptureMode.EXCLUSIVE};
    }

    static {
        CaptureMode.SHARED = new CaptureMode("SHARED", 0);
        CaptureMode.EXCLUSIVE = new CaptureMode("EXCLUSIVE", 1);
        CaptureMode[] v0 = CaptureMode.$values();
        CaptureMode.$VALUES = v0;
        CaptureMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CaptureMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CaptureMode.$ENTRIES;
    }

    public static CaptureMode valueOf(String arg1) {
        return Enum.valueOf(CaptureMode.class, arg1);
    }

    public static CaptureMode[] values() {
        return CaptureMode.$VALUES.clone();
    }
}

