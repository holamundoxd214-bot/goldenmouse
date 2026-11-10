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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_carCrash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CarCrash", "Landroidx/compose/material/icons/Icons$Rounded;", "getCarCrash", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CarCrashKt {
    private static ImageVector _carCrash;

    static {
    }

    public static final ImageVector getCarCrash(Rounded arg19) {
        ImageVector v0 = CarCrashKt._carCrash;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CarCrash", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(18f, 7f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(17.5f, 3.22f, 17.719999f, 3f, 18f, 3f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(18.5f, 6.78f, 18.280001f, 7f, 18f, 7f);
        v12.close();
        v12.moveTo(18.5f, 8.5f);
        v12.curveTo(18.5f, 8.78f, 18.280001f, 9f, 18f, 9f);
        v12.reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f);
        v12.reflectiveCurveTo(17.719999f, 8f, 18f, 8f);
        v12.reflectiveCurveTo(18.5f, 8.22f, 18.5f, 8.5f);
        v12.close();
        v12.moveTo(19.5f, 20f);
        v12.curveToRelative(0.82f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-6.18f);
        v12.curveToRelative(-1.05f, 0.51f, -2.16f, 0.69f, -3.09f, 0.68f);
        v12.curveToRelative(0.06f, 0.16f, 0.09f, 0.33f, 0.09f, 0.5f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.reflectiveCurveTo(15f, 14.33f, 15f, 13.5f);
        v12.curveToRelative(0f, -0.39f, 0.15f, -0.74f, 0.39f, -1.01f);
        v12.curveToRelative(-1.63f, -0.66f, -2.96f, -1.91f, -3.71f, -3.49f);
        v12.horizontalLineTo(5.81f);
        v12.lineToRelative(1.04f, -3f);
        v12.horizontalLineTo(11f);
        v12.curveToRelative(0f, -0.69f, 0.1f, -1.37f, 0.29f, -2f);
        v12.horizontalLineTo(6.5f);
        v12.curveTo(5.84f, 4f, 5.29f, 4.42f, 5.08f, 5.01f);
        v12.lineToRelative(-1.97f, 5.67f);
        v12.curveTo(3.04f, 10.89f, 3f, 11.11f, 3f, 11.34f);
        v12.verticalLineToRelative(7.16f);
        v12.curveTo(3f, 19.33f, 3.67f, 20f, 4.5f, 20f);
        v12.reflectiveCurveTo(6f, 19.33f, 6f, 18.5f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(0.5f);
        v12.curveTo(18f, 19.33f, 18.68f, 20f, 19.5f, 20f);
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

