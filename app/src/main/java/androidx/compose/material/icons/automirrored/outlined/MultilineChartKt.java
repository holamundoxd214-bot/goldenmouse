package androidx.compose.material.icons.automirrored.outlined;

import androidx.compose.material.icons.Icons$AutoMirrored$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_multilineChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MultilineChart", "Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;", "getMultilineChart", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MultilineChartKt {
    private static ImageVector _multilineChart;

    static {
    }

    public static final ImageVector getMultilineChart(Outlined arg19) {
        ImageVector v0 = MultilineChartKt._multilineChart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Outlined.MultilineChart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 6.92f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(-2.85f, 3.21f);
        v12.curveTo(15.68f, 6.4f, 12.83f, 5f, 9.61f, 5f);
        v12.curveTo(6.72f, 5f, 4.07f, 6.16f, 2f, 8f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(5.12f, 7.93f, 7.27f, 7f, 9.61f, 7f);
        v12.curveToRelative(2.74f, 0f, 5.09f, 1.26f, 6.77f, 3.24f);
        v12.lineToRelative(-2.88f, 3.24f);
        v12.lineToRelative(-4f, -4f);
        v12.lineTo(2f, 16.99f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.lineToRelative(6f, -6.01f);
        v12.lineToRelative(4f, 4f);
        v12.lineToRelative(4.05f, -4.55f);
        v12.curveToRelative(0.75f, 1.35f, 1.25f, 2.9f, 1.44f, 4.55f);
        v12.horizontalLineTo(21f);
        v12.curveToRelative(-0.22f, -2.3f, -0.95f, -4.39f, -2.04f, -6.14f);
        v12.lineTo(22f, 6.92f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MultilineChartKt._multilineChart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

