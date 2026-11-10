package com.TryJeanPc.goldenmouse.injector;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/GgMeasuredBackend;", "", "<init>", "(Ljava/lang/String;I)V", "SHIZUKU", "KADB", "OTHER", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum GgMeasuredBackend {
    public static final enum GgMeasuredBackend KADB;
    public static final enum GgMeasuredBackend OTHER;
    public static final enum GgMeasuredBackend SHIZUKU;

    private static final GgMeasuredBackend[] $values() {
        return new GgMeasuredBackend[]{GgMeasuredBackend.SHIZUKU, GgMeasuredBackend.KADB, GgMeasuredBackend.OTHER};
    }

    static {
        GgMeasuredBackend.SHIZUKU = new GgMeasuredBackend("SHIZUKU", 0);
        GgMeasuredBackend.KADB = new GgMeasuredBackend("KADB", 1);
        GgMeasuredBackend.OTHER = new GgMeasuredBackend("OTHER", 2);
        GgMeasuredBackend[] v0 = GgMeasuredBackend.$values();
        GgMeasuredBackend.$VALUES = v0;
        GgMeasuredBackend.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private GgMeasuredBackend(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return GgMeasuredBackend.$ENTRIES;
    }

    public static GgMeasuredBackend valueOf(String arg1) {
        return Enum.valueOf(GgMeasuredBackend.class, arg1);
    }

    public static GgMeasuredBackend[] values() {
        return GgMeasuredBackend.$VALUES.clone();
    }
}

