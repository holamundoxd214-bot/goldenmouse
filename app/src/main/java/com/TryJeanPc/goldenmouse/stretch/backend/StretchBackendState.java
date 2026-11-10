package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendState;", "", "<init>", "(Ljava/lang/String;I)V", "AVAILABLE", "UNAVAILABLE", "NOT_AUTHORIZED", "DISCONNECTED", "UNSUPPORTED", "ERROR", "UNKNOWN", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchBackendState {
    public static final enum StretchBackendState AVAILABLE;
    public static final enum StretchBackendState DISCONNECTED;
    public static final enum StretchBackendState ERROR;
    public static final enum StretchBackendState NOT_AUTHORIZED;
    public static final enum StretchBackendState UNAVAILABLE;
    public static final enum StretchBackendState UNKNOWN;
    public static final enum StretchBackendState UNSUPPORTED;

    private static final StretchBackendState[] $values() {
        return new StretchBackendState[]{StretchBackendState.AVAILABLE, StretchBackendState.UNAVAILABLE, StretchBackendState.NOT_AUTHORIZED, StretchBackendState.DISCONNECTED, StretchBackendState.UNSUPPORTED, StretchBackendState.ERROR, StretchBackendState.UNKNOWN};
    }

    static {
        StretchBackendState.AVAILABLE = new StretchBackendState("AVAILABLE", 0);
        StretchBackendState.UNAVAILABLE = new StretchBackendState("UNAVAILABLE", 1);
        StretchBackendState.NOT_AUTHORIZED = new StretchBackendState("NOT_AUTHORIZED", 2);
        StretchBackendState.DISCONNECTED = new StretchBackendState("DISCONNECTED", 3);
        StretchBackendState.UNSUPPORTED = new StretchBackendState("UNSUPPORTED", 4);
        StretchBackendState.ERROR = new StretchBackendState("ERROR", 5);
        StretchBackendState.UNKNOWN = new StretchBackendState("UNKNOWN", 6);
        StretchBackendState[] v0 = StretchBackendState.$values();
        StretchBackendState.$VALUES = v0;
        StretchBackendState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchBackendState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchBackendState.$ENTRIES;
    }

    public static StretchBackendState valueOf(String arg1) {
        return Enum.valueOf(StretchBackendState.class, arg1);
    }

    public static StretchBackendState[] values() {
        return StretchBackendState.$VALUES.clone();
    }
}

