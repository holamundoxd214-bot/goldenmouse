package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCode;", "", "<init>", "(Ljava/lang/String;I)V", "ACCEPTED", "BASELINE_READ", "UNAUTHORIZED", "PROTOCOL_MISMATCH", "STALE_AGENT", "STALE_SESSION", "INVALID_REQUEST", "SESSION_BUSY", "OUT_OF_ORDER", "DISPLAY_MISMATCH", "SNAPSHOT_MISMATCH", "BACKEND_DISCONNECTED", "READ_FAILED", "RECOVERY_UNAVAILABLE", "BLOCKED_BY_SAFETY", "RECOVERY_PENDING", "OPERATION_UNKNOWN", "TIMEOUT", "LIMIT_REACHED", "CLOSED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchAgentCode {
    public static final enum StretchAgentCode ACCEPTED;
    public static final enum StretchAgentCode BACKEND_DISCONNECTED;
    public static final enum StretchAgentCode BASELINE_READ;
    public static final enum StretchAgentCode BLOCKED_BY_SAFETY;
    public static final enum StretchAgentCode CLOSED;
    public static final enum StretchAgentCode DISPLAY_MISMATCH;
    public static final enum StretchAgentCode INVALID_REQUEST;
    public static final enum StretchAgentCode LIMIT_REACHED;
    public static final enum StretchAgentCode OPERATION_UNKNOWN;
    public static final enum StretchAgentCode OUT_OF_ORDER;
    public static final enum StretchAgentCode PROTOCOL_MISMATCH;
    public static final enum StretchAgentCode READ_FAILED;
    public static final enum StretchAgentCode RECOVERY_PENDING;
    public static final enum StretchAgentCode RECOVERY_UNAVAILABLE;
    public static final enum StretchAgentCode SESSION_BUSY;
    public static final enum StretchAgentCode SNAPSHOT_MISMATCH;
    public static final enum StretchAgentCode STALE_AGENT;
    public static final enum StretchAgentCode STALE_SESSION;
    public static final enum StretchAgentCode TIMEOUT;
    public static final enum StretchAgentCode UNAUTHORIZED;

    private static final StretchAgentCode[] $values() {
        return new StretchAgentCode[]{StretchAgentCode.ACCEPTED, StretchAgentCode.BASELINE_READ, StretchAgentCode.UNAUTHORIZED, StretchAgentCode.PROTOCOL_MISMATCH, StretchAgentCode.STALE_AGENT, StretchAgentCode.STALE_SESSION, StretchAgentCode.INVALID_REQUEST, StretchAgentCode.SESSION_BUSY, StretchAgentCode.OUT_OF_ORDER, StretchAgentCode.DISPLAY_MISMATCH, StretchAgentCode.SNAPSHOT_MISMATCH, StretchAgentCode.BACKEND_DISCONNECTED, StretchAgentCode.READ_FAILED, StretchAgentCode.RECOVERY_UNAVAILABLE, StretchAgentCode.BLOCKED_BY_SAFETY, StretchAgentCode.RECOVERY_PENDING, StretchAgentCode.OPERATION_UNKNOWN, StretchAgentCode.TIMEOUT, StretchAgentCode.LIMIT_REACHED, StretchAgentCode.CLOSED};
    }

    static {
        StretchAgentCode.ACCEPTED = new StretchAgentCode("ACCEPTED", 0);
        StretchAgentCode.BASELINE_READ = new StretchAgentCode("BASELINE_READ", 1);
        StretchAgentCode.UNAUTHORIZED = new StretchAgentCode("UNAUTHORIZED", 2);
        StretchAgentCode.PROTOCOL_MISMATCH = new StretchAgentCode("PROTOCOL_MISMATCH", 3);
        StretchAgentCode.STALE_AGENT = new StretchAgentCode("STALE_AGENT", 4);
        StretchAgentCode.STALE_SESSION = new StretchAgentCode("STALE_SESSION", 5);
        StretchAgentCode.INVALID_REQUEST = new StretchAgentCode("INVALID_REQUEST", 6);
        StretchAgentCode.SESSION_BUSY = new StretchAgentCode("SESSION_BUSY", 7);
        StretchAgentCode.OUT_OF_ORDER = new StretchAgentCode("OUT_OF_ORDER", 8);
        StretchAgentCode.DISPLAY_MISMATCH = new StretchAgentCode("DISPLAY_MISMATCH", 9);
        StretchAgentCode.SNAPSHOT_MISMATCH = new StretchAgentCode("SNAPSHOT_MISMATCH", 10);
        StretchAgentCode.BACKEND_DISCONNECTED = new StretchAgentCode("BACKEND_DISCONNECTED", 11);
        StretchAgentCode.READ_FAILED = new StretchAgentCode("READ_FAILED", 12);
        StretchAgentCode.RECOVERY_UNAVAILABLE = new StretchAgentCode("RECOVERY_UNAVAILABLE", 13);
        StretchAgentCode.BLOCKED_BY_SAFETY = new StretchAgentCode("BLOCKED_BY_SAFETY", 14);
        StretchAgentCode.RECOVERY_PENDING = new StretchAgentCode("RECOVERY_PENDING", 15);
        StretchAgentCode.OPERATION_UNKNOWN = new StretchAgentCode("OPERATION_UNKNOWN", 16);
        StretchAgentCode.TIMEOUT = new StretchAgentCode("TIMEOUT", 17);
        StretchAgentCode.LIMIT_REACHED = new StretchAgentCode("LIMIT_REACHED", 18);
        StretchAgentCode.CLOSED = new StretchAgentCode("CLOSED", 19);
        StretchAgentCode[] v0 = StretchAgentCode.$values();
        StretchAgentCode.$VALUES = v0;
        StretchAgentCode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchAgentCode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchAgentCode.$ENTRIES;
    }

    public static StretchAgentCode valueOf(String arg1) {
        return Enum.valueOf(StretchAgentCode.class, arg1);
    }

    public static StretchAgentCode[] values() {
        return StretchAgentCode.$VALUES.clone();
    }
}

