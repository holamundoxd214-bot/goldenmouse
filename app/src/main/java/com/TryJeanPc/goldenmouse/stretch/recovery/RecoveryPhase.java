package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PREPARING", "BASELINE_CAPTURED", "RECOVERY_READY", "APPLYING", "VERIFYING", "AWAITING_CONFIRMATION", "CONFIRMED", "RESTORE_REQUESTED", "RESTORING", "VERIFYING_RESTORE", "RECOVERY_PENDING", "RECOVERED", "FAILED", "NOT_RECOVERABLE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryPhase {
    public static final enum RecoveryPhase APPLYING;
    public static final enum RecoveryPhase AWAITING_CONFIRMATION;
    public static final enum RecoveryPhase BASELINE_CAPTURED;
    public static final enum RecoveryPhase CONFIRMED;
    public static final enum RecoveryPhase FAILED;
    public static final enum RecoveryPhase IDLE;
    public static final enum RecoveryPhase NOT_RECOVERABLE;
    public static final enum RecoveryPhase PREPARING;
    public static final enum RecoveryPhase RECOVERED;
    public static final enum RecoveryPhase RECOVERY_PENDING;
    public static final enum RecoveryPhase RECOVERY_READY;
    public static final enum RecoveryPhase RESTORE_REQUESTED;
    public static final enum RecoveryPhase RESTORING;
    public static final enum RecoveryPhase VERIFYING;
    public static final enum RecoveryPhase VERIFYING_RESTORE;

    private static final RecoveryPhase[] $values() {
        return new RecoveryPhase[]{RecoveryPhase.IDLE, RecoveryPhase.PREPARING, RecoveryPhase.BASELINE_CAPTURED, RecoveryPhase.RECOVERY_READY, RecoveryPhase.APPLYING, RecoveryPhase.VERIFYING, RecoveryPhase.AWAITING_CONFIRMATION, RecoveryPhase.CONFIRMED, RecoveryPhase.RESTORE_REQUESTED, RecoveryPhase.RESTORING, RecoveryPhase.VERIFYING_RESTORE, RecoveryPhase.RECOVERY_PENDING, RecoveryPhase.RECOVERED, RecoveryPhase.FAILED, RecoveryPhase.NOT_RECOVERABLE};
    }

    static {
        RecoveryPhase.IDLE = new RecoveryPhase("IDLE", 0);
        RecoveryPhase.PREPARING = new RecoveryPhase("PREPARING", 1);
        RecoveryPhase.BASELINE_CAPTURED = new RecoveryPhase("BASELINE_CAPTURED", 2);
        RecoveryPhase.RECOVERY_READY = new RecoveryPhase("RECOVERY_READY", 3);
        RecoveryPhase.APPLYING = new RecoveryPhase("APPLYING", 4);
        RecoveryPhase.VERIFYING = new RecoveryPhase("VERIFYING", 5);
        RecoveryPhase.AWAITING_CONFIRMATION = new RecoveryPhase("AWAITING_CONFIRMATION", 6);
        RecoveryPhase.CONFIRMED = new RecoveryPhase("CONFIRMED", 7);
        RecoveryPhase.RESTORE_REQUESTED = new RecoveryPhase("RESTORE_REQUESTED", 8);
        RecoveryPhase.RESTORING = new RecoveryPhase("RESTORING", 9);
        RecoveryPhase.VERIFYING_RESTORE = new RecoveryPhase("VERIFYING_RESTORE", 10);
        RecoveryPhase.RECOVERY_PENDING = new RecoveryPhase("RECOVERY_PENDING", 11);
        RecoveryPhase.RECOVERED = new RecoveryPhase("RECOVERED", 12);
        RecoveryPhase.FAILED = new RecoveryPhase("FAILED", 13);
        RecoveryPhase.NOT_RECOVERABLE = new RecoveryPhase("NOT_RECOVERABLE", 14);
        RecoveryPhase[] v0 = RecoveryPhase.$values();
        RecoveryPhase.$VALUES = v0;
        RecoveryPhase.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryPhase(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryPhase.$ENTRIES;
    }

    public static RecoveryPhase valueOf(String arg1) {
        return Enum.valueOf(RecoveryPhase.class, arg1);
    }

    public static RecoveryPhase[] values() {
        return RecoveryPhase.$VALUES.clone();
    }
}

