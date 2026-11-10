package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/unit/LayoutDirection;", "", "<init>", "(Ljava/lang/String;I)V", "Ltr", "Rtl", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public enum LayoutDirection {
    public static final enum LayoutDirection Ltr;
    public static final enum LayoutDirection Rtl;

    private static final LayoutDirection[] $values() {
        return new LayoutDirection[]{LayoutDirection.Ltr, LayoutDirection.Rtl};
    }

    static {
        LayoutDirection.Ltr = new LayoutDirection("Ltr", 0);
        LayoutDirection.Rtl = new LayoutDirection("Rtl", 1);
        LayoutDirection[] v0 = LayoutDirection.$values();
        LayoutDirection.$VALUES = v0;
        LayoutDirection.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private LayoutDirection(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return LayoutDirection.$ENTRIES;
    }

    public static LayoutDirection valueOf(String arg1) {
        return Enum.valueOf(LayoutDirection.class, arg1);
    }

    public static LayoutDirection[] values() {
        return LayoutDirection.$VALUES.clone();
    }
}

