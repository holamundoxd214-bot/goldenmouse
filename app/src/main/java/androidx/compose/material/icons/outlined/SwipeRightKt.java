package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeRight", "Landroidx/compose/material/icons/Icons$Outlined;", "getSwipeRight", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeRightKt {
    private static ImageVector _swipeRight;

    static {
    }

    public static final ImageVector getSwipeRight(Outlined arg19) {
        ImageVector v0 = SwipeRightKt._swipeRight;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SwipeRight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.889999f, 13.77f);
        v12.lineToRelative(-3.8f, -1.67f);
        v12.curveTo(14.96f, 12.04f, 14.81f, 12f, 14.65f, 12f);
        v12.horizontalLineTo(14f);
        v12.verticalLineTo(7.5f);
        v12.curveTo(14f, 6.12f, 12.88f, 5f, 11.5f, 5f);
        v12.reflectiveCurveTo(9f, 6.12f, 9f, 7.5f);
        v12.verticalLineToRelative(8.15f);
        v12.lineToRelative(-1.87f, -0.4f);
        v12.curveToRelative(-0.19f, -0.03f, -1.02f, -0.15f, -1.73f, 0.56f);
        v12.lineTo(4f, 17.219999f);
        v12.lineToRelative(5.12f, 5.19f);
        v12.curveTo(9.49f, 22.790001f, 10f, 23f, 10.53f, 23f);
        v12.horizontalLineToRelative(6.55f);
        v12.curveToRelative(0.98f, 0f, 1.81f, -0.7f, 1.97f, -1.67f);
        v12.lineToRelative(0.92f, -5.44f);
        v12.curveTo(20.120001f, 15.03f, 19.68f, 14.17f, 18.889999f, 13.77f);
        v12.close();
        v12.moveTo(17.08f, 21f);
        v12.horizontalLineToRelative(-6.55f);
        v12.lineToRelative(-3.7f, -3.78f);
        v12.lineTo(11f, 18.110001f);
        v12.verticalLineTo(7.5f);
        v12.curveTo(11f, 7.22f, 11.22f, 7f, 11.5f, 7f);
        v12.reflectiveCurveTo(12f, 7.22f, 12f, 7.5f);
        v12.verticalLineToRelative(6.18f);
        v12.horizontalLineToRelative(1.76f);
        v12.lineTo(18f, 15.56f);
        v12.lineTo(17.08f, 21f);
        v12.close();
        v12.moveTo(12f, 2.5f);
        v12.curveTo(7.26f, 2.5f, 4.33f, 5.02f, 3.57f, 7f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(0.73f, -2.88f, 4.51f, -6f, 10f, -6f);
        v12.curveToRelative(3.22f, 0f, 6.18f, 1.13f, 8.5f, 3.02f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(22f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(-5f);
        v12.verticalLineTo(5.5f);
        v12.horizontalLineToRelative(2.91f);
        v12.curveTo(17.790001f, 3.64f, 15.03f, 2.5f, 12f, 2.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeRightKt._swipeRight = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

