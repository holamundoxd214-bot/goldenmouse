package com.flyfishxu.kadb;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/flyfishxu/kadb/DelayedAckMode;", "", "<init>", "(Ljava/lang/String;I)V", "AOSP_DEFAULT", "ENABLED", "DISABLED", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public enum DelayedAckMode {
    public static final enum DelayedAckMode AOSP_DEFAULT;
    public static final enum DelayedAckMode DISABLED;
    public static final enum DelayedAckMode ENABLED;

    private static final DelayedAckMode[] $values() {
        return new DelayedAckMode[]{DelayedAckMode.AOSP_DEFAULT, DelayedAckMode.ENABLED, DelayedAckMode.DISABLED};
    }

    static {
        DelayedAckMode.AOSP_DEFAULT = new DelayedAckMode("AOSP_DEFAULT", 0);
        DelayedAckMode.ENABLED = new DelayedAckMode("ENABLED", 1);
        DelayedAckMode.DISABLED = new DelayedAckMode("DISABLED", 2);
        DelayedAckMode[] v0 = DelayedAckMode.$values();
        DelayedAckMode.$VALUES = v0;
        DelayedAckMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private DelayedAckMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return DelayedAckMode.$ENTRIES;
    }

    public static DelayedAckMode valueOf(String arg1) {
        return Enum.valueOf(DelayedAckMode.class, arg1);
    }

    public static DelayedAckMode[] values() {
        return DelayedAckMode.$VALUES.clone();
    }
}

