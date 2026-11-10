package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/material3/internal/SwipeEdge;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "Right", "None", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SwipeEdge {
    public static final enum SwipeEdge Left;
    public static final enum SwipeEdge None;
    public static final enum SwipeEdge Right;

    private static final SwipeEdge[] $values() {
        return new SwipeEdge[]{SwipeEdge.Left, SwipeEdge.Right, SwipeEdge.None};
    }

    static {
        SwipeEdge.Left = new SwipeEdge("Left", 0);
        SwipeEdge.Right = new SwipeEdge("Right", 1);
        SwipeEdge.None = new SwipeEdge("None", 2);
        SwipeEdge[] v0 = SwipeEdge.$values();
        SwipeEdge.$VALUES = v0;
        SwipeEdge.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SwipeEdge(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SwipeEdge.$ENTRIES;
    }

    public static SwipeEdge valueOf(String arg1) {
        return Enum.valueOf(SwipeEdge.class, arg1);
    }

    public static SwipeEdge[] values() {
        return SwipeEdge.$VALUES.clone();
    }
}

