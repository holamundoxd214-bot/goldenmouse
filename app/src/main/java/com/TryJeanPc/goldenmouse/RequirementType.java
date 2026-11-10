package com.TryJeanPc.goldenmouse;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/RequirementType;", "", "<init>", "(Ljava/lang/String;I)V", "MANDATORY", "OPTIONAL", "RECOMMENDATION", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum RequirementType {
    public static final enum RequirementType MANDATORY;
    public static final enum RequirementType OPTIONAL;
    public static final enum RequirementType RECOMMENDATION;

    private static final RequirementType[] $values() {
        return new RequirementType[]{RequirementType.MANDATORY, RequirementType.OPTIONAL, RequirementType.RECOMMENDATION};
    }

    static {
        RequirementType.MANDATORY = new RequirementType("MANDATORY", 0);
        RequirementType.OPTIONAL = new RequirementType("OPTIONAL", 1);
        RequirementType.RECOMMENDATION = new RequirementType("RECOMMENDATION", 2);
        RequirementType[] v0 = RequirementType.$values();
        RequirementType.$VALUES = v0;
        RequirementType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RequirementType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RequirementType.$ENTRIES;
    }

    public static RequirementType valueOf(String arg1) {
        return Enum.valueOf(RequirementType.class, arg1);
    }

    public static RequirementType[] values() {
        return RequirementType.$VALUES.clone();
    }
}

