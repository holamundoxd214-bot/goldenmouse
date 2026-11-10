package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchConnectRejection;", "", "<init>", "(Ljava/lang/String;I)V", "SERVICE_DESTROYED", "SERVICE_UID_NOT_SHELL", "SERVICE_CONTEXT_MISSING", "OWNER_LOOKUP_SECURITY", "OWNER_LOOKUP_FAILED", "OWNER_UID_INVALID", "CALLER_UID_MISMATCH", "CALL_FLAGS_INVALID", "SERVICE_INTERFACE", "SERVICE_CALLBACK_RETURN", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchConnectRejection {
    public static final enum StretchConnectRejection CALLER_UID_MISMATCH;
    public static final enum StretchConnectRejection CALL_FLAGS_INVALID;
    public static final enum StretchConnectRejection OWNER_LOOKUP_FAILED;
    public static final enum StretchConnectRejection OWNER_LOOKUP_SECURITY;
    public static final enum StretchConnectRejection OWNER_UID_INVALID;
    public static final enum StretchConnectRejection SERVICE_CALLBACK_RETURN;
    public static final enum StretchConnectRejection SERVICE_CONTEXT_MISSING;
    public static final enum StretchConnectRejection SERVICE_DESTROYED;
    public static final enum StretchConnectRejection SERVICE_INTERFACE;
    public static final enum StretchConnectRejection SERVICE_UID_NOT_SHELL;

    private static final StretchConnectRejection[] $values() {
        return new StretchConnectRejection[]{StretchConnectRejection.SERVICE_DESTROYED, StretchConnectRejection.SERVICE_UID_NOT_SHELL, StretchConnectRejection.SERVICE_CONTEXT_MISSING, StretchConnectRejection.OWNER_LOOKUP_SECURITY, StretchConnectRejection.OWNER_LOOKUP_FAILED, StretchConnectRejection.OWNER_UID_INVALID, StretchConnectRejection.CALLER_UID_MISMATCH, StretchConnectRejection.CALL_FLAGS_INVALID, StretchConnectRejection.SERVICE_INTERFACE, StretchConnectRejection.SERVICE_CALLBACK_RETURN};
    }

    static {
        StretchConnectRejection.SERVICE_DESTROYED = new StretchConnectRejection("SERVICE_DESTROYED", 0);
        StretchConnectRejection.SERVICE_UID_NOT_SHELL = new StretchConnectRejection("SERVICE_UID_NOT_SHELL", 1);
        StretchConnectRejection.SERVICE_CONTEXT_MISSING = new StretchConnectRejection("SERVICE_CONTEXT_MISSING", 2);
        StretchConnectRejection.OWNER_LOOKUP_SECURITY = new StretchConnectRejection("OWNER_LOOKUP_SECURITY", 3);
        StretchConnectRejection.OWNER_LOOKUP_FAILED = new StretchConnectRejection("OWNER_LOOKUP_FAILED", 4);
        StretchConnectRejection.OWNER_UID_INVALID = new StretchConnectRejection("OWNER_UID_INVALID", 5);
        StretchConnectRejection.CALLER_UID_MISMATCH = new StretchConnectRejection("CALLER_UID_MISMATCH", 6);
        StretchConnectRejection.CALL_FLAGS_INVALID = new StretchConnectRejection("CALL_FLAGS_INVALID", 7);
        StretchConnectRejection.SERVICE_INTERFACE = new StretchConnectRejection("SERVICE_INTERFACE", 8);
        StretchConnectRejection.SERVICE_CALLBACK_RETURN = new StretchConnectRejection("SERVICE_CALLBACK_RETURN", 9);
        StretchConnectRejection[] v0 = StretchConnectRejection.$values();
        StretchConnectRejection.$VALUES = v0;
        StretchConnectRejection.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchConnectRejection(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchConnectRejection.$ENTRIES;
    }

    public static StretchConnectRejection valueOf(String arg1) {
        return Enum.valueOf(StretchConnectRejection.class, arg1);
    }

    public static StretchConnectRejection[] values() {
        return StretchConnectRejection.$VALUES.clone();
    }
}

