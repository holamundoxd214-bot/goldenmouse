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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hourglassBottom", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HourglassBottom", "Landroidx/compose/material/icons/Icons$Rounded;", "getHourglassBottom", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HourglassBottomKt {
    private static ImageVector _hourglassBottom;

    static {
    }

    public static final ImageVector getHourglassBottom(Rounded arg19) {
        ImageVector v0 = HourglassBottomKt._hourglassBottom;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HourglassBottom", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 22f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineToRelative(-0.01f, -3.18f);
        v12.curveToRelative(0f, -0.53f, -0.21f, -1.03f, -0.58f, -1.41f);
        v12.lineTo(14f, 12f);
        v12.lineToRelative(3.41f, -3.43f);
        v12.curveToRelative(0.37f, -0.37f, 0.58f, -0.88f, 0.58f, -1.41f);
        v12.lineTo(18f, 4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(8f);
        v12.curveTo(6.9f, 2f, 6f, 2.9f, 6f, 4f);
        v12.verticalLineToRelative(3.16f);
        v12.curveTo(6f, 7.69f, 6.21f, 8.2f, 6.58f, 8.58f);
        v12.lineTo(10f, 12f);
        v12.lineToRelative(-3.41f, 3.4f);
        v12.curveTo(6.21f, 15.78f, 6f, 16.290001f, 6f, 16.82f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineTo(16f);
        v12.close();
        v12.moveTo(8f, 7.09f);
        v12.verticalLineTo(5f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2.09f);
        v12.curveToRelative(0f, 0.27f, -0.11f, 0.52f, -0.29f, 0.71f);
        v12.lineTo(12f, 11.5f);
        v12.lineTo(8.29f, 7.79f);
        v12.curveTo(8.11f, 7.61f, 8f, 7.35f, 8f, 7.09f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HourglassBottomKt._hourglassBottom = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

