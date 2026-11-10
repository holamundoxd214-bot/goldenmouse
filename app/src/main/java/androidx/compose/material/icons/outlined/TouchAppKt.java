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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_touchApp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TouchApp", "Landroidx/compose/material/icons/Icons$Outlined;", "getTouchApp", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TouchAppKt {
    private static ImageVector _touchApp;

    static {
    }

    public static final ImageVector getTouchApp(Outlined arg19) {
        ImageVector v0 = TouchAppKt._touchApp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.TouchApp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.190001f, 12.44f);
        v12.lineToRelative(-3.24f, -1.62f);
        v12.curveToRelative(1.29f, -1f, 2.12f, -2.56f, 2.12f, -4.32f);
        v12.curveToRelative(0f, -3.03f, -2.47f, -5.5f, -5.5f, -5.5f);
        v12.reflectiveCurveToRelative(-5.5f, 2.47f, -5.5f, 5.5f);
        v12.curveToRelative(0f, 2.13f, 1.22f, 3.98f, 3f, 4.89f);
        v12.verticalLineToRelative(3.26f);
        v12.curveToRelative(-2.15f, -0.46f, -2.02f, -0.44f, -2.26f, -0.44f);
        v12.curveToRelative(-0.53f, 0f, -1.03f, 0.21f, -1.41f, 0.59f);
        v12.lineTo(4f, 16.219999f);
        v12.lineToRelative(5.09f, 5.09f);
        v12.curveTo(9.52f, 21.75f, 10.12f, 22f, 10.74f, 22f);
        v12.horizontalLineToRelative(6.3f);
        v12.curveToRelative(0.98f, 0f, 1.81f, -0.7f, 1.97f, -1.67f);
        v12.lineToRelative(0.8f, -4.71f);
        v12.curveTo(20.030001f, 14.32f, 19.379999f, 13.04f, 18.190001f, 12.44f);
        v12.close();
        v12.moveTo(17.84f, 15.29f);
        v12.lineTo(17.040001f, 20f);
        v12.horizontalLineToRelative(-6.3f);
        v12.curveToRelative(-0.09f, 0f, -0.17f, -0.04f, -0.24f, -0.1f);
        v12.lineToRelative(-3.68f, -3.68f);
        v12.lineToRelative(4.25f, 0.89f);
        v12.verticalLineTo(6.5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(1.76f);
        v12.lineToRelative(3.46f, 1.73f);
        v12.curveTo(17.690001f, 14.43f, 17.91f, 14.86f, 17.84f, 15.29f);
        v12.close();
        v12.moveTo(8.07f, 6.5f);
        v12.curveToRelative(0f, -1.93f, 1.57f, -3.5f, 3.5f, -3.5f);
        v12.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        v12.curveToRelative(0f, 0.95f, -0.38f, 1.81f, -1f, 2.44f);
        v12.verticalLineTo(6.5f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, 1.12f, -2.5f, 2.5f);
        v12.verticalLineToRelative(2.44f);
        v12.curveTo(8.45f, 8.31f, 8.07f, 7.45f, 8.07f, 6.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TouchAppKt._touchApp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

