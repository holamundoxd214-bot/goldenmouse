package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/HandleState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Selection", "Cursor", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum HandleState {
    public static final enum HandleState Cursor;
    public static final enum HandleState None;
    public static final enum HandleState Selection;

    private static final HandleState[] $values() {
        return new HandleState[]{HandleState.None, HandleState.Selection, HandleState.Cursor};
    }

    static {
        HandleState.None = new HandleState("None", 0);
        HandleState.Selection = new HandleState("Selection", 1);
        HandleState.Cursor = new HandleState("Cursor", 2);
        HandleState[] v0 = HandleState.$values();
        HandleState.$VALUES = v0;
        HandleState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private HandleState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return HandleState.$ENTRIES;
    }

    public static HandleState valueOf(String arg1) {
        return Enum.valueOf(HandleState.class, arg1);
    }

    public static HandleState[] values() {
        return HandleState.$VALUES.clone();
    }
}

