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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_vpnLock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VpnLock", "Landroidx/compose/material/icons/Icons$Rounded;", "getVpnLock", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VpnLockKt {
    private static ImageVector _vpnLock;

    static {
    }

    public static final ImageVector getVpnLock(Rounded arg19) {
        ImageVector v0 = VpnLockKt._vpnLock;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.VpnLock", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.92f, 11f);
        v12.curveToRelative(0.44f, 3.63f, -1.52f, 5.85f, -2.02f, 6.39f);
        v12.curveTo(17.639999f, 16.58f, 16.9f, 16f, 16f, 16f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(2.46f);
        v12.curveTo(14.05f, 2.16f, 13.05f, 2f, 12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.curveToRelative(5.73f, 0f, 10.51f, -4.86f, 9.95f, -11f);
        v12.horizontalLineTo(19.92f);
        v12.close();
        v12.moveTo(11f, 19.93f);
        v12.curveTo(7.05f, 19.440001f, 4f, 16.08f, 4f, 12f);
        v12.curveToRelative(0f, -0.62f, 0.08f, -1.21f, 0.21f, -1.79f);
        v12.lineTo(9f, 15f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.verticalLineTo(19.93f);
        v12.close();
        v12.moveTo(22f, 4f);
        v12.verticalLineTo(3.11f);
        v12.curveToRelative(0f, -1f, -0.68f, -1.92f, -1.66f, -2.08f);
        v12.curveTo(19.08f, 0.82f, 18f, 1.79f, 18f, 3f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(5f);
        v12.curveTo(23f, 4.45f, 22.549999f, 4f, 22f, 4f);
        v12.close();
        v12.moveTo(21f, 4f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VpnLockKt._vpnLock = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

