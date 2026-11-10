package androidx.compose.ui.focus;

import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001A\u00020\u0007H&J\b\u0010\b\u001A\u00020\u0007H\u0017R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\u0082\u0001\u0001\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "requestedFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "getRequestedFocusDirection-dhqQ-8s", "()I", "cancelFocusChange", "", "cancelFocus", "Landroidx/compose/ui/focus/CancelIndicatingFocusBoundaryScope;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FocusEnterExitScope {
    @Deprecated(message="Use cancelFocusChange instead", replaceWith="<_subannotation>") default void cancelFocus() {
        this.cancelFocusChange();
    }

    void cancelFocusChange();

    int getRequestedFocusDirection-dhqQ-8s();
}

