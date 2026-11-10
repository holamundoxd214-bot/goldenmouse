package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/text/style/ResolvedTextDirection;", "", "<init>", "(Ljava/lang/String;I)V", "Ltr", "Rtl", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public enum ResolvedTextDirection {
    public static final enum ResolvedTextDirection Ltr;
    public static final enum ResolvedTextDirection Rtl;

    private static final ResolvedTextDirection[] $values() {
        return new ResolvedTextDirection[]{ResolvedTextDirection.Ltr, ResolvedTextDirection.Rtl};
    }

    static {
        ResolvedTextDirection.Ltr = new ResolvedTextDirection("Ltr", 0);
        ResolvedTextDirection.Rtl = new ResolvedTextDirection("Rtl", 1);
        ResolvedTextDirection[] v0 = ResolvedTextDirection.$values();
        ResolvedTextDirection.$VALUES = v0;
        ResolvedTextDirection.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ResolvedTextDirection(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ResolvedTextDirection.$ENTRIES;
    }

    public static ResolvedTextDirection valueOf(String arg1) {
        return Enum.valueOf(ResolvedTextDirection.class, arg1);
    }

    public static ResolvedTextDirection[] values() {
        return ResolvedTextDirection.$VALUES.clone();
    }
}

