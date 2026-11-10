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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeLeft", "Landroidx/compose/material/icons/Icons$Filled;", "getSwipeLeft", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeLeftKt {
    private static ImageVector _swipeLeft;

    static {
    }

    public static final ImageVector getSwipeLeft(Filled arg19) {
        ImageVector v0 = SwipeLeftKt._swipeLeft;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SwipeLeft", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.98f, 16.82f);
        v12.lineToRelative(-0.63f, 4.46f);
        v12.curveTo(19.209999f, 22.27f, 18.360001f, 23f, 17.370001f, 23f);
        v12.horizontalLineToRelative(-6.16f);
        v12.curveToRelative(-0.53f, 0f, -1.29f, -0.21f, -1.66f, -0.59f);
        v12.lineTo(5f, 17.620001f);
        v12.lineToRelative(0.83f, -0.84f);
        v12.curveToRelative(0.24f, -0.24f, 0.58f, -0.35f, 0.92f, -0.28f);
        v12.lineTo(10f, 17.24f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(10f, 5.67f, 10.67f, 5f, 11.5f, 5f);
        v12.reflectiveCurveTo(13f, 5.67f, 13f, 6.5f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(0.91f);
        v12.curveToRelative(0.31f, 0f, 0.62f, 0.07f, 0.89f, 0.21f);
        v12.lineToRelative(4.09f, 2.04f);
        v12.curveTo(19.66f, 15.14f, 20.1f, 15.97f, 19.98f, 16.82f);
        v12.close();
        v12.moveTo(12f, 2.5f);
        v12.curveToRelative(4.74f, 0f, 7.67f, 2.52f, 8.43f, 4.5f);
        v12.horizontalLineTo(22f);
        v12.curveToRelative(-0.73f, -2.88f, -4.51f, -6f, -10f, -6f);
        v12.curveTo(8.78f, 1f, 5.82f, 2.13f, 3.5f, 4.02f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(5.5f);
        v12.horizontalLineTo(4.09f);
        v12.curveTo(6.21f, 3.64f, 8.97f, 2.5f, 12f, 2.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeLeftKt._swipeLeft = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

