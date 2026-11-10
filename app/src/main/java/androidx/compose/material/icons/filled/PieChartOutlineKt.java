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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pieChartOutline", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PieChartOutline", "Landroidx/compose/material/icons/Icons$Filled;", "getPieChartOutline", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PieChartOutlineKt {
    private static ImageVector _pieChartOutline;

    static {
    }

    public static final ImageVector getPieChartOutline(Filled arg19) {
        ImageVector v0 = PieChartOutlineKt._pieChartOutline;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PieChartOutline", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.5f, 2f, 2f, 6.5f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.5f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.5f, 10f, -10f);
        v12.reflectiveCurveTo(17.5f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(13f, 4.07f);
        v12.curveToRelative(3.61f, 0.45f, 6.48f, 3.33f, 6.93f, 6.93f);
        v12.horizontalLineTo(13f);
        v12.verticalLineTo(4.07f);
        v12.close();
        v12.moveTo(4f, 12f);
        v12.curveToRelative(0f, -4.06f, 3.07f, -7.44f, 7f, -7.93f);
        v12.verticalLineToRelative(15.87f);
        v12.curveTo(7.07f, 19.440001f, 4f, 16.059999f, 4f, 12f);
        v12.close();
        v12.moveTo(13f, 19.93f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(6.93f);
        v12.curveTo(19.48f, 16.610001f, 16.610001f, 19.48f, 13f, 19.93f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PieChartOutlineKt._pieChartOutline = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

