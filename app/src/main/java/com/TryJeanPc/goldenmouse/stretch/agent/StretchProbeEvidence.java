package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProbeEvidence;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "OBSERVED", "METHOD_PRESENT", "UNAVAILABLE", "UNSUPPORTED", "PERMISSION_DENIED", "READ_FAILED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchProbeEvidence {
    public static final enum StretchProbeEvidence METHOD_PRESENT;
    public static final enum StretchProbeEvidence OBSERVED;
    public static final enum StretchProbeEvidence PERMISSION_DENIED;
    public static final enum StretchProbeEvidence READ_FAILED;
    public static final enum StretchProbeEvidence UNAVAILABLE;
    public static final enum StretchProbeEvidence UNKNOWN;
    public static final enum StretchProbeEvidence UNSUPPORTED;

    private static final StretchProbeEvidence[] $values() {
        return new StretchProbeEvidence[]{StretchProbeEvidence.UNKNOWN, StretchProbeEvidence.OBSERVED, StretchProbeEvidence.METHOD_PRESENT, StretchProbeEvidence.UNAVAILABLE, StretchProbeEvidence.UNSUPPORTED, StretchProbeEvidence.PERMISSION_DENIED, StretchProbeEvidence.READ_FAILED};
    }

    static {
        StretchProbeEvidence.UNKNOWN = new StretchProbeEvidence("UNKNOWN", 0);
        StretchProbeEvidence.OBSERVED = new StretchProbeEvidence("OBSERVED", 1);
        StretchProbeEvidence.METHOD_PRESENT = new StretchProbeEvidence("METHOD_PRESENT", 2);
        StretchProbeEvidence.UNAVAILABLE = new StretchProbeEvidence("UNAVAILABLE", 3);
        StretchProbeEvidence.UNSUPPORTED = new StretchProbeEvidence("UNSUPPORTED", 4);
        StretchProbeEvidence.PERMISSION_DENIED = new StretchProbeEvidence("PERMISSION_DENIED", 5);
        StretchProbeEvidence.READ_FAILED = new StretchProbeEvidence("READ_FAILED", 6);
        StretchProbeEvidence[] v0 = StretchProbeEvidence.$values();
        StretchProbeEvidence.$VALUES = v0;
        StretchProbeEvidence.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchProbeEvidence(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchProbeEvidence.$ENTRIES;
    }

    public static StretchProbeEvidence valueOf(String arg1) {
        return Enum.valueOf(StretchProbeEvidence.class, arg1);
    }

    public static StretchProbeEvidence[] values() {
        return StretchProbeEvidence.$VALUES.clone();
    }
}

