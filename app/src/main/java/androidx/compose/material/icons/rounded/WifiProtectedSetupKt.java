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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiProtectedSetup", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiProtectedSetup", "Landroidx/compose/material/icons/Icons$Rounded;", "getWifiProtectedSetup", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiProtectedSetupKt {
    private static ImageVector _wifiProtectedSetup;

    static {
    }

    public static final ImageVector getWifiProtectedSetup(Rounded arg19) {
        ImageVector v0 = WifiProtectedSetupKt._wifiProtectedSetup;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WifiProtectedSetup", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.700001f, 5.3f);
        v12.lineToRelative(1.44f, -1.44f);
        v12.curveToRelative(0.32f, -0.32f, 0.09f, -0.85f, -0.35f, -0.85f);
        v12.horizontalLineTo(11.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineTo(9.8f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(1.45f, -1.45f);
        v12.curveToRelative(1.97f, 1.46f, 3.25f, 3.78f, 3.25f, 6.42f);
        v12.curveToRelative(0f, 0.66f, -0.08f, 1.31f, -0.24f, 1.92f);
        v12.curveToRelative(-0.12f, 0.5f, 0.48f, 0.86f, 0.84f, 0.49f);
        v12.curveToRelative(1.48f, -1.53f, 2.4f, -3.61f, 2.4f, -5.91f);
        v12.curveTo(19.549999f, 9.11f, 18.440001f, 6.86f, 16.700001f, 5.3f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.15f, 13.86f);
        v12.lineTo(10.7f, 15.3f);
        v12.curveToRelative(-1.97f, -1.46f, -3.25f, -3.78f, -3.25f, -6.42f);
        v12.curveToRelative(0f, -0.66f, 0.08f, -1.31f, 0.24f, -1.92f);
        v12.curveToRelative(0.12f, -0.5f, -0.48f, -0.86f, -0.84f, -0.49f);
        v12.curveToRelative(-1.48f, 1.53f, -2.4f, 3.61f, -2.4f, 5.91f);
        v12.curveToRelative(0f, 2.52f, 1.1f, 4.77f, 2.84f, 6.33f);
        v12.lineToRelative(-1.44f, 1.44f);
        v12.curveToRelative(-0.32f, 0.32f, -0.09f, 0.85f, 0.35f, 0.85f);
        v12.horizontalLineToRelative(6.29f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.verticalLineToRelative(-6.29f);
        v12.curveTo(13f, 13.77f, 12.46f, 13.54f, 12.15f, 13.86f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiProtectedSetupKt._wifiProtectedSetup = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

