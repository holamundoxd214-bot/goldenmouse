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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeRight", "Landroidx/compose/material/icons/Icons$Rounded;", "getSwipeRight", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeRightKt {
    private static ImageVector _swipeRight;

    static {
    }

    public static final ImageVector getSwipeRight(Rounded arg19) {
        ImageVector v0 = SwipeRightKt._swipeRight;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SwipeRight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 1f);
        v12.curveTo(7.19f, 1f, 3.7f, 3.39f, 2.41f, 5.92f);
        v12.curveTo(2.16f, 6.41f, 2.53f, 7f, 3.09f, 7f);
        v12.curveToRelative(0.28f, 0f, 0.54f, -0.15f, 0.66f, -0.4f);
        v12.curveTo(4.73f, 4.69f, 7.58f, 2.5f, 12f, 2.5f);
        v12.curveToRelative(3.03f, 0f, 5.79f, 1.14f, 7.91f, 3f);
        v12.horizontalLineToRelative(-2.16f);
        v12.curveTo(17.34f, 5.5f, 17f, 5.84f, 17f, 6.25f);
        v12.reflectiveCurveTo(17.34f, 7f, 17.75f, 7f);
        v12.horizontalLineTo(21f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(2.75f);
        v12.curveTo(22f, 2.34f, 21.66f, 2f, 21.25f, 2f);
        v12.reflectiveCurveTo(20.5f, 2.34f, 20.5f, 2.75f);
        v12.verticalLineToRelative(1.27f);
        v12.curveTo(18.18f, 2.13f, 15.22f, 1f, 12f, 1f);
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
        SwipeRightKt._swipeRight = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

