package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "", "<init>", "(Ljava/lang/String;I)V", "NO_BACKEND", "PERMISSION_DENIED", "UNSUPPORTED", "TIMEOUT", "DISCONNECTED", "TRANSPORT_FAILURE", "COMMAND_FAILED", "EMPTY_RESPONSE", "MALFORMED_RESPONSE", "INCOMPLETE_RESPONSE", "OUTPUT_LIMIT", "CANCELLED", "SESSION_INVALIDATED", "BUSY", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchTransportError {
    public static final enum StretchTransportError BUSY;
    public static final enum StretchTransportError CANCELLED;
    public static final enum StretchTransportError COMMAND_FAILED;
    public static final enum StretchTransportError DISCONNECTED;
    public static final enum StretchTransportError EMPTY_RESPONSE;
    public static final enum StretchTransportError INCOMPLETE_RESPONSE;
    public static final enum StretchTransportError MALFORMED_RESPONSE;
    public static final enum StretchTransportError NO_BACKEND;
    public static final enum StretchTransportError OUTPUT_LIMIT;
    public static final enum StretchTransportError PERMISSION_DENIED;
    public static final enum StretchTransportError SESSION_INVALIDATED;
    public static final enum StretchTransportError TIMEOUT;
    public static final enum StretchTransportError TRANSPORT_FAILURE;
    public static final enum StretchTransportError UNSUPPORTED;

    private static final StretchTransportError[] $values() {
        return new StretchTransportError[]{StretchTransportError.NO_BACKEND, StretchTransportError.PERMISSION_DENIED, StretchTransportError.UNSUPPORTED, StretchTransportError.TIMEOUT, StretchTransportError.DISCONNECTED, StretchTransportError.TRANSPORT_FAILURE, StretchTransportError.COMMAND_FAILED, StretchTransportError.EMPTY_RESPONSE, StretchTransportError.MALFORMED_RESPONSE, StretchTransportError.INCOMPLETE_RESPONSE, StretchTransportError.OUTPUT_LIMIT, StretchTransportError.CANCELLED, StretchTransportError.SESSION_INVALIDATED, StretchTransportError.BUSY};
    }

    static {
        StretchTransportError.NO_BACKEND = new StretchTransportError("NO_BACKEND", 0);
        StretchTransportError.PERMISSION_DENIED = new StretchTransportError("PERMISSION_DENIED", 1);
        StretchTransportError.UNSUPPORTED = new StretchTransportError("UNSUPPORTED", 2);
        StretchTransportError.TIMEOUT = new StretchTransportError("TIMEOUT", 3);
        StretchTransportError.DISCONNECTED = new StretchTransportError("DISCONNECTED", 4);
        StretchTransportError.TRANSPORT_FAILURE = new StretchTransportError("TRANSPORT_FAILURE", 5);
        StretchTransportError.COMMAND_FAILED = new StretchTransportError("COMMAND_FAILED", 6);
        StretchTransportError.EMPTY_RESPONSE = new StretchTransportError("EMPTY_RESPONSE", 7);
        StretchTransportError.MALFORMED_RESPONSE = new StretchTransportError("MALFORMED_RESPONSE", 8);
        StretchTransportError.INCOMPLETE_RESPONSE = new StretchTransportError("INCOMPLETE_RESPONSE", 9);
        StretchTransportError.OUTPUT_LIMIT = new StretchTransportError("OUTPUT_LIMIT", 10);
        StretchTransportError.CANCELLED = new StretchTransportError("CANCELLED", 11);
        StretchTransportError.SESSION_INVALIDATED = new StretchTransportError("SESSION_INVALIDATED", 12);
        StretchTransportError.BUSY = new StretchTransportError("BUSY", 13);
        StretchTransportError[] v0 = StretchTransportError.$values();
        StretchTransportError.$VALUES = v0;
        StretchTransportError.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchTransportError(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchTransportError.$ENTRIES;
    }

    public static StretchTransportError valueOf(String arg1) {
        return Enum.valueOf(StretchTransportError.class, arg1);
    }

    public static StretchTransportError[] values() {
        return StretchTransportError.$VALUES.clone();
    }
}

