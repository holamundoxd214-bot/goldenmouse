package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeVertical", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeVertical", "Landroidx/compose/material/icons/Icons$Filled;", "getSwipeVertical", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeVerticalKt {
    private static ImageVector _swipeVertical;

    static {
    }

    public static final ImageVector getSwipeVertical(Filled arg19) {
        ImageVector v0 = SwipeVerticalKt._swipeVertical;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SwipeVertical", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(13.85f, 11.62f);
        v12.lineToRelative(-2.68f, -5.37f);
        v12.curveToRelative(-0.37f, -0.74f, -1.27f, -1.04f, -2.01f, -0.67f);
        v12.curveTo(8.41f, 5.96f, 8.11f, 6.86f, 8.48f, 7.6f);
        v12.lineToRelative(4.81f, 9.6f);
        v12.lineTo(10.05f, 18f);
        v12.curveToRelative(-0.33f, 0.09f, -0.59f, 0.33f, -0.7f, 0.66f);
        v12.lineTo(9f, 19.780001f);
        v12.lineToRelative(6.19f, 2.25f);
        v12.curveToRelative(0.5f, 0.17f, 1.28f, 0.02f, 1.75f, -0.22f);
        v12.lineToRelative(5.51f, -2.75f);
        v12.curveToRelative(0.89f, -0.45f, 1.32f, -1.48f, 1f, -2.42f);
        v12.lineToRelative(-1.43f, -4.27f);
        v12.curveToRelative(-0.27f, -0.82f, -1.04f, -1.37f, -1.9f, -1.37f);
        v12.horizontalLineToRelative(-4.56f);
        v12.curveToRelative(-0.31f, 0f, -0.62f, 0.07f, -0.89f, 0.21f);
        v12.lineTo(13.85f, 11.62f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeVerticalKt._swipeVertical = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

