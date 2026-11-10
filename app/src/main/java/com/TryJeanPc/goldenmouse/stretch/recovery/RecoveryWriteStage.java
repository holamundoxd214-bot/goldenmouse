package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryWriteStage;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_WRITE", "AFTER_FILE_SYNC", "AFTER_RENAME", "AFTER_DIRECTORY_SYNC", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RecoveryWriteStage {
    public static final enum RecoveryWriteStage AFTER_DIRECTORY_SYNC;
    public static final enum RecoveryWriteStage AFTER_FILE_SYNC;
    public static final enum RecoveryWriteStage AFTER_RENAME;
    public static final enum RecoveryWriteStage BEFORE_WRITE;

    private static final RecoveryWriteStage[] $values() {
        return new RecoveryWriteStage[]{RecoveryWriteStage.BEFORE_WRITE, RecoveryWriteStage.AFTER_FILE_SYNC, RecoveryWriteStage.AFTER_RENAME, RecoveryWriteStage.AFTER_DIRECTORY_SYNC};
    }

    static {
        RecoveryWriteStage.BEFORE_WRITE = new RecoveryWriteStage("BEFORE_WRITE", 0);
        RecoveryWriteStage.AFTER_FILE_SYNC = new RecoveryWriteStage("AFTER_FILE_SYNC", 1);
        RecoveryWriteStage.AFTER_RENAME = new RecoveryWriteStage("AFTER_RENAME", 2);
        RecoveryWriteStage.AFTER_DIRECTORY_SYNC = new RecoveryWriteStage("AFTER_DIRECTORY_SYNC", 3);
        RecoveryWriteStage[] v0 = RecoveryWriteStage.$values();
        RecoveryWriteStage.$VALUES = v0;
        RecoveryWriteStage.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RecoveryWriteStage(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RecoveryWriteStage.$ENTRIES;
    }

    public static RecoveryWriteStage valueOf(String arg1) {
        return Enum.valueOf(RecoveryWriteStage.class, arg1);
    }

    public static RecoveryWriteStage[] values() {
        return RecoveryWriteStage.$VALUES.clone();
    }
}

