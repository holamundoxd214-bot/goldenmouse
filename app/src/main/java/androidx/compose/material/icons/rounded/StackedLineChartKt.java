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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_stackedLineChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StackedLineChart", "Landroidx/compose/material/icons/Icons$Rounded;", "getStackedLineChart", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StackedLineChartKt {
    private static ImageVector _stackedLineChart;

    static {
    }

    public static final ImageVector getStackedLineChart(Rounded arg19) {
        ImageVector v0 = StackedLineChartKt._stackedLineChart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.StackedLineChart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.79f, 14.78f);
        v12.lineTo(2.7f, 14.69f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(6.09f, -6.1f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(3.29f, 3.29f);
        v12.lineToRelative(6.39f, -7.18f);
        v12.curveToRelative(0.38f, -0.43f, 1.05f, -0.44f, 1.45f, -0.04f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.37f, 0.38f, 0.39f, 0.98f, 0.04f, 1.37f);
        v12.lineToRelative(-7.17f, 8.07f);
        v12.curveToRelative(-0.38f, 0.43f, -1.04f, 0.45f, -1.45f, 0.04f);
        v12.lineTo(9.5f, 9.48f);
        v12.lineToRelative(-5.3f, 5.3f);
        v12.curveTo(3.82f, 15.17f, 3.18f, 15.17f, 2.79f, 14.78f);
        v12.close();
        v12.moveTo(4.2f, 20.780001f);
        v12.lineToRelative(5.3f, -5.3f);
        v12.lineToRelative(3.25f, 3.25f);
        v12.curveToRelative(0.41f, 0.41f, 1.07f, 0.39f, 1.45f, -0.04f);
        v12.lineToRelative(7.17f, -8.07f);
        v12.curveToRelative(0.35f, -0.39f, 0.33f, -0.99f, -0.04f, -1.37f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.4f, -0.4f, -1.07f, -0.39f, -1.45f, 0.04f);
        v12.lineToRelative(-6.39f, 7.18f);
        v12.lineToRelative(-3.29f, -3.29f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(-6.09f, 6.1f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0.09f, 0.09f);
        v12.curveTo(3.18f, 21.17f, 3.82f, 21.17f, 4.2f, 20.780001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StackedLineChartKt._stackedLineChart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

