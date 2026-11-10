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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bubbleChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BubbleChart", "Landroidx/compose/material/icons/Icons$Outlined;", "getBubbleChart", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BubbleChartKt {
    private static ImageVector _bubbleChart;

    static {
    }

    public static final ImageVector getBubbleChart(Outlined arg19) {
        ImageVector v0 = BubbleChartKt._bubbleChart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.BubbleChart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 10f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveToRelative(-1.79f, -4f, -4f, -4f);
        v12.close();
        v12.moveTo(7f, 16f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.close();
        v12.moveTo(15.01f, 15f);
        v12.curveToRelative(-1.65f, 0f, -3f, 1.35f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.35f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.35f, 3f, -3f);
        v12.reflectiveCurveToRelative(-1.35f, -3f, -3f, -3f);
        v12.close();
        v12.moveTo(15.01f, 19f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v12.moveTo(16.5f, 3f);
        v12.curveTo(13.47f, 3f, 11f, 5.47f, 11f, 8.5f);
        v12.reflectiveCurveToRelative(2.47f, 5.5f, 5.5f, 5.5f);
        v12.reflectiveCurveTo(22f, 11.53f, 22f, 8.5f);
        v12.reflectiveCurveTo(19.530001f, 3f, 16.5f, 3f);
        v12.close();
        v12.moveTo(16.5f, 12f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f);
        v12.reflectiveCurveTo(14.57f, 5f, 16.5f, 5f);
        v12.reflectiveCurveTo(20f, 6.57f, 20f, 8.5f);
        v12.reflectiveCurveTo(18.43f, 12f, 16.5f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BubbleChartKt._bubbleChart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

