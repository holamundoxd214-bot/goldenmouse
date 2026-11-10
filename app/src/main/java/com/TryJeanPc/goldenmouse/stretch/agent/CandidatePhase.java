package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidatePhase;", "", "<init>", "(Ljava/lang/String;I)V", "CAPTURED", "INTENT_RESERVED", "EXECUTION_UNKNOWN", "RESTORE_PENDING", "RESTORE_PARTIAL", "RESTORE_UNVERIFIED", "CLOSED_WITHOUT_MUTATION", "RESTORED_VERIFIED", "ACTIVE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum CandidatePhase {
    public static final enum CandidatePhase ACTIVE;
    public static final enum CandidatePhase CAPTURED;
    public static final enum CandidatePhase CLOSED_WITHOUT_MUTATION;
    public static final enum CandidatePhase EXECUTION_UNKNOWN;
    public static final enum CandidatePhase INTENT_RESERVED;
    public static final enum CandidatePhase RESTORED_VERIFIED;
    public static final enum CandidatePhase RESTORE_PARTIAL;
    public static final enum CandidatePhase RESTORE_PENDING;
    public static final enum CandidatePhase RESTORE_UNVERIFIED;

    private static final CandidatePhase[] $values() {
        return new CandidatePhase[]{CandidatePhase.CAPTURED, CandidatePhase.INTENT_RESERVED, CandidatePhase.EXECUTION_UNKNOWN, CandidatePhase.RESTORE_PENDING, CandidatePhase.RESTORE_PARTIAL, CandidatePhase.RESTORE_UNVERIFIED, CandidatePhase.CLOSED_WITHOUT_MUTATION, CandidatePhase.RESTORED_VERIFIED, CandidatePhase.ACTIVE};
    }

    static {
        CandidatePhase.CAPTURED = new CandidatePhase("CAPTURED", 0);
        CandidatePhase.INTENT_RESERVED = new CandidatePhase("INTENT_RESERVED", 1);
        CandidatePhase.EXECUTION_UNKNOWN = new CandidatePhase("EXECUTION_UNKNOWN", 2);
        CandidatePhase.RESTORE_PENDING = new CandidatePhase("RESTORE_PENDING", 3);
        CandidatePhase.RESTORE_PARTIAL = new CandidatePhase("RESTORE_PARTIAL", 4);
        CandidatePhase.RESTORE_UNVERIFIED = new CandidatePhase("RESTORE_UNVERIFIED", 5);
        CandidatePhase.CLOSED_WITHOUT_MUTATION = new CandidatePhase("CLOSED_WITHOUT_MUTATION", 6);
        CandidatePhase.RESTORED_VERIFIED = new CandidatePhase("RESTORED_VERIFIED", 7);
        CandidatePhase.ACTIVE = new CandidatePhase("ACTIVE", 8);
        CandidatePhase[] v0 = CandidatePhase.$values();
        CandidatePhase.$VALUES = v0;
        CandidatePhase.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CandidatePhase(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CandidatePhase.$ENTRIES;
    }

    public static CandidatePhase valueOf(String arg1) {
        return Enum.valueOf(CandidatePhase.class, arg1);
    }

    public static CandidatePhase[] values() {
        return CandidatePhase.$VALUES.clone();
    }
}

