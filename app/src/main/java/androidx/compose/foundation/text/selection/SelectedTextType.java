package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/text/selection/SelectedTextType;", "", "<init>", "(Ljava/lang/String;I)V", "EditableText", "StaticText", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SelectedTextType {
    public static final enum SelectedTextType EditableText;
    public static final enum SelectedTextType StaticText;

    private static final SelectedTextType[] $values() {
        return new SelectedTextType[]{SelectedTextType.EditableText, SelectedTextType.StaticText};
    }

    static {
        SelectedTextType.EditableText = new SelectedTextType("EditableText", 0);
        SelectedTextType.StaticText = new SelectedTextType("StaticText", 1);
        SelectedTextType[] v0 = SelectedTextType.$values();
        SelectedTextType.$VALUES = v0;
        SelectedTextType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SelectedTextType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SelectedTextType.$ENTRIES;
    }

    public static SelectedTextType valueOf(String arg1) {
        return Enum.valueOf(SelectedTextType.class, arg1);
    }

    public static SelectedTextType[] values() {
        return SelectedTextType.$VALUES.clone();
    }
}

