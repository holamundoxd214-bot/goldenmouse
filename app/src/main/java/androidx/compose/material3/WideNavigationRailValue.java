package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/material3/WideNavigationRailValue;", "", "<init>", "(Ljava/lang/String;I)V", "Collapsed", "Expanded", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum WideNavigationRailValue {
    public static final enum WideNavigationRailValue Collapsed;
    public static final enum WideNavigationRailValue Expanded;

    private static final WideNavigationRailValue[] $values() {
        return new WideNavigationRailValue[]{WideNavigationRailValue.Collapsed, WideNavigationRailValue.Expanded};
    }

    static {
        WideNavigationRailValue.Collapsed = new WideNavigationRailValue("Collapsed", 0);
        WideNavigationRailValue.Expanded = new WideNavigationRailValue("Expanded", 1);
        WideNavigationRailValue[] v0 = WideNavigationRailValue.$values();
        WideNavigationRailValue.$VALUES = v0;
        WideNavigationRailValue.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private WideNavigationRailValue(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return WideNavigationRailValue.$ENTRIES;
    }

    public static WideNavigationRailValue valueOf(String arg1) {
        return Enum.valueOf(WideNavigationRailValue.class, arg1);
    }

    public static WideNavigationRailValue[] values() {
        return WideNavigationRailValue.$VALUES.clone();
    }
}

