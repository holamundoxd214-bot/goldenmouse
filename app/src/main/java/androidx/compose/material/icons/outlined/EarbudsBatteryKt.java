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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_earbudsBattery", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EarbudsBattery", "Landroidx/compose/material/icons/Icons$Outlined;", "getEarbudsBattery", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EarbudsBatteryKt {
    private static ImageVector _earbudsBattery;

    static {
    }

    public static final ImageVector getEarbudsBattery(Outlined arg19) {
        ImageVector v0 = EarbudsBatteryKt._earbudsBattery;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.EarbudsBattery", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 7f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(9f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(8f);
        v12.curveTo(22f, 7.45f, 21.549999f, 7f, 21f, 7f);
        v12.close();
        v12.moveTo(20f, 16f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(16f);
        v12.close();
        v12.moveTo(14f, 9.38f);
        v12.curveTo(14f, 7.51f, 12.49f, 6f, 10.62f, 6f);
        v12.reflectiveCurveTo(7.25f, 7.51f, 7.25f, 9.38f);
        v12.verticalLineToRelative(5.25f);
        v12.curveToRelative(0f, 1.04f, -0.84f, 1.88f, -1.88f, 1.88f);
        v12.reflectiveCurveTo(3.5f, 15.66f, 3.5f, 14.62f);
        v12.verticalLineToRelative(-4.7f);
        v12.curveTo(3.66f, 9.97f, 3.83f, 10f, 4f, 10f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(5.1f, 6f, 4f, 6f);
        v12.reflectiveCurveTo(2f, 6.9f, 2f, 8f);
        v12.curveToRelative(0f, 0.04f, 0f, 6.62f, 0f, 6.62f);
        v12.curveTo(2f, 16.49f, 3.51f, 18f, 5.38f, 18f);
        v12.reflectiveCurveToRelative(3.38f, -1.51f, 3.38f, -3.38f);
        v12.verticalLineTo(9.38f);
        v12.curveToRelative(0f, -1.04f, 0.84f, -1.88f, 1.88f, -1.88f);
        v12.reflectiveCurveToRelative(1.88f, 0.84f, 1.88f, 1.88f);
        v12.verticalLineToRelative(4.7f);
        v12.curveTo(12.34f, 14.03f, 12.17f, 14f, 12f, 14f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.curveTo(14f, 15.96f, 14f, 9.38f, 14f, 9.38f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EarbudsBatteryKt._earbudsBattery = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

