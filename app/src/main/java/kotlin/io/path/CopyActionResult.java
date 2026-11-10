package kotlin.io.path;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlin/io/path/CopyActionResult;", "", "<init>", "(Ljava/lang/String;I)V", "CONTINUE", "SKIP_SUBTREE", "TERMINATE", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) public enum CopyActionResult {
    public static final enum CopyActionResult CONTINUE;
    public static final enum CopyActionResult SKIP_SUBTREE;
    public static final enum CopyActionResult TERMINATE;

    private static final CopyActionResult[] $values() {
        return new CopyActionResult[]{CopyActionResult.CONTINUE, CopyActionResult.SKIP_SUBTREE, CopyActionResult.TERMINATE};
    }

    static {
        CopyActionResult.CONTINUE = new CopyActionResult("CONTINUE", 0);
        CopyActionResult.SKIP_SUBTREE = new CopyActionResult("SKIP_SUBTREE", 1);
        CopyActionResult.TERMINATE = new CopyActionResult("TERMINATE", 2);
        CopyActionResult[] v0 = CopyActionResult.$values();
        CopyActionResult.$VALUES = v0;
        CopyActionResult.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CopyActionResult(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CopyActionResult.$ENTRIES;
    }

    public static CopyActionResult valueOf(String arg1) {
        return Enum.valueOf(CopyActionResult.class, arg1);
    }

    public static CopyActionResult[] values() {
        return CopyActionResult.$VALUES.clone();
    }
}

