package androidx.compose.ui.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/ui/state/ToggleableState;", "", "<init>", "(Ljava/lang/String;I)V", "On", "Off", "Indeterminate", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum ToggleableState {
    public static final enum ToggleableState Indeterminate;
    public static final enum ToggleableState Off;
    public static final enum ToggleableState On;

    private static final ToggleableState[] $values() {
        return new ToggleableState[]{ToggleableState.On, ToggleableState.Off, ToggleableState.Indeterminate};
    }

    static {
        ToggleableState.On = new ToggleableState("On", 0);
        ToggleableState.Off = new ToggleableState("Off", 1);
        ToggleableState.Indeterminate = new ToggleableState("Indeterminate", 2);
        ToggleableState[] v0 = ToggleableState.$values();
        ToggleableState.$VALUES = v0;
        ToggleableState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ToggleableState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ToggleableState.$ENTRIES;
    }

    public static ToggleableState valueOf(String arg1) {
        return Enum.valueOf(ToggleableState.class, arg1);
    }

    public static ToggleableState[] values() {
        return ToggleableState.$VALUES.clone();
    }
}

