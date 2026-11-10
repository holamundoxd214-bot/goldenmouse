package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeVertical", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeVertical", "Landroidx/compose/material/icons/Icons$Sharp;", "getSwipeVertical", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeVerticalKt {
    private static ImageVector _swipeVertical;

    static {
    }

    public static final ImageVector getSwipeVertical(Sharp arg19) {
        ImageVector v0 = SwipeVerticalKt._swipeVertical;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SwipeVertical", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(1f, 3.5f);
        v12.horizontalLineToRelative(2.02f);
        v12.curveTo(1.13f, 5.82f, 0f, 8.78f, 0f, 12f);
        v12.reflectiveCurveToRelative(1.13f, 6.18f, 3.02f, 8.5f);
        v12.horizontalLineTo(1f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineTo(4.5f);
        v12.verticalLineToRelative(2.91f);
        v12.curveToRelative(-1.86f, -2.11f, -3f, -4.88f, -3f, -7.91f);
        v12.reflectiveCurveToRelative(1.14f, -5.79f, 3f, -7.91f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(1f);
        v12.verticalLineTo(3.5f);
        v12.close();
        v12.moveTo(21.709999f, 11.18f);
        v12.lineToRelative(2.09f, 7.39f);
        v12.lineToRelative(-8.23f, 3.65f);
        v12.lineToRelative(-6.84f, -2.85f);
        v12.lineToRelative(0.61f, -1.62f);
        v12.lineToRelative(3.8f, -0.75f);
        v12.lineTo(8.79f, 7.17f);
        v12.curveToRelative(-0.34f, -0.76f, 0f, -1.64f, 0.76f, -1.98f);
        v12.curveToRelative(0.76f, -0.34f, 1.64f, 0f, 1.98f, 0.76f);
        v12.lineToRelative(2.43f, 5.49f);
        v12.lineToRelative(1.26f, -0.56f);
        v12.lineTo(21.709999f, 11.18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeVerticalKt._swipeVertical = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

