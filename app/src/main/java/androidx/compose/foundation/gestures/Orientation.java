package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/gestures/Orientation;", "", "<init>", "(Ljava/lang/String;I)V", "Vertical", "Horizontal", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum Orientation {
    public static final enum Orientation Horizontal;
    public static final enum Orientation Vertical;

    private static final Orientation[] $values() {
        return new Orientation[]{Orientation.Vertical, Orientation.Horizontal};
    }

    static {
        Orientation.Vertical = new Orientation("Vertical", 0);
        Orientation.Horizontal = new Orientation("Horizontal", 1);
        Orientation[] v0 = Orientation.$values();
        Orientation.$VALUES = v0;
        Orientation.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private Orientation(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return Orientation.$ENTRIES;
    }

    public static Orientation valueOf(String arg1) {
        return Enum.valueOf(Orientation.class, arg1);
    }

    public static Orientation[] values() {
        return Orientation.$VALUES.clone();
    }
}

