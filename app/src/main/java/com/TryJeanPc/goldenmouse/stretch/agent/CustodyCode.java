package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CustodyCode;", "", "<init>", "(Ljava/lang/String;I)V", "OBSERVING", "NO_MUTATION_CLOSED", "RESTORE_PENDING", "BLOCKED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum CustodyCode {
    public static final enum CustodyCode BLOCKED;
    public static final enum CustodyCode NO_MUTATION_CLOSED;
    public static final enum CustodyCode OBSERVING;
    public static final enum CustodyCode RESTORE_PENDING;

    private static final CustodyCode[] $values() {
        return new CustodyCode[]{CustodyCode.OBSERVING, CustodyCode.NO_MUTATION_CLOSED, CustodyCode.RESTORE_PENDING, CustodyCode.BLOCKED};
    }

    static {
        CustodyCode.OBSERVING = new CustodyCode("OBSERVING", 0);
        CustodyCode.NO_MUTATION_CLOSED = new CustodyCode("NO_MUTATION_CLOSED", 1);
        CustodyCode.RESTORE_PENDING = new CustodyCode("RESTORE_PENDING", 2);
        CustodyCode.BLOCKED = new CustodyCode("BLOCKED", 3);
        CustodyCode[] v0 = CustodyCode.$values();
        CustodyCode.$VALUES = v0;
        CustodyCode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CustodyCode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CustodyCode.$ENTRIES;
    }

    public static CustodyCode valueOf(String arg1) {
        return Enum.valueOf(CustodyCode.class, arg1);
    }

    public static CustodyCode[] values() {
        return CustodyCode.$VALUES.clone();
    }
}

