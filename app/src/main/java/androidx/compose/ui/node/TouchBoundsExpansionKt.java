package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A3\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0002\u0010\u0007\u001A5\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u0002\u001A\u00020\n2\b\b\u0002\u0010\u0004\u001A\u00020\n2\b\b\u0002\u0010\u0005\u001A\u00020\n2\b\b\u0002\u0010\u0006\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"TouchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "start", "", "top", "end", "bottom", "(IIII)J", "DpTouchBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "Landroidx/compose/ui/unit/Dp;", "DpTouchBoundsExpansion-a9UjIt4", "(FFFF)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TouchBoundsExpansionKt {
    public static final DpTouchBoundsExpansion DpTouchBoundsExpansion-a9UjIt4(float arg7, float arg8, float arg9, float arg10) {
        return new DpTouchBoundsExpansion(arg7, arg8, arg9, arg10, true, null);
    }

    public static DpTouchBoundsExpansion DpTouchBoundsExpansion-a9UjIt4$default(float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = Dp.constructor-impl(0f);
        }

        if((arg5 & 2) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg5 & 4) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        if((arg5 & 8) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        return TouchBoundsExpansionKt.DpTouchBoundsExpansion-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static final long TouchBoundsExpansion(int arg7, int arg8, int arg9, int arg10) {
        int v0 = 1;
        int v1 = 0x8000;
        int v3 = arg7 < 0 || arg7 >= v1 ? 0 : 1;
        if(v3 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Start must be in the range of 0 .. 32767");
        }

        v3 = arg8 < 0 || arg8 >= v1 ? 0 : 1;
        if(v3 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Top must be in the range of 0 .. 32767");
        }

        v3 = arg9 < 0 || arg9 >= v1 ? 0 : 1;
        if(v3 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("End must be in the range of 0 .. 32767");
        }

        if(arg10 < 0 || arg10 >= v1) {
            v0 = 0;
        }
        else {
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Bottom must be in the range of 0 .. 32767");
        }

        return TouchBoundsExpansion.constructor-impl(TouchBoundsExpansion.Companion.pack$ui(arg7, arg8, arg9, arg10, true));
    }

    public static long TouchBoundsExpansion$default(int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        return TouchBoundsExpansionKt.TouchBoundsExpansion(0, 0, 0, 0);
    }
}

