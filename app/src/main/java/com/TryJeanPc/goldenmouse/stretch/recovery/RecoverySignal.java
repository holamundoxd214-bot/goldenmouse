package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySignal;", "", "<init>", "(Ljava/lang/String;I)V", "PRESENTATION_CLOSED", "HOME", "ORIENTATION_CHANGED", "VIEW_DESTROYED", "HUD_CLOSED", "BACKEND_LOST", "OPERATION_TIMEOUT", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoverySignal {
    public static final enum RecoverySignal BACKEND_LOST;
    public static final enum RecoverySignal HOME;
    public static final enum RecoverySignal HUD_CLOSED;
    public static final enum RecoverySignal OPERATION_TIMEOUT;
    public static final enum RecoverySignal ORIENTATION_CHANGED;
    public static final enum RecoverySignal PRESENTATION_CLOSED;
    public static final enum RecoverySignal VIEW_DESTROYED;

    private static final RecoverySignal[] $values() {
        return new RecoverySignal[]{RecoverySignal.PRESENTATION_CLOSED, RecoverySignal.HOME, RecoverySignal.ORIENTATION_CHANGED, RecoverySignal.VIEW_DESTROYED, RecoverySignal.HUD_CLOSED, RecoverySignal.BACKEND_LOST, RecoverySignal.OPERATION_TIMEOUT};
    }

    static {
        RecoverySignal.PRESENTATION_CLOSED = new RecoverySignal("PRESENTATION_CLOSED", 0);
        RecoverySignal.HOME = new RecoverySignal("HOME", 1);
        RecoverySignal.ORIENTATION_CHANGED = new RecoverySignal("ORIENTATION_CHANGED", 2);
        RecoverySignal.VIEW_DESTROYED = new RecoverySignal("VIEW_DESTROYED", 3);
        RecoverySignal.HUD_CLOSED = new RecoverySignal("HUD_CLOSED", 4);
        RecoverySignal.BACKEND_LOST = new RecoverySignal("BACKEND_LOST", 5);
        RecoverySignal.OPERATION_TIMEOUT = new RecoverySignal("OPERATION_TIMEOUT", 6);
        RecoverySignal[] v0 = RecoverySignal.$values();
        RecoverySignal.$VALUES = v0;
        RecoverySignal.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoverySignal(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoverySignal.$ENTRIES;
    }

    public static RecoverySignal valueOf(String arg1) {
        return Enum.valueOf(RecoverySignal.class, arg1);
    }

    public static RecoverySignal[] values() {
        return RecoverySignal.$VALUES.clone();
    }
}

