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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_batteryChargingFull", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BatteryChargingFull", "Landroidx/compose/material/icons/Icons$Rounded;", "getBatteryChargingFull", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BatteryChargingFullKt {
    private static ImageVector _batteryChargingFull;

    static {
    }

    public static final ImageVector getBatteryChargingFull(Rounded arg19) {
        ImageVector v0 = BatteryChargingFullKt._batteryChargingFull;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BatteryChargingFull", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.67f, 4f);
        v12.lineTo(14f, 4f);
        v12.lineTo(14f, 3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.lineTo(8.33f, 4f);
        v12.curveTo(7.6f, 4f, 7f, 4.6f, 7f, 5.33f);
        v12.verticalLineToRelative(15.33f);
        v12.curveTo(7f, 21.4f, 7.6f, 22f, 8.34f, 22f);
        v12.horizontalLineToRelative(7.32f);
        v12.curveToRelative(0.74f, 0f, 1.34f, -0.6f, 1.34f, -1.33f);
        v12.lineTo(17f, 5.33f);
        v12.curveTo(17f, 4.6f, 16.4f, 4f, 15.67f, 4f);
        v12.close();
        v12.moveTo(14.61f, 13.24f);
        v12.lineToRelative(-2.67f, 5f);
        v12.curveToRelative(-0.24f, 0.45f, -0.94f, 0.28f, -0.94f, -0.24f);
        v12.verticalLineToRelative(-3.5f);
        v12.lineTo(9.83f, 14.5f);
        v12.curveToRelative(-0.38f, 0f, -0.62f, -0.4f, -0.44f, -0.74f);
        v12.lineToRelative(2.67f, -5f);
        v12.curveToRelative(0.24f, -0.45f, 0.94f, -0.28f, 0.94f, 0.24f);
        v12.verticalLineToRelative(3.5f);
        v12.horizontalLineToRelative(1.17f);
        v12.curveToRelative(0.37f, 0f, 0.62f, 0.4f, 0.44f, 0.74f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BatteryChargingFullKt._batteryChargingFull = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

