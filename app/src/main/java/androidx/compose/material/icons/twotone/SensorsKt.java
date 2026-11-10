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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sensors", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sensors", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSensors", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SensorsKt {
    private static ImageVector _sensors;

    static {
    }

    public static final ImageVector getSensors(TwoTone arg19) {
        ImageVector v0 = SensorsKt._sensors;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Sensors", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.76f, 16.24f);
        v12.curveTo(6.67f, 15.16f, 6f, 13.66f, 6f, 12f);
        v12.reflectiveCurveToRelative(0.67f, -3.16f, 1.76f, -4.24f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(8.45f, 9.9f, 8f, 10.9f, 8f, 12f);
        v12.curveToRelative(0f, 1.1f, 0.45f, 2.1f, 1.17f, 2.83f);
        v12.lineTo(7.76f, 16.24f);
        v12.close();
        v12.moveTo(16.24f, 16.24f);
        v12.curveTo(17.33f, 15.16f, 18f, 13.66f, 18f, 12f);
        v12.reflectiveCurveToRelative(-0.67f, -3.16f, -1.76f, -4.24f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveTo(15.55f, 9.9f, 16f, 10.9f, 16f, 12f);
        v12.curveToRelative(0f, 1.1f, -0.45f, 2.1f, -1.17f, 2.83f);
        v12.lineTo(16.24f, 16.24f);
        v12.close();
        v12.moveTo(12f, 10f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(13.1f, 10f, 12f, 10f);
        v12.close();
        v12.moveTo(20f, 12f);
        v12.curveToRelative(0f, 2.21f, -0.9f, 4.21f, -2.35f, 5.65f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(20.879999f, 17.26f, 22f, 14.76f, 22f, 12f);
        v12.reflectiveCurveToRelative(-1.12f, -5.26f, -2.93f, -7.07f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveTo(19.1f, 7.79f, 20f, 9.79f, 20f, 12f);
        v12.close();
        v12.moveTo(6.35f, 6.35f);
        v12.lineTo(4.93f, 4.93f);
        v12.curveTo(3.12f, 6.74f, 2f, 9.24f, 2f, 12f);
        v12.reflectiveCurveToRelative(1.12f, 5.26f, 2.93f, 7.07f);
        v12.lineToRelative(1.42f, -1.42f);
        v12.curveTo(4.9f, 16.209999f, 4f, 14.21f, 4f, 12f);
        v12.reflectiveCurveTo(4.9f, 7.79f, 6.35f, 6.35f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SensorsKt._sensors = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

