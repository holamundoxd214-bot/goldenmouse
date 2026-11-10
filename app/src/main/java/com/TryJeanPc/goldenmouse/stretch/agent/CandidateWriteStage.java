package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateWriteStage;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_SLOT", "AFTER_HALF_SLOT", "AFTER_SYNC", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum CandidateWriteStage {
    public static final enum CandidateWriteStage AFTER_HALF_SLOT;
    public static final enum CandidateWriteStage AFTER_SYNC;
    public static final enum CandidateWriteStage BEFORE_SLOT;

    private static final CandidateWriteStage[] $values() {
        return new CandidateWriteStage[]{CandidateWriteStage.BEFORE_SLOT, CandidateWriteStage.AFTER_HALF_SLOT, CandidateWriteStage.AFTER_SYNC};
    }

    static {
        CandidateWriteStage.BEFORE_SLOT = new CandidateWriteStage("BEFORE_SLOT", 0);
        CandidateWriteStage.AFTER_HALF_SLOT = new CandidateWriteStage("AFTER_HALF_SLOT", 1);
        CandidateWriteStage.AFTER_SYNC = new CandidateWriteStage("AFTER_SYNC", 2);
        CandidateWriteStage[] v0 = CandidateWriteStage.$values();
        CandidateWriteStage.$VALUES = v0;
        CandidateWriteStage.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CandidateWriteStage(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CandidateWriteStage.$ENTRIES;
    }

    public static CandidateWriteStage valueOf(String arg1) {
        return Enum.valueOf(CandidateWriteStage.class, arg1);
    }

    public static CandidateWriteStage[] values() {
        return CandidateWriteStage.$VALUES.clone();
    }
}

