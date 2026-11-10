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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_touchApp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TouchApp", "Landroidx/compose/material/icons/Icons$Sharp;", "getTouchApp", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TouchAppKt {
    private static ImageVector _touchApp;

    static {
    }

    public static final ImageVector getTouchApp(Sharp arg19) {
        ImageVector v0 = TouchAppKt._touchApp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.TouchApp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.25f, 9.24f);
        v12.verticalLineTo(5.5f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        v12.verticalLineToRelative(3.74f);
        v12.curveToRelative(1.21f, -0.81f, 2f, -2.18f, 2f, -3.74f);
        v12.curveToRelative(0f, -2.49f, -2.01f, -4.5f, -4.5f, -4.5f);
        v12.reflectiveCurveToRelative(-4.5f, 2.01f, -4.5f, 4.5f);
        v12.curveTo(6.25f, 7.06f, 7.04f, 8.43f, 8.25f, 9.24f);
        v12.close();
        v12.moveTo(13.33f, 11.5f);
        v12.horizontalLineToRelative(-1.08f);
        v12.verticalLineToRelative(-6f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-1.5f, 0.67f, -1.5f, 1.5f);
        v12.verticalLineToRelative(10.74f);
        v12.lineToRelative(-4.04f, -0.85f);
        v12.lineTo(4f, 16.620001f);
        v12.lineTo(9.38f, 22f);
        v12.horizontalLineToRelative(8.67f);
        v12.lineToRelative(1.07f, -7.62f);
        v12.lineTo(13.33f, 11.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TouchAppKt._touchApp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

