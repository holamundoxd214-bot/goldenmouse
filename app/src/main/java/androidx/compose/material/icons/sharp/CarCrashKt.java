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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_carCrash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CarCrash", "Landroidx/compose/material/icons/Icons$Sharp;", "getCarCrash", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CarCrashKt {
    private static ImageVector _carCrash;

    static {
    }

    public static final ImageVector getCarCrash(Sharp arg19) {
        ImageVector v0 = CarCrashKt._carCrash;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.CarCrash", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(17.91f, 13f);
        v12.curveToRelative(0.06f, 0.16f, 0.09f, 0.33f, 0.09f, 0.5f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.reflectiveCurveTo(15f, 14.33f, 15f, 13.5f);
        v12.curveToRelative(0f, -0.39f, 0.15f, -0.74f, 0.39f, -1.01f);
        v12.curveToRelative(-1.63f, -0.66f, -2.96f, -1.91f, -3.71f, -3.49f);
        v12.horizontalLineTo(5.81f);
        v12.lineToRelative(1.04f, -3f);
        v12.horizontalLineTo(11f);
        v12.curveToRelative(0f, -0.69f, 0.1f, -1.37f, 0.29f, -2f);
        v12.horizontalLineTo(5.41f);
        v12.lineTo(3f, 11f);
        v12.verticalLineToRelative(9f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-7.68f);
        v12.curveTo(19.950001f, 12.83f, 18.84f, 13.01f, 17.91f, 13f);
        v12.close();
        v12.moveTo(7.5f, 15f);
        v12.curveTo(6.67f, 15f, 6f, 14.33f, 6f, 13.5f);
        v12.reflectiveCurveTo(6.67f, 12f, 7.5f, 12f);
        v12.reflectiveCurveTo(9f, 12.67f, 9f, 13.5f);
        v12.reflectiveCurveTo(8.33f, 15f, 7.5f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CarCrashKt._carCrash = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

