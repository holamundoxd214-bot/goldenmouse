package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalError;", "", "<init>", "(Ljava/lang/String;I)V", "CORRUPT", "VERSION_UNSUPPORTED", "SIMULATION_RECORD_REJECTED", "BUSY", "CLOSED", "IO_FAILED", "UNPROTECTED_DESCRIPTOR", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum CandidateJournalError {
    public static final enum CandidateJournalError BUSY;
    public static final enum CandidateJournalError CLOSED;
    public static final enum CandidateJournalError CORRUPT;
    public static final enum CandidateJournalError IO_FAILED;
    public static final enum CandidateJournalError SIMULATION_RECORD_REJECTED;
    public static final enum CandidateJournalError UNPROTECTED_DESCRIPTOR;
    public static final enum CandidateJournalError VERSION_UNSUPPORTED;

    private static final CandidateJournalError[] $values() {
        return new CandidateJournalError[]{CandidateJournalError.CORRUPT, CandidateJournalError.VERSION_UNSUPPORTED, CandidateJournalError.SIMULATION_RECORD_REJECTED, CandidateJournalError.BUSY, CandidateJournalError.CLOSED, CandidateJournalError.IO_FAILED, CandidateJournalError.UNPROTECTED_DESCRIPTOR};
    }

    static {
        CandidateJournalError.CORRUPT = new CandidateJournalError("CORRUPT", 0);
        CandidateJournalError.VERSION_UNSUPPORTED = new CandidateJournalError("VERSION_UNSUPPORTED", 1);
        CandidateJournalError.SIMULATION_RECORD_REJECTED = new CandidateJournalError("SIMULATION_RECORD_REJECTED", 2);
        CandidateJournalError.BUSY = new CandidateJournalError("BUSY", 3);
        CandidateJournalError.CLOSED = new CandidateJournalError("CLOSED", 4);
        CandidateJournalError.IO_FAILED = new CandidateJournalError("IO_FAILED", 5);
        CandidateJournalError.UNPROTECTED_DESCRIPTOR = new CandidateJournalError("UNPROTECTED_DESCRIPTOR", 6);
        CandidateJournalError[] v0 = CandidateJournalError.$values();
        CandidateJournalError.$VALUES = v0;
        CandidateJournalError.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CandidateJournalError(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CandidateJournalError.$ENTRIES;
    }

    public static CandidateJournalError valueOf(String arg1) {
        return Enum.valueOf(CandidateJournalError.class, arg1);
    }

    public static CandidateJournalError[] values() {
        return CandidateJournalError.$VALUES.clone();
    }
}

