package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "End", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum WedgeAffinity {
    public static final enum WedgeAffinity End;
    public static final enum WedgeAffinity Start;

    private static final WedgeAffinity[] $values() {
        return new WedgeAffinity[]{WedgeAffinity.Start, WedgeAffinity.End};
    }

    static {
        WedgeAffinity.Start = new WedgeAffinity("Start", 0);
        WedgeAffinity.End = new WedgeAffinity("End", 1);
        WedgeAffinity[] v0 = WedgeAffinity.$values();
        WedgeAffinity.$VALUES = v0;
        WedgeAffinity.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private WedgeAffinity(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return WedgeAffinity.$ENTRIES;
    }

    public static WedgeAffinity valueOf(String arg1) {
        return Enum.valueOf(WedgeAffinity.class, arg1);
    }

    public static WedgeAffinity[] values() {
        return WedgeAffinity.$VALUES.clone();
    }
}

