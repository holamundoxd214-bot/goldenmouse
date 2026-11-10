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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiChannel", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiChannel", "Landroidx/compose/material/icons/Icons$Sharp;", "getWifiChannel", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiChannelKt {
    private static ImageVector _wifiChannel;

    static {
    }

    public static final ImageVector getWifiChannel(Sharp arg19) {
        ImageVector v0 = WifiChannelKt._wifiChannel;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.WifiChannel", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 3f);
        v12.curveToRelative(-2.51f, 0f, -3.77f, 5.61f, -4.4f, 10.57f);
        v12.curveTo(10.79f, 10.66f, 9.61f, 8f, 8f, 8f);
        v12.curveTo(4.43f, 8f, 3f, 21f, 3f, 21f);
        v12.horizontalLineToRelative(2.01f);
        v12.curveToRelative(0.61f, -5.27f, 2f, -9.82f, 2.99f, -10.87f);
        v12.curveToRelative(0.98f, 1.05f, 2.38f, 5.61f, 2.99f, 10.87f);
        v12.horizontalLineTo(13f);
        v12.curveToRelative(0.5f, -2.53f, 2f, -6f, 3f, -6f);
        v12.reflectiveCurveToRelative(2.5f, 3.53f, 3f, 6f);
        v12.horizontalLineToRelative(2f);
        v12.curveTo(21f, 21f, 20.5f, 3f, 16f, 3f);
        v12.close();
        v12.moveTo(16f, 13f);
        v12.curveToRelative(-0.99f, 0f, -1.82f, 0.62f, -2.5f, 1.5f);
        v12.curveToRelative(0.57f, -4.77f, 1.54f, -8.62f, 2.5f, -9.44f);
        v12.curveToRelative(0.97f, 0.81f, 1.91f, 4.67f, 2.49f, 9.43f);
        v12.curveTo(17.809999f, 13.62f, 16.98f, 13f, 16f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiChannelKt._wifiChannel = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

