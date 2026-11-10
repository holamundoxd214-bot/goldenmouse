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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_ssidChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SsidChart", "Landroidx/compose/material/icons/Icons$Rounded;", "getSsidChart", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SsidChartKt {
    private static ImageVector _ssidChart;

    static {
    }

    public static final ImageVector getSsidChart(Rounded arg19) {
        ImageVector v0 = SsidChartKt._ssidChart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SsidChart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 9.03f);
        v12.curveToRelative(0f, -0.32f, 0.15f, -0.62f, 0.41f, -0.81f);
        v12.lineTo(7.14f, 5.5f);
        v12.curveToRelative(0.4f, -0.29f, 0.95f, -0.25f, 1.3f, 0.1f);
        v12.lineToRelative(3.78f, 3.78f);
        v12.lineToRelative(7.2f, -5.23f);
        v12.curveTo(20.07f, 3.67f, 21f, 4.14f, 21f, 4.96f);
        v12.curveToRelative(0f, 0.32f, -0.15f, 0.62f, -0.41f, 0.81f);
        v12.lineToRelative(-7.9f, 5.73f);
        v12.curveToRelative(-0.4f, 0.29f, -0.95f, 0.25f, -1.29f, -0.1f);
        v12.lineTo(7.62f, 7.62f);
        v12.lineTo(4.59f, 9.84f);
        v12.curveTo(3.93f, 10.32f, 3f, 9.85f, 3f, 9.03f);
        v12.close();
        v12.moveTo(21f, 16f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3.35f);
        v12.curveToRelative(-0.23f, 0f, -0.45f, 0.08f, -0.62f, 0.22f);
        v12.lineToRelative(-3.9f, 3.12f);
        v12.lineTo(6.6f, 12.99f);
        v12.curveToRelative(-0.35f, -0.34f, -0.88f, -0.38f, -1.27f, -0.1f);
        v12.lineToRelative(-1.9f, 1.35f);
        v12.curveTo(3.16f, 14.43f, 3f, 14.74f, 3f, 15.06f);
        v12.curveToRelative(0f, 0.81f, 0.92f, 1.29f, 1.58f, 0.81f);
        v12.lineTo(5.8f, 15f);
        v12.lineToRelative(5.57f, 5.39f);
        v12.curveToRelative(0.36f, 0.35f, 0.93f, 0.38f, 1.32f, 0.06f);
        v12.lineTo(17f, 17f);
        v12.horizontalLineToRelative(3f);
        v12.curveTo(20.549999f, 17f, 21f, 16.549999f, 21f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SsidChartKt._ssidChart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

