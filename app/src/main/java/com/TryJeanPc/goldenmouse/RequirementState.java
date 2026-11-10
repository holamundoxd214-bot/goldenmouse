package com.TryJeanPc.goldenmouse;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/RequirementState;", "", "<init>", "(Ljava/lang/String;I)V", "SATISFIED", "PENDING", "UNAVAILABLE", "UNVERIFIABLE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RequirementState {
    public static final enum RequirementState PENDING;
    public static final enum RequirementState SATISFIED;
    public static final enum RequirementState UNAVAILABLE;
    public static final enum RequirementState UNVERIFIABLE;

    private static final RequirementState[] $values() {
        return new RequirementState[]{RequirementState.SATISFIED, RequirementState.PENDING, RequirementState.UNAVAILABLE, RequirementState.UNVERIFIABLE};
    }

    static {
        RequirementState.SATISFIED = new RequirementState("SATISFIED", 0);
        RequirementState.PENDING = new RequirementState("PENDING", 1);
        RequirementState.UNAVAILABLE = new RequirementState("UNAVAILABLE", 2);
        RequirementState.UNVERIFIABLE = new RequirementState("UNVERIFIABLE", 3);
        RequirementState[] v0 = RequirementState.$values();
        RequirementState.$VALUES = v0;
        RequirementState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RequirementState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RequirementState.$ENTRIES;
    }

    public static RequirementState valueOf(String arg1) {
        return Enum.valueOf(RequirementState.class, arg1);
    }

    public static RequirementState[] values() {
        return RequirementState.$VALUES.clone();
    }
}

