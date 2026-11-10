package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/material3/SliderComponents;", "", "<init>", "(Ljava/lang/String;I)V", "THUMB", "TRACK", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) enum SliderComponents {
    public static final enum SliderComponents THUMB;
    public static final enum SliderComponents TRACK;

    private static final SliderComponents[] $values() {
        return new SliderComponents[]{SliderComponents.THUMB, SliderComponents.TRACK};
    }

    static {
        SliderComponents.THUMB = new SliderComponents("THUMB", 0);
        SliderComponents.TRACK = new SliderComponents("TRACK", 1);
        SliderComponents[] v0 = SliderComponents.$values();
        SliderComponents.$VALUES = v0;
        SliderComponents.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SliderComponents(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SliderComponents.$ENTRIES;
    }

    public static SliderComponents valueOf(String arg1) {
        return Enum.valueOf(SliderComponents.class, arg1);
    }

    public static SliderComponents[] values() {
        return SliderComponents.$VALUES.clone();
    }
}

