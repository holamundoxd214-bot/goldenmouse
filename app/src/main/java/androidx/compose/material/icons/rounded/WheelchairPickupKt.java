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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wheelchairPickup", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WheelchairPickup", "Landroidx/compose/material/icons/Icons$Rounded;", "getWheelchairPickup", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WheelchairPickupKt {
    private static ImageVector _wheelchairPickup;

    static {
    }

    public static final ImageVector getWheelchairPickup(Rounded arg19) {
        ImageVector v0 = WheelchairPickupKt._wheelchairPickup;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WheelchairPickup", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.5f, 4f);
        v12.curveToRelative(0f, -1.11f, 0.89f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.89f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.89f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(4.5f, 5.11f, 4.5f, 4f);
        v12.close();
        v12.moveTo(10f, 10.95f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 7f, 3f, 7.9f, 3f, 9f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2.5f);
        v12.verticalLineToRelative(-0.11f);
        v12.curveToRelative(-1.24f, -1.26f, -2f, -2.99f, -2f, -4.89f);
        v12.curveTo(6.5f, 14.42f, 7.91f, 12.16f, 10f, 10.95f);
        v12.close();
        v12.moveTo(16.5f, 17f);
        v12.curveToRelative(0f, 1.65f, -1.35f, 3f, -3f, 3f);
        v12.reflectiveCurveToRelative(-3f, -1.35f, -3f, -3f);
        v12.curveToRelative(0f, -1.11f, 0.61f, -2.06f, 1.5f, -2.58f);
        v12.verticalLineToRelative(-2.16f);
        v12.curveTo(9.98f, 12.9f, 8.5f, 14.77f, 8.5f, 17f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.24f, 5f, -5f);
        v12.horizontalLineTo(16.5f);
        v12.close();
        v12.moveTo(19f, 14f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4.46f);
        v12.lineToRelative(1.92f, 2.88f);
        v12.curveToRelative(0.31f, 0.46f, 0.93f, 0.58f, 1.39f, 0.28f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.46f, -0.31f, 0.58f, -0.93f, 0.28f, -1.39f);
        v12.lineToRelative(-2.21f, -3.32f);
        v12.curveTo(19.65f, 14.17f, 19.33f, 14f, 19f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WheelchairPickupKt._wheelchairPickup = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

