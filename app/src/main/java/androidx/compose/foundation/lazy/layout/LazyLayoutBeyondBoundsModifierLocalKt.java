package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\u001A,\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000\u001A\b\u0010\n\u001A\u00020\u000BH\u0002\"\u000E\u0010\f\u001A\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"lazyLayoutBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "unsupportedDirection", "", "BeyondBoundsViewportFactor", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutBeyondBoundsModifierLocalKt {
    private static final int BeyondBoundsViewportFactor = 2;

    public static final Void access$unsupportedDirection() {
        return LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
    }

    public static final Modifier lazyLayoutBeyondBoundsModifier(Modifier arg1, LazyLayoutBeyondBoundsState arg2, LazyLayoutBeyondBoundsInfo arg3, boolean arg4, Orientation arg5) {
        return arg1.then(new LazyLayoutBeyondBoundsModifierElement(arg2, arg3, arg4, arg5));
    }

    private static final Void unsupportedDirection() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
    }
}

