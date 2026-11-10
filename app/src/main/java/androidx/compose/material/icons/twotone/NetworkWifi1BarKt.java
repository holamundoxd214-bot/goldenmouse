package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_networkWifi1Bar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NetworkWifi1Bar", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNetworkWifi1Bar", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NetworkWifi1BarKt {
    private static ImageVector _networkWifi1Bar;

    static {
    }

    public static final ImageVector getNetworkWifi1Bar(TwoTone arg19) {
        ImageVector v0 = NetworkWifi1BarKt._networkWifi1Bar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.NetworkWifi1Bar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.32f, 14.84f);
        v12.curveTo(14.34f, 14.3f, 13.2f, 14f, 12f, 14f);
        v12.curveToRelative(-1.2f, 0f, -2.34f, 0.3f, -3.32f, 0.84f);
        v12.lineTo(2.92f, 9.07f);
        v12.curveTo(5.51f, 7.08f, 8.67f, 6f, 12f, 6f);
        v12.reflectiveCurveToRelative(6.49f, 1.08f, 9.08f, 3.07f);
        v12.lineTo(15.32f, 14.84f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveTo(7.31f, 4f, 3.07f, 5.9f, 0f, 8.98f);
        v12.lineTo(12f, 21f);
        v12.lineTo(24f, 8.98f);
        v12.curveTo(20.93f, 5.9f, 16.690001f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(15.32f, 14.84f);
        v12.curveTo(14.34f, 14.3f, 13.2f, 14f, 12f, 14f);
        v12.curveToRelative(-1.2f, 0f, -2.34f, 0.3f, -3.32f, 0.84f);
        v12.lineTo(2.92f, 9.07f);
        v12.curveTo(5.51f, 7.08f, 8.67f, 6f, 12f, 6f);
        v12.reflectiveCurveToRelative(6.49f, 1.08f, 9.08f, 3.07f);
        v12.lineTo(15.32f, 14.84f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NetworkWifi1BarKt._networkWifi1Bar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

