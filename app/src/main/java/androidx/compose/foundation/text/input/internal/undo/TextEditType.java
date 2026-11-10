package androidx.compose.foundation.text.input.internal.undo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "", "<init>", "(Ljava/lang/String;I)V", "Insert", "Delete", "Replace", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum TextEditType {
    public static final enum TextEditType Delete;
    public static final enum TextEditType Insert;
    public static final enum TextEditType Replace;

    private static final TextEditType[] $values() {
        return new TextEditType[]{TextEditType.Insert, TextEditType.Delete, TextEditType.Replace};
    }

    static {
        TextEditType.Insert = new TextEditType("Insert", 0);
        TextEditType.Delete = new TextEditType("Delete", 1);
        TextEditType.Replace = new TextEditType("Replace", 2);
        TextEditType[] v0 = TextEditType.$values();
        TextEditType.$VALUES = v0;
        TextEditType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TextEditType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TextEditType.$ENTRIES;
    }

    public static TextEditType valueOf(String arg1) {
        return Enum.valueOf(TextEditType.class, arg1);
    }

    public static TextEditType[] values() {
        return TextEditType.$VALUES.clone();
    }
}

