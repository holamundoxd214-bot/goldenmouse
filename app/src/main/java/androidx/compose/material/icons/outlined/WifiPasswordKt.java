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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiPassword", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiPassword", "Landroidx/compose/material/icons/Icons$Outlined;", "getWifiPassword", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiPasswordKt {
    private static ImageVector _wifiPassword;

    static {
    }

    public static final ImageVector getWifiPassword(Outlined arg19) {
        ImageVector v0 = WifiPasswordKt._wifiPassword;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.WifiPassword", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(24f, 8.98f);
        v12.lineToRelative(-2.12f, 2.13f);
        v12.curveTo(19.35f, 8.57f, 15.85f, 7f, 12f, 7f);
        v12.reflectiveCurveToRelative(-7.35f, 1.57f, -9.88f, 4.11f);
        v12.lineTo(0f, 8.98f);
        v12.curveTo(3.07f, 5.9f, 7.31f, 4f, 12f, 4f);
        v12.reflectiveCurveTo(20.93f, 5.9f, 24f, 8.98f);
        v12.close();
        v12.moveTo(4.24f, 13.22f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.curveTo(7.8f, 13.9f, 9.8f, 13f, 12f, 13f);
        v12.curveToRelative(2.2f, 0f, 4.2f, 0.9f, 5.64f, 2.35f);
        v12.lineToRelative(2.12f, -2.12f);
        v12.curveTo(17.780001f, 11.23f, 15.03f, 10f, 12f, 10f);
        v12.curveTo(8.97f, 10f, 6.22f, 11.23f, 4.24f, 13.22f);
        v12.close();
        v12.moveTo(24f, 20f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(1f);
        v12.curveTo(23.549999f, 19f, 24f, 19.450001f, 24f, 20f);
        v12.close();
        v12.moveTo(22f, 18f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(18f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-1.38f, 0f, -2.63f, 0.56f, -3.53f, 1.46f);
        v12.lineTo(12f, 21f);
        v12.lineToRelative(3.53f, -3.54f);
        v12.curveTo(14.63f, 16.559999f, 13.38f, 16f, 12f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiPasswordKt._wifiPassword = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

