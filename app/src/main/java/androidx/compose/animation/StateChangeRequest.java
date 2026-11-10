package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/animation/StateChangeRequest;", "", "<init>", "(Ljava/lang/String;I)V", "NoRequest", "MatchFound", "VisibleContentAbsentDuringTransition", "NoMatchFound", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum StateChangeRequest {
    public static final enum StateChangeRequest MatchFound;
    public static final enum StateChangeRequest NoMatchFound;
    public static final enum StateChangeRequest NoRequest;
    public static final enum StateChangeRequest VisibleContentAbsentDuringTransition;

    private static final StateChangeRequest[] $values() {
        return new StateChangeRequest[]{StateChangeRequest.NoRequest, StateChangeRequest.MatchFound, StateChangeRequest.VisibleContentAbsentDuringTransition, StateChangeRequest.NoMatchFound};
    }

    static {
        StateChangeRequest.NoRequest = new StateChangeRequest("NoRequest", 0);
        StateChangeRequest.MatchFound = new StateChangeRequest("MatchFound", 1);
        StateChangeRequest.VisibleContentAbsentDuringTransition = new StateChangeRequest("VisibleContentAbsentDuringTransition", 2);
        StateChangeRequest.NoMatchFound = new StateChangeRequest("NoMatchFound", 3);
        StateChangeRequest[] v0 = StateChangeRequest.$values();
        StateChangeRequest.$VALUES = v0;
        StateChangeRequest.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StateChangeRequest(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StateChangeRequest.$ENTRIES;
    }

    public static StateChangeRequest valueOf(String arg1) {
        return Enum.valueOf(StateChangeRequest.class, arg1);
    }

    public static StateChangeRequest[] values() {
        return StateChangeRequest.$VALUES.clone();
    }
}

