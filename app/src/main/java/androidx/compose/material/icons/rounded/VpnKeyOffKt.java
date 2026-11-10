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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_vpnKeyOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VpnKeyOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getVpnKeyOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VpnKeyOffKt {
    private static ImageVector _vpnKeyOff;

    static {
    }

    public static final ImageVector getVpnKeyOff(Rounded arg19) {
        ImageVector v0 = VpnKeyOffKt._vpnKeyOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.VpnKeyOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.98f, 6.81f);
        v12.curveTo(2.2f, 7.85f, 1f, 9.79f, 1f, 12f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.curveToRelative(2.21f, 0f, 4.15f, -1.2f, 5.18f, -2.99f);
        v12.lineToRelative(6.89f, 6.89f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(3.98f, 6.81f);
        v12.close();
        v12.moveTo(8.99f, 11.82f);
        v12.curveTo(9f, 11.88f, 9f, 11.94f, 9f, 12f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.curveToRelative(0.06f, 0f, 0.12f, 0f, 0.18f, 0.01f);
        v12.lineTo(8.99f, 11.82f);
        v12.close();
        v12.moveTo(20.32f, 17.5f);
        v12.curveTo(20.74f, 17.129999f, 21f, 16.59f, 21f, 16f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-8.17f);
        v12.lineTo(20.32f, 17.5f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VpnKeyOffKt._vpnKeyOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

