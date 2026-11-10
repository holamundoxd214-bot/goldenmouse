package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchLogicalSizeSource;", "", "<init>", "(Ljava/lang/String;I)V", "MAXIMUM_WINDOW_METRICS", "DISPLAY_REAL_SIZE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchLogicalSizeSource {
    public static final enum StretchLogicalSizeSource DISPLAY_REAL_SIZE;
    public static final enum StretchLogicalSizeSource MAXIMUM_WINDOW_METRICS;

    private static final StretchLogicalSizeSource[] $values() {
        return new StretchLogicalSizeSource[]{StretchLogicalSizeSource.MAXIMUM_WINDOW_METRICS, StretchLogicalSizeSource.DISPLAY_REAL_SIZE};
    }

    static {
        StretchLogicalSizeSource.MAXIMUM_WINDOW_METRICS = new StretchLogicalSizeSource("MAXIMUM_WINDOW_METRICS", 0);
        StretchLogicalSizeSource.DISPLAY_REAL_SIZE = new StretchLogicalSizeSource("DISPLAY_REAL_SIZE", 1);
        StretchLogicalSizeSource[] v0 = StretchLogicalSizeSource.$values();
        StretchLogicalSizeSource.$VALUES = v0;
        StretchLogicalSizeSource.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchLogicalSizeSource(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchLogicalSizeSource.$ENTRIES;
    }

    public static StretchLogicalSizeSource valueOf(String arg1) {
        return Enum.valueOf(StretchLogicalSizeSource.class, arg1);
    }

    public static StretchLogicalSizeSource[] values() {
        return StretchLogicalSizeSource.$VALUES.clone();
    }
}

