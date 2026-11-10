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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Swipe", "Landroidx/compose/material/icons/Icons$Rounded;", "getSwipe", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeKt {
    private static ImageVector _swipe;

    static {
    }

    public static final ImageVector getSwipe(Rounded arg19) {
        ImageVector v0 = SwipeKt._swipe;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Swipe", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.15f, 2.85f);
        v12.lineToRelative(-1.02f, 1.02f);
        v12.curveTo(18.690001f, 2.17f, 15.6f, 1f, 12f, 1f);
        v12.reflectiveCurveTo(5.31f, 2.17f, 3.87f, 3.87f);
        v12.lineTo(2.85f, 2.85f);
        v12.curveTo(2.54f, 2.54f, 2f, 2.76f, 2f, 3.21f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(2f, 6.78f, 2.22f, 7f, 2.5f, 7f);
        v12.horizontalLineToRelative(3.29f);
        v12.curveToRelative(0.45f, 0f, 0.67f, -0.54f, 0.35f, -0.85f);
        v12.lineTo(4.93f, 4.93f);
        v12.curveToRelative(1f, -1.29f, 3.7f, -2.43f, 7.07f, -2.43f);
        v12.reflectiveCurveToRelative(6.07f, 1.14f, 7.07f, 2.43f);
        v12.lineToRelative(-1.22f, 1.22f);
        v12.curveTo(17.540001f, 6.46f, 17.76f, 7f, 18.209999f, 7f);
        v12.horizontalLineToRelative(3.29f);
        v12.curveTo(21.780001f, 7f, 22f, 6.78f, 22f, 6.5f);
        v12.verticalLineTo(3.21f);
        v12.curveTo(22f, 2.76f, 21.459999f, 2.54f, 21.15f, 2.85f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(14.5f, 12.71f);
        v12.curveToRelative(-0.28f, -0.14f, -0.58f, -0.21f, -0.89f, -0.21f);
        v12.horizontalLineTo(13f);
        v12.verticalLineToRelative(-6f);
        v12.curveTo(13f, 5.67f, 12.33f, 5f, 11.5f, 5f);
        v12.reflectiveCurveTo(10f, 5.67f, 10f, 6.5f);
        v12.verticalLineToRelative(10.74f);
        v12.lineToRelative(-3.44f, -0.72f);
        v12.curveToRelative(-0.37f, -0.08f, -0.76f, 0.04f, -1.03f, 0.31f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.43f, 0.44f, -0.43f, 1.14f, 0.01f, 1.58f);
        v12.lineToRelative(4.01f, 4.01f);
        v12.curveTo(9.92f, 22.790001f, 10.43f, 23f, 10.96f, 23f);
        v12.horizontalLineToRelative(6.41f);
        v12.curveToRelative(1f, 0f, 1.84f, -0.73f, 1.98f, -1.72f);
        v12.lineToRelative(0.63f, -4.46f);
        v12.curveToRelative(0.12f, -0.85f, -0.32f, -1.69f, -1.09f, -2.07f);
        v12.lineTo(14.5f, 12.71f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeKt._swipe = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

