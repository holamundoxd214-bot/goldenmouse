package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "REQUESTED", "VERIFIED", "UNKNOWN", "FAILED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryStepOutcome {
    public static final enum RecoveryStepOutcome FAILED;
    public static final enum RecoveryStepOutcome REQUESTED;
    public static final enum RecoveryStepOutcome UNKNOWN;
    public static final enum RecoveryStepOutcome VERIFIED;

    private static final RecoveryStepOutcome[] $values() {
        return new RecoveryStepOutcome[]{RecoveryStepOutcome.REQUESTED, RecoveryStepOutcome.VERIFIED, RecoveryStepOutcome.UNKNOWN, RecoveryStepOutcome.FAILED};
    }

    static {
        RecoveryStepOutcome.REQUESTED = new RecoveryStepOutcome("REQUESTED", 0);
        RecoveryStepOutcome.VERIFIED = new RecoveryStepOutcome("VERIFIED", 1);
        RecoveryStepOutcome.UNKNOWN = new RecoveryStepOutcome("UNKNOWN", 2);
        RecoveryStepOutcome.FAILED = new RecoveryStepOutcome("FAILED", 3);
        RecoveryStepOutcome[] v0 = RecoveryStepOutcome.$values();
        RecoveryStepOutcome.$VALUES = v0;
        RecoveryStepOutcome.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryStepOutcome(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryStepOutcome.$ENTRIES;
    }

    public static RecoveryStepOutcome valueOf(String arg1) {
        return Enum.valueOf(RecoveryStepOutcome.class, arg1);
    }

    public static RecoveryStepOutcome[] values() {
        return RecoveryStepOutcome.$VALUES.clone();
    }
}

