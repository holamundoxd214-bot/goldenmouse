package androidx.compose.ui.state;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u0004"}, d2={"ToggleableState", "Landroidx/compose/ui/state/ToggleableState;", "value", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ToggleableStateKt {
    public static final ToggleableState ToggleableState(boolean arg0) {
        if(arg0) {
            return ToggleableState.On;
        }

        return ToggleableState.Off;
    }
}

