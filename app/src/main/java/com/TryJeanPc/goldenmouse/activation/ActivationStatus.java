package com.TryJeanPc.goldenmouse.activation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/activation/ActivationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNCONFIGURED", "PAIRING_REQUIRED", "PAIRING", "RECONNECTING", "ACTIVE_KADB", "ACTIVE_SHIZUKU", "UNAVAILABLE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum ActivationStatus {
    public static final enum ActivationStatus ACTIVE_KADB;
    public static final enum ActivationStatus ACTIVE_SHIZUKU;
    public static final enum ActivationStatus PAIRING;
    public static final enum ActivationStatus PAIRING_REQUIRED;
    public static final enum ActivationStatus RECONNECTING;
    public static final enum ActivationStatus UNAVAILABLE;
    public static final enum ActivationStatus UNCONFIGURED;

    private static final ActivationStatus[] $values() {
        return new ActivationStatus[]{ActivationStatus.UNCONFIGURED, ActivationStatus.PAIRING_REQUIRED, ActivationStatus.PAIRING, ActivationStatus.RECONNECTING, ActivationStatus.ACTIVE_KADB, ActivationStatus.ACTIVE_SHIZUKU, ActivationStatus.UNAVAILABLE};
    }

    static {
        ActivationStatus.UNCONFIGURED = new ActivationStatus("UNCONFIGURED", 0);
        ActivationStatus.PAIRING_REQUIRED = new ActivationStatus("PAIRING_REQUIRED", 1);
        ActivationStatus.PAIRING = new ActivationStatus("PAIRING", 2);
        ActivationStatus.RECONNECTING = new ActivationStatus("RECONNECTING", 3);
        ActivationStatus.ACTIVE_KADB = new ActivationStatus("ACTIVE_KADB", 4);
        ActivationStatus.ACTIVE_SHIZUKU = new ActivationStatus("ACTIVE_SHIZUKU", 5);
        ActivationStatus.UNAVAILABLE = new ActivationStatus("UNAVAILABLE", 6);
        ActivationStatus[] v0 = ActivationStatus.$values();
        ActivationStatus.$VALUES = v0;
        ActivationStatus.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ActivationStatus(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ActivationStatus.$ENTRIES;
    }

    public static ActivationStatus valueOf(String arg1) {
        return Enum.valueOf(ActivationStatus.class, arg1);
    }

    public static ActivationStatus[] values() {
        return ActivationStatus.$VALUES.clone();
    }
}

