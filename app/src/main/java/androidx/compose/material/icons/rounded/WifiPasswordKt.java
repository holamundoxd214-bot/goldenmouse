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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiPassword", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiPassword", "Landroidx/compose/material/icons/Icons$Rounded;", "getWifiPassword", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiPasswordKt {
    private static ImageVector _wifiPassword;

    static {
    }

    public static final ImageVector getWifiPassword(Rounded arg19) {
        ImageVector v0 = WifiPasswordKt._wifiPassword;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WifiPassword", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.49f, 12.13f);
        v12.curveTo(16.67f, 10.79f, 14.43f, 10f, 12f, 10f);
        v12.curveToRelative(-2.43f, 0f, -4.67f, 0.79f, -6.49f, 2.13f);
        v12.curveToRelative(-0.72f, 0.53f, -0.76f, 1.6f, -0.13f, 2.24f);
        v12.curveToRelative(0.53f, 0.54f, 1.37f, 0.57f, 1.98f, 0.12f);
        v12.curveTo(8.67f, 13.55f, 10.27f, 13f, 12f, 13f);
        v12.curveToRelative(1.73f, 0f, 3.33f, 0.55f, 4.64f, 1.49f);
        v12.curveToRelative(0.62f, 0.44f, 1.45f, 0.41f, 1.98f, -0.12f);
        v12.curveTo(19.26f, 13.73f, 19.219999f, 12.66f, 18.49f, 12.13f);
        v12.close();
        v12.moveTo(22.799999f, 7.89f);
        v12.curveTo(19.860001f, 5.46f, 16.1f, 4f, 12f, 4f);
        v12.reflectiveCurveTo(4.14f, 5.46f, 1.2f, 7.89f);
        v12.curveTo(0.53f, 8.44f, 0.49f, 9.47f, 1.11f, 10.1f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.55f, 0.55f, 1.42f, 0.58f, 2.02f, 0.09f);
        v12.curveTo(5.55f, 8.2f, 8.64f, 7f, 12f, 7f);
        v12.reflectiveCurveToRelative(6.45f, 1.2f, 8.87f, 3.19f);
        v12.curveToRelative(0.6f, 0.49f, 1.47f, 0.46f, 2.02f, -0.09f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(23.51f, 9.47f, 23.469999f, 8.44f, 22.799999f, 7.89f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(13.1f, 16f, 12f, 16f);
        v12.close();
        v12.moveTo(23f, 19f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(24f, 19.450001f, 23.549999f, 19f, 23f, 19f);
        v12.close();
        v12.moveTo(22f, 19f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiPasswordKt._wifiPassword = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

