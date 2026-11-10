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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiTethering", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiTethering", "Landroidx/compose/material/icons/Icons$Rounded;", "getWifiTethering", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiTetheringKt {
    private static ImageVector _wifiTethering;

    static {
    }

    public static final ImageVector getWifiTethering(Rounded arg19) {
        ImageVector v0 = WifiTetheringKt._wifiTethering;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WifiTethering", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.curveToRelative(0f, -3.56f, -3.11f, -6.4f, -6.75f, -5.95f);
        v12.curveToRelative(-2.62f, 0.32f, -4.78f, 2.41f, -5.18f, 5.02f);
        v12.curveToRelative(-0.33f, 2.15f, 0.49f, 4.11f, 1.93f, 5.4f);
        v12.curveToRelative(0.48f, 0.43f, 1.23f, 0.33f, 1.56f, -0.23f);
        v12.lineToRelative(0.01f, -0.01f);
        v12.curveToRelative(0.24f, -0.42f, 0.14f, -0.93f, -0.22f, -1.26f);
        v12.curveToRelative(-1.03f, -0.93f, -1.59f, -2.37f, -1.22f, -3.94f);
        v12.curveToRelative(0.33f, -1.42f, 1.48f, -2.57f, 2.9f, -2.91f);
        v12.curveTo(13.65f, 8.49f, 16f, 10.47f, 16f, 13f);
        v12.curveToRelative(0f, 1.18f, -0.52f, 2.23f, -1.33f, 2.96f);
        v12.curveToRelative(-0.36f, 0.32f, -0.47f, 0.84f, -0.23f, 1.26f);
        v12.lineToRelative(0.01f, 0.01f);
        v12.curveToRelative(0.31f, 0.53f, 1.03f, 0.69f, 1.5f, 0.28f);
        v12.curveTo(17.200001f, 16.41f, 18f, 14.8f, 18f, 13f);
        v12.close();
        v12.moveTo(10.83f, 3.07f);
        v12.curveToRelative(-4.62f, 0.52f, -8.35f, 4.33f, -8.78f, 8.96f);
        v12.curveToRelative(-0.35f, 3.7f, 1.32f, 7.02f, 4.02f, 9.01f);
        v12.curveToRelative(0.48f, 0.35f, 1.16f, 0.2f, 1.46f, -0.31f);
        v12.curveToRelative(0.25f, -0.43f, 0.14f, -0.99f, -0.26f, -1.29f);
        v12.curveToRelative(-2.28f, -1.69f, -3.65f, -4.55f, -3.16f, -7.7f);
        v12.curveToRelative(0.54f, -3.5f, 3.46f, -6.29f, 6.98f, -6.68f);
        v12.curveTo(15.91f, 4.51f, 20f, 8.28f, 20f, 13f);
        v12.curveToRelative(0f, 2.65f, -1.29f, 4.98f, -3.27f, 6.44f);
        v12.curveToRelative(-0.4f, 0.3f, -0.51f, 0.85f, -0.26f, 1.29f);
        v12.curveToRelative(0.3f, 0.52f, 0.98f, 0.66f, 1.46f, 0.31f);
        v12.curveTo(20.4f, 19.219999f, 22f, 16.299999f, 22f, 13f);
        v12.curveToRelative(0f, -5.91f, -5.13f, -10.62f, -11.17f, -9.93f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiTetheringKt._wifiTethering = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

