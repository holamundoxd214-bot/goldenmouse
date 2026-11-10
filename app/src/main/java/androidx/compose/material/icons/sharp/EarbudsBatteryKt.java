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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_earbudsBattery", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EarbudsBattery", "Landroidx/compose/material/icons/Icons$Sharp;", "getEarbudsBattery", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EarbudsBatteryKt {
    private static ImageVector _earbudsBattery;

    static {
    }

    public static final ImageVector getEarbudsBattery(Sharp arg19) {
        ImageVector v0 = EarbudsBatteryKt._earbudsBattery;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.EarbudsBattery", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(20f, 7f);
        v0_1.lineToRelative(0f, -1f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 1f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 11f);
        v0_1.lineToRelative(6f, 0f);
        v0_1.lineToRelative(0f, -11f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5.38f, 16.5f);
        v12.lineTo(5.38f, 16.5f);
        v12.curveToRelative(-1.04f, 0f, -1.88f, -0.84f, -1.88f, -1.87f);
        v12.verticalLineTo(10f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(6f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 6f, 2f, 6.9f, 2f, 8f);
        v12.verticalLineToRelative(6.63f);
        v12.curveTo(2f, 16.49f, 3.51f, 18f, 5.37f, 18f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(1.86f, 0f, 3.37f, -1.51f, 3.37f, -3.37f);
        v12.verticalLineTo(9.37f);
        v12.curveToRelative(0f, -1.04f, 0.84f, -1.87f, 1.87f, -1.87f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(1.04f, 0f, 1.87f, 0.84f, 1.87f, 1.87f);
        v12.verticalLineTo(14f);
        v12.horizontalLineTo(10f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(9.37f);
        v12.curveTo(14f, 7.51f, 12.49f, 6f, 10.63f, 6f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(8.76f, 6f, 7.25f, 7.51f, 7.25f, 9.37f);
        v12.verticalLineToRelative(5.25f);
        v12.curveTo(7.25f, 15.66f, 6.41f, 16.5f, 5.38f, 16.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EarbudsBatteryKt._earbudsBattery = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

