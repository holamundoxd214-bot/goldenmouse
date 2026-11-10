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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_batteryStd", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BatteryStd", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBatteryStd", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BatteryStdKt {
    private static ImageVector _batteryStd;

    static {
    }

    public static final ImageVector getBatteryStd(TwoTone arg19) {
        ImageVector v0 = BatteryStdKt._batteryStd;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BatteryStd", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.67f, 4f);
        v12.horizontalLineTo(14f);
        v12.verticalLineTo(2f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(8.33f);
        v12.curveTo(7.6f, 4f, 7f, 4.6f, 7f, 5.33f);
        v12.verticalLineToRelative(15.33f);
        v12.curveTo(7f, 21.4f, 7.6f, 22f, 8.33f, 22f);
        v12.horizontalLineToRelative(7.33f);
        v12.curveToRelative(0.74f, 0f, 1.34f, -0.6f, 1.34f, -1.33f);
        v12.verticalLineTo(5.33f);
        v12.curveTo(17f, 4.6f, 16.4f, 4f, 15.67f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BatteryStdKt._batteryStd = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

