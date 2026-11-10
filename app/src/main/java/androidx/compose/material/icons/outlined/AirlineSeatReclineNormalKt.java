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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_airlineSeatReclineNormal", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AirlineSeatReclineNormal", "Landroidx/compose/material/icons/Icons$Outlined;", "getAirlineSeatReclineNormal", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirlineSeatReclineNormalKt {
    private static ImageVector _airlineSeatReclineNormal;

    static {
    }

    public static final ImageVector getAirlineSeatReclineNormal(Outlined arg19) {
        ImageVector v0 = AirlineSeatReclineNormalKt._airlineSeatReclineNormal;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AirlineSeatReclineNormal", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.59f, 5.41f);
        v12.curveToRelative(-0.78f, -0.78f, -0.78f, -2.05f, 0f, -2.83f);
        v12.reflectiveCurveToRelative(2.05f, -0.78f, 2.83f, 0f);
        v12.reflectiveCurveToRelative(0.78f, 2.05f, 0f, 2.83f);
        v12.curveToRelative(-0.79f, 0.79f, -2.05f, 0.79f, -2.83f, 0f);
        v12.close();
        v12.moveTo(6f, 16f);
        v12.lineTo(6f, 7f);
        v12.lineTo(4f, 7f);
        v12.verticalLineToRelative(9f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(9f, 19f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.close();
        v12.moveTo(20f, 20.07f);
        v12.lineTo(14.93f, 15f);
        v12.lineTo(11.5f, 15f);
        v12.verticalLineToRelative(-3.68f);
        v12.curveToRelative(1.4f, 1.15f, 3.6f, 2.16f, 5.5f, 2.16f);
        v12.verticalLineToRelative(-2.16f);
        v12.curveToRelative(-1.66f, 0.02f, -3.61f, -0.87f, -4.67f, -2.04f);
        v12.lineToRelative(-1.4f, -1.55f);
        v12.curveToRelative(-0.19f, -0.21f, -0.43f, -0.38f, -0.69f, -0.5f);
        v12.curveToRelative(-0.29f, -0.14f, -0.62f, -0.23f, -0.96f, -0.23f);
        v12.horizontalLineToRelative(-0.03f);
        v12.curveTo(8.01f, 7f, 7f, 8.01f, 7f, 9.25f);
        v12.lineTo(7f, 15f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.horizontalLineToRelative(5.07f);
        v12.lineToRelative(3.5f, 3.5f);
        v12.lineTo(20f, 20.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirlineSeatReclineNormalKt._airlineSeatReclineNormal = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

