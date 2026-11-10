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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hourglassTop", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HourglassTop", "Landroidx/compose/material/icons/Icons$Rounded;", "getHourglassTop", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HourglassTopKt {
    private static ImageVector _hourglassTop;

    static {
    }

    public static final ImageVector getHourglassTop(Rounded arg19) {
        ImageVector v0 = HourglassTopKt._hourglassTop;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HourglassTop", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 2f);
        v12.curveTo(6.9f, 2f, 6f, 2.9f, 6f, 4f);
        v12.lineToRelative(0.01f, 3.18f);
        v12.curveToRelative(0f, 0.53f, 0.21f, 1.03f, 0.58f, 1.41f);
        v12.lineTo(10f, 12f);
        v12.lineToRelative(-3.41f, 3.43f);
        v12.curveToRelative(-0.37f, 0.37f, -0.58f, 0.88f, -0.58f, 1.41f);
        v12.lineTo(6f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(8f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-3.16f);
        v12.curveToRelative(0f, -0.53f, -0.21f, -1.04f, -0.58f, -1.41f);
        v12.lineTo(14f, 12f);
        v12.lineToRelative(3.41f, -3.4f);
        v12.curveTo(17.790001f, 8.22f, 18f, 7.71f, 18f, 7.18f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(8f);
        v12.close();
        v12.moveTo(16f, 16.91f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-2.09f);
        v12.curveToRelative(0f, -0.27f, 0.11f, -0.52f, 0.29f, -0.71f);
        v12.lineTo(12f, 12.5f);
        v12.lineToRelative(3.71f, 3.71f);
        v12.curveTo(15.89f, 16.389999f, 16f, 16.65f, 16f, 16.91f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HourglassTopKt._hourglassTop = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

