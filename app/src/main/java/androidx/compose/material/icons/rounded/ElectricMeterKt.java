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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_electricMeter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ElectricMeter", "Landroidx/compose/material/icons/Icons$Rounded;", "getElectricMeter", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ElectricMeterKt {
    private static ImageVector _electricMeter;

    static {
    }

    public static final ImageVector getElectricMeter(Rounded arg19) {
        ImageVector v0 = ElectricMeterKt._electricMeter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ElectricMeter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.73f, 2f);
        v12.curveTo(7.05f, 2.14f, 3.15f, 6.03f, 3f, 10.71f);
        v12.curveToRelative(-0.13f, 4.04f, 2.42f, 7.5f, 6f, 8.77f);
        v12.verticalLineTo(21f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1.06f);
        v12.curveToRelative(0.33f, 0.04f, 0.66f, 0.06f, 1f, 0.06f);
        v12.reflectiveCurveToRelative(0.67f, -0.02f, 1f, -0.06f);
        v12.verticalLineTo(21f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1.53f);
        v12.curveToRelative(3.49f, -1.24f, 6f, -4.57f, 6f, -8.47f);
        v12.curveTo(21f, 5.95f, 16.82f, 1.85f, 11.73f, 2f);
        v12.close();
        v12.moveTo(13.54f, 14.71f);
        v12.lineTo(12f, 16.25f);
        v12.curveToRelative(-0.41f, 0.41f, -1.09f, 0.41f, -1.5f, 0f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.41f, -0.41f, -0.41f, -1.09f, 0f, -1.5f);
        v12.lineToRelative(0.5f, -0.5f);
        v12.lineToRelative(-0.54f, -0.54f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(12f, 10.75f);
        v12.curveToRelative(0.41f, -0.41f, 1.09f, -0.41f, 1.5f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.41f, 0.41f, 0.41f, 1.09f, 0f, 1.5f);
        v12.lineToRelative(-0.5f, 0.5f);
        v12.lineToRelative(0.54f, 0.54f);
        v12.curveTo(13.93f, 13.68f, 13.93f, 14.32f, 13.54f, 14.71f);
        v12.close();
        v12.moveTo(15f, 9f);
        v12.horizontalLineTo(9f);
        v12.curveTo(8.45f, 9f, 8f, 8.55f, 8f, 8f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(16f, 8.55f, 15.55f, 9f, 15f, 9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ElectricMeterKt._electricMeter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

