package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/platform/TextToolbarStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Shown", "Hidden", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum TextToolbarStatus {
    public static final enum TextToolbarStatus Hidden;
    public static final enum TextToolbarStatus Shown;

    private static final TextToolbarStatus[] $values() {
        return new TextToolbarStatus[]{TextToolbarStatus.Shown, TextToolbarStatus.Hidden};
    }

    static {
        TextToolbarStatus.Shown = new TextToolbarStatus("Shown", 0);
        TextToolbarStatus.Hidden = new TextToolbarStatus("Hidden", 1);
        TextToolbarStatus[] v0 = TextToolbarStatus.$values();
        TextToolbarStatus.$VALUES = v0;
        TextToolbarStatus.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TextToolbarStatus(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TextToolbarStatus.$ENTRIES;
    }

    public static TextToolbarStatus valueOf(String arg1) {
        return Enum.valueOf(TextToolbarStatus.class, arg1);
    }

    public static TextToolbarStatus[] values() {
        return TextToolbarStatus.$VALUES.clone();
    }
}

