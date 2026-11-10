package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateExecutorProbe;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "RESERVED", "MATCHED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum CandidateExecutorProbe {
    public static final enum CandidateExecutorProbe MATCHED;
    public static final enum CandidateExecutorProbe NONE;
    public static final enum CandidateExecutorProbe RESERVED;

    private static final CandidateExecutorProbe[] $values() {
        return new CandidateExecutorProbe[]{CandidateExecutorProbe.NONE, CandidateExecutorProbe.RESERVED, CandidateExecutorProbe.MATCHED};
    }

    static {
        CandidateExecutorProbe.NONE = new CandidateExecutorProbe("NONE", 0);
        CandidateExecutorProbe.RESERVED = new CandidateExecutorProbe("RESERVED", 1);
        CandidateExecutorProbe.MATCHED = new CandidateExecutorProbe("MATCHED", 2);
        CandidateExecutorProbe[] v0 = CandidateExecutorProbe.$values();
        CandidateExecutorProbe.$VALUES = v0;
        CandidateExecutorProbe.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CandidateExecutorProbe(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CandidateExecutorProbe.$ENTRIES;
    }

    public static CandidateExecutorProbe valueOf(String arg1) {
        return Enum.valueOf(CandidateExecutorProbe.class, arg1);
    }

    public static CandidateExecutorProbe[] values() {
        return CandidateExecutorProbe.$VALUES.clone();
    }
}

