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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_battery3Bar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Battery3Bar", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBattery3Bar", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Battery3BarKt {
    private static ImageVector _battery3Bar;

    static {
    }

    public static final ImageVector getBattery3Bar(TwoTone arg29) {
        ImageVector v0 = Battery3BarKt._battery3Bar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Battery3Bar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(9f, 6f);
        v0_1.horizontalLineToRelative(6f);
        v0_1.verticalLineToRelative(8f);
        v0_1.horizontalLineToRelative(-6f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(17f, 5f);
        v0_1.verticalLineToRelative(16f);
        v0_1.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v0_1.horizontalLineTo(8f);
        v0_1.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v0_1.verticalLineTo(5f);
        v0_1.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineTo(2f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.curveTo(16.549999f, 4f, 17f, 4.45f, 17f, 5f);
        v0_1.close();
        v0_1.moveTo(15f, 6f);
        v0_1.horizontalLineTo(9f);
        v0_1.verticalLineToRelative(8f);
        v0_1.horizontalLineToRelative(6f);
        v0_1.verticalLineTo(6f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Battery3BarKt._battery3Bar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

