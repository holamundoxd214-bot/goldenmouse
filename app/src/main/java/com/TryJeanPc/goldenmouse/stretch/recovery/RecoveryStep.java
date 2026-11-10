package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "", "<init>", "(Ljava/lang/String;I)V", "SIZE", "SCALING", "PROJECTION", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryStep {
    public static final enum RecoveryStep PROJECTION;
    public static final enum RecoveryStep SCALING;
    public static final enum RecoveryStep SIZE;

    private static final RecoveryStep[] $values() {
        return new RecoveryStep[]{RecoveryStep.SIZE, RecoveryStep.SCALING, RecoveryStep.PROJECTION};
    }

    static {
        RecoveryStep.SIZE = new RecoveryStep("SIZE", 0);
        RecoveryStep.SCALING = new RecoveryStep("SCALING", 1);
        RecoveryStep.PROJECTION = new RecoveryStep("PROJECTION", 2);
        RecoveryStep[] v0 = RecoveryStep.$values();
        RecoveryStep.$VALUES = v0;
        RecoveryStep.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryStep(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryStep.$ENTRIES;
    }

    public static RecoveryStep valueOf(String arg1) {
        return Enum.valueOf(RecoveryStep.class, arg1);
    }

    public static RecoveryStep[] values() {
        return RecoveryStep.$VALUES.clone();
    }
}

