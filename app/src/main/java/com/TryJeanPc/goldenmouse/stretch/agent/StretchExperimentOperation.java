package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentOperation;", "", "<init>", "(Ljava/lang/String;I)V", "ENDPOINT", "ARM", "VERIFY_EXECUTOR", "APPLY_EXPERIMENT", "RESTORE", "STATUS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchExperimentOperation {
    public static final enum StretchExperimentOperation APPLY_EXPERIMENT;
    public static final enum StretchExperimentOperation ARM;
    public static final enum StretchExperimentOperation ENDPOINT;
    public static final enum StretchExperimentOperation RESTORE;
    public static final enum StretchExperimentOperation STATUS;
    public static final enum StretchExperimentOperation VERIFY_EXECUTOR;

    private static final StretchExperimentOperation[] $values() {
        return new StretchExperimentOperation[]{StretchExperimentOperation.ENDPOINT, StretchExperimentOperation.ARM, StretchExperimentOperation.VERIFY_EXECUTOR, StretchExperimentOperation.APPLY_EXPERIMENT, StretchExperimentOperation.RESTORE, StretchExperimentOperation.STATUS};
    }

    static {
        StretchExperimentOperation.ENDPOINT = new StretchExperimentOperation("ENDPOINT", 0);
        StretchExperimentOperation.ARM = new StretchExperimentOperation("ARM", 1);
        StretchExperimentOperation.VERIFY_EXECUTOR = new StretchExperimentOperation("VERIFY_EXECUTOR", 2);
        StretchExperimentOperation.APPLY_EXPERIMENT = new StretchExperimentOperation("APPLY_EXPERIMENT", 3);
        StretchExperimentOperation.RESTORE = new StretchExperimentOperation("RESTORE", 4);
        StretchExperimentOperation.STATUS = new StretchExperimentOperation("STATUS", 5);
        StretchExperimentOperation[] v0 = StretchExperimentOperation.$values();
        StretchExperimentOperation.$VALUES = v0;
        StretchExperimentOperation.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchExperimentOperation(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchExperimentOperation.$ENTRIES;
    }

    public static StretchExperimentOperation valueOf(String arg1) {
        return Enum.valueOf(StretchExperimentOperation.class, arg1);
    }

    public static StretchExperimentOperation[] values() {
        return StretchExperimentOperation.$VALUES.clone();
    }
}

