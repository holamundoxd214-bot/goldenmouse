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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_carCrash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CarCrash", "Landroidx/compose/material/icons/Icons$Outlined;", "getCarCrash", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CarCrashKt {
    private static ImageVector _carCrash;

    static {
    }

    public static final ImageVector getCarCrash(Outlined arg19) {
        ImageVector v0 = CarCrashKt._carCrash;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CarCrash", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 1f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveTo(20.76f, 1f, 18f, 1f);
        v12.close();
        v12.moveTo(18.5f, 7f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(18.5f, 8f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(8f);
        v12.horizontalLineTo(18.5f);
        v12.close();
        v12.moveTo(6f, 13.5f);
        v12.curveTo(6f, 12.67f, 6.67f, 12f, 7.5f, 12f);
        v12.reflectiveCurveTo(9f, 12.67f, 9f, 13.5f);
        v12.reflectiveCurveTo(8.33f, 15f, 7.5f, 15f);
        v12.reflectiveCurveTo(6f, 14.33f, 6f, 13.5f);
        v12.close();
        v12.moveTo(19f, 12.93f);
        v12.curveToRelative(0.65f, -0.09f, 1.34f, -0.28f, 2f, -0.6f);
        v12.horizontalLineToRelative(0f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-8f);
        v12.lineToRelative(2.08f, -5.99f);
        v12.curveTo(5.29f, 4.42f, 5.84f, 4f, 6.5f, 4f);
        v12.lineToRelative(4.79f, 0f);
        v12.curveTo(11.1f, 4.63f, 11f, 5.31f, 11f, 6f);
        v12.horizontalLineTo(6.85f);
        v12.lineTo(5.81f, 9f);
        v12.horizontalLineToRelative(5.86f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0.36f, 0.75f, 0.84f, 1.43f, 1.43f, 2f);
        v12.lineTo(5f, 11f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(14f);
        v12.lineTo(19f, 12.93f);
        v12.close();
        v12.moveTo(17.91f, 13f);
        v12.curveToRelative(-0.89f, -0.01f, -1.74f, -0.19f, -2.53f, -0.51f);
        v12.curveTo(15.15f, 12.76f, 15f, 13.11f, 15f, 13.5f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(1.5f, -0.67f, 1.5f, -1.5f);
        v12.curveTo(18f, 13.32f, 17.969999f, 13.16f, 17.91f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CarCrashKt._carCrash = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

