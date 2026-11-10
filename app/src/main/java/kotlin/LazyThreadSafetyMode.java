package kotlin;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlin/LazyThreadSafetyMode;", "", "<init>", "(Ljava/lang/String;I)V", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum LazyThreadSafetyMode {
    public static final enum LazyThreadSafetyMode NONE;
    public static final enum LazyThreadSafetyMode PUBLICATION;
    public static final enum LazyThreadSafetyMode SYNCHRONIZED;

    private static final LazyThreadSafetyMode[] $values() {
        return new LazyThreadSafetyMode[]{LazyThreadSafetyMode.SYNCHRONIZED, LazyThreadSafetyMode.PUBLICATION, LazyThreadSafetyMode.NONE};
    }

    static {
        LazyThreadSafetyMode.SYNCHRONIZED = new LazyThreadSafetyMode("SYNCHRONIZED", 0);
        LazyThreadSafetyMode.PUBLICATION = new LazyThreadSafetyMode("PUBLICATION", 1);
        LazyThreadSafetyMode.NONE = new LazyThreadSafetyMode("NONE", 2);
        LazyThreadSafetyMode[] v0 = LazyThreadSafetyMode.$values();
        LazyThreadSafetyMode.$VALUES = v0;
        LazyThreadSafetyMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private LazyThreadSafetyMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return LazyThreadSafetyMode.$ENTRIES;
    }

    public static LazyThreadSafetyMode valueOf(String arg1) {
        return Enum.valueOf(LazyThreadSafetyMode.class, arg1);
    }

    public static LazyThreadSafetyMode[] values() {
        return LazyThreadSafetyMode.$VALUES.clone();
    }
}

