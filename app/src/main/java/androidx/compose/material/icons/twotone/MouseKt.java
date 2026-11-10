package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mouse", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Mouse", "Landroidx/compose/material/icons/Icons$TwoTone;", "getMouse", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MouseKt {
    private static ImageVector _mouse;

    static {
    }

    public static final ImageVector getMouse(TwoTone arg19) {
        ImageVector v0 = MouseKt._mouse;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Mouse", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 3.16f);
        v12.lineTo(13f, 9f);
        v12.horizontalLineToRelative(5f);
        v12.curveToRelative(-0.04f, -2.94f, -2.19f, -5.37f, -5f, -5.84f);
        v12.close();
        v12.moveTo(11f, 3.16f);
        v12.curveTo(8.19f, 3.63f, 6.04f, 6.06f, 6f, 9f);
        v12.horizontalLineToRelative(5f);
        v12.lineTo(11f, 3.16f);
        v12.close();
        v12.moveTo(11f, 11f);
        v12.lineTo(6f, 11f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.reflectiveCurveToRelative(6f, -2.69f, 6f, -6f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(-7f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20f, 9f);
        v12.curveToRelative(-0.04f, -4.39f, -3.6f, -7.93f, -8f, -7.93f);
        v12.reflectiveCurveTo(4.04f, 4.61f, 4f, 9f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 4.42f, 3.58f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.58f, 8f, -8f);
        v12.lineTo(20f, 9f);
        v12.close();
        v12.moveTo(13f, 3.16f);
        v12.curveToRelative(2.81f, 0.47f, 4.96f, 2.9f, 5f, 5.84f);
        v12.horizontalLineToRelative(-5f);
        v12.lineTo(13f, 3.16f);
        v12.close();
        v12.moveTo(11f, 3.16f);
        v12.lineTo(11f, 9f);
        v12.lineTo(6f, 9f);
        v12.curveToRelative(0.04f, -2.94f, 2.19f, -5.37f, 5f, -5.84f);
        v12.close();
        v12.moveTo(18f, 15f);
        v12.curveToRelative(0f, 3.31f, -2.69f, 6f, -6f, 6f);
        v12.reflectiveCurveToRelative(-6f, -2.69f, -6f, -6f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MouseKt._mouse = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

