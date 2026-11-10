package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchCapability;", "", "<init>", "(Ljava/lang/String;I)V", "PUBLIC_DISPLAY_READ", "BACKEND_DISPLAY_READ", "QUERY_OPERATIONS", "PRIVILEGED_OPERATIONS", "REAL_PROJECTION", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchCapability {
    public static final enum StretchCapability BACKEND_DISPLAY_READ;
    public static final enum StretchCapability PRIVILEGED_OPERATIONS;
    public static final enum StretchCapability PUBLIC_DISPLAY_READ;
    public static final enum StretchCapability QUERY_OPERATIONS;
    public static final enum StretchCapability REAL_PROJECTION;

    private static final StretchCapability[] $values() {
        return new StretchCapability[]{StretchCapability.PUBLIC_DISPLAY_READ, StretchCapability.BACKEND_DISPLAY_READ, StretchCapability.QUERY_OPERATIONS, StretchCapability.PRIVILEGED_OPERATIONS, StretchCapability.REAL_PROJECTION};
    }

    static {
        StretchCapability.PUBLIC_DISPLAY_READ = new StretchCapability("PUBLIC_DISPLAY_READ", 0);
        StretchCapability.BACKEND_DISPLAY_READ = new StretchCapability("BACKEND_DISPLAY_READ", 1);
        StretchCapability.QUERY_OPERATIONS = new StretchCapability("QUERY_OPERATIONS", 2);
        StretchCapability.PRIVILEGED_OPERATIONS = new StretchCapability("PRIVILEGED_OPERATIONS", 3);
        StretchCapability.REAL_PROJECTION = new StretchCapability("REAL_PROJECTION", 4);
        StretchCapability[] v0 = StretchCapability.$values();
        StretchCapability.$VALUES = v0;
        StretchCapability.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchCapability(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchCapability.$ENTRIES;
    }

    public static StretchCapability valueOf(String arg1) {
        return Enum.valueOf(StretchCapability.class, arg1);
    }

    public static StretchCapability[] values() {
        return StretchCapability.$VALUES.clone();
    }
}

