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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sensors", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sensors", "Landroidx/compose/material/icons/Icons$Rounded;", "getSensors", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SensorsKt {
    private static ImageVector _sensors;

    static {
    }

    public static final ImageVector getSensors(Rounded arg19) {
        ImageVector v0 = SensorsKt._sensors;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Sensors", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.54f, 8.54f);
        v12.curveToRelative(0.35f, 0.35f, 0.37f, 0.88f, 0.1f, 1.29f);
        v12.curveTo(8.24f, 10.45f, 8f, 11.2f, 8f, 12f);
        v12.curveToRelative(0f, 0.8f, 0.24f, 1.55f, 0.64f, 2.17f);
        v12.curveToRelative(0.27f, 0.41f, 0.24f, 0.95f, -0.11f, 1.29f);
        v12.curveToRelative(-0.43f, 0.43f, -1.17f, 0.4f, -1.51f, -0.11f);
        v12.curveTo(6.38f, 14.4f, 6f, 13.24f, 6f, 12f);
        v12.curveToRelative(0f, -1.21f, 0.36f, -2.33f, 0.97f, -3.28f);
        v12.curveTo(7.33f, 8.18f, 8.08f, 8.08f, 8.54f, 8.54f);
        v12.close();
        v12.moveTo(15.46f, 15.46f);
        v12.curveToRelative(0.43f, 0.43f, 1.17f, 0.4f, 1.51f, -0.11f);
        v12.curveTo(17.620001f, 14.4f, 18f, 13.24f, 18f, 12f);
        v12.curveToRelative(0f, -1.24f, -0.38f, -2.4f, -1.03f, -3.36f);
        v12.curveToRelative(-0.34f, -0.5f, -1.08f, -0.54f, -1.51f, -0.11f);
        v12.curveToRelative(-0.35f, 0.35f, -0.37f, 0.88f, -0.11f, 1.29f);
        v12.curveTo(15.76f, 10.45f, 16f, 11.2f, 16f, 12f);
        v12.curveToRelative(0f, 0.8f, -0.24f, 1.55f, -0.64f, 2.17f);
        v12.curveTo(15.09f, 14.58f, 15.12f, 15.12f, 15.46f, 15.46f);
        v12.close();
        v12.moveTo(12f, 10f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(13.1f, 10f, 12f, 10f);
        v12.close();
        v12.moveTo(18.32f, 18.32f);
        v12.curveToRelative(0.42f, 0.42f, 1.12f, 0.39f, 1.5f, -0.08f);
        v12.curveTo(21.18f, 16.530001f, 22f, 14.36f, 22f, 12f);
        v12.reflectiveCurveToRelative(-0.82f, -4.53f, -2.18f, -6.24f);
        v12.curveToRelative(-0.37f, -0.47f, -1.07f, -0.5f, -1.5f, -0.08f);
        v12.curveToRelative(-0.36f, 0.36f, -0.4f, 0.92f, -0.08f, 1.32f);
        v12.curveToRelative(1.1f, 1.37f, 1.76f, 3.11f, 1.76f, 5f);
        v12.reflectiveCurveToRelative(-0.66f, 3.63f, -1.76f, 5f);
        v12.curveTo(17.92f, 17.389999f, 17.959999f, 17.959999f, 18.32f, 18.32f);
        v12.close();
        v12.moveTo(5.68f, 5.68f);
        v12.curveToRelative(-0.42f, -0.42f, -1.12f, -0.39f, -1.5f, 0.08f);
        v12.curveTo(2.82f, 7.47f, 2f, 9.64f, 2f, 12f);
        v12.reflectiveCurveToRelative(0.82f, 4.53f, 2.18f, 6.24f);
        v12.curveToRelative(0.37f, 0.47f, 1.07f, 0.5f, 1.5f, 0.08f);
        v12.curveToRelative(0.36f, -0.36f, 0.4f, -0.92f, 0.08f, -1.32f);
        v12.curveTo(4.66f, 15.63f, 4f, 13.89f, 4f, 12f);
        v12.reflectiveCurveToRelative(0.66f, -3.63f, 1.76f, -5f);
        v12.curveTo(6.08f, 6.61f, 6.04f, 6.04f, 5.68f, 5.68f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SensorsKt._sensors = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

