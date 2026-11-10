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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tty", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Tty", "Landroidx/compose/material/icons/Icons$Outlined;", "getTty", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TtyKt {
    private static ImageVector _tty;

    static {
    }

    public static final ImageVector getTty(Outlined arg19) {
        ImageVector v0 = TtyKt._tty;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Tty", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 6f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(6f);
        v12.close();
        v12.moveTo(18f, 7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(19f, 9f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(19f, 4f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(4f);
        v12.close();
        v12.moveTo(15f, 7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(19f, 10f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(10f);
        v12.close();
        v12.moveTo(16f, 10f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(10f);
        v12.close();
        v12.moveTo(13f, 4f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(4f);
        v12.close();
        v12.moveTo(20f, 15.82f);
        v12.verticalLineToRelative(4.15f);
        v12.curveToRelative(0f, 0.56f, -0.47f, 1.03f, -1.03f, 1f);
        v12.curveToRelative(-2.89f, -0.17f, -5.6f, -1.03f, -7.97f, -2.4f);
        v12.curveTo(8.27f, 16.99f, 6.01f, 14.73f, 4.43f, 12f);
        v12.curveTo(3.05f, 9.63f, 2.2f, 6.92f, 2.03f, 4.03f);
        v12.curveTo(2f, 3.47f, 2.47f, 3f, 3.03f, 3f);
        v12.horizontalLineToRelative(4.15f);
        v12.curveToRelative(0.48f, 0f, 0.89f, 0.34f, 0.98f, 0.8f);
        v12.lineTo(8.9f, 7.48f);
        v12.curveToRelative(0.07f, 0.33f, -0.04f, 0.67f, -0.27f, 0.9f);
        v12.lineTo(6.1f, 10.9f);
        v12.curveToRelative(1.43f, 2.5f, 3.5f, 4.57f, 6f, 6f);
        v12.lineToRelative(2.52f, -2.52f);
        v12.curveToRelative(0.24f, -0.24f, 0.58f, -0.34f, 0.9f, -0.27f);
        v12.lineToRelative(3.67f, 0.73f);
        v12.curveTo(19.66f, 14.93f, 20f, 15.34f, 20f, 15.82f);
        v12.close();
        v12.moveTo(5.18f, 8.99f);
        v12.lineToRelative(1.65f, -1.65f);
        v12.lineTo(6.36f, 5f);
        v12.horizontalLineTo(4.13f);
        v12.curveTo(4.3f, 6.37f, 4.66f, 7.71f, 5.18f, 8.99f);
        v12.close();
        v12.moveTo(18f, 16.639999f);
        v12.lineToRelative(-2.34f, -0.47f);
        v12.lineToRelative(-1.65f, 1.65f);
        v12.curveToRelative(1.28f, 0.52f, 2.63f, 0.87f, 3.99f, 1.05f);
        v12.verticalLineTo(16.639999f);
        v12.close();
        v12.moveTo(20f, 4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(20f);
        v12.close();
        v12.moveTo(20f, 12f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(12f);
        v12.close();
        v12.moveTo(13f, 10f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TtyKt._tty = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

