package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000E\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000E¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CompositorReadCode;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "OBSERVED_COMPOSITOR_ONLY", "UNSUPPORTED", "PERMISSION_DENIED", "READ_FAILED", "TIMED_OUT", "OUTPUT_LIMIT", "INVALID_DATA", "DISPLAY_MISMATCH", "AMBIGUOUS", "UNSTABLE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum CompositorReadCode {
    public static final enum CompositorReadCode AMBIGUOUS;
    public static final enum CompositorReadCode DISPLAY_MISMATCH;
    public static final enum CompositorReadCode INVALID_DATA;
    public static final enum CompositorReadCode OBSERVED_COMPOSITOR_ONLY;
    public static final enum CompositorReadCode OUTPUT_LIMIT;
    public static final enum CompositorReadCode PERMISSION_DENIED;
    public static final enum CompositorReadCode READ_FAILED;
    public static final enum CompositorReadCode TIMED_OUT;
    public static final enum CompositorReadCode UNKNOWN;
    public static final enum CompositorReadCode UNSTABLE;
    public static final enum CompositorReadCode UNSUPPORTED;

    private static final CompositorReadCode[] $values() {
        return new CompositorReadCode[]{CompositorReadCode.UNKNOWN, CompositorReadCode.OBSERVED_COMPOSITOR_ONLY, CompositorReadCode.UNSUPPORTED, CompositorReadCode.PERMISSION_DENIED, CompositorReadCode.READ_FAILED, CompositorReadCode.TIMED_OUT, CompositorReadCode.OUTPUT_LIMIT, CompositorReadCode.INVALID_DATA, CompositorReadCode.DISPLAY_MISMATCH, CompositorReadCode.AMBIGUOUS, CompositorReadCode.UNSTABLE};
    }

    static {
        CompositorReadCode.UNKNOWN = new CompositorReadCode("UNKNOWN", 0);
        CompositorReadCode.OBSERVED_COMPOSITOR_ONLY = new CompositorReadCode("OBSERVED_COMPOSITOR_ONLY", 1);
        CompositorReadCode.UNSUPPORTED = new CompositorReadCode("UNSUPPORTED", 2);
        CompositorReadCode.PERMISSION_DENIED = new CompositorReadCode("PERMISSION_DENIED", 3);
        CompositorReadCode.READ_FAILED = new CompositorReadCode("READ_FAILED", 4);
        CompositorReadCode.TIMED_OUT = new CompositorReadCode("TIMED_OUT", 5);
        CompositorReadCode.OUTPUT_LIMIT = new CompositorReadCode("OUTPUT_LIMIT", 6);
        CompositorReadCode.INVALID_DATA = new CompositorReadCode("INVALID_DATA", 7);
        CompositorReadCode.DISPLAY_MISMATCH = new CompositorReadCode("DISPLAY_MISMATCH", 8);
        CompositorReadCode.AMBIGUOUS = new CompositorReadCode("AMBIGUOUS", 9);
        CompositorReadCode.UNSTABLE = new CompositorReadCode("UNSTABLE", 10);
        CompositorReadCode[] v0 = CompositorReadCode.$values();
        CompositorReadCode.$VALUES = v0;
        CompositorReadCode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CompositorReadCode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CompositorReadCode.$ENTRIES;
    }

    public static CompositorReadCode valueOf(String arg1) {
        return Enum.valueOf(CompositorReadCode.class, arg1);
    }

    public static CompositorReadCode[] values() {
        return CompositorReadCode.$VALUES.clone();
    }
}

