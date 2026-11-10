package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/material3/SwipeToDismissBoxValue;", "", "<init>", "(Ljava/lang/String;I)V", "StartToEnd", "EndToStart", "Settled", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SwipeToDismissBoxValue {
    public static final enum SwipeToDismissBoxValue EndToStart;
    public static final enum SwipeToDismissBoxValue Settled;
    public static final enum SwipeToDismissBoxValue StartToEnd;

    private static final SwipeToDismissBoxValue[] $values() {
        return new SwipeToDismissBoxValue[]{SwipeToDismissBoxValue.StartToEnd, SwipeToDismissBoxValue.EndToStart, SwipeToDismissBoxValue.Settled};
    }

    static {
        SwipeToDismissBoxValue.StartToEnd = new SwipeToDismissBoxValue("StartToEnd", 0);
        SwipeToDismissBoxValue.EndToStart = new SwipeToDismissBoxValue("EndToStart", 1);
        SwipeToDismissBoxValue.Settled = new SwipeToDismissBoxValue("Settled", 2);
        SwipeToDismissBoxValue[] v0 = SwipeToDismissBoxValue.$values();
        SwipeToDismissBoxValue.$VALUES = v0;
        SwipeToDismissBoxValue.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SwipeToDismissBoxValue(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SwipeToDismissBoxValue.$ENTRIES;
    }

    public static SwipeToDismissBoxValue valueOf(String arg1) {
        return Enum.valueOf(SwipeToDismissBoxValue.class, arg1);
    }

    public static SwipeToDismissBoxValue[] values() {
        return SwipeToDismissBoxValue.$VALUES.clone();
    }
}

