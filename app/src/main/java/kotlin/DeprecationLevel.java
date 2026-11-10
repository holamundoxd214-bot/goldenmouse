package kotlin;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlin/DeprecationLevel;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum DeprecationLevel {
    public static final enum DeprecationLevel ERROR;
    public static final enum DeprecationLevel HIDDEN;
    public static final enum DeprecationLevel WARNING;

    private static final DeprecationLevel[] $values() {
        return new DeprecationLevel[]{DeprecationLevel.WARNING, DeprecationLevel.ERROR, DeprecationLevel.HIDDEN};
    }

    static {
        DeprecationLevel.WARNING = new DeprecationLevel("WARNING", 0);
        DeprecationLevel.ERROR = new DeprecationLevel("ERROR", 1);
        DeprecationLevel.HIDDEN = new DeprecationLevel("HIDDEN", 2);
        DeprecationLevel[] v0 = DeprecationLevel.$values();
        DeprecationLevel.$VALUES = v0;
        DeprecationLevel.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private DeprecationLevel(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return DeprecationLevel.$ENTRIES;
    }

    public static DeprecationLevel valueOf(String arg1) {
        return Enum.valueOf(DeprecationLevel.class, arg1);
    }

    public static DeprecationLevel[] values() {
        return DeprecationLevel.$VALUES.clone();
    }
}

