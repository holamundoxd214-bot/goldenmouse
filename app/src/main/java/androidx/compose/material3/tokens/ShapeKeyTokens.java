package androidx.compose.material3.tokens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/material3/tokens/ShapeKeyTokens;", "", "<init>", "(Ljava/lang/String;I)V", "CornerExtraExtraLarge", "CornerExtraLarge", "CornerExtraLargeIncreased", "CornerExtraLargeTop", "CornerExtraSmall", "CornerExtraSmallTop", "CornerFull", "CornerLarge", "CornerLargeEnd", "CornerLargeIncreased", "CornerLargeStart", "CornerLargeTop", "CornerMedium", "CornerNone", "CornerSmall", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum ShapeKeyTokens {
    public static final enum ShapeKeyTokens CornerExtraExtraLarge;
    public static final enum ShapeKeyTokens CornerExtraLarge;
    public static final enum ShapeKeyTokens CornerExtraLargeIncreased;
    public static final enum ShapeKeyTokens CornerExtraLargeTop;
    public static final enum ShapeKeyTokens CornerExtraSmall;
    public static final enum ShapeKeyTokens CornerExtraSmallTop;
    public static final enum ShapeKeyTokens CornerFull;
    public static final enum ShapeKeyTokens CornerLarge;
    public static final enum ShapeKeyTokens CornerLargeEnd;
    public static final enum ShapeKeyTokens CornerLargeIncreased;
    public static final enum ShapeKeyTokens CornerLargeStart;
    public static final enum ShapeKeyTokens CornerLargeTop;
    public static final enum ShapeKeyTokens CornerMedium;
    public static final enum ShapeKeyTokens CornerNone;
    public static final enum ShapeKeyTokens CornerSmall;

    private static final ShapeKeyTokens[] $values() {
        return new ShapeKeyTokens[]{ShapeKeyTokens.CornerExtraExtraLarge, ShapeKeyTokens.CornerExtraLarge, ShapeKeyTokens.CornerExtraLargeIncreased, ShapeKeyTokens.CornerExtraLargeTop, ShapeKeyTokens.CornerExtraSmall, ShapeKeyTokens.CornerExtraSmallTop, ShapeKeyTokens.CornerFull, ShapeKeyTokens.CornerLarge, ShapeKeyTokens.CornerLargeEnd, ShapeKeyTokens.CornerLargeIncreased, ShapeKeyTokens.CornerLargeStart, ShapeKeyTokens.CornerLargeTop, ShapeKeyTokens.CornerMedium, ShapeKeyTokens.CornerNone, ShapeKeyTokens.CornerSmall};
    }

    static {
        ShapeKeyTokens.CornerExtraExtraLarge = new ShapeKeyTokens("CornerExtraExtraLarge", 0);
        ShapeKeyTokens.CornerExtraLarge = new ShapeKeyTokens("CornerExtraLarge", 1);
        ShapeKeyTokens.CornerExtraLargeIncreased = new ShapeKeyTokens("CornerExtraLargeIncreased", 2);
        ShapeKeyTokens.CornerExtraLargeTop = new ShapeKeyTokens("CornerExtraLargeTop", 3);
        ShapeKeyTokens.CornerExtraSmall = new ShapeKeyTokens("CornerExtraSmall", 4);
        ShapeKeyTokens.CornerExtraSmallTop = new ShapeKeyTokens("CornerExtraSmallTop", 5);
        ShapeKeyTokens.CornerFull = new ShapeKeyTokens("CornerFull", 6);
        ShapeKeyTokens.CornerLarge = new ShapeKeyTokens("CornerLarge", 7);
        ShapeKeyTokens.CornerLargeEnd = new ShapeKeyTokens("CornerLargeEnd", 8);
        ShapeKeyTokens.CornerLargeIncreased = new ShapeKeyTokens("CornerLargeIncreased", 9);
        ShapeKeyTokens.CornerLargeStart = new ShapeKeyTokens("CornerLargeStart", 10);
        ShapeKeyTokens.CornerLargeTop = new ShapeKeyTokens("CornerLargeTop", 11);
        ShapeKeyTokens.CornerMedium = new ShapeKeyTokens("CornerMedium", 12);
        ShapeKeyTokens.CornerNone = new ShapeKeyTokens("CornerNone", 13);
        ShapeKeyTokens.CornerSmall = new ShapeKeyTokens("CornerSmall", 14);
        ShapeKeyTokens[] v0 = ShapeKeyTokens.$values();
        ShapeKeyTokens.$VALUES = v0;
        ShapeKeyTokens.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ShapeKeyTokens(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ShapeKeyTokens.$ENTRIES;
    }

    public static ShapeKeyTokens valueOf(String arg1) {
        return Enum.valueOf(ShapeKeyTokens.class, arg1);
    }

    public static ShapeKeyTokens[] values() {
        return ShapeKeyTokens.$VALUES.clone();
    }
}

