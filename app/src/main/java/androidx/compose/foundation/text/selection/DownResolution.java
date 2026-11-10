package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/selection/DownResolution;", "", "<init>", "(Ljava/lang/String;I)V", "Up", "Drag", "Timeout", "Cancel", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) enum DownResolution {
    public static final enum DownResolution Cancel;
    public static final enum DownResolution Drag;
    public static final enum DownResolution Timeout;
    public static final enum DownResolution Up;

    private static final DownResolution[] $values() {
        return new DownResolution[]{DownResolution.Up, DownResolution.Drag, DownResolution.Timeout, DownResolution.Cancel};
    }

    static {
        DownResolution.Up = new DownResolution("Up", 0);
        DownResolution.Drag = new DownResolution("Drag", 1);
        DownResolution.Timeout = new DownResolution("Timeout", 2);
        DownResolution.Cancel = new DownResolution("Cancel", 3);
        DownResolution[] v0 = DownResolution.$values();
        DownResolution.$VALUES = v0;
        DownResolution.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private DownResolution(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return DownResolution.$ENTRIES;
    }

    public static DownResolution valueOf(String arg1) {
        return Enum.valueOf(DownResolution.class, arg1);
    }

    public static DownResolution[] values() {
        return DownResolution.$VALUES.clone();
    }
}

