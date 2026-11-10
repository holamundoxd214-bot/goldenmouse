package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.TouchBoundsExpansionKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A*\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000\"\u0016\u0010\b\u001A\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000B\"\u0016\u0010\r\u001A\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000B\"\u0014\u0010\u000F\u001A\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"stylusHandwriting", "Landroidx/compose/ui/Modifier;", "enabled", "", "showHoverIcon", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "HandwritingBoundsVerticalOffset", "Landroidx/compose/ui/unit/Dp;", "getHandwritingBoundsVerticalOffset", "()F", "F", "HandwritingBoundsHorizontalOffset", "getHandwritingBoundsHorizontalOffset", "HandwritingBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "getHandwritingBoundsExpansion", "()Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StylusHandwritingKt {
    private static final DpTouchBoundsExpansion HandwritingBoundsExpansion;
    private static final float HandwritingBoundsHorizontalOffset;
    private static final float HandwritingBoundsVerticalOffset;

    static {
        float v0 = Dp.constructor-impl(40f);
        StylusHandwritingKt.HandwritingBoundsVerticalOffset = v0;
        float v1 = Dp.constructor-impl(10f);
        StylusHandwritingKt.HandwritingBoundsHorizontalOffset = v1;
        StylusHandwritingKt.HandwritingBoundsExpansion = TouchBoundsExpansionKt.DpTouchBoundsExpansion-a9UjIt4(v1, v0, v1, v0);
    }

    public static final DpTouchBoundsExpansion getHandwritingBoundsExpansion() {
        return StylusHandwritingKt.HandwritingBoundsExpansion;
    }

    public static final float getHandwritingBoundsHorizontalOffset() {
        return StylusHandwritingKt.HandwritingBoundsHorizontalOffset;
    }

    public static final float getHandwritingBoundsVerticalOffset() {
        return StylusHandwritingKt.HandwritingBoundsVerticalOffset;
    }

    public static final Modifier stylusHandwriting(Modifier arg1, boolean arg2, boolean arg3, Function0 arg4) {
        if((arg2) && (StylusHandwriting_androidKt.isStylusHandwritingSupported())) {
            if(arg3) {
                arg1 = PointerIconKt.stylusHoverIcon(arg1, TextPointerIcon_androidKt.getHandwritingPointerIcon(), false, StylusHandwritingKt.HandwritingBoundsExpansion);
            }

            arg1 = arg1.then(new StylusHandwritingElement(arg4));
        }

        return arg1;
    }
}

