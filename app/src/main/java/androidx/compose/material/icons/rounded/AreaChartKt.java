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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_areaChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AreaChart", "Landroidx/compose/material/icons/Icons$Rounded;", "getAreaChart", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AreaChartKt {
    private static ImageVector _areaChart;

    static {
    }

    public static final ImageVector getAreaChart(Rounded arg19) {
        ImageVector v0 = AreaChartKt._areaChart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AreaChart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 17f);
        v12.lineToRelative(3.39f, -4.66f);
        v12.curveToRelative(0.33f, -0.46f, 0.98f, -0.55f, 1.42f, -0.2f);
        v12.lineTo(21f, 18.5f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.lineToRelative(0f, -5.72f);
        v12.curveToRelative(0.22f, 0f, 0.44f, 0.07f, 0.62f, 0.22f);
        v12.lineTo(8f, 17f);
        v12.close();
        v12.moveTo(3f, 11f);
        v12.curveToRelative(0.44f, 0f, 0.88f, 0.15f, 1.25f, 0.44f);
        v12.lineToRelative(3.37f, 2.69f);
        v12.lineToRelative(2.77f, -3.81f);
        v12.curveToRelative(0.66f, -0.91f, 1.95f, -1.1f, 2.85f, -0.4f);
        v12.lineTo(21f, 15.97f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3f);
        v12.lineToRelative(-4.18f, -3.34f);
        v12.curveToRelative(-0.45f, -0.36f, -1.1f, -0.27f, -1.44f, 0.2f);
        v12.lineTo(7f, 10f);
        v12.lineTo(3.6f, 7.45f);
        v12.curveTo(3.42f, 7.32f, 3.21f, 7.25f, 3f, 7.25f);
        v12.lineTo(3f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AreaChartKt._areaChart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

