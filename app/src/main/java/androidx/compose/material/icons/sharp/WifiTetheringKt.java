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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiTethering", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiTethering", "Landroidx/compose/material/icons/Icons$Sharp;", "getWifiTethering", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiTetheringKt {
    private static ImageVector _wifiTethering;

    static {
    }

    public static final ImageVector getWifiTethering(Sharp arg19) {
        ImageVector v0 = WifiTetheringKt._wifiTethering;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.WifiTethering", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 11f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(18f, 13f);
        v12.curveToRelative(0f, -3.31f, -2.69f, -6f, -6f, -6f);
        v12.reflectiveCurveToRelative(-6f, 2.69f, -6f, 6f);
        v12.curveToRelative(0f, 2.22f, 1.21f, 4.15f, 3f, 5.19f);
        v12.lineToRelative(1f, -1.74f);
        v12.curveToRelative(-1.19f, -0.7f, -2f, -1.97f, -2f, -3.45f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 1.48f, -0.81f, 2.75f, -2f, 3.45f);
        v12.lineToRelative(1f, 1.74f);
        v12.curveToRelative(1.79f, -1.04f, 3f, -2.97f, 3f, -5.19f);
        v12.close();
        v12.moveTo(12f, 3f);
        v12.curveTo(6.48f, 3f, 2f, 7.48f, 2f, 13f);
        v12.curveToRelative(0f, 3.7f, 2.01f, 6.92f, 4.99f, 8.65f);
        v12.lineToRelative(1f, -1.73f);
        v12.curveTo(5.61f, 18.530001f, 4f, 15.96f, 4f, 13f);
        v12.curveToRelative(0f, -4.42f, 3.58f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.58f, 8f, 8f);
        v12.curveToRelative(0f, 2.96f, -1.61f, 5.53f, -4f, 6.92f);
        v12.lineToRelative(1f, 1.73f);
        v12.curveToRelative(2.99f, -1.73f, 5f, -4.95f, 5f, -8.65f);
        v12.curveToRelative(0f, -5.52f, -4.48f, -10f, -10f, -10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiTetheringKt._wifiTethering = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

