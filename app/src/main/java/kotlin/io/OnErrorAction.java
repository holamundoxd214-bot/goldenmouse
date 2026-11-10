package kotlin.io;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lkotlin/io/OnErrorAction;", "", "<init>", "(Ljava/lang/String;I)V", "SKIP", "TERMINATE", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum OnErrorAction {
    public static final enum OnErrorAction SKIP;
    public static final enum OnErrorAction TERMINATE;

    private static final OnErrorAction[] $values() {
        return new OnErrorAction[]{OnErrorAction.SKIP, OnErrorAction.TERMINATE};
    }

    static {
        OnErrorAction.SKIP = new OnErrorAction("SKIP", 0);
        OnErrorAction.TERMINATE = new OnErrorAction("TERMINATE", 1);
        OnErrorAction[] v0 = OnErrorAction.$values();
        OnErrorAction.$VALUES = v0;
        OnErrorAction.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private OnErrorAction(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return OnErrorAction.$ENTRIES;
    }

    public static OnErrorAction valueOf(String arg1) {
        return Enum.valueOf(OnErrorAction.class, arg1);
    }

    public static OnErrorAction[] values() {
        return OnErrorAction.$VALUES.clone();
    }
}

