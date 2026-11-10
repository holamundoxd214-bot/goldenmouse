package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_multilineChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MultilineChart", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getMultilineChart", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MultilineChartKt {
    private static ImageVector _multilineChart;

    static {
    }

    public static final ImageVector getMultilineChart(Rounded arg19) {
        ImageVector v0 = MultilineChartKt._multilineChart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.MultilineChart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.360001f, 6.28f);
        v12.lineToRelative(-0.06f, -0.06f);
        v12.curveToRelative(-0.39f, -0.39f, -1.03f, -0.37f, -1.39f, 0.04f);
        v12.lineToRelative(-2.18f, 2.45f);
        v12.curveTo(15.68f, 6.4f, 12.83f, 5f, 9.61f, 5f);
        v12.curveToRelative(-2.5f, 0f, -4.83f, 0.87f, -6.75f, 2.3f);
        v12.curveToRelative(-0.47f, 0.35f, -0.52f, 1.04f, -0.11f, 1.45f);
        v12.lineToRelative(0.06f, 0.06f);
        v12.curveToRelative(0.33f, 0.33f, 0.86f, 0.39f, 1.23f, 0.11f);
        v12.curveTo(5.63f, 7.72f, 7.54f, 7f, 9.61f, 7f);
        v12.curveToRelative(2.74f, 0f, 5.09f, 1.26f, 6.77f, 3.24f);
        v12.lineToRelative(-2.88f, 3.24f);
        v12.lineToRelative(-3.29f, -3.29f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(-6.12f, 6.13f);
        v12.curveToRelative(-0.37f, 0.37f, -0.37f, 0.98f, 0f, 1.35f);
        v12.lineToRelative(0.15f, 0.15f);
        v12.curveToRelative(0.37f, 0.37f, 0.98f, 0.37f, 1.35f, 0f);
        v12.lineToRelative(5.32f, -5.33f);
        v12.lineToRelative(3.25f, 3.25f);
        v12.curveToRelative(0.41f, 0.41f, 1.07f, 0.39f, 1.45f, -0.04f);
        v12.lineToRelative(3.35f, -3.76f);
        v12.curveToRelative(0.62f, 1.12f, 1.08f, 2.39f, 1.32f, 3.73f);
        v12.curveToRelative(0.08f, 0.47f, 0.47f, 0.82f, 0.95f, 0.82f);
        v12.horizontalLineToRelative(0.09f);
        v12.curveToRelative(0.6f, 0f, 1.05f, -0.55f, 0.94f, -1.14f);
        v12.curveToRelative(-0.32f, -1.85f, -0.98f, -3.54f, -1.89f, -5f);
        v12.lineTo(21.4f, 7.6f);
        v12.curveToRelative(0.34f, -0.38f, 0.32f, -0.96f, -0.04f, -1.32f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MultilineChartKt._multilineChart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

