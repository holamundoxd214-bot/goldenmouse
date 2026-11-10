package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_carRepair", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CarRepair", "Landroidx/compose/material/icons/Icons$Filled;", "getCarRepair", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CarRepairKt {
    private static ImageVector _carRepair;

    static {
    }

    public static final ImageVector getCarRepair(Filled arg19) {
        ImageVector v0 = CarRepairKt._carRepair;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.CarRepair", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.219999f, 12f);
        v12.curveToRelative(0.68f, 0f, 1.22f, -0.54f, 1.22f, -1.22f);
        v12.curveToRelative(0f, -0.67f, -0.54f, -1.22f, -1.22f, -1.22f);
        v12.reflectiveCurveTo(15f, 10.11f, 15f, 10.78f);
        v12.curveTo(15f, 11.46f, 15.55f, 12f, 16.219999f, 12f);
        v12.close();
        v12.moveTo(6.56f, 10.78f);
        v12.curveToRelative(0f, 0.67f, 0.54f, 1.22f, 1.22f, 1.22f);
        v12.reflectiveCurveTo(9f, 11.46f, 9f, 10.78f);
        v12.curveToRelative(0f, -0.67f, -0.54f, -1.22f, -1.22f, -1.22f);
        v12.reflectiveCurveTo(6.56f, 10.11f, 6.56f, 10.78f);
        v12.close();
        v12.moveTo(7.61f, 4f);
        v12.lineTo(6.28f, 8f);
        v12.horizontalLineToRelative(11.43f);
        v12.lineToRelative(-1.33f, -4f);
        v12.horizontalLineTo(7.61f);
        v12.close();
        v12.moveTo(16.280001f, 3f);
        v12.curveToRelative(0f, 0f, 0.54f, 0.01f, 0.92f, 0.54f);
        v12.curveToRelative(0.02f, 0.02f, 0.03f, 0.04f, 0.05f, 0.07f);
        v12.curveToRelative(0.07f, 0.11f, 0.14f, 0.24f, 0.19f, 0.4f);
        v12.curveTo(17.66f, 4.66f, 19f, 8.69f, 19f, 8.69f);
        v12.verticalLineToRelative(6.5f);
        v12.curveToRelative(0f, 0.45f, -0.35f, 0.81f, -0.78f, 0.81f);
        v12.horizontalLineToRelative(-0.44f);
        v12.curveTo(17.35f, 16f, 17f, 15.64f, 17f, 15.19f);
        v12.verticalLineTo(14f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(1.19f);
        v12.curveTo(7f, 15.64f, 6.65f, 16f, 6.22f, 16f);
        v12.horizontalLineTo(5.78f);
        v12.curveTo(5.35f, 16f, 5f, 15.64f, 5f, 15.19f);
        v12.verticalLineToRelative(-6.5f);
        v12.curveToRelative(0f, 0f, 1.34f, -4.02f, 1.55f, -4.69f);
        v12.curveToRelative(0.05f, -0.16f, 0.12f, -0.28f, 0.19f, -0.4f);
        v12.curveTo(6.77f, 3.58f, 6.78f, 3.56f, 6.8f, 3.54f);
        v12.curveTo(7.18f, 3.01f, 7.72f, 3f, 7.72f, 3f);
        v12.horizontalLineTo(16.280001f);
        v12.close();
        v12.moveTo(4f, 17.01f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(-7f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(17.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CarRepairKt._carRepair = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

