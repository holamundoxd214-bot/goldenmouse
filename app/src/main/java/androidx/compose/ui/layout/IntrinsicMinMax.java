package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/layout/IntrinsicMinMax;", "", "<init>", "(Ljava/lang/String;I)V", "Min", "Max", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum IntrinsicMinMax {
    public static final enum IntrinsicMinMax Max;
    public static final enum IntrinsicMinMax Min;

    private static final IntrinsicMinMax[] $values() {
        return new IntrinsicMinMax[]{IntrinsicMinMax.Min, IntrinsicMinMax.Max};
    }

    static {
        IntrinsicMinMax.Min = new IntrinsicMinMax("Min", 0);
        IntrinsicMinMax.Max = new IntrinsicMinMax("Max", 1);
        IntrinsicMinMax[] v0 = IntrinsicMinMax.$values();
        IntrinsicMinMax.$VALUES = v0;
        IntrinsicMinMax.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private IntrinsicMinMax(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return IntrinsicMinMax.$ENTRIES;
    }

    public static IntrinsicMinMax valueOf(String arg1) {
        return Enum.valueOf(IntrinsicMinMax.class, arg1);
    }

    public static IntrinsicMinMax[] values() {
        return IntrinsicMinMax.$VALUES.clone();
    }
}

