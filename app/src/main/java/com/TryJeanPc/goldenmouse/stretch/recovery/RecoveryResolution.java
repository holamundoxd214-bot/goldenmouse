package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryResolution;", "", "<init>", "(Ljava/lang/String;I)V", "NO_CHANGE_REQUESTED", "SIMULATION_VERIFIED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryResolution {
    public static final enum RecoveryResolution NO_CHANGE_REQUESTED;
    public static final enum RecoveryResolution SIMULATION_VERIFIED;

    private static final RecoveryResolution[] $values() {
        return new RecoveryResolution[]{RecoveryResolution.NO_CHANGE_REQUESTED, RecoveryResolution.SIMULATION_VERIFIED};
    }

    static {
        RecoveryResolution.NO_CHANGE_REQUESTED = new RecoveryResolution("NO_CHANGE_REQUESTED", 0);
        RecoveryResolution.SIMULATION_VERIFIED = new RecoveryResolution("SIMULATION_VERIFIED", 1);
        RecoveryResolution[] v0 = RecoveryResolution.$values();
        RecoveryResolution.$VALUES = v0;
        RecoveryResolution.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryResolution(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryResolution.$ENTRIES;
    }

    public static RecoveryResolution valueOf(String arg1) {
        return Enum.valueOf(RecoveryResolution.class, arg1);
    }

    public static RecoveryResolution[] values() {
        return RecoveryResolution.$VALUES.clone();
    }
}

