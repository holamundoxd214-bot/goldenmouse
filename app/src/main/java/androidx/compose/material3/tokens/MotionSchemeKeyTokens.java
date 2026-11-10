package androidx.compose.material3.tokens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Landroidx/compose/material3/tokens/MotionSchemeKeyTokens;", "", "<init>", "(Ljava/lang/String;I)V", "DefaultSpatial", "FastSpatial", "SlowSpatial", "DefaultEffects", "FastEffects", "SlowEffects", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum MotionSchemeKeyTokens {
    public static final enum MotionSchemeKeyTokens DefaultEffects;
    public static final enum MotionSchemeKeyTokens DefaultSpatial;
    public static final enum MotionSchemeKeyTokens FastEffects;
    public static final enum MotionSchemeKeyTokens FastSpatial;
    public static final enum MotionSchemeKeyTokens SlowEffects;
    public static final enum MotionSchemeKeyTokens SlowSpatial;

    private static final MotionSchemeKeyTokens[] $values() {
        return new MotionSchemeKeyTokens[]{MotionSchemeKeyTokens.DefaultSpatial, MotionSchemeKeyTokens.FastSpatial, MotionSchemeKeyTokens.SlowSpatial, MotionSchemeKeyTokens.DefaultEffects, MotionSchemeKeyTokens.FastEffects, MotionSchemeKeyTokens.SlowEffects};
    }

    static {
        MotionSchemeKeyTokens.DefaultSpatial = new MotionSchemeKeyTokens("DefaultSpatial", 0);
        MotionSchemeKeyTokens.FastSpatial = new MotionSchemeKeyTokens("FastSpatial", 1);
        MotionSchemeKeyTokens.SlowSpatial = new MotionSchemeKeyTokens("SlowSpatial", 2);
        MotionSchemeKeyTokens.DefaultEffects = new MotionSchemeKeyTokens("DefaultEffects", 3);
        MotionSchemeKeyTokens.FastEffects = new MotionSchemeKeyTokens("FastEffects", 4);
        MotionSchemeKeyTokens.SlowEffects = new MotionSchemeKeyTokens("SlowEffects", 5);
        MotionSchemeKeyTokens[] v0 = MotionSchemeKeyTokens.$values();
        MotionSchemeKeyTokens.$VALUES = v0;
        MotionSchemeKeyTokens.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private MotionSchemeKeyTokens(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return MotionSchemeKeyTokens.$ENTRIES;
    }

    public static MotionSchemeKeyTokens valueOf(String arg1) {
        return Enum.valueOf(MotionSchemeKeyTokens.class, arg1);
    }

    public static MotionSchemeKeyTokens[] values() {
        return MotionSchemeKeyTokens.$VALUES.clone();
    }
}

