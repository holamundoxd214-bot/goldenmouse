package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreStatus;", "", "<init>", "(Ljava/lang/String;I)V", "VERIFIED", "PARTIAL", "BACKEND_ERROR", "PERMISSION_LOST", "DISPLAY_MISMATCH", "UNKNOWN_BASELINE", "TIMEOUT", "STALE", "PENDING", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchRestoreStatus {
    public static final enum StretchRestoreStatus BACKEND_ERROR;
    public static final enum StretchRestoreStatus DISPLAY_MISMATCH;
    public static final enum StretchRestoreStatus PARTIAL;
    public static final enum StretchRestoreStatus PENDING;
    public static final enum StretchRestoreStatus PERMISSION_LOST;
    public static final enum StretchRestoreStatus STALE;
    public static final enum StretchRestoreStatus TIMEOUT;
    public static final enum StretchRestoreStatus UNKNOWN_BASELINE;
    public static final enum StretchRestoreStatus VERIFIED;

    private static final StretchRestoreStatus[] $values() {
        return new StretchRestoreStatus[]{StretchRestoreStatus.VERIFIED, StretchRestoreStatus.PARTIAL, StretchRestoreStatus.BACKEND_ERROR, StretchRestoreStatus.PERMISSION_LOST, StretchRestoreStatus.DISPLAY_MISMATCH, StretchRestoreStatus.UNKNOWN_BASELINE, StretchRestoreStatus.TIMEOUT, StretchRestoreStatus.STALE, StretchRestoreStatus.PENDING};
    }

    static {
        StretchRestoreStatus.VERIFIED = new StretchRestoreStatus("VERIFIED", 0);
        StretchRestoreStatus.PARTIAL = new StretchRestoreStatus("PARTIAL", 1);
        StretchRestoreStatus.BACKEND_ERROR = new StretchRestoreStatus("BACKEND_ERROR", 2);
        StretchRestoreStatus.PERMISSION_LOST = new StretchRestoreStatus("PERMISSION_LOST", 3);
        StretchRestoreStatus.DISPLAY_MISMATCH = new StretchRestoreStatus("DISPLAY_MISMATCH", 4);
        StretchRestoreStatus.UNKNOWN_BASELINE = new StretchRestoreStatus("UNKNOWN_BASELINE", 5);
        StretchRestoreStatus.TIMEOUT = new StretchRestoreStatus("TIMEOUT", 6);
        StretchRestoreStatus.STALE = new StretchRestoreStatus("STALE", 7);
        StretchRestoreStatus.PENDING = new StretchRestoreStatus("PENDING", 8);
        StretchRestoreStatus[] v0 = StretchRestoreStatus.$values();
        StretchRestoreStatus.$VALUES = v0;
        StretchRestoreStatus.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchRestoreStatus(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchRestoreStatus.$ENTRIES;
    }

    public static StretchRestoreStatus valueOf(String arg1) {
        return Enum.valueOf(StretchRestoreStatus.class, arg1);
    }

    public static StretchRestoreStatus[] values() {
        return StretchRestoreStatus.$VALUES.clone();
    }
}

