package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000B\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\u000E\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b\u001A\u0015\u0010\u0006\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\f\u001A\u000E\u0010\u0006\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0005\u001A\u000E\u0010\u0006\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E\u001A5\u0010\u0006\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\n2\b\b\u0002\u0010\u0010\u001A\u00020\n2\b\b\u0002\u0010\u0011\u001A\u00020\n2\b\b\u0002\u0010\u0012\u001A\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014\u001A.\u0010\u0006\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00052\b\b\u0002\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0012\u001A\u00020\u0005\u001A.\u0010\u0006\u001A\u00020\u00012\b\b\u0003\u0010\u0015\u001A\u00020\u000E2\b\b\u0003\u0010\u0016\u001A\u00020\u000E2\b\b\u0003\u0010\u0017\u001A\u00020\u000E2\b\b\u0003\u0010\u0018\u001A\u00020\u000E¨\u0006\u0019"}, d2={"lerp", "Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "a", "b", "t", "", "AbsoluteCutCornerShape", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "AbsoluteCutCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "percent", "", "topLeft", "topRight", "bottomRight", "bottomLeft", "AbsoluteCutCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "topLeftPercent", "topRightPercent", "bottomRightPercent", "bottomLeftPercent", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AbsoluteCutCornerShapeKt {
    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(float arg0) {
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(CornerSizeKt.CornerSize(arg0));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(CornerSize arg1) {
        return new AbsoluteCutCornerShape(arg1, arg1, arg1, arg1);
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(float arg1, float arg2, float arg3, float arg4) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(arg1), CornerSizeKt.CornerSize(arg2), CornerSizeKt.CornerSize(arg3), CornerSizeKt.CornerSize(arg4));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(int arg0) {
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(CornerSizeKt.CornerSize(arg0));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(int arg1, int arg2, int arg3, int arg4) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(arg1), CornerSizeKt.CornerSize(arg2), CornerSizeKt.CornerSize(arg3), CornerSizeKt.CornerSize(arg4));
    }

    public static AbsoluteCutCornerShape AbsoluteCutCornerShape$default(float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(0f, 0f, 0f, 0f);
    }

    public static AbsoluteCutCornerShape AbsoluteCutCornerShape$default(int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(0, 0, 0, 0);
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape-0680j_4(float arg0) {
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(CornerSizeKt.CornerSize-0680j_4(arg0));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape-a9UjIt4(float arg1, float arg2, float arg3, float arg4) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize-0680j_4(arg1), CornerSizeKt.CornerSize-0680j_4(arg2), CornerSizeKt.CornerSize-0680j_4(arg3), CornerSizeKt.CornerSize-0680j_4(arg4));
    }

    public static AbsoluteCutCornerShape AbsoluteCutCornerShape-a9UjIt4$default(float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
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

        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static final AbsoluteCutCornerShape lerp(AbsoluteCutCornerShape arg5, AbsoluteCutCornerShape arg6, float arg7) {
        return new AbsoluteCutCornerShape(RoundedCornerShapeKt.lerp(arg5.getTopStart(), arg6.getTopStart(), arg7), RoundedCornerShapeKt.lerp(arg5.getTopEnd(), arg6.getTopEnd(), arg7), RoundedCornerShapeKt.lerp(arg5.getBottomEnd(), arg6.getBottomEnd(), arg7), RoundedCornerShapeKt.lerp(arg5.getBottomStart(), arg6.getBottomStart(), arg7));
    }
}

