package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;", "", "<init>", "(Ljava/lang/String;I)V", "PUBLIC_API", "INFORMATIVE_BACKEND", "SIMULATION", "UNKNOWN", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoverySource {
    public static final enum RecoverySource INFORMATIVE_BACKEND;
    public static final enum RecoverySource PUBLIC_API;
    public static final enum RecoverySource SIMULATION;
    public static final enum RecoverySource UNKNOWN;

    private static final RecoverySource[] $values() {
        return new RecoverySource[]{RecoverySource.PUBLIC_API, RecoverySource.INFORMATIVE_BACKEND, RecoverySource.SIMULATION, RecoverySource.UNKNOWN};
    }

    static {
        RecoverySource.PUBLIC_API = new RecoverySource("PUBLIC_API", 0);
        RecoverySource.INFORMATIVE_BACKEND = new RecoverySource("INFORMATIVE_BACKEND", 1);
        RecoverySource.SIMULATION = new RecoverySource("SIMULATION", 2);
        RecoverySource.UNKNOWN = new RecoverySource("UNKNOWN", 3);
        RecoverySource[] v0 = RecoverySource.$values();
        RecoverySource.$VALUES = v0;
        RecoverySource.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoverySource(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoverySource.$ENTRIES;
    }

    public static RecoverySource valueOf(String arg1) {
        return Enum.valueOf(RecoverySource.class, arg1);
    }

    public static RecoverySource[] values() {
        return RecoverySource.$VALUES.clone();
    }
}

