package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "OPEN", "BASELINE_CAPTURED", "NOT_RECOVERABLE", "RECOVERY_PENDING", "CLOSED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchAgentPhase {
    public static final enum StretchAgentPhase BASELINE_CAPTURED;
    public static final enum StretchAgentPhase CLOSED;
    public static final enum StretchAgentPhase IDLE;
    public static final enum StretchAgentPhase NOT_RECOVERABLE;
    public static final enum StretchAgentPhase OPEN;
    public static final enum StretchAgentPhase RECOVERY_PENDING;

    private static final StretchAgentPhase[] $values() {
        return new StretchAgentPhase[]{StretchAgentPhase.IDLE, StretchAgentPhase.OPEN, StretchAgentPhase.BASELINE_CAPTURED, StretchAgentPhase.NOT_RECOVERABLE, StretchAgentPhase.RECOVERY_PENDING, StretchAgentPhase.CLOSED};
    }

    static {
        StretchAgentPhase.IDLE = new StretchAgentPhase("IDLE", 0);
        StretchAgentPhase.OPEN = new StretchAgentPhase("OPEN", 1);
        StretchAgentPhase.BASELINE_CAPTURED = new StretchAgentPhase("BASELINE_CAPTURED", 2);
        StretchAgentPhase.NOT_RECOVERABLE = new StretchAgentPhase("NOT_RECOVERABLE", 3);
        StretchAgentPhase.RECOVERY_PENDING = new StretchAgentPhase("RECOVERY_PENDING", 4);
        StretchAgentPhase.CLOSED = new StretchAgentPhase("CLOSED", 5);
        StretchAgentPhase[] v0 = StretchAgentPhase.$values();
        StretchAgentPhase.$VALUES = v0;
        StretchAgentPhase.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchAgentPhase(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchAgentPhase.$ENTRIES;
    }

    public static StretchAgentPhase valueOf(String arg1) {
        return Enum.valueOf(StretchAgentPhase.class, arg1);
    }

    public static StretchAgentPhase[] values() {
        return StretchAgentPhase.$VALUES.clone();
    }
}

