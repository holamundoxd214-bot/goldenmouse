package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESSFUL", "REREGISTER", "CANCELLED", "ALREADY_SELECTED", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public enum TrySelectDetailedResult {
    public static final enum TrySelectDetailedResult ALREADY_SELECTED;
    public static final enum TrySelectDetailedResult CANCELLED;
    public static final enum TrySelectDetailedResult REREGISTER;
    public static final enum TrySelectDetailedResult SUCCESSFUL;

    private static final TrySelectDetailedResult[] $values() {
        return new TrySelectDetailedResult[]{TrySelectDetailedResult.SUCCESSFUL, TrySelectDetailedResult.REREGISTER, TrySelectDetailedResult.CANCELLED, TrySelectDetailedResult.ALREADY_SELECTED};
    }

    static {
        TrySelectDetailedResult.SUCCESSFUL = new TrySelectDetailedResult("SUCCESSFUL", 0);
        TrySelectDetailedResult.REREGISTER = new TrySelectDetailedResult("REREGISTER", 1);
        TrySelectDetailedResult.CANCELLED = new TrySelectDetailedResult("CANCELLED", 2);
        TrySelectDetailedResult.ALREADY_SELECTED = new TrySelectDetailedResult("ALREADY_SELECTED", 3);
        TrySelectDetailedResult[] v0 = TrySelectDetailedResult.$values();
        TrySelectDetailedResult.$VALUES = v0;
        TrySelectDetailedResult.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TrySelectDetailedResult(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TrySelectDetailedResult.$ENTRIES;
    }

    public static TrySelectDetailedResult valueOf(String arg1) {
        return Enum.valueOf(TrySelectDetailedResult.class, arg1);
    }

    public static TrySelectDetailedResult[] values() {
        return TrySelectDetailedResult.$VALUES.clone();
    }
}

