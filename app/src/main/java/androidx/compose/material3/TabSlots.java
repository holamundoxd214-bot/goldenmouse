package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/material3/TabSlots;", "", "<init>", "(Ljava/lang/String;I)V", "Tabs", "Divider", "Indicator", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) enum TabSlots {
    public static final enum TabSlots Divider;
    public static final enum TabSlots Indicator;
    public static final enum TabSlots Tabs;

    private static final TabSlots[] $values() {
        return new TabSlots[]{TabSlots.Tabs, TabSlots.Divider, TabSlots.Indicator};
    }

    static {
        TabSlots.Tabs = new TabSlots("Tabs", 0);
        TabSlots.Divider = new TabSlots("Divider", 1);
        TabSlots.Indicator = new TabSlots("Indicator", 2);
        TabSlots[] v0 = TabSlots.$values();
        TabSlots.$VALUES = v0;
        TabSlots.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TabSlots(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TabSlots.$ENTRIES;
    }

    public static TabSlots valueOf(String arg1) {
        return Enum.valueOf(TabSlots.class, arg1);
    }

    public static TabSlots[] values() {
        return TabSlots.$VALUES.clone();
    }
}

