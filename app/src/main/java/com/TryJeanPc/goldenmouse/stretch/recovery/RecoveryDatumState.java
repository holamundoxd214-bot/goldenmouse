package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatumState;", "", "<init>", "(Ljava/lang/String;I)V", "KNOWN", "ABSENT", "UNKNOWN", "UNSUPPORTED", "READ_FAILED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryDatumState {
    public static final enum RecoveryDatumState ABSENT;
    public static final enum RecoveryDatumState KNOWN;
    public static final enum RecoveryDatumState READ_FAILED;
    public static final enum RecoveryDatumState UNKNOWN;
    public static final enum RecoveryDatumState UNSUPPORTED;

    private static final RecoveryDatumState[] $values() {
        return new RecoveryDatumState[]{RecoveryDatumState.KNOWN, RecoveryDatumState.ABSENT, RecoveryDatumState.UNKNOWN, RecoveryDatumState.UNSUPPORTED, RecoveryDatumState.READ_FAILED};
    }

    static {
        RecoveryDatumState.KNOWN = new RecoveryDatumState("KNOWN", 0);
        RecoveryDatumState.ABSENT = new RecoveryDatumState("ABSENT", 1);
        RecoveryDatumState.UNKNOWN = new RecoveryDatumState("UNKNOWN", 2);
        RecoveryDatumState.UNSUPPORTED = new RecoveryDatumState("UNSUPPORTED", 3);
        RecoveryDatumState.READ_FAILED = new RecoveryDatumState("READ_FAILED", 4);
        RecoveryDatumState[] v0 = RecoveryDatumState.$values();
        RecoveryDatumState.$VALUES = v0;
        RecoveryDatumState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryDatumState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryDatumState.$ENTRIES;
    }

    public static RecoveryDatumState valueOf(String arg1) {
        return Enum.valueOf(RecoveryDatumState.class, arg1);
    }

    public static RecoveryDatumState[] values() {
        return RecoveryDatumState.$VALUES.clone();
    }
}

