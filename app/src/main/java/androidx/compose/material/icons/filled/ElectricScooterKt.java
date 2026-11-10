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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_electricScooter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ElectricScooter", "Landroidx/compose/material/icons/Icons$Filled;", "getElectricScooter", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ElectricScooterKt {
    private static ImageVector _electricScooter;

    static {
    }

    public static final ImageVector getElectricScooter(Filled arg19) {
        ImageVector v0 = ElectricScooterKt._electricScooter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ElectricScooter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.82f, 16f);
        v12.horizontalLineTo(15f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.horizontalLineToRelative(0.74f);
        v12.lineToRelative(-1.9f, -8.44f);
        v12.curveTo(17.629999f, 1.65f, 16.82f, 1f, 15.89f, 1f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3.89f);
        v12.lineToRelative(1.4f, 6.25f);
        v12.curveToRelative(0f, 0f, -0.01f, 0f, -0.01f, 0f);
        v12.curveToRelative(-2.16f, 0.65f, -3.81f, 2.48f, -4.19f, 4.75f);
        v12.horizontalLineTo(7.82f);
        v12.curveToRelative(-0.48f, -1.34f, -1.86f, -2.24f, -3.42f, -1.94f);
        v12.curveToRelative(-1.18f, 0.23f, -2.13f, 1.2f, -2.35f, 2.38f);
        v12.curveTo(1.7f, 16.34f, 3.16f, 18f, 5f, 18f);
        v12.curveTo(6.3f, 18f, 7.4f, 17.16f, 7.82f, 16f);
        v12.close();
        v12.moveTo(5f, 16f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(5.55f, 16f, 5f, 16f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19f, 12f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.reflectiveCurveTo(20.66f, 12f, 19f, 12f);
        v12.close();
        v12.moveTo(19f, 16f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(19.549999f, 16f, 19f, 16f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(11f, 20f);
        v0_1.lineToRelative(-4f, 0f);
        v0_1.lineToRelative(6f, 3f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.lineToRelative(4f, 0f);
        v0_1.lineToRelative(-6f, -3f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ElectricScooterKt._electricScooter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

