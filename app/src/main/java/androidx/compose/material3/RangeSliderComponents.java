package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/material3/RangeSliderComponents;", "", "<init>", "(Ljava/lang/String;I)V", "ENDTHUMB", "STARTTHUMB", "TRACK", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) enum RangeSliderComponents {
    public static final enum RangeSliderComponents ENDTHUMB;
    public static final enum RangeSliderComponents STARTTHUMB;
    public static final enum RangeSliderComponents TRACK;

    private static final RangeSliderComponents[] $values() {
        return new RangeSliderComponents[]{RangeSliderComponents.ENDTHUMB, RangeSliderComponents.STARTTHUMB, RangeSliderComponents.TRACK};
    }

    static {
        RangeSliderComponents.ENDTHUMB = new RangeSliderComponents("ENDTHUMB", 0);
        RangeSliderComponents.STARTTHUMB = new RangeSliderComponents("STARTTHUMB", 1);
        RangeSliderComponents.TRACK = new RangeSliderComponents("TRACK", 2);
        RangeSliderComponents[] v0 = RangeSliderComponents.$values();
        RangeSliderComponents.$VALUES = v0;
        RangeSliderComponents.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private RangeSliderComponents(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return RangeSliderComponents.$ENTRIES;
    }

    public static RangeSliderComponents valueOf(String arg1) {
        return Enum.valueOf(RangeSliderComponents.class, arg1);
    }

    public static RangeSliderComponents[] values() {
        return RangeSliderComponents.$VALUES.clone();
    }
}

