package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_electricMeter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ElectricMeter", "Landroidx/compose/material/icons/Icons$TwoTone;", "getElectricMeter", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ElectricMeterKt {
    private static ImageVector _electricMeter;

    static {
    }

    public static final ImageVector getElectricMeter(TwoTone arg19) {
        ImageVector v0 = ElectricMeterKt._electricMeter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.ElectricMeter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(-3.86f, 0f, -7f, 3.14f, -7f, 7f);
        v12.reflectiveCurveToRelative(3.14f, 7f, 7f, 7f);
        v12.reflectiveCurveToRelative(7f, -3.14f, 7f, -7f);
        v12.reflectiveCurveTo(15.86f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(14.25f, 14f);
        v12.lineToRelative(-3f, 3f);
        v12.lineToRelative(-1.5f, -1.5f);
        v12.lineTo(11f, 14.25f);
        v12.lineTo(9.75f, 13f);
        v12.lineToRelative(3f, -3f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.lineTo(13f, 12.75f);
        v12.lineTo(14.25f, 14f);
        v12.close();
        v12.moveTo(16f, 9f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(9f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.curveToRelative(0f, 3.92f, 2.51f, 7.24f, 6f, 8.48f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2.06f);
        v12.curveToRelative(0.33f, 0.04f, 0.66f, 0.06f, 1f, 0.06f);
        v12.reflectiveCurveToRelative(0.67f, -0.02f, 1f, -0.06f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2.52f);
        v12.curveToRelative(3.49f, -1.24f, 6f, -4.56f, 6f, -8.48f);
        v12.curveTo(21f, 6.03f, 16.969999f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-3.86f, 0f, -7f, -3.14f, -7f, -7f);
        v12.reflectiveCurveToRelative(3.14f, -7f, 7f, -7f);
        v12.reflectiveCurveToRelative(7f, 3.14f, 7f, 7f);
        v12.reflectiveCurveTo(15.86f, 18f, 12f, 18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(8f, 7f);
        v0_1.horizontalLineToRelative(8f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(-8f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(12.75f, 10f);
        v0_1.lineToRelative(-3f, 3f);
        v0_1.lineToRelative(1.25f, 1.25f);
        v0_1.lineToRelative(-1.25f, 1.25f);
        v0_1.lineToRelative(1.5f, 1.5f);
        v0_1.lineToRelative(3f, -3f);
        v0_1.lineToRelative(-1.25f, -1.25f);
        v0_1.lineToRelative(1.25f, -1.25f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ElectricMeterKt._electricMeter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

