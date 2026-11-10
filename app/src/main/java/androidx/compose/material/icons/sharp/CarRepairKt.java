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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_carRepair", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CarRepair", "Landroidx/compose/material/icons/Icons$Sharp;", "getCarRepair", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CarRepairKt {
    private static ImageVector _carRepair;

    static {
    }

    public static final ImageVector getCarRepair(Sharp arg19) {
        ImageVector v0 = CarRepairKt._carRepair;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.CarRepair", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 17.01f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-1.99f);
        v12.horizontalLineTo(4f);
        v12.close();
        v12.moveTo(7f, 14f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(8.69f);
        v12.lineTo(17.110001f, 3f);
        v12.horizontalLineTo(6.89f);
        v12.lineTo(5f, 8.69f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(14f);
        v12.close();
        v12.moveTo(9f, 11.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(9.55f, 11.5f, 9f, 11.5f);
        v12.close();
        v12.moveTo(15f, 11.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(15.55f, 11.5f, 15f, 11.5f);
        v12.close();
        v12.moveTo(8.33f, 5f);
        v12.horizontalLineToRelative(7.34f);
        v12.lineToRelative(0.66f, 2f);
        v12.horizontalLineTo(7.67f);
        v12.lineTo(8.33f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CarRepairKt._carRepair = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

