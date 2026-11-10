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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_usb", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Usb", "Landroidx/compose/material/icons/Icons$Rounded;", "getUsb", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class UsbKt {
    private static ImageVector _usb;

    static {
    }

    public static final ImageVector getUsb(Rounded arg19) {
        ImageVector v0 = UsbKt._usb;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Usb", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 7f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.41f, 0f, 0.65f, -0.47f, 0.4f, -0.8f);
        v12.lineToRelative(-2f, -2.67f);
        v12.curveToRelative(-0.2f, -0.27f, -0.6f, -0.27f, -0.8f, 0f);
        v12.lineToRelative(-2f, 2.67f);
        v12.curveToRelative(-0.25f, 0.33f, -0.01f, 0.8f, 0.4f, 0.8f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-2.07f);
        v12.curveToRelative(0.83f, -0.44f, 1.38f, -1.36f, 1.14f, -2.43f);
        v12.curveToRelative(-0.17f, -0.77f, -0.77f, -1.4f, -1.52f, -1.61f);
        v12.curveTo(6.15f, 6.48f, 4.8f, 7.59f, 4.8f, 9f);
        v12.curveToRelative(0f, 0.85f, 0.5f, 1.56f, 1.2f, 1.93f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(3.05f);
        v12.curveToRelative(-0.86f, 0.45f, -1.39f, 1.42f, -1.13f, 2.49f);
        v12.curveToRelative(0.18f, 0.75f, 0.79f, 1.38f, 1.54f, 1.58f);
        v12.curveToRelative(1.46f, 0.39f, 2.8f, -0.7f, 2.8f, -2.12f);
        v12.curveToRelative(0f, -0.85f, -0.49f, -1.58f, -1.2f, -1.95f);
        v12.verticalLineTo(15f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(8f);
        v12.curveTo(19f, 7.45f, 18.549999f, 7f, 18f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        UsbKt._usb = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

