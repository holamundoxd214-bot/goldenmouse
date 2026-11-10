package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "", "<init>", "(Ljava/lang/String;I)V", "SIMULATION_ONLY", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryScope {
    public static final enum RecoveryScope SIMULATION_ONLY;

    private static final RecoveryScope[] $values() {
        return new RecoveryScope[]{RecoveryScope.SIMULATION_ONLY};
    }

    static {
        RecoveryScope.SIMULATION_ONLY = new RecoveryScope("SIMULATION_ONLY", 0);
        RecoveryScope[] v0 = RecoveryScope.$values();
        RecoveryScope.$VALUES = v0;
        RecoveryScope.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryScope(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryScope.$ENTRIES;
    }

    public static RecoveryScope valueOf(String arg1) {
        return Enum.valueOf(RecoveryScope.class, arg1);
    }

    public static RecoveryScope[] values() {
        return RecoveryScope.$VALUES.clone();
    }
}

