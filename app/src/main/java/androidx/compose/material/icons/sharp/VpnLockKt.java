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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_vpnLock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VpnLock", "Landroidx/compose/material/icons/Icons$Sharp;", "getVpnLock", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VpnLockKt {
    private static ImageVector _vpnLock;

    static {
    }

    public static final ImageVector getVpnLock(Sharp arg19) {
        ImageVector v0 = VpnLockKt._vpnLock;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.VpnLock", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 13f);
        v12.curveToRelative(0f, 2.08f, -0.8f, 3.97f, -2.1f, 5.39f);
        v12.lineTo(16.9f, 17f);
        v12.lineTo(14f, 17f);
        v12.verticalLineToRelative(-4f);
        v12.lineTo(7f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(3f);
        v12.lineTo(10f, 8f);
        v12.horizontalLineToRelative(4f);
        v12.lineTo(14f, 3.46f);
        v12.curveToRelative(-0.95f, -0.3f, -1.95f, -0.46f, -3f, -0.46f);
        v12.curveTo(5.48f, 3f, 1f, 7.48f, 1f, 13f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveToRelative(0f, -0.34f, -0.02f, -0.67f, -0.05f, -1f);
        v12.horizontalLineToRelative(-2.03f);
        v12.curveToRelative(0.04f, 0.33f, 0.08f, 0.66f, 0.08f, 1f);
        v12.close();
        v12.moveTo(10f, 20.93f);
        v12.curveToRelative(-3.95f, -0.49f, -7f, -3.85f, -7f, -7.93f);
        v12.curveToRelative(0f, -0.62f, 0.08f, -1.21f, 0.21f, -1.79f);
        v12.lineTo(8f, 16f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1.93f);
        v12.close();
        v12.moveTo(22f, 4f);
        v12.verticalLineToRelative(-0.36f);
        v12.curveToRelative(0f, -1.31f, -0.94f, -2.5f, -2.24f, -2.63f);
        v12.curveTo(18.26f, 0.86f, 17f, 2.03f, 17f, 3.5f);
        v12.lineTo(17f, 4f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(7f);
        v12.lineTo(23f, 4f);
        v12.horizontalLineToRelative(-1f);
        v12.close();
        v12.moveTo(21f, 4f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.lineTo(21f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VpnLockKt._vpnLock = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

