package kotlin.io.path;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lkotlin/io/path/OnErrorResult;", "", "<init>", "(Ljava/lang/String;I)V", "SKIP_SUBTREE", "TERMINATE", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) public enum OnErrorResult {
    public static final enum OnErrorResult SKIP_SUBTREE;
    public static final enum OnErrorResult TERMINATE;

    private static final OnErrorResult[] $values() {
        return new OnErrorResult[]{OnErrorResult.SKIP_SUBTREE, OnErrorResult.TERMINATE};
    }

    static {
        OnErrorResult.SKIP_SUBTREE = new OnErrorResult("SKIP_SUBTREE", 0);
        OnErrorResult.TERMINATE = new OnErrorResult("TERMINATE", 1);
        OnErrorResult[] v0 = OnErrorResult.$values();
        OnErrorResult.$VALUES = v0;
        OnErrorResult.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private OnErrorResult(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return OnErrorResult.$ENTRIES;
    }

    public static OnErrorResult valueOf(String arg1) {
        return Enum.valueOf(OnErrorResult.class, arg1);
    }

    public static OnErrorResult[] values() {
        return OnErrorResult.$VALUES.clone();
    }
}

