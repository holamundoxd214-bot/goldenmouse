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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_deviceUnknown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DeviceUnknown", "Landroidx/compose/material/icons/Icons$Outlined;", "getDeviceUnknown", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DeviceUnknownKt {
    private static ImageVector _deviceUnknown;

    static {
    }

    public static final ImageVector getDeviceUnknown(Outlined arg19) {
        ImageVector v0 = DeviceUnknownKt._deviceUnknown;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.DeviceUnknown", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 1f);
        v12.lineTo(7f, 1f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(19f, 3f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(17f, 19f);
        v12.lineTo(7f, 19f);
        v12.lineTo(7f, 5f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(14f);
        v12.close();
        v12.moveTo(12f, 6.72f);
        v12.curveToRelative(-1.96f, 0f, -3.5f, 1.52f, -3.5f, 3.47f);
        v12.horizontalLineToRelative(1.75f);
        v12.curveToRelative(0f, -0.93f, 0.82f, -1.75f, 1.75f, -1.75f);
        v12.reflectiveCurveToRelative(1.75f, 0.82f, 1.75f, 1.75f);
        v12.curveToRelative(0f, 1.75f, -2.63f, 1.57f, -2.63f, 4.45f);
        v12.horizontalLineToRelative(1.76f);
        v12.curveToRelative(0f, -1.96f, 2.62f, -2.19f, 2.62f, -4.45f);
        v12.curveToRelative(0f, -1.96f, -1.54f, -3.47f, -3.5f, -3.47f);
        v12.close();
        v12.moveTo(11f, 16f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DeviceUnknownKt._deviceUnknown = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

