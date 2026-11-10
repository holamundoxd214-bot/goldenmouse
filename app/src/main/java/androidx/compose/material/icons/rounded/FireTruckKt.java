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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fireTruck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FireTruck", "Landroidx/compose/material/icons/Icons$Rounded;", "getFireTruck", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FireTruckKt {
    private static ImageVector _fireTruck;

    static {
    }

    public static final ImageVector getFireTruck(Rounded arg19) {
        ImageVector v0 = FireTruckKt._fireTruck;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FireTruck", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.9f, 10.69f);
        v12.lineToRelative(-1.44f, -4.32f);
        v12.curveTo(21.18f, 5.55f, 20.42f, 5f, 19.559999f, 5f);
        v12.horizontalLineTo(19f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4.68f);
        v12.curveTo(23f, 11.11f, 22.969999f, 10.9f, 22.9f, 10.69f);
        v12.close();
        v12.moveTo(7f, 19f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(7.55f, 19f, 7f, 19f);
        v12.close();
        v12.moveTo(17f, 19f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(17.549999f, 19f, 17f, 19f);
        v12.close();
        v12.moveTo(14f, 11f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(5.56f);
        v12.lineToRelative(1.33f, 4f);
        v12.horizontalLineTo(14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(10.25f, 8.5f);
        v12.horizontalLineTo(10f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(0.25f);
        v12.curveTo(10.66f, 6.5f, 11f, 6.16f, 11f, 5.75f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(11f, 5.34f, 10.66f, 5f, 10.25f, 5f);
        v12.horizontalLineToRelative(-8.5f);
        v12.curveTo(1.34f, 5f, 1f, 5.34f, 1f, 5.75f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(1f, 6.16f, 1.34f, 6.5f, 1.75f, 6.5f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(1.75f);
        v12.curveTo(1.34f, 8.5f, 1f, 8.84f, 1f, 9.25f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(1f, 9.66f, 1.34f, 10f, 1.75f, 10f);
        v12.horizontalLineToRelative(8.5f);
        v12.curveTo(10.66f, 10f, 11f, 9.66f, 11f, 9.25f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(11f, 8.84f, 10.66f, 8.5f, 10.25f, 8.5f);
        v12.close();
        v12.moveTo(5.25f, 8.5f);
        v12.horizontalLineTo(3.5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(1.75f);
        v12.verticalLineTo(8.5f);
        v12.close();
        v12.moveTo(8.5f, 8.5f);
        v12.horizontalLineTo(6.75f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(8.5f);
        v12.verticalLineTo(8.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FireTruckKt._fireTruck = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

