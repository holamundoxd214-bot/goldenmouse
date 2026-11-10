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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_touchApp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TouchApp", "Landroidx/compose/material/icons/Icons$Rounded;", "getTouchApp", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TouchAppKt {
    private static ImageVector _touchApp;

    static {
    }

    public static final ImageVector getTouchApp(Rounded arg19) {
        ImageVector v0 = TouchAppKt._touchApp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TouchApp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.79f, 9.24f);
        v12.verticalLineTo(5.5f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        v12.verticalLineToRelative(3.74f);
        v12.curveToRelative(1.21f, -0.81f, 2f, -2.18f, 2f, -3.74f);
        v12.curveToRelative(0f, -2.49f, -2.01f, -4.5f, -4.5f, -4.5f);
        v12.reflectiveCurveToRelative(-4.5f, 2.01f, -4.5f, 4.5f);
        v12.curveTo(6.79f, 7.06f, 7.58f, 8.43f, 8.79f, 9.24f);
        v12.close();
        v12.moveTo(14.29f, 11.71f);
        v12.curveToRelative(-0.28f, -0.14f, -0.58f, -0.21f, -0.89f, -0.21f);
        v12.horizontalLineToRelative(-0.61f);
        v12.verticalLineToRelative(-6f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-1.5f, 0.67f, -1.5f, 1.5f);
        v12.verticalLineToRelative(10.74f);
        v12.lineToRelative(-3.44f, -0.72f);
        v12.curveToRelative(-0.37f, -0.08f, -0.76f, 0.04f, -1.03f, 0.31f);
        v12.curveToRelative(-0.43f, 0.44f, -0.43f, 1.14f, 0f, 1.58f);
        v12.lineToRelative(4.01f, 4.01f);
        v12.curveTo(9.71f, 21.790001f, 10.22f, 22f, 10.75f, 22f);
        v12.horizontalLineToRelative(6.1f);
        v12.curveToRelative(1f, 0f, 1.84f, -0.73f, 1.98f, -1.72f);
        v12.lineToRelative(0.63f, -4.47f);
        v12.curveToRelative(0.12f, -0.85f, -0.32f, -1.69f, -1.09f, -2.07f);
        v12.lineTo(14.29f, 11.71f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TouchAppKt._touchApp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

