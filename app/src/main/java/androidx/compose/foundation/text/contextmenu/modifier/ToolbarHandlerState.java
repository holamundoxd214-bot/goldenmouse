package androidx.compose.foundation.text.contextmenu.modifier;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarHandlerState;", "", "<init>", "(Ljava/lang/String;I)V", "Uninitialized", "Detached", "Attached", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum ToolbarHandlerState {
    public static final enum ToolbarHandlerState Attached;
    public static final enum ToolbarHandlerState Detached;
    public static final enum ToolbarHandlerState Uninitialized;

    private static final ToolbarHandlerState[] $values() {
        return new ToolbarHandlerState[]{ToolbarHandlerState.Uninitialized, ToolbarHandlerState.Detached, ToolbarHandlerState.Attached};
    }

    static {
        ToolbarHandlerState.Uninitialized = new ToolbarHandlerState("Uninitialized", 0);
        ToolbarHandlerState.Detached = new ToolbarHandlerState("Detached", 1);
        ToolbarHandlerState.Attached = new ToolbarHandlerState("Attached", 2);
        ToolbarHandlerState[] v0 = ToolbarHandlerState.$values();
        ToolbarHandlerState.$VALUES = v0;
        ToolbarHandlerState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ToolbarHandlerState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ToolbarHandlerState.$ENTRIES;
    }

    public static ToolbarHandlerState valueOf(String arg1) {
        return Enum.valueOf(ToolbarHandlerState.class, arg1);
    }

    public static ToolbarHandlerState[] values() {
        return ToolbarHandlerState.$VALUES.clone();
    }
}

