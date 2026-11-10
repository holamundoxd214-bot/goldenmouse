package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u001F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u0007\u001A\u001F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\rH\u0007¢\u0006\u0004\b\u000E\u0010\u000F\u001A \u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u0014H\u0007\u001A\f\u0010\u0015\u001A\u00020\u0016*\u00020\u0001H\u0007\u001A\f\u0010\u0017\u001A\u00020\u0001*\u00020\u0016H\u0007¨\u0006\u0018"}, d2={"IntRect", "Landroidx/compose/ui/unit/IntRect;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "topLeft", "bottomRight", "IntRect-E1MhUcY", "center", "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "toRect", "Landroidx/compose/ui/geometry/Rect;", "roundToIntRect", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IntRectKt {
    public static final IntRect IntRect-E1MhUcY(long arg2, long arg4) {
        return new IntRect(IntOffset.getX-impl(arg2), IntOffset.getY-impl(arg2), IntOffset.getX-impl(arg4), IntOffset.getY-impl(arg4));
    }

    public static final IntRect IntRect-VbeCjmY(long arg6, long arg8) {
        return new IntRect(IntOffset.getX-impl(arg6), IntOffset.getY-impl(arg6), IntOffset.getX-impl(arg6) + (((int)(arg8 >> 0x20))), IntOffset.getY-impl(arg6) + (((int)(arg8 & 0xFFFFFFFFL))));
    }

    public static final IntRect IntRect-ar5cAso(long arg4, int arg6) {
        return new IntRect(IntOffset.getX-impl(arg4) - arg6, IntOffset.getY-impl(arg4) - arg6, IntOffset.getX-impl(arg4) + arg6, IntOffset.getY-impl(arg4) + arg6);
    }

    public static final IntRect lerp(IntRect arg5, IntRect arg6, float arg7) {
        return new IntRect(MathHelpersKt.lerp(arg5.getLeft(), arg6.getLeft(), arg7), MathHelpersKt.lerp(arg5.getTop(), arg6.getTop(), arg7), MathHelpersKt.lerp(arg5.getRight(), arg6.getRight(), arg7), MathHelpersKt.lerp(arg5.getBottom(), arg6.getBottom(), arg7));
    }

    public static final IntRect roundToIntRect(Rect arg4) {
        return new IntRect(Math.round(arg4.getLeft()), Math.round(arg4.getTop()), Math.round(arg4.getRight()), Math.round(arg4.getBottom()));
    }

    public static final Rect toRect(IntRect arg4) {
        return new Rect(((float)arg4.getLeft()), ((float)arg4.getTop()), ((float)arg4.getRight()), ((float)arg4.getBottom()));
    }
}

