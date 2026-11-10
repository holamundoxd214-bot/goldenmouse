package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "", "<init>", "(Ljava/lang/String;I)V", "OBSERVED_DIAGNOSTIC_ONLY", "UNKNOWN_IDENTITY", "DISPLAY_MISMATCH", "DISPLAY_CHANGED", "FORMAT_UNSUPPORTED", "AMBIGUOUS", "INVALID_DATA", "METHOD_UNAVAILABLE", "PERMISSION_DENIED", "TIMED_OUT", "OUTPUT_LIMIT", "READ_FAILED", "NOT_REQUESTED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum OriginalReadCode {
    public static final enum OriginalReadCode AMBIGUOUS;
    public static final enum OriginalReadCode DISPLAY_CHANGED;
    public static final enum OriginalReadCode DISPLAY_MISMATCH;
    public static final enum OriginalReadCode FORMAT_UNSUPPORTED;
    public static final enum OriginalReadCode INVALID_DATA;
    public static final enum OriginalReadCode METHOD_UNAVAILABLE;
    public static final enum OriginalReadCode NOT_REQUESTED;
    public static final enum OriginalReadCode OBSERVED_DIAGNOSTIC_ONLY;
    public static final enum OriginalReadCode OUTPUT_LIMIT;
    public static final enum OriginalReadCode PERMISSION_DENIED;
    public static final enum OriginalReadCode READ_FAILED;
    public static final enum OriginalReadCode TIMED_OUT;
    public static final enum OriginalReadCode UNKNOWN_IDENTITY;

    private static final OriginalReadCode[] $values() {
        return new OriginalReadCode[]{OriginalReadCode.OBSERVED_DIAGNOSTIC_ONLY, OriginalReadCode.UNKNOWN_IDENTITY, OriginalReadCode.DISPLAY_MISMATCH, OriginalReadCode.DISPLAY_CHANGED, OriginalReadCode.FORMAT_UNSUPPORTED, OriginalReadCode.AMBIGUOUS, OriginalReadCode.INVALID_DATA, OriginalReadCode.METHOD_UNAVAILABLE, OriginalReadCode.PERMISSION_DENIED, OriginalReadCode.TIMED_OUT, OriginalReadCode.OUTPUT_LIMIT, OriginalReadCode.READ_FAILED, OriginalReadCode.NOT_REQUESTED};
    }

    static {
        OriginalReadCode.OBSERVED_DIAGNOSTIC_ONLY = new OriginalReadCode("OBSERVED_DIAGNOSTIC_ONLY", 0);
        OriginalReadCode.UNKNOWN_IDENTITY = new OriginalReadCode("UNKNOWN_IDENTITY", 1);
        OriginalReadCode.DISPLAY_MISMATCH = new OriginalReadCode("DISPLAY_MISMATCH", 2);
        OriginalReadCode.DISPLAY_CHANGED = new OriginalReadCode("DISPLAY_CHANGED", 3);
        OriginalReadCode.FORMAT_UNSUPPORTED = new OriginalReadCode("FORMAT_UNSUPPORTED", 4);
        OriginalReadCode.AMBIGUOUS = new OriginalReadCode("AMBIGUOUS", 5);
        OriginalReadCode.INVALID_DATA = new OriginalReadCode("INVALID_DATA", 6);
        OriginalReadCode.METHOD_UNAVAILABLE = new OriginalReadCode("METHOD_UNAVAILABLE", 7);
        OriginalReadCode.PERMISSION_DENIED = new OriginalReadCode("PERMISSION_DENIED", 8);
        OriginalReadCode.TIMED_OUT = new OriginalReadCode("TIMED_OUT", 9);
        OriginalReadCode.OUTPUT_LIMIT = new OriginalReadCode("OUTPUT_LIMIT", 10);
        OriginalReadCode.READ_FAILED = new OriginalReadCode("READ_FAILED", 11);
        OriginalReadCode.NOT_REQUESTED = new OriginalReadCode("NOT_REQUESTED", 12);
        OriginalReadCode[] v0 = OriginalReadCode.$values();
        OriginalReadCode.$VALUES = v0;
        OriginalReadCode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private OriginalReadCode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return OriginalReadCode.$ENTRIES;
    }

    public static OriginalReadCode valueOf(String arg1) {
        return Enum.valueOf(OriginalReadCode.class, arg1);
    }

    public static OriginalReadCode[] values() {
        return OriginalReadCode.$VALUES.clone();
    }
}

