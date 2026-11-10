package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001D\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001Bj\u0002\b\u001Cj\u0002\b\u001D¨\u0006\u001E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_RECOVERABLE", "INVALID_REQUEST", "INVALID_TRANSITION", "STALE_OPERATION", "SESSION_BUSY", "JOURNAL_CORRUPT", "JOURNAL_VERSION", "JOURNAL_BUSY", "JOURNAL_READ_FAILED", "JOURNAL_WRITE_FAILED", "PHYSICAL_AGENT_UNAVAILABLE", "BACKEND_LOST", "PERMISSION_LOST", "DISPLAY_MISMATCH", "UNKNOWN_BASELINE", "APPLY_UNCERTAIN", "RESTORE_UNVERIFIED", "RESTORE_PARTIAL", "EXECUTOR_ERROR", "OPERATION_TIMEOUT", "CONFIRMATION_EXPIRED", "PROCESS_RESTART", "OWNER_CLOSED", "ATTEMPT_LIMIT", "EXECUTOR_STILL_ACTIVE", "CLOSED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryError {
    public static final enum RecoveryError APPLY_UNCERTAIN;
    public static final enum RecoveryError ATTEMPT_LIMIT;
    public static final enum RecoveryError BACKEND_LOST;
    public static final enum RecoveryError CLOSED;
    public static final enum RecoveryError CONFIRMATION_EXPIRED;
    public static final enum RecoveryError DISPLAY_MISMATCH;
    public static final enum RecoveryError EXECUTOR_ERROR;
    public static final enum RecoveryError EXECUTOR_STILL_ACTIVE;
    public static final enum RecoveryError INVALID_REQUEST;
    public static final enum RecoveryError INVALID_TRANSITION;
    public static final enum RecoveryError JOURNAL_BUSY;
    public static final enum RecoveryError JOURNAL_CORRUPT;
    public static final enum RecoveryError JOURNAL_READ_FAILED;
    public static final enum RecoveryError JOURNAL_VERSION;
    public static final enum RecoveryError JOURNAL_WRITE_FAILED;
    public static final enum RecoveryError NOT_RECOVERABLE;
    public static final enum RecoveryError OPERATION_TIMEOUT;
    public static final enum RecoveryError OWNER_CLOSED;
    public static final enum RecoveryError PERMISSION_LOST;
    public static final enum RecoveryError PHYSICAL_AGENT_UNAVAILABLE;
    public static final enum RecoveryError PROCESS_RESTART;
    public static final enum RecoveryError RESTORE_PARTIAL;
    public static final enum RecoveryError RESTORE_UNVERIFIED;
    public static final enum RecoveryError SESSION_BUSY;
    public static final enum RecoveryError STALE_OPERATION;
    public static final enum RecoveryError UNKNOWN_BASELINE;

    private static final RecoveryError[] $values() {
        return new RecoveryError[]{RecoveryError.NOT_RECOVERABLE, RecoveryError.INVALID_REQUEST, RecoveryError.INVALID_TRANSITION, RecoveryError.STALE_OPERATION, RecoveryError.SESSION_BUSY, RecoveryError.JOURNAL_CORRUPT, RecoveryError.JOURNAL_VERSION, RecoveryError.JOURNAL_BUSY, RecoveryError.JOURNAL_READ_FAILED, RecoveryError.JOURNAL_WRITE_FAILED, RecoveryError.PHYSICAL_AGENT_UNAVAILABLE, RecoveryError.BACKEND_LOST, RecoveryError.PERMISSION_LOST, RecoveryError.DISPLAY_MISMATCH, RecoveryError.UNKNOWN_BASELINE, RecoveryError.APPLY_UNCERTAIN, RecoveryError.RESTORE_UNVERIFIED, RecoveryError.RESTORE_PARTIAL, RecoveryError.EXECUTOR_ERROR, RecoveryError.OPERATION_TIMEOUT, RecoveryError.CONFIRMATION_EXPIRED, RecoveryError.PROCESS_RESTART, RecoveryError.OWNER_CLOSED, RecoveryError.ATTEMPT_LIMIT, RecoveryError.EXECUTOR_STILL_ACTIVE, RecoveryError.CLOSED};
    }

    static {
        RecoveryError.NOT_RECOVERABLE = new RecoveryError("NOT_RECOVERABLE", 0);
        RecoveryError.INVALID_REQUEST = new RecoveryError("INVALID_REQUEST", 1);
        RecoveryError.INVALID_TRANSITION = new RecoveryError("INVALID_TRANSITION", 2);
        RecoveryError.STALE_OPERATION = new RecoveryError("STALE_OPERATION", 3);
        RecoveryError.SESSION_BUSY = new RecoveryError("SESSION_BUSY", 4);
        RecoveryError.JOURNAL_CORRUPT = new RecoveryError("JOURNAL_CORRUPT", 5);
        RecoveryError.JOURNAL_VERSION = new RecoveryError("JOURNAL_VERSION", 6);
        RecoveryError.JOURNAL_BUSY = new RecoveryError("JOURNAL_BUSY", 7);
        RecoveryError.JOURNAL_READ_FAILED = new RecoveryError("JOURNAL_READ_FAILED", 8);
        RecoveryError.JOURNAL_WRITE_FAILED = new RecoveryError("JOURNAL_WRITE_FAILED", 9);
        RecoveryError.PHYSICAL_AGENT_UNAVAILABLE = new RecoveryError("PHYSICAL_AGENT_UNAVAILABLE", 10);
        RecoveryError.BACKEND_LOST = new RecoveryError("BACKEND_LOST", 11);
        RecoveryError.PERMISSION_LOST = new RecoveryError("PERMISSION_LOST", 12);
        RecoveryError.DISPLAY_MISMATCH = new RecoveryError("DISPLAY_MISMATCH", 13);
        RecoveryError.UNKNOWN_BASELINE = new RecoveryError("UNKNOWN_BASELINE", 14);
        RecoveryError.APPLY_UNCERTAIN = new RecoveryError("APPLY_UNCERTAIN", 15);
        RecoveryError.RESTORE_UNVERIFIED = new RecoveryError("RESTORE_UNVERIFIED", 16);
        RecoveryError.RESTORE_PARTIAL = new RecoveryError("RESTORE_PARTIAL", 17);
        RecoveryError.EXECUTOR_ERROR = new RecoveryError("EXECUTOR_ERROR", 18);
        RecoveryError.OPERATION_TIMEOUT = new RecoveryError("OPERATION_TIMEOUT", 19);
        RecoveryError.CONFIRMATION_EXPIRED = new RecoveryError("CONFIRMATION_EXPIRED", 20);
        RecoveryError.PROCESS_RESTART = new RecoveryError("PROCESS_RESTART", 21);
        RecoveryError.OWNER_CLOSED = new RecoveryError("OWNER_CLOSED", 22);
        RecoveryError.ATTEMPT_LIMIT = new RecoveryError("ATTEMPT_LIMIT", 23);
        RecoveryError.EXECUTOR_STILL_ACTIVE = new RecoveryError("EXECUTOR_STILL_ACTIVE", 24);
        RecoveryError.CLOSED = new RecoveryError("CLOSED", 25);
        RecoveryError[] v0 = RecoveryError.$values();
        RecoveryError.$VALUES = v0;
        RecoveryError.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryError(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryError.$ENTRIES;
    }

    public static RecoveryError valueOf(String arg1) {
        return Enum.valueOf(RecoveryError.class, arg1);
    }

    public static RecoveryError[] values() {
        return RecoveryError.$VALUES.clone();
    }
}

