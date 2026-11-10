package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCEEDED", "COMPLETED_UNVERIFIED", "REJECTED", "FAILED", "TIMED_OUT", "CANCELLED", "SESSION_INVALIDATED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchExecutionStatus {
    public static final enum StretchExecutionStatus CANCELLED;
    public static final enum StretchExecutionStatus COMPLETED_UNVERIFIED;
    public static final enum StretchExecutionStatus FAILED;
    public static final enum StretchExecutionStatus REJECTED;
    public static final enum StretchExecutionStatus SESSION_INVALIDATED;
    public static final enum StretchExecutionStatus SUCCEEDED;
    public static final enum StretchExecutionStatus TIMED_OUT;

    private static final StretchExecutionStatus[] $values() {
        return new StretchExecutionStatus[]{StretchExecutionStatus.SUCCEEDED, StretchExecutionStatus.COMPLETED_UNVERIFIED, StretchExecutionStatus.REJECTED, StretchExecutionStatus.FAILED, StretchExecutionStatus.TIMED_OUT, StretchExecutionStatus.CANCELLED, StretchExecutionStatus.SESSION_INVALIDATED};
    }

    static {
        StretchExecutionStatus.SUCCEEDED = new StretchExecutionStatus("SUCCEEDED", 0);
        StretchExecutionStatus.COMPLETED_UNVERIFIED = new StretchExecutionStatus("COMPLETED_UNVERIFIED", 1);
        StretchExecutionStatus.REJECTED = new StretchExecutionStatus("REJECTED", 2);
        StretchExecutionStatus.FAILED = new StretchExecutionStatus("FAILED", 3);
        StretchExecutionStatus.TIMED_OUT = new StretchExecutionStatus("TIMED_OUT", 4);
        StretchExecutionStatus.CANCELLED = new StretchExecutionStatus("CANCELLED", 5);
        StretchExecutionStatus.SESSION_INVALIDATED = new StretchExecutionStatus("SESSION_INVALIDATED", 6);
        StretchExecutionStatus[] v0 = StretchExecutionStatus.$values();
        StretchExecutionStatus.$VALUES = v0;
        StretchExecutionStatus.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchExecutionStatus(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchExecutionStatus.$ENTRIES;
    }

    public static StretchExecutionStatus valueOf(String arg1) {
        return Enum.valueOf(StretchExecutionStatus.class, arg1);
    }

    public static StretchExecutionStatus[] values() {
        return StretchExecutionStatus.$VALUES.clone();
    }
}

