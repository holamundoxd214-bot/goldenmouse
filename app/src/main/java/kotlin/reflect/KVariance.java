package kotlin.reflect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlin/reflect/KVariance;", "", "<init>", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum KVariance {
    public static final enum KVariance IN;
    public static final enum KVariance INVARIANT;
    public static final enum KVariance OUT;

    private static final KVariance[] $values() {
        return new KVariance[]{KVariance.INVARIANT, KVariance.IN, KVariance.OUT};
    }

    static {
        KVariance.INVARIANT = new KVariance("INVARIANT", 0);
        KVariance.IN = new KVariance("IN", 1);
        KVariance.OUT = new KVariance("OUT", 2);
        KVariance[] v0 = KVariance.$values();
        KVariance.$VALUES = v0;
        KVariance.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private KVariance(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return KVariance.$ENTRIES;
    }

    public static KVariance valueOf(String arg1) {
        return Enum.valueOf(KVariance.class, arg1);
    }

    public static KVariance[] values() {
        return KVariance.$VALUES.clone();
    }
}

