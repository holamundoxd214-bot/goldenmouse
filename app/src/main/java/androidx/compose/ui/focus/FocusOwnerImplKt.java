package androidx.compose.ui.focus;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"is1dFocusSearch", "", "Landroidx/compose/ui/focus/FocusDirection;", "is1dFocusSearch-3ESFkO8", "(I)Z", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusOwnerImplKt {
    public static final boolean is1dFocusSearch-3ESFkO8(int arg1) {
        if(!FocusDirection.equals-impl0(arg1, FocusDirection.Companion.getNext-dhqQ-8s())) {
            if(FocusDirection.equals-impl0(arg1, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

