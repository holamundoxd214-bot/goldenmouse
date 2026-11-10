package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/material3/DrawerValue;", "", "<init>", "(Ljava/lang/String;I)V", "Closed", "Open", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum DrawerValue {
    public static final enum DrawerValue Closed;
    public static final enum DrawerValue Open;

    private static final DrawerValue[] $values() {
        return new DrawerValue[]{DrawerValue.Closed, DrawerValue.Open};
    }

    static {
        DrawerValue.Closed = new DrawerValue("Closed", 0);
        DrawerValue.Open = new DrawerValue("Open", 1);
        DrawerValue[] v0 = DrawerValue.$values();
        DrawerValue.$VALUES = v0;
        DrawerValue.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private DrawerValue(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return DrawerValue.$ENTRIES;
    }

    public static DrawerValue valueOf(String arg1) {
        return Enum.valueOf(DrawerValue.class, arg1);
    }

    public static DrawerValue[] values() {
        return DrawerValue.$VALUES.clone();
    }
}

