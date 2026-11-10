package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_brightnessAuto", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BrightnessAuto", "Landroidx/compose/material/icons/Icons$Filled;", "getBrightnessAuto", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BrightnessAutoKt {
    private static ImageVector _brightnessAuto;

    static {
    }

    public static final ImageVector getBrightnessAuto(Filled arg18) {
        ImageVector v0 = BrightnessAutoKt._brightnessAuto;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.BrightnessAuto", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(10.85f, 12.65f);
        v0_1.horizontalLineToRelative(2.3f);
        v0_1.lineTo(12f, 9f);
        v0_1.lineToRelative(-1.15f, 3.65f);
        v0_1.close();
        v0_1.moveTo(20f, 8.69f);
        v0_1.verticalLineTo(4f);
        v0_1.horizontalLineToRelative(-4.69f);
        v0_1.lineTo(12f, 0.69f);
        v0_1.lineTo(8.69f, 4f);
        v0_1.horizontalLineTo(4f);
        v0_1.verticalLineToRelative(4.69f);
        v0_1.lineTo(0.69f, 12f);
        v0_1.lineTo(4f, 15.31f);
        v0_1.verticalLineTo(20f);
        v0_1.horizontalLineToRelative(4.69f);
        v0_1.lineTo(12f, 23.309999f);
        v0_1.lineTo(15.31f, 20f);
        v0_1.horizontalLineTo(20f);
        v0_1.verticalLineToRelative(-4.69f);
        v0_1.lineTo(23.309999f, 12f);
        v0_1.lineTo(20f, 8.69f);
        v0_1.close();
        v0_1.moveTo(14.3f, 16f);
        v0_1.lineToRelative(-0.7f, -2f);
        v0_1.horizontalLineToRelative(-3.2f);
        v0_1.lineToRelative(-0.7f, 2f);
        v0_1.horizontalLineTo(7.8f);
        v0_1.lineTo(11f, 7f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.lineToRelative(3.2f, 9f);
        v0_1.horizontalLineToRelative(-1.9f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BrightnessAutoKt._brightnessAuto = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

