package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Landroidx/compose/runtime/PausedCompositionState;", "", "<init>", "(Ljava/lang/String;I)V", "Invalid", "Cancelled", "InitialPending", "RecomposePending", "Recomposing", "ApplyPending", "Applied", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public enum PausedCompositionState {
    public static final enum PausedCompositionState Applied;
    public static final enum PausedCompositionState ApplyPending;
    public static final enum PausedCompositionState Cancelled;
    public static final enum PausedCompositionState InitialPending;
    public static final enum PausedCompositionState Invalid;
    public static final enum PausedCompositionState RecomposePending;
    public static final enum PausedCompositionState Recomposing;

    private static final PausedCompositionState[] $values() {
        return new PausedCompositionState[]{PausedCompositionState.Invalid, PausedCompositionState.Cancelled, PausedCompositionState.InitialPending, PausedCompositionState.RecomposePending, PausedCompositionState.Recomposing, PausedCompositionState.ApplyPending, PausedCompositionState.Applied};
    }

    static {
        PausedCompositionState.Invalid = new PausedCompositionState("Invalid", 0);
        PausedCompositionState.Cancelled = new PausedCompositionState("Cancelled", 1);
        PausedCompositionState.InitialPending = new PausedCompositionState("InitialPending", 2);
        PausedCompositionState.RecomposePending = new PausedCompositionState("RecomposePending", 3);
        PausedCompositionState.Recomposing = new PausedCompositionState("Recomposing", 4);
        PausedCompositionState.ApplyPending = new PausedCompositionState("ApplyPending", 5);
        PausedCompositionState.Applied = new PausedCompositionState("Applied", 6);
        PausedCompositionState[] v0 = PausedCompositionState.$values();
        PausedCompositionState.$VALUES = v0;
        PausedCompositionState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private PausedCompositionState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return PausedCompositionState.$ENTRIES;
    }

    public static PausedCompositionState valueOf(String arg1) {
        return Enum.valueOf(PausedCompositionState.class, arg1);
    }

    public static PausedCompositionState[] values() {
        return PausedCompositionState.$VALUES.clone();
    }
}

