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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifiFind", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiFind", "Landroidx/compose/material/icons/Icons$Outlined;", "getWifiFind", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WifiFindKt {
    private static ImageVector _wifiFind;

    static {
    }

    public static final ImageVector getWifiFind(Outlined arg19) {
        ImageVector v0 = WifiFindKt._wifiFind;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.WifiFind", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(4.14f, 0f, 7.88f, 1.68f, 10.59f, 4.39f);
        v12.lineTo(24f, 8.98f);
        v12.curveTo(20.93f, 5.9f, 16.690001f, 4f, 12f, 4f);
        v12.curveTo(7.31f, 4f, 3.07f, 5.9f, 0f, 8.98f);
        v12.lineTo(12f, 21f);
        v12.lineToRelative(1.41f, -1.42f);
        v12.lineTo(2.93f, 9.08f);
        v12.curveTo(5.45f, 7.16f, 8.59f, 6f, 12f, 6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21f, 14f);
        v12.curveToRelative(0f, -2.24f, -1.76f, -4f, -4f, -4f);
        v12.reflectiveCurveToRelative(-4f, 1.76f, -4f, 4f);
        v12.curveToRelative(0f, 2.24f, 1.76f, 4f, 4f, 4f);
        v12.curveToRelative(0.75f, 0f, 1.44f, -0.21f, 2.03f, -0.56f);
        v12.lineTo(21.59f, 20f);
        v12.lineTo(23f, 18.59f);
        v12.lineToRelative(-2.56f, -2.56f);
        v12.curveTo(20.790001f, 15.44f, 21f, 14.75f, 21f, 14f);
        v12.close();
        v12.moveTo(17f, 16f);
        v12.curveToRelative(-1.12f, 0f, -2f, -0.88f, -2f, -2f);
        v12.curveToRelative(0f, -1.12f, 0.88f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.88f, 2f, 2f);
        v12.curveTo(19f, 15.12f, 18.120001f, 16f, 17f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WifiFindKt._wifiFind = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

