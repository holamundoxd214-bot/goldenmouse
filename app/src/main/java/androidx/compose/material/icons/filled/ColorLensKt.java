package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_colorLens", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ColorLens", "Landroidx/compose/material/icons/Icons$Filled;", "getColorLens", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ColorLensKt {
    private static ImageVector _colorLens;

    static {
    }

    public static final ImageVector getColorLens(Filled arg19) {
        ImageVector v0 = ColorLensKt._colorLens;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ColorLens", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 3f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.reflectiveCurveToRelative(4.03f, 9f, 9f, 9f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.curveToRelative(0f, -0.39f, -0.15f, -0.74f, -0.39f, -1.01f);
        v12.curveToRelative(-0.23f, -0.26f, -0.38f, -0.61f, -0.38f, -0.99f);
        v12.curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        v12.lineTo(16f, 16f);
        v12.curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f);
        v12.curveToRelative(0f, -4.42f, -4.03f, -8f, -9f, -8f);
        v12.close();
        v12.moveTo(6.5f, 12f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(5.67f, 9f, 6.5f, 9f);
        v12.reflectiveCurveTo(8f, 9.67f, 8f, 10.5f);
        v12.reflectiveCurveTo(7.33f, 12f, 6.5f, 12f);
        v12.close();
        v12.moveTo(9.5f, 8f);
        v12.curveTo(8.67f, 8f, 8f, 7.33f, 8f, 6.5f);
        v12.reflectiveCurveTo(8.67f, 5f, 9.5f, 5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(10.33f, 8f, 9.5f, 8f);
        v12.close();
        v12.moveTo(14.5f, 8f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(13.67f, 5f, 14.5f, 5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(15.33f, 8f, 14.5f, 8f);
        v12.close();
        v12.moveTo(17.5f, 12f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(16.67f, 9f, 17.5f, 9f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ColorLensKt._colorLens = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

