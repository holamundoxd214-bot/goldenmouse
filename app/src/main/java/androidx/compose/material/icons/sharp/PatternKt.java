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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pattern", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pattern", "Landroidx/compose/material/icons/Icons$Sharp;", "getPattern", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PatternKt {
    private static ImageVector _pattern;

    static {
    }

    public static final ImageVector getPattern(Sharp arg19) {
        ImageVector v0 = PatternKt._pattern;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Pattern", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 6f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveTo(7.1f, 8f, 6f, 8f);
        v12.reflectiveCurveTo(4f, 7.1f, 4f, 6f);
        v12.close();
        v12.moveTo(6f, 14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(4.9f, 14f, 6f, 14f);
        v12.close();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(10.9f, 8f, 12f, 8f);
        v12.close();
        v12.moveTo(18f, 10f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(19.1f, 10f, 18f, 10f);
        v12.close();
        v12.moveTo(17.98f, 16f);
        v12.curveToRelative(-0.74f, 0f, -1.37f, 0.4f, -1.72f, 1f);
        v12.horizontalLineToRelative(-2.54f);
        v12.curveToRelative(-0.34f, -0.6f, -0.98f, -1f, -1.72f, -1f);
        v12.reflectiveCurveToRelative(-1.37f, 0.4f, -1.72f, 1f);
        v12.horizontalLineTo(8.41f);
        v12.lineToRelative(3.07f, -3.07f);
        v12.curveTo(11.65f, 13.97f, 11.82f, 14f, 12f, 14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -0.18f, -0.03f, -0.35f, -0.07f, -0.51f);
        v12.lineToRelative(3.56f, -3.56f);
        v12.curveTo(17.65f, 7.97f, 17.82f, 8f, 18f, 8f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.curveToRelative(0f, 0.18f, 0.03f, 0.35f, 0.07f, 0.51f);
        v12.lineToRelative(-3.56f, 3.56f);
        v12.curveTo(12.35f, 10.03f, 12.18f, 10f, 12f, 10f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.curveToRelative(0f, 0.18f, 0.03f, 0.35f, 0.07f, 0.51f);
        v12.lineToRelative(-3.56f, 3.56f);
        v12.curveTo(6.35f, 16.030001f, 6.18f, 16f, 6f, 16f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.curveToRelative(0.74f, 0f, 1.37f, -0.4f, 1.72f, -1f);
        v12.horizontalLineToRelative(2.57f);
        v12.curveToRelative(0.34f, 0.6f, 0.98f, 1f, 1.72f, 1f);
        v12.reflectiveCurveToRelative(1.37f, -0.4f, 1.72f, -1f);
        v12.horizontalLineToRelative(2.55f);
        v12.curveToRelative(0.34f, 0.6f, 0.98f, 1f, 1.72f, 1f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveTo(19.98f, 16.9f, 19.08f, 16f, 17.98f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PatternKt._pattern = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

