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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiProtectedSetup", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiProtectedSetup", "Landroidx/compose/material/icons/Icons$Outlined;", "getWifiProtectedSetup", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiProtectedSetupKt {
    private static ImageVector _wifiProtectedSetup;

    static {
    }

    public static final ImageVector getWifiProtectedSetup(Outlined arg19) {
        ImageVector v0 = WifiProtectedSetupKt._wifiProtectedSetup;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.WifiProtectedSetup", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.709999f, 5.29f);
        v12.lineTo(19f, 3f);
        v12.horizontalLineToRelative(-8f);
        v12.verticalLineToRelative(8f);
        v12.lineToRelative(2.3f, -2.3f);
        v12.curveToRelative(1.97f, 1.46f, 3.25f, 3.78f, 3.25f, 6.42f);
        v12.curveToRelative(0f, 1.31f, -0.32f, 2.54f, -0.88f, 3.63f);
        v12.curveToRelative(2.33f, -1.52f, 3.88f, -4.14f, 3.88f, -7.13f);
        v12.curveTo(19.549999f, 9.1f, 18.440001f, 6.85f, 16.709999f, 5.29f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7.46f, 8.88f);
        v12.curveToRelative(0f, -1.31f, 0.32f, -2.54f, 0.88f, -3.63f);
        v12.curveTo(6f, 6.77f, 4.46f, 9.39f, 4.46f, 12.38f);
        v12.curveToRelative(0f, 2.52f, 1.1f, 4.77f, 2.84f, 6.33f);
        v12.lineTo(5f, 21f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-8f);
        v12.lineToRelative(-2.3f, 2.3f);
        v12.curveTo(8.74f, 13.84f, 7.46f, 11.52f, 7.46f, 8.88f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiProtectedSetupKt._wifiProtectedSetup = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

