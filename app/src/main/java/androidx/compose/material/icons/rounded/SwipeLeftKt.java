package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeLeft", "Landroidx/compose/material/icons/Icons$Rounded;", "getSwipeLeft", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeLeftKt {
    private static ImageVector _swipeLeft;

    static {
    }

    public static final ImageVector getSwipeLeft(Rounded arg19) {
        ImageVector v0 = SwipeLeftKt._swipeLeft;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SwipeLeft", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.5f, 4.02f);
        v12.verticalLineTo(2.75f);
        v12.curveTo(3.5f, 2.34f, 3.16f, 2f, 2.75f, 2f);
        v12.reflectiveCurveTo(2f, 2.34f, 2f, 2.75f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3.25f);
        v12.curveTo(6.66f, 7f, 7f, 6.66f, 7f, 6.25f);
        v12.reflectiveCurveTo(6.66f, 5.5f, 6.25f, 5.5f);
        v12.horizontalLineTo(4.09f);
        v12.curveToRelative(2.11f, -1.86f, 4.88f, -3f, 7.91f, -3f);
        v12.curveToRelative(4.42f, 0f, 7.27f, 2.19f, 8.25f, 4.1f);
        v12.curveTo(20.370001f, 6.85f, 20.629999f, 7f, 20.91f, 7f);
        v12.curveToRelative(0.56f, 0f, 0.93f, -0.59f, 0.67f, -1.08f);
        v12.curveTo(20.299999f, 3.39f, 16.809999f, 1f, 12f, 1f);
        v12.curveTo(8.78f, 1f, 5.82f, 2.13f, 3.5f, 4.02f);
        v12.close();
        v12.moveTo(5.2f, 17.43f);
        v12.curveToRelative(0f, -0.65f, 0.6f, -1.13f, 1.24f, -0.99f);
        v12.lineTo(10f, 17.24f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(10f, 5.67f, 10.67f, 5f, 11.5f, 5f);
        v12.reflectiveCurveTo(13f, 5.67f, 13f, 6.5f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(0.91f);
        v12.curveToRelative(0.31f, 0f, 0.62f, 0.07f, 0.89f, 0.21f);
        v12.lineToRelative(4.09f, 2.04f);
        v12.curveToRelative(0.77f, 0.38f, 1.21f, 1.22f, 1.09f, 2.07f);
        v12.lineToRelative(-0.63f, 4.46f);
        v12.curveTo(19.209999f, 22.27f, 18.360001f, 23f, 17.370001f, 23f);
        v12.horizontalLineToRelative(-6.16f);
        v12.curveToRelative(-0.53f, 0f, -1.29f, -0.21f, -1.66f, -0.59f);
        v12.lineToRelative(-4.07f, -4.29f);
        v12.curveTo(5.3f, 17.940001f, 5.2f, 17.690001f, 5.2f, 17.43f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeLeftKt._swipeLeft = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

