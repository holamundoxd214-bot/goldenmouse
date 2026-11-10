package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchScaling;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "OFF", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchScaling {
    public static final enum StretchScaling AUTO;
    public static final enum StretchScaling OFF;

    private static final StretchScaling[] $values() {
        return new StretchScaling[]{StretchScaling.AUTO, StretchScaling.OFF};
    }

    static {
        StretchScaling.AUTO = new StretchScaling("AUTO", 0);
        StretchScaling.OFF = new StretchScaling("OFF", 1);
        StretchScaling[] v0 = StretchScaling.$values();
        StretchScaling.$VALUES = v0;
        StretchScaling.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchScaling(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchScaling.$ENTRIES;
    }

    public static StretchScaling valueOf(String arg1) {
        return Enum.valueOf(StretchScaling.class, arg1);
    }

    public static StretchScaling[] values() {
        return StretchScaling.$VALUES.clone();
    }
}

