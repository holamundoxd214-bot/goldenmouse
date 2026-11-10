package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "", "<init>", "(Ljava/lang/String;I)V", "SHIZUKU", "KADB", "NONE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchBackendType {
    public static final enum StretchBackendType KADB;
    public static final enum StretchBackendType NONE;
    public static final enum StretchBackendType SHIZUKU;

    private static final StretchBackendType[] $values() {
        return new StretchBackendType[]{StretchBackendType.SHIZUKU, StretchBackendType.KADB, StretchBackendType.NONE};
    }

    static {
        StretchBackendType.SHIZUKU = new StretchBackendType("SHIZUKU", 0);
        StretchBackendType.KADB = new StretchBackendType("KADB", 1);
        StretchBackendType.NONE = new StretchBackendType("NONE", 2);
        StretchBackendType[] v0 = StretchBackendType.$values();
        StretchBackendType.$VALUES = v0;
        StretchBackendType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchBackendType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchBackendType.$ENTRIES;
    }

    public static StretchBackendType valueOf(String arg1) {
        return Enum.valueOf(StretchBackendType.class, arg1);
    }

    public static StretchBackendType[] values() {
        return StretchBackendType.$VALUES.clone();
    }
}

