package kotlin.reflect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lkotlin/reflect/KVisibility;", "", "<init>", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum KVisibility {
    public static final enum KVisibility INTERNAL;
    public static final enum KVisibility PRIVATE;
    public static final enum KVisibility PROTECTED;
    public static final enum KVisibility PUBLIC;

    private static final KVisibility[] $values() {
        return new KVisibility[]{KVisibility.PUBLIC, KVisibility.PROTECTED, KVisibility.INTERNAL, KVisibility.PRIVATE};
    }

    static {
        KVisibility.PUBLIC = new KVisibility("PUBLIC", 0);
        KVisibility.PROTECTED = new KVisibility("PROTECTED", 1);
        KVisibility.INTERNAL = new KVisibility("INTERNAL", 2);
        KVisibility.PRIVATE = new KVisibility("PRIVATE", 3);
        KVisibility[] v0 = KVisibility.$values();
        KVisibility.$VALUES = v0;
        KVisibility.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private KVisibility(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return KVisibility.$ENTRIES;
    }

    public static KVisibility valueOf(String arg1) {
        return Enum.valueOf(KVisibility.class, arg1);
    }

    public static KVisibility[] values() {
        return KVisibility.$VALUES.clone();
    }
}

