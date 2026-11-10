package androidx.compose.foundation.text.input.internal.undo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "MergeIfPossible", "ClearHistory", "NeverMerge", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum TextFieldEditUndoBehavior {
    public static final enum TextFieldEditUndoBehavior ClearHistory;
    public static final enum TextFieldEditUndoBehavior MergeIfPossible;
    public static final enum TextFieldEditUndoBehavior NeverMerge;

    private static final TextFieldEditUndoBehavior[] $values() {
        return new TextFieldEditUndoBehavior[]{TextFieldEditUndoBehavior.MergeIfPossible, TextFieldEditUndoBehavior.ClearHistory, TextFieldEditUndoBehavior.NeverMerge};
    }

    static {
        TextFieldEditUndoBehavior.MergeIfPossible = new TextFieldEditUndoBehavior("MergeIfPossible", 0);
        TextFieldEditUndoBehavior.ClearHistory = new TextFieldEditUndoBehavior("ClearHistory", 1);
        TextFieldEditUndoBehavior.NeverMerge = new TextFieldEditUndoBehavior("NeverMerge", 2);
        TextFieldEditUndoBehavior[] v0 = TextFieldEditUndoBehavior.$values();
        TextFieldEditUndoBehavior.$VALUES = v0;
        TextFieldEditUndoBehavior.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TextFieldEditUndoBehavior(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TextFieldEditUndoBehavior.$ENTRIES;
    }

    public static TextFieldEditUndoBehavior valueOf(String arg1) {
        return Enum.valueOf(TextFieldEditUndoBehavior.class, arg1);
    }

    public static TextFieldEditUndoBehavior[] values() {
        return TextFieldEditUndoBehavior.$VALUES.clone();
    }
}

