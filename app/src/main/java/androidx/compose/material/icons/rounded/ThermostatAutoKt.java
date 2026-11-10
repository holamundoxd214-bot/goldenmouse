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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thermostatAuto", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThermostatAuto", "Landroidx/compose/material/icons/Icons$Rounded;", "getThermostatAuto", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThermostatAutoKt {
    private static ImageVector _thermostatAuto;

    static {
    }

    public static final ImageVector getThermostatAuto(Rounded arg19) {
        ImageVector v0 = ThermostatAutoKt._thermostatAuto;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ThermostatAuto", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 12f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveTo(5f, 4.34f, 5f, 6f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(-1.21f, 0.91f, -2f, 2.37f, -2f, 4f);
        v12.curveToRelative(0f, 1.12f, 0.38f, 2.14f, 1f, 2.97f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(0.02f);
        v12.curveToRelative(0.91f, 1.21f, 2.35f, 2f, 3.98f, 2f);
        v12.reflectiveCurveToRelative(3.06f, -0.79f, 3.98f, -2f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(-0.03f);
        v12.curveToRelative(0.62f, -0.83f, 1f, -1.85f, 1f, -2.97f);
        v12.curveTo(13f, 14.37f, 12.21f, 12.91f, 11f, 12f);
        v12.close();
        v12.moveTo(5f, 16f);
        v12.curveToRelative(0f, -0.94f, 0.45f, -1.84f, 1.2f, -2.4f);
        v12.lineTo(7f, 13f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(7f);
        v12.lineToRelative(0.8f, 0.6f);
        v12.curveToRelative(0.75f, 0.57f, 1.2f, 1.46f, 1.2f, 2.4f);
        v12.horizontalLineTo(5f);
        v12.close();
        v12.moveTo(17.809999f, 4f);
        v12.lineTo(17.809999f, 4f);
        v12.curveToRelative(-0.48f, 0f, -0.92f, 0.3f, -1.09f, 0.75f);
        v12.lineTo(14f, 12.02f);
        v12.curveTo(13.82f, 12.49f, 14.17f, 13f, 14.67f, 13f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.31f, 0f, 0.58f, -0.19f, 0.68f, -0.48f);
        v12.lineTo(16f, 10.7f);
        v12.horizontalLineToRelative(3.63f);
        v12.lineToRelative(0.64f, 1.82f);
        v12.curveToRelative(0.1f, 0.29f, 0.38f, 0.48f, 0.68f, 0.48f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.51f, 0f, 0.86f, -0.51f, 0.68f, -0.98f);
        v12.lineTo(18.9f, 4.75f);
        v12.curveTo(18.73f, 4.3f, 18.299999f, 4f, 17.809999f, 4f);
        v12.close();
        v12.moveTo(16.469999f, 9.39f);
        v12.lineToRelative(1.31f, -3.72f);
        v12.horizontalLineToRelative(0.08f);
        v12.lineToRelative(1.31f, 3.72f);
        v12.horizontalLineTo(16.469999f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThermostatAutoKt._thermostatAuto = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

