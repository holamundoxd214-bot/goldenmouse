package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/Handle;", "", "<init>", "(Ljava/lang/String;I)V", "Cursor", "SelectionStart", "SelectionEnd", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum Handle {
    public static final enum Handle Cursor;
    public static final enum Handle SelectionEnd;
    public static final enum Handle SelectionStart;

    private static final Handle[] $values() {
        return new Handle[]{Handle.Cursor, Handle.SelectionStart, Handle.SelectionEnd};
    }

    static {
        Handle.Cursor = new Handle("Cursor", 0);
        Handle.SelectionStart = new Handle("SelectionStart", 1);
        Handle.SelectionEnd = new Handle("SelectionEnd", 2);
        Handle[] v0 = Handle.$values();
        Handle.$VALUES = v0;
        Handle.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private Handle(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return Handle.$ENTRIES;
    }

    public static Handle valueOf(String arg1) {
        return Enum.valueOf(Handle.class, arg1);
    }

    public static Handle[] values() {
        return Handle.$VALUES.clone();
    }
}

