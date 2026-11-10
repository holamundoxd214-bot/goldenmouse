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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_heatPump", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HeatPump", "Landroidx/compose/material/icons/Icons$Outlined;", "getHeatPump", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HeatPumpKt {
    private static ImageVector _heatPump;

    static {
    }

    public static final ImageVector getHeatPump(Outlined arg19) {
        ImageVector v0 = HeatPumpKt._heatPump;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.HeatPump", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineTo(19f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(3.31f, 0f, 6f, -2.69f, 6f, -6f);
        v12.reflectiveCurveToRelative(-2.69f, -6f, -6f, -6f);
        v12.reflectiveCurveToRelative(-6f, 2.69f, -6f, 6f);
        v12.reflectiveCurveTo(8.69f, 18f, 12f, 18f);
        v12.close();
        v12.moveTo(11.25f, 15.92f);
        v12.curveToRelative(-0.55f, -0.1f, -1.05f, -0.32f, -1.5f, -0.62f);
        v12.lineToRelative(1.5f, -1.5f);
        v12.verticalLineTo(15.92f);
        v12.close();
        v12.moveTo(12.75f, 15.92f);
        v12.verticalLineToRelative(-2.11f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveTo(13.8f, 15.61f, 13.3f, 15.82f, 12.75f, 15.92f);
        v12.close();
        v12.moveTo(15.31f, 14.25f);
        v12.lineToRelative(-1.5f, -1.5f);
        v12.horizontalLineToRelative(2.11f);
        v12.curveTo(15.82f, 13.3f, 15.61f, 13.8f, 15.31f, 14.25f);
        v12.close();
        v12.moveTo(15.92f, 11.25f);
        v12.horizontalLineToRelative(-2.11f);
        v12.lineToRelative(1.5f, -1.5f);
        v12.curveTo(15.61f, 10.2f, 15.82f, 10.7f, 15.92f, 11.25f);
        v12.close();
        v12.moveTo(12.75f, 8.08f);
        v12.curveToRelative(0.55f, 0.1f, 1.05f, 0.32f, 1.5f, 0.62f);
        v12.lineToRelative(-1.5f, 1.5f);
        v12.verticalLineTo(8.08f);
        v12.close();
        v12.moveTo(12f, 11f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.curveTo(11f, 11.45f, 11.45f, 11f, 12f, 11f);
        v12.close();
        v12.moveTo(11.25f, 8.08f);
        v12.verticalLineToRelative(2.11f);
        v12.lineToRelative(-1.5f, -1.5f);
        v12.curveTo(10.2f, 8.39f, 10.7f, 8.18f, 11.25f, 8.08f);
        v12.close();
        v12.moveTo(8.69f, 9.75f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.horizontalLineTo(8.08f);
        v12.curveTo(8.18f, 10.7f, 8.39f, 10.2f, 8.69f, 9.75f);
        v12.close();
        v12.moveTo(10.19f, 12.75f);
        v12.lineToRelative(-1.5f, 1.5f);
        v12.curveToRelative(-0.3f, -0.44f, -0.51f, -0.95f, -0.62f, -1.5f);
        v12.horizontalLineTo(10.19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HeatPumpKt._heatPump = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

