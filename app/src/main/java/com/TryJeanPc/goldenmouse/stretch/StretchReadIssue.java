package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchReadIssue;", "", "<init>", "(Ljava/lang/String;I)V", "DISPLAY_UNAVAILABLE", "LOGICAL_SIZE_UNAVAILABLE", "DISPLAY_CHANGED", "READ_FAILED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchReadIssue {
    public static final enum StretchReadIssue DISPLAY_CHANGED;
    public static final enum StretchReadIssue DISPLAY_UNAVAILABLE;
    public static final enum StretchReadIssue LOGICAL_SIZE_UNAVAILABLE;
    public static final enum StretchReadIssue READ_FAILED;

    private static final StretchReadIssue[] $values() {
        return new StretchReadIssue[]{StretchReadIssue.DISPLAY_UNAVAILABLE, StretchReadIssue.LOGICAL_SIZE_UNAVAILABLE, StretchReadIssue.DISPLAY_CHANGED, StretchReadIssue.READ_FAILED};
    }

    static {
        StretchReadIssue.DISPLAY_UNAVAILABLE = new StretchReadIssue("DISPLAY_UNAVAILABLE", 0);
        StretchReadIssue.LOGICAL_SIZE_UNAVAILABLE = new StretchReadIssue("LOGICAL_SIZE_UNAVAILABLE", 1);
        StretchReadIssue.DISPLAY_CHANGED = new StretchReadIssue("DISPLAY_CHANGED", 2);
        StretchReadIssue.READ_FAILED = new StretchReadIssue("READ_FAILED", 3);
        StretchReadIssue[] v0 = StretchReadIssue.$values();
        StretchReadIssue.$VALUES = v0;
        StretchReadIssue.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchReadIssue(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchReadIssue.$ENTRIES;
    }

    public static StretchReadIssue valueOf(String arg1) {
        return Enum.valueOf(StretchReadIssue.class, arg1);
    }

    public static StretchReadIssue[] values() {
        return StretchReadIssue.$VALUES.clone();
    }
}

