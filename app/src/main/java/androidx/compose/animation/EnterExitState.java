package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/animation/EnterExitState;", "", "<init>", "(Ljava/lang/String;I)V", "PreEnter", "Visible", "PostExit", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum EnterExitState {
    public static final enum EnterExitState PostExit;
    public static final enum EnterExitState PreEnter;
    public static final enum EnterExitState Visible;

    private static final EnterExitState[] $values() {
        return new EnterExitState[]{EnterExitState.PreEnter, EnterExitState.Visible, EnterExitState.PostExit};
    }

    static {
        EnterExitState.PreEnter = new EnterExitState("PreEnter", 0);
        EnterExitState.Visible = new EnterExitState("Visible", 1);
        EnterExitState.PostExit = new EnterExitState("PostExit", 2);
        EnterExitState[] v0 = EnterExitState.$values();
        EnterExitState.$VALUES = v0;
        EnterExitState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private EnterExitState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return EnterExitState.$ENTRIES;
    }

    public static EnterExitState valueOf(String arg1) {
        return Enum.valueOf(EnterExitState.class, arg1);
    }

    public static EnterExitState[] values() {
        return EnterExitState.$VALUES.clone();
    }
}

