package androidx.compose.foundation.text.input.internal.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Cursor", "Selection", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum TextToolbarState {
    public static final enum TextToolbarState Cursor;
    public static final enum TextToolbarState None;
    public static final enum TextToolbarState Selection;

    private static final TextToolbarState[] $values() {
        return new TextToolbarState[]{TextToolbarState.None, TextToolbarState.Cursor, TextToolbarState.Selection};
    }

    static {
        TextToolbarState.None = new TextToolbarState("None", 0);
        TextToolbarState.Cursor = new TextToolbarState("Cursor", 1);
        TextToolbarState.Selection = new TextToolbarState("Selection", 2);
        TextToolbarState[] v0 = TextToolbarState.$values();
        TextToolbarState.$VALUES = v0;
        TextToolbarState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TextToolbarState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TextToolbarState.$ENTRIES;
    }

    public static TextToolbarState valueOf(String arg1) {
        return Enum.valueOf(TextToolbarState.class, arg1);
    }

    public static TextToolbarState[] values() {
        return TextToolbarState.$VALUES.clone();
    }
}

