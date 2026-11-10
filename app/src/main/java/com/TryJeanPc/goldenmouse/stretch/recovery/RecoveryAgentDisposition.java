package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentDisposition;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING_VALIDATION", "PREPARED", "UNAVAILABLE", "IDENTITY_MISMATCH", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryAgentDisposition {
    public static final enum RecoveryAgentDisposition IDENTITY_MISMATCH;
    public static final enum RecoveryAgentDisposition PENDING_VALIDATION;
    public static final enum RecoveryAgentDisposition PREPARED;
    public static final enum RecoveryAgentDisposition UNAVAILABLE;

    private static final RecoveryAgentDisposition[] $values() {
        return new RecoveryAgentDisposition[]{RecoveryAgentDisposition.PENDING_VALIDATION, RecoveryAgentDisposition.PREPARED, RecoveryAgentDisposition.UNAVAILABLE, RecoveryAgentDisposition.IDENTITY_MISMATCH};
    }

    static {
        RecoveryAgentDisposition.PENDING_VALIDATION = new RecoveryAgentDisposition("PENDING_VALIDATION", 0);
        RecoveryAgentDisposition.PREPARED = new RecoveryAgentDisposition("PREPARED", 1);
        RecoveryAgentDisposition.UNAVAILABLE = new RecoveryAgentDisposition("UNAVAILABLE", 2);
        RecoveryAgentDisposition.IDENTITY_MISMATCH = new RecoveryAgentDisposition("IDENTITY_MISMATCH", 3);
        RecoveryAgentDisposition[] v0 = RecoveryAgentDisposition.$values();
        RecoveryAgentDisposition.$VALUES = v0;
        RecoveryAgentDisposition.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryAgentDisposition(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryAgentDisposition.$ENTRIES;
    }

    public static RecoveryAgentDisposition valueOf(String arg1) {
        return Enum.valueOf(RecoveryAgentDisposition.class, arg1);
    }

    public static RecoveryAgentDisposition[] values() {
        return RecoveryAgentDisposition.$VALUES.clone();
    }
}

