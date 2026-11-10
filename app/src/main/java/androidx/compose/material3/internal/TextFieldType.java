package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/material3/internal/TextFieldType;", "", "<init>", "(Ljava/lang/String;I)V", "Filled", "Outlined", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum TextFieldType {
    public static final enum TextFieldType Filled;
    public static final enum TextFieldType Outlined;

    private static final TextFieldType[] $values() {
        return new TextFieldType[]{TextFieldType.Filled, TextFieldType.Outlined};
    }

    static {
        TextFieldType.Filled = new TextFieldType("Filled", 0);
        TextFieldType.Outlined = new TextFieldType("Outlined", 1);
        TextFieldType[] v0 = TextFieldType.$values();
        TextFieldType.$VALUES = v0;
        TextFieldType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TextFieldType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TextFieldType.$ENTRIES;
    }

    public static TextFieldType valueOf(String arg1) {
        return Enum.valueOf(TextFieldType.class, arg1);
    }

    public static TextFieldType[] values() {
        return TextFieldType.$VALUES.clone();
    }
}

