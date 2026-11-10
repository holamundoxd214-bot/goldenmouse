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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pieChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PieChart", "Landroidx/compose/material/icons/Icons$Rounded;", "getPieChart", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PieChartKt {
    private static ImageVector _pieChart;

    static {
    }

    public static final ImageVector getPieChart(Rounded arg19) {
        ImageVector v0 = PieChartKt._pieChart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PieChart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 3.18f);
        v12.verticalLineToRelative(17.639999f);
        v12.curveToRelative(0f, 0.64f, -0.59f, 1.12f, -1.21f, 0.98f);
        v12.curveTo(5.32f, 20.799999f, 2f, 16.790001f, 2f, 12f);
        v12.reflectiveCurveToRelative(3.32f, -8.8f, 7.79f, -9.8f);
        v12.curveToRelative(0.62f, -0.14f, 1.21f, 0.34f, 1.21f, 0.98f);
        v12.close();
        v12.moveTo(13.03f, 3.18f);
        v12.verticalLineToRelative(6.81f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6.79f);
        v12.curveToRelative(0.64f, 0f, 1.12f, -0.59f, 0.98f, -1.22f);
        v12.curveToRelative(-0.85f, -3.76f, -3.8f, -6.72f, -7.55f, -7.57f);
        v12.curveToRelative(-0.63f, -0.14f, -1.22f, 0.34f, -1.22f, 0.98f);
        v12.close();
        v12.moveTo(13.03f, 14.01f);
        v12.verticalLineToRelative(6.81f);
        v12.curveToRelative(0f, 0.64f, 0.59f, 1.12f, 1.22f, 0.98f);
        v12.curveToRelative(3.76f, -0.85f, 6.71f, -3.82f, 7.56f, -7.58f);
        v12.curveToRelative(0.14f, -0.62f, -0.35f, -1.22f, -0.98f, -1.22f);
        v12.horizontalLineToRelative(-6.79f);
        v12.curveToRelative(-0.56f, 0.01f, -1.01f, 0.46f, -1.01f, 1.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PieChartKt._pieChart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

