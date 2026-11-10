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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_carRental", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CarRental", "Landroidx/compose/material/icons/Icons$Sharp;", "getCarRental", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CarRentalKt {
    private static ImageVector _carRental;

    static {
    }

    public static final ImageVector getCarRental(Sharp arg19) {
        ImageVector v0 = CarRentalKt._carRental;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.CarRental", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.83f, 3f);
        v12.curveTo(10.41f, 1.83f, 9.3f, 1f, 8f, 1f);
        v12.curveTo(6.34f, 1f, 5f, 2.34f, 5f, 4f);
        v12.curveToRelative(0f, 1.65f, 1.34f, 3f, 3f, 3f);
        v12.curveToRelative(1.3f, 0f, 2.41f, -0.84f, 2.83f, -2f);
        v12.horizontalLineTo(16f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(10.83f);
        v12.close();
        v12.moveTo(8f, 5f);
        v12.curveTo(7.45f, 5f, 7f, 4.55f, 7f, 4f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(8.55f, 5f, 8f, 5f);
        v12.close();
        v12.moveTo(17.110001f, 9f);
        v12.horizontalLineTo(6.89f);
        v12.lineTo(5f, 14.69f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-7.31f);
        v12.lineTo(17.110001f, 9f);
        v12.close();
        v12.moveTo(9f, 17.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(9.55f, 17.5f, 9f, 17.5f);
        v12.close();
        v12.moveTo(15f, 17.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(15.55f, 17.5f, 15f, 17.5f);
        v12.close();
        v12.moveTo(7.67f, 13f);
        v12.lineToRelative(0.66f, -2f);
        v12.horizontalLineToRelative(7.34f);
        v12.lineToRelative(0.66f, 2f);
        v12.horizontalLineTo(7.67f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CarRentalKt._carRental = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

