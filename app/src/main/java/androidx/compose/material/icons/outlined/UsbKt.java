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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_usb", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Usb", "Landroidx/compose/material/icons/Icons$Outlined;", "getUsb", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UsbKt {
    private static ImageVector _usb;

    static {
    }

    public static final ImageVector getUsb(Outlined arg19) {
        ImageVector v0 = UsbKt._usb;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Usb", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 7f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(-3f, -4f);
        v12.lineToRelative(-3f, 4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-2.07f);
        v12.curveToRelative(0.7f, -0.37f, 1.2f, -1.08f, 1.2f, -1.93f);
        v12.curveToRelative(0f, -1.21f, -0.99f, -2.2f, -2.2f, -2.2f);
        v12.reflectiveCurveTo(4.8f, 7.79f, 4.8f, 9f);
        v12.curveToRelative(0f, 0.85f, 0.5f, 1.56f, 1.2f, 1.93f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, 1.11f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(3.05f);
        v12.curveToRelative(-0.71f, 0.37f, -1.2f, 1.1f, -1.2f, 1.95f);
        v12.curveToRelative(0f, 1.22f, 0.99f, 2.2f, 2.2f, 2.2f);
        v12.reflectiveCurveToRelative(2.2f, -0.98f, 2.2f, -2.2f);
        v12.curveToRelative(0f, -0.85f, -0.49f, -1.58f, -1.2f, -1.95f);
        v12.verticalLineTo(15f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.89f, 2f, -2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UsbKt._usb = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

