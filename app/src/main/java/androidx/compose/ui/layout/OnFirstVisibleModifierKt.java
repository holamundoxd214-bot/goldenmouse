package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001A:\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¨\u0006\u000B"}, d2={"onFirstVisible", "Landroidx/compose/ui/Modifier;", "minDurationMs", "", "minFractionVisible", "", "viewportBounds", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "callback", "Lkotlin/Function0;", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OnFirstVisibleModifierKt {
    public static final Modifier onFirstVisible(Modifier arg6, long arg7, float arg9, LayoutBoundsHolder arg10, Function0 arg11) {
        return arg6.then(new OnFirstVisibleElement(arg7, arg9, arg10, arg11));
    }

    public static Modifier onFirstVisible$default(Modifier arg6, long arg7, float arg9, LayoutBoundsHolder arg10, Function0 arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = 0;
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = 1f;
        }

        float v3 = arg9;
        if((arg12 & 4) != 0) {
            arg10 = null;
        }

        return OnFirstVisibleModifierKt.onFirstVisible(arg6, v1, v3, arg10, arg11);
    }
}

