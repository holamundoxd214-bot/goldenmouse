package com.TryJeanPc.goldenmouse.engine;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/GoldenState;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "READY", "ACTIVE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum GoldenState {
    public static final enum GoldenState ACTIVE;
    public static final enum GoldenState OFF;
    public static final enum GoldenState READY;

    private static final GoldenState[] $values() {
        return new GoldenState[]{GoldenState.OFF, GoldenState.READY, GoldenState.ACTIVE};
    }

    static {
        GoldenState.OFF = new GoldenState("OFF", 0);
        GoldenState.READY = new GoldenState("READY", 1);
        GoldenState.ACTIVE = new GoldenState("ACTIVE", 2);
        GoldenState[] v0 = GoldenState.$values();
        GoldenState.$VALUES = v0;
        GoldenState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private GoldenState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return GoldenState.$ENTRIES;
    }

    public static GoldenState valueOf(String arg1) {
        return Enum.valueOf(GoldenState.class, arg1);
    }

    public static GoldenState[] values() {
        return GoldenState.$VALUES.clone();
    }
}

