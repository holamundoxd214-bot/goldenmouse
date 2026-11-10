package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/node/Invalidation;", "", "<init>", "(Ljava/lang/String;I)V", "LookaheadMeasurement", "LookaheadPlacement", "Measurement", "Placement", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum Invalidation {
    public static final enum Invalidation LookaheadMeasurement;
    public static final enum Invalidation LookaheadPlacement;
    public static final enum Invalidation Measurement;
    public static final enum Invalidation Placement;

    private static final Invalidation[] $values() {
        return new Invalidation[]{Invalidation.LookaheadMeasurement, Invalidation.LookaheadPlacement, Invalidation.Measurement, Invalidation.Placement};
    }

    static {
        Invalidation.LookaheadMeasurement = new Invalidation("LookaheadMeasurement", 0);
        Invalidation.LookaheadPlacement = new Invalidation("LookaheadPlacement", 1);
        Invalidation.Measurement = new Invalidation("Measurement", 2);
        Invalidation.Placement = new Invalidation("Placement", 3);
        Invalidation[] v0 = Invalidation.$values();
        Invalidation.$VALUES = v0;
        Invalidation.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private Invalidation(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return Invalidation.$ENTRIES;
    }

    public static Invalidation valueOf(String arg1) {
        return Enum.valueOf(Invalidation.class, arg1);
    }

    public static Invalidation[] values() {
        return Invalidation.$VALUES.clone();
    }
}

