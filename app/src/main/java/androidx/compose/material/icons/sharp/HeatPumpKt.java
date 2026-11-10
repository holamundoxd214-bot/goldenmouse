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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_heatPump", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HeatPump", "Landroidx/compose/material/icons/Icons$Sharp;", "getHeatPump", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HeatPumpKt {
    private static ImageVector _heatPump;

    static {
    }

    public static final ImageVector getHeatPump(Sharp arg19) {
        ImageVector v0 = HeatPumpKt._heatPump;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.HeatPump", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 3f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(18f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineTo(3f);
        v12.close();
        v12.moveTo(12.75f, 7.08f);
        v12.curveToRelative(0.82f, 0.12f, 1.57f, 0.44f, 2.2f, 0.91f);
        v12.lineToRelative(-2.2f, 2.2f);
        v12.verticalLineTo(7.08f);
        v12.close();
        v12.moveTo(11.25f, 7.08f);
        v12.verticalLineToRelative(3.11f);
        v12.lineToRelative(-2.2f, -2.2f);
        v12.curveTo(9.68f, 7.52f, 10.43f, 7.2f, 11.25f, 7.08f);
        v12.close();
        v12.moveTo(7.99f, 9.05f);
        v12.lineToRelative(2.2f, 2.2f);
        v12.horizontalLineTo(7.08f);
        v12.curveTo(7.2f, 10.43f, 7.52f, 9.68f, 7.99f, 9.05f);
        v12.close();
        v12.moveTo(7.08f, 12.75f);
        v12.horizontalLineToRelative(3.11f);
        v12.lineToRelative(-2.2f, 2.2f);
        v12.curveTo(7.52f, 14.32f, 7.2f, 13.57f, 7.08f, 12.75f);
        v12.close();
        v12.moveTo(11.25f, 16.92f);
        v12.curveToRelative(-0.82f, -0.12f, -1.57f, -0.44f, -2.2f, -0.91f);
        v12.lineToRelative(2.2f, -2.2f);
        v12.verticalLineTo(16.92f);
        v12.close();
        v12.moveTo(12f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(13f, 12.55f, 12.55f, 13f, 12f, 13f);
        v12.close();
        v12.moveTo(12.75f, 16.92f);
        v12.verticalLineToRelative(-3.11f);
        v12.lineToRelative(2.2f, 2.2f);
        v12.curveTo(14.32f, 16.48f, 13.57f, 16.799999f, 12.75f, 16.92f);
        v12.close();
        v12.moveTo(16.01f, 14.95f);
        v12.lineToRelative(-2.2f, -2.2f);
        v12.horizontalLineToRelative(3.11f);
        v12.curveTo(16.799999f, 13.57f, 16.48f, 14.32f, 16.01f, 14.95f);
        v12.close();
        v12.moveTo(13.81f, 11.25f);
        v12.lineToRelative(2.2f, -2.2f);
        v12.curveToRelative(0.47f, 0.64f, 0.79f, 1.39f, 0.91f, 2.2f);
        v12.horizontalLineTo(13.81f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HeatPumpKt._heatPump = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

