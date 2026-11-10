package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/selection/Direction;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE", "ON", "AFTER", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum Direction {
    public static final enum Direction AFTER;
    public static final enum Direction BEFORE;
    public static final enum Direction ON;

    private static final Direction[] $values() {
        return new Direction[]{Direction.BEFORE, Direction.ON, Direction.AFTER};
    }

    static {
        Direction.BEFORE = new Direction("BEFORE", 0);
        Direction.ON = new Direction("ON", 1);
        Direction.AFTER = new Direction("AFTER", 2);
        Direction[] v0 = Direction.$values();
        Direction.$VALUES = v0;
        Direction.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private Direction(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return Direction.$ENTRIES;
    }

    public static Direction valueOf(String arg1) {
        return Enum.valueOf(Direction.class, arg1);
    }

    public static Direction[] values() {
        return Direction.$VALUES.clone();
    }
}

