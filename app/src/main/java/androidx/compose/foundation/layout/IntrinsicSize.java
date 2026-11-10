package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/layout/IntrinsicSize;", "", "<init>", "(Ljava/lang/String;I)V", "Min", "Max", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public enum IntrinsicSize {
    public static final enum IntrinsicSize Max;
    public static final enum IntrinsicSize Min;

    private static final IntrinsicSize[] $values() {
        return new IntrinsicSize[]{IntrinsicSize.Min, IntrinsicSize.Max};
    }

    static {
        IntrinsicSize.Min = new IntrinsicSize("Min", 0);
        IntrinsicSize.Max = new IntrinsicSize("Max", 1);
        IntrinsicSize[] v0 = IntrinsicSize.$values();
        IntrinsicSize.$VALUES = v0;
        IntrinsicSize.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private IntrinsicSize(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return IntrinsicSize.$ENTRIES;
    }

    public static IntrinsicSize valueOf(String arg1) {
        return Enum.valueOf(IntrinsicSize.class, arg1);
    }

    public static IntrinsicSize[] values() {
        return IntrinsicSize.$VALUES.clone();
    }
}

