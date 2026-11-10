package kotlin.contracts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lkotlin/contracts/InvocationKind;", "", "<init>", "(Ljava/lang/String;I)V", "AT_MOST_ONCE", "AT_LEAST_ONCE", "EXACTLY_ONCE", "UNKNOWN", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum InvocationKind {
    public static final enum InvocationKind AT_LEAST_ONCE;
    public static final enum InvocationKind AT_MOST_ONCE;
    public static final enum InvocationKind EXACTLY_ONCE;
    public static final enum InvocationKind UNKNOWN;

    private static final InvocationKind[] $values() {
        return new InvocationKind[]{InvocationKind.AT_MOST_ONCE, InvocationKind.AT_LEAST_ONCE, InvocationKind.EXACTLY_ONCE, InvocationKind.UNKNOWN};
    }

    static {
        InvocationKind.AT_MOST_ONCE = new InvocationKind("AT_MOST_ONCE", 0);
        InvocationKind.AT_LEAST_ONCE = new InvocationKind("AT_LEAST_ONCE", 1);
        InvocationKind.EXACTLY_ONCE = new InvocationKind("EXACTLY_ONCE", 2);
        InvocationKind.UNKNOWN = new InvocationKind("UNKNOWN", 3);
        InvocationKind[] v0 = InvocationKind.$values();
        InvocationKind.$VALUES = v0;
        InvocationKind.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private InvocationKind(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return InvocationKind.$ENTRIES;
    }

    public static InvocationKind valueOf(String arg1) {
        return Enum.valueOf(InvocationKind.class, arg1);
    }

    public static InvocationKind[] values() {
        return InvocationKind.$VALUES.clone();
    }
}

