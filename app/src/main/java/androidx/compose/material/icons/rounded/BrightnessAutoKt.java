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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_brightnessAuto", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BrightnessAuto", "Landroidx/compose/material/icons/Icons$Rounded;", "getBrightnessAuto", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BrightnessAutoKt {
    private static ImageVector _brightnessAuto;

    static {
    }

    public static final ImageVector getBrightnessAuto(Rounded arg19) {
        ImageVector v0 = BrightnessAutoKt._brightnessAuto;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BrightnessAuto", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.85f, 12.65f);
        v12.horizontalLineToRelative(2.3f);
        v12.lineTo(12f, 9f);
        v12.lineToRelative(-1.15f, 3.65f);
        v12.close();
        v12.moveTo(20f, 8.69f);
        v12.lineTo(20f, 6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-2.69f);
        v12.lineToRelative(-1.9f, -1.9f);
        v12.curveToRelative(-0.78f, -0.78f, -2.05f, -0.78f, -2.83f, 0f);
        v12.lineTo(8.69f, 4f);
        v12.lineTo(6f, 4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(2.69f);
        v12.lineToRelative(-1.9f, 1.9f);
        v12.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0f, 2.83f);
        v12.lineToRelative(1.9f, 1.9f);
        v12.lineTo(4f, 18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(2.69f);
        v12.lineToRelative(1.9f, 1.9f);
        v12.curveToRelative(0.78f, 0.78f, 2.05f, 0.78f, 2.83f, 0f);
        v12.lineToRelative(1.9f, -1.9f);
        v12.lineTo(18f, 20f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-2.69f);
        v12.lineToRelative(1.9f, -1.9f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineTo(20f, 8.69f);
        v12.close();
        v12.moveTo(14.09f, 15.4f);
        v12.lineTo(13.6f, 14f);
        v12.horizontalLineToRelative(-3.2f);
        v12.lineToRelative(-0.49f, 1.4f);
        v12.curveToRelative(-0.13f, 0.36f, -0.46f, 0.6f, -0.84f, 0.6f);
        v12.curveToRelative(-0.62f, 0f, -1.05f, -0.61f, -0.84f, -1.19f);
        v12.lineToRelative(2.44f, -6.86f);
        v12.curveToRelative(0.2f, -0.57f, 0.73f, -0.95f, 1.33f, -0.95f);
        v12.curveToRelative(0.6f, 0f, 1.13f, 0.38f, 1.34f, 0.94f);
        v12.lineToRelative(2.44f, 6.86f);
        v12.curveToRelative(0.21f, 0.58f, -0.22f, 1.19f, -0.84f, 1.19f);
        v12.curveToRelative(-0.39f, 0.01f, -0.72f, -0.23f, -0.85f, -0.59f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BrightnessAutoKt._brightnessAuto = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

