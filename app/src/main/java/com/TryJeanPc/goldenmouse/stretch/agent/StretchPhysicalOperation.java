package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalOperation;", "", "<init>", "(Ljava/lang/String;I)V", "PREPARE", "APPLY", "RESTORE", "STATUS", "RELEASE", "RECOVER_PERSISTED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchPhysicalOperation {
    public static final enum StretchPhysicalOperation APPLY;
    public static final enum StretchPhysicalOperation PREPARE;
    public static final enum StretchPhysicalOperation RECOVER_PERSISTED;
    public static final enum StretchPhysicalOperation RELEASE;
    public static final enum StretchPhysicalOperation RESTORE;
    public static final enum StretchPhysicalOperation STATUS;

    private static final StretchPhysicalOperation[] $values() {
        return new StretchPhysicalOperation[]{StretchPhysicalOperation.PREPARE, StretchPhysicalOperation.APPLY, StretchPhysicalOperation.RESTORE, StretchPhysicalOperation.STATUS, StretchPhysicalOperation.RELEASE, StretchPhysicalOperation.RECOVER_PERSISTED};
    }

    static {
        StretchPhysicalOperation.PREPARE = new StretchPhysicalOperation("PREPARE", 0);
        StretchPhysicalOperation.APPLY = new StretchPhysicalOperation("APPLY", 1);
        StretchPhysicalOperation.RESTORE = new StretchPhysicalOperation("RESTORE", 2);
        StretchPhysicalOperation.STATUS = new StretchPhysicalOperation("STATUS", 3);
        StretchPhysicalOperation.RELEASE = new StretchPhysicalOperation("RELEASE", 4);
        StretchPhysicalOperation.RECOVER_PERSISTED = new StretchPhysicalOperation("RECOVER_PERSISTED", 5);
        StretchPhysicalOperation[] v0 = StretchPhysicalOperation.$values();
        StretchPhysicalOperation.$VALUES = v0;
        StretchPhysicalOperation.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchPhysicalOperation(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchPhysicalOperation.$ENTRIES;
    }

    public static StretchPhysicalOperation valueOf(String arg1) {
        return Enum.valueOf(StretchPhysicalOperation.class, arg1);
    }

    public static StretchPhysicalOperation[] values() {
        return StretchPhysicalOperation.$VALUES.clone();
    }
}

