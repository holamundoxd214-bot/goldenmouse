package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "", "<init>", "(Ljava/lang/String;I)V", "Width", "Height", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum IntrinsicWidthHeight {
    public static final enum IntrinsicWidthHeight Height;
    public static final enum IntrinsicWidthHeight Width;

    private static final IntrinsicWidthHeight[] $values() {
        return new IntrinsicWidthHeight[]{IntrinsicWidthHeight.Width, IntrinsicWidthHeight.Height};
    }

    static {
        IntrinsicWidthHeight.Width = new IntrinsicWidthHeight("Width", 0);
        IntrinsicWidthHeight.Height = new IntrinsicWidthHeight("Height", 1);
        IntrinsicWidthHeight[] v0 = IntrinsicWidthHeight.$values();
        IntrinsicWidthHeight.$VALUES = v0;
        IntrinsicWidthHeight.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private IntrinsicWidthHeight(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return IntrinsicWidthHeight.$ENTRIES;
    }

    public static IntrinsicWidthHeight valueOf(String arg1) {
        return Enum.valueOf(IntrinsicWidthHeight.class, arg1);
    }

    public static IntrinsicWidthHeight[] values() {
        return IntrinsicWidthHeight.$VALUES.clone();
    }
}

