package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/material3/SheetValue;", "", "<init>", "(Ljava/lang/String;I)V", "Hidden", "Expanded", "PartiallyExpanded", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SheetValue {
    public static final enum SheetValue Expanded;
    public static final enum SheetValue Hidden;
    public static final enum SheetValue PartiallyExpanded;

    private static final SheetValue[] $values() {
        return new SheetValue[]{SheetValue.Hidden, SheetValue.Expanded, SheetValue.PartiallyExpanded};
    }

    static {
        SheetValue.Hidden = new SheetValue("Hidden", 0);
        SheetValue.Expanded = new SheetValue("Expanded", 1);
        SheetValue.PartiallyExpanded = new SheetValue("PartiallyExpanded", 2);
        SheetValue[] v0 = SheetValue.$values();
        SheetValue.$VALUES = v0;
        SheetValue.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SheetValue(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SheetValue.$ENTRIES;
    }

    public static SheetValue valueOf(String arg1) {
        return Enum.valueOf(SheetValue.class, arg1);
    }

    public static SheetValue[] values() {
        return SheetValue.$VALUES.clone();
    }
}

