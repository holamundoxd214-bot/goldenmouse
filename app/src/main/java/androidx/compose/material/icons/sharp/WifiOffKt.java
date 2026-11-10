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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiOff", "Landroidx/compose/material/icons/Icons$Sharp;", "getWifiOff", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiOffKt {
    private static ImageVector _wifiOff;

    static {
    }

    public static final ImageVector getWifiOff(Sharp arg19) {
        ImageVector v0 = WifiOffKt._wifiOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.WifiOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 11f);
        v12.lineToRelative(2f, -2f);
        v12.curveToRelative(-3.73f, -3.73f, -8.87f, -5.15f, -13.7f, -4.31f);
        v12.lineToRelative(2.58f, 2.58f);
        v12.curveToRelative(3.3f, -0.02f, 6.61f, 1.22f, 9.12f, 3.73f);
        v12.close();
        v12.moveTo(9f, 17f);
        v12.lineToRelative(3f, 3f);
        v12.lineToRelative(3f, -3f);
        v12.curveToRelative(-1.65f, -1.66f, -4.34f, -1.66f, -6f, 0f);
        v12.close();
        v12.moveTo(19f, 13f);
        v12.curveToRelative(-1.08f, -1.08f, -2.36f, -1.85f, -3.72f, -2.33f);
        v12.lineToRelative(3.02f, 3.02f);
        v12.lineToRelative(0.7f, -0.69f);
        v12.close();
        v12.moveTo(3.41f, 1.64f);
        v12.lineTo(2f, 3.05f);
        v12.lineTo(5.05f, 6.1f);
        v12.curveTo(3.59f, 6.83f, 2.22f, 7.79f, 1f, 9f);
        v12.lineToRelative(2f, 2f);
        v12.curveToRelative(1.23f, -1.23f, 2.65f, -2.16f, 4.17f, -2.78f);
        v12.lineToRelative(2.24f, 2.24f);
        v12.curveTo(7.79f, 10.89f, 6.27f, 11.74f, 5f, 13f);
        v12.lineToRelative(2f, 2f);
        v12.curveToRelative(1.35f, -1.35f, 3.11f, -2.04f, 4.89f, -2.06f);
        v12.lineToRelative(7.08f, 7.08f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(3.41f, 1.64f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiOffKt._wifiOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

