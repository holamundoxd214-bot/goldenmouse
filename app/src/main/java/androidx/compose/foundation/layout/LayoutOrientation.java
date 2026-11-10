package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/layout/LayoutOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Horizontal", "Vertical", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public enum LayoutOrientation {
    public static final enum LayoutOrientation Horizontal;
    public static final enum LayoutOrientation Vertical;

    private static final LayoutOrientation[] $values() {
        return new LayoutOrientation[]{LayoutOrientation.Horizontal, LayoutOrientation.Vertical};
    }

    static {
        LayoutOrientation.Horizontal = new LayoutOrientation("Horizontal", 0);
        LayoutOrientation.Vertical = new LayoutOrientation("Vertical", 1);
        LayoutOrientation[] v0 = LayoutOrientation.$values();
        LayoutOrientation.$VALUES = v0;
        LayoutOrientation.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private LayoutOrientation(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return LayoutOrientation.$ENTRIES;
    }

    public static LayoutOrientation valueOf(String arg1) {
        return Enum.valueOf(LayoutOrientation.class, arg1);
    }

    public static LayoutOrientation[] values() {
        return LayoutOrientation.$VALUES.clone();
    }
}

