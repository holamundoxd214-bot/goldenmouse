package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompatibility;", "", "<init>", "(Ljava/lang/String;I)V", "VERIFIED_COMPATIBLE", "PHYSICAL_TEST_PENDING", "BACKEND_UNAUTHORIZED", "RECOVERY_UNAVAILABLE", "PROJECTION_UNSUPPORTED", "SAFETY_BLOCKED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchCompatibility {
    public static final enum StretchCompatibility BACKEND_UNAUTHORIZED;
    public static final enum StretchCompatibility PHYSICAL_TEST_PENDING;
    public static final enum StretchCompatibility PROJECTION_UNSUPPORTED;
    public static final enum StretchCompatibility RECOVERY_UNAVAILABLE;
    public static final enum StretchCompatibility SAFETY_BLOCKED;
    public static final enum StretchCompatibility VERIFIED_COMPATIBLE;

    private static final StretchCompatibility[] $values() {
        return new StretchCompatibility[]{StretchCompatibility.VERIFIED_COMPATIBLE, StretchCompatibility.PHYSICAL_TEST_PENDING, StretchCompatibility.BACKEND_UNAUTHORIZED, StretchCompatibility.RECOVERY_UNAVAILABLE, StretchCompatibility.PROJECTION_UNSUPPORTED, StretchCompatibility.SAFETY_BLOCKED};
    }

    static {
        StretchCompatibility.VERIFIED_COMPATIBLE = new StretchCompatibility("VERIFIED_COMPATIBLE", 0);
        StretchCompatibility.PHYSICAL_TEST_PENDING = new StretchCompatibility("PHYSICAL_TEST_PENDING", 1);
        StretchCompatibility.BACKEND_UNAUTHORIZED = new StretchCompatibility("BACKEND_UNAUTHORIZED", 2);
        StretchCompatibility.RECOVERY_UNAVAILABLE = new StretchCompatibility("RECOVERY_UNAVAILABLE", 3);
        StretchCompatibility.PROJECTION_UNSUPPORTED = new StretchCompatibility("PROJECTION_UNSUPPORTED", 4);
        StretchCompatibility.SAFETY_BLOCKED = new StretchCompatibility("SAFETY_BLOCKED", 5);
        StretchCompatibility[] v0 = StretchCompatibility.$values();
        StretchCompatibility.$VALUES = v0;
        StretchCompatibility.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchCompatibility(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchCompatibility.$ENTRIES;
    }

    public static StretchCompatibility valueOf(String arg1) {
        return Enum.valueOf(StretchCompatibility.class, arg1);
    }

    public static StretchCompatibility[] values() {
        return StretchCompatibility.$VALUES.clone();
    }
}

