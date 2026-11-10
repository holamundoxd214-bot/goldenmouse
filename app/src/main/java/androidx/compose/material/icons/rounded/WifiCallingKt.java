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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiCalling", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiCalling", "Landroidx/compose/material/icons/Icons$Rounded;", "getWifiCalling", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiCallingKt {
    private static ImageVector _wifiCalling;

    static {
    }

    public static final ImageVector getWifiCalling(Rounded arg19) {
        ImageVector v0 = WifiCallingKt._wifiCalling;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WifiCalling", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 4.95f);
        v12.curveTo(21.790001f, 4.78f, 19.67f, 3f, 16.5f, 3f);
        v12.curveToRelative(-3.18f, 0f, -5.29f, 1.78f, -5.5f, 1.95f);
        v12.lineTo(16.5f, 12f);
        v12.lineTo(22f, 4.95f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.200001f, 15.28f);
        v12.lineToRelative(-2.54f, -0.29f);
        v12.curveToRelative(-0.61f, -0.07f, -1.21f, 0.14f, -1.64f, 0.57f);
        v12.lineToRelative(-1.84f, 1.84f);
        v12.curveToRelative(-2.83f, -1.44f, -5.15f, -3.75f, -6.59f, -6.59f);
        v12.lineToRelative(1.85f, -1.85f);
        v12.curveToRelative(0.43f, -0.43f, 0.64f, -1.04f, 0.57f, -1.64f);
        v12.lineTo(8.72f, 4.8f);
        v12.curveTo(8.6f, 3.79f, 7.75f, 3.03f, 6.73f, 3.03f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-1.13f, 0f, -2.07f, 0.94f, -2f, 2.07f);
        v12.curveTo(3.53f, 13.64f, 10.36f, 20.469999f, 18.9f, 21f);
        v12.curveToRelative(1.13f, 0.07f, 2.07f, -0.87f, 2.07f, -2f);
        v12.verticalLineToRelative(-1.73f);
        v12.curveTo(20.969999f, 16.25f, 20.209999f, 15.4f, 19.200001f, 15.28f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiCallingKt._wifiCalling = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

