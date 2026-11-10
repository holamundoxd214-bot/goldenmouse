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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_carRepair", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CarRepair", "Landroidx/compose/material/icons/Icons$Outlined;", "getCarRepair", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CarRepairKt {
    private static ImageVector _carRepair;

    static {
    }

    public static final ImageVector getCarRepair(Outlined arg20) {
        ImageVector v0 = CarRepairKt._carRepair;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CarRepair", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 10.5f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15f, 10.5f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(5.78f, 16f);
        v12.horizontalLineToRelative(0.44f);
        v12.curveTo(6.65f, 16f, 7f, 15.64f, 7f, 15.19f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(1.19f);
        v12.curveToRelative(0f, 0.45f, 0.34f, 0.81f, 0.78f, 0.81f);
        v12.horizontalLineToRelative(0.44f);
        v12.curveToRelative(0.43f, 0f, 0.78f, -0.36f, 0.78f, -0.81f);
        v12.verticalLineToRelative(-6.5f);
        v12.curveToRelative(0f, 0f, -1.34f, -4.03f, -1.56f, -4.69f);
        v12.curveToRelative(-0.05f, -0.16f, -0.12f, -0.29f, -0.19f, -0.4f);
        v12.curveToRelative(-0.02f, -0.02f, -0.03f, -0.04f, -0.05f, -0.07f);
        v12.curveTo(16.82f, 3.01f, 16.280001f, 3f, 16.280001f, 3f);
        v12.horizontalLineTo(7.72f);
        v12.curveToRelative(0f, 0f, -0.54f, 0.01f, -0.92f, 0.54f);
        v12.curveTo(6.78f, 3.56f, 6.77f, 3.58f, 6.75f, 3.6f);
        v12.curveTo(6.68f, 3.71f, 6.61f, 3.84f, 6.56f, 4f);
        v12.curveTo(6.34f, 4.66f, 5f, 8.69f, 5f, 8.69f);
        v12.verticalLineToRelative(6.5f);
        v12.curveTo(5f, 15.64f, 5.35f, 16f, 5.78f, 16f);
        v12.close();
        v12.moveTo(8.33f, 5f);
        v12.horizontalLineToRelative(7.34f);
        v12.lineToRelative(0.23f, 0.69f);
        v12.lineTo(16.33f, 7f);
        v12.horizontalLineTo(7.67f);
        v12.lineTo(8.33f, 5f);
        v12.close();
        v12.moveTo(7f, 9.01f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(0.01f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(9.01f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(4f, 17.01f);
        v0_1.lineToRelative(0f, 1.99f);
        v0_1.lineToRelative(7f, 0f);
        v0_1.lineToRelative(0f, 3f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, -3f);
        v0_1.lineToRelative(7f, 0f);
        v0_1.lineToRelative(0f, -1.99f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CarRepairKt._carRepair = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

