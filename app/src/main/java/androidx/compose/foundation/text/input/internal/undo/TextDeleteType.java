package androidx.compose.foundation.text.input.internal.undo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "End", "Inner", "NotByUser", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum TextDeleteType {
    public static final enum TextDeleteType End;
    public static final enum TextDeleteType Inner;
    public static final enum TextDeleteType NotByUser;
    public static final enum TextDeleteType Start;

    private static final TextDeleteType[] $values() {
        return new TextDeleteType[]{TextDeleteType.Start, TextDeleteType.End, TextDeleteType.Inner, TextDeleteType.NotByUser};
    }

    static {
        TextDeleteType.Start = new TextDeleteType("Start", 0);
        TextDeleteType.End = new TextDeleteType("End", 1);
        TextDeleteType.Inner = new TextDeleteType("Inner", 2);
        TextDeleteType.NotByUser = new TextDeleteType("NotByUser", 3);
        TextDeleteType[] v0 = TextDeleteType.$values();
        TextDeleteType.$VALUES = v0;
        TextDeleteType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TextDeleteType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TextDeleteType.$ENTRIES;
    }

    public static TextDeleteType valueOf(String arg1) {
        return Enum.valueOf(TextDeleteType.class, arg1);
    }

    public static TextDeleteType[] values() {
        return TextDeleteType.$VALUES.clone();
    }
}

