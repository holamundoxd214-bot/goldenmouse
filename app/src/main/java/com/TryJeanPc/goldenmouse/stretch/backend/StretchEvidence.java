package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchEvidence;", "", "<init>", "(Ljava/lang/String;I)V", "VERIFIED", "UNAVAILABLE", "NOT_AUTHORIZED", "PENDING_VALIDATION", "UNKNOWN", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchEvidence {
    public static final enum StretchEvidence NOT_AUTHORIZED;
    public static final enum StretchEvidence PENDING_VALIDATION;
    public static final enum StretchEvidence UNAVAILABLE;
    public static final enum StretchEvidence UNKNOWN;
    public static final enum StretchEvidence VERIFIED;

    private static final StretchEvidence[] $values() {
        return new StretchEvidence[]{StretchEvidence.VERIFIED, StretchEvidence.UNAVAILABLE, StretchEvidence.NOT_AUTHORIZED, StretchEvidence.PENDING_VALIDATION, StretchEvidence.UNKNOWN};
    }

    static {
        StretchEvidence.VERIFIED = new StretchEvidence("VERIFIED", 0);
        StretchEvidence.UNAVAILABLE = new StretchEvidence("UNAVAILABLE", 1);
        StretchEvidence.NOT_AUTHORIZED = new StretchEvidence("NOT_AUTHORIZED", 2);
        StretchEvidence.PENDING_VALIDATION = new StretchEvidence("PENDING_VALIDATION", 3);
        StretchEvidence.UNKNOWN = new StretchEvidence("UNKNOWN", 4);
        StretchEvidence[] v0 = StretchEvidence.$values();
        StretchEvidence.$VALUES = v0;
        StretchEvidence.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchEvidence(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchEvidence.$ENTRIES;
    }

    public static StretchEvidence valueOf(String arg1) {
        return Enum.valueOf(StretchEvidence.class, arg1);
    }

    public static StretchEvidence[] values() {
        return StretchEvidence.$VALUES.clone();
    }
}

