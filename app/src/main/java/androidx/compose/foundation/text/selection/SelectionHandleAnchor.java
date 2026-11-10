package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/selection/SelectionHandleAnchor;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "Middle", "Right", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SelectionHandleAnchor {
    public static final enum SelectionHandleAnchor Left;
    public static final enum SelectionHandleAnchor Middle;
    public static final enum SelectionHandleAnchor Right;

    private static final SelectionHandleAnchor[] $values() {
        return new SelectionHandleAnchor[]{SelectionHandleAnchor.Left, SelectionHandleAnchor.Middle, SelectionHandleAnchor.Right};
    }

    static {
        SelectionHandleAnchor.Left = new SelectionHandleAnchor("Left", 0);
        SelectionHandleAnchor.Middle = new SelectionHandleAnchor("Middle", 1);
        SelectionHandleAnchor.Right = new SelectionHandleAnchor("Right", 2);
        SelectionHandleAnchor[] v0 = SelectionHandleAnchor.$values();
        SelectionHandleAnchor.$VALUES = v0;
        SelectionHandleAnchor.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SelectionHandleAnchor(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SelectionHandleAnchor.$ENTRIES;
    }

    public static SelectionHandleAnchor valueOf(String arg1) {
        return Enum.valueOf(SelectionHandleAnchor.class, arg1);
    }

    public static SelectionHandleAnchor[] values() {
        return SelectionHandleAnchor.$VALUES.clone();
    }
}

