package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/material3/LayoutId;", "", "<init>", "(Ljava/lang/String;I)V", "Selector", "InnerCircle", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) enum LayoutId {
    public static final enum LayoutId InnerCircle;
    public static final enum LayoutId Selector;

    private static final LayoutId[] $values() {
        return new LayoutId[]{LayoutId.Selector, LayoutId.InnerCircle};
    }

    static {
        LayoutId.Selector = new LayoutId("Selector", 0);
        LayoutId.InnerCircle = new LayoutId("InnerCircle", 1);
        LayoutId[] v0 = LayoutId.$values();
        LayoutId.$VALUES = v0;
        LayoutId.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private LayoutId(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return LayoutId.$ENTRIES;
    }

    public static LayoutId valueOf(String arg1) {
        return Enum.valueOf(LayoutId.class, arg1);
    }

    public static LayoutId[] values() {
        return LayoutId.$VALUES.clone();
    }
}

