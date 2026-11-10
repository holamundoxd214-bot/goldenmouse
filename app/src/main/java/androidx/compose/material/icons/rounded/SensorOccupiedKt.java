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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sensorOccupied", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SensorOccupied", "Landroidx/compose/material/icons/Icons$Rounded;", "getSensorOccupied", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SensorOccupiedKt {
    private static ImageVector _sensorOccupied;

    static {
    }

    public static final ImageVector getSensorOccupied(Rounded arg19) {
        ImageVector v0 = SensorOccupiedKt._sensorOccupied;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SensorOccupied", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 11f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.reflectiveCurveToRelative(-1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveTo(9f, 6.34f, 9f, 8f);
        v12.reflectiveCurveTo(10.34f, 11f, 12f, 11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 12f);
        v12.curveToRelative(-1.84f, 0f, -3.56f, 0.5f, -5.03f, 1.37f);
        v12.curveTo(6.36f, 13.73f, 6f, 14.39f, 6f, 15.09f);
        v12.lineTo(6f, 16f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.lineToRelative(0f, -0.91f);
        v12.curveToRelative(0f, -0.7f, -0.36f, -1.36f, -0.97f, -1.72f);
        v12.curveTo(15.56f, 12.5f, 13.84f, 12f, 12f, 12f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(22.110001f, 7.79f);
        v12.lineTo(22.110001f, 7.79f);
        v12.curveToRelative(0.55f, -0.23f, 0.78f, -0.88f, 0.5f, -1.41f);
        v12.curveToRelative(-1.13f, -2.12f, -2.87f, -3.86f, -4.99f, -4.99f);
        v12.curveToRelative(-0.52f, -0.28f, -1.17f, -0.04f, -1.4f, 0.5f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(-0.19f, 0.47f, -0.01f, 1.02f, 0.43f, 1.25f);
        v12.curveToRelative(1.79f, 0.94f, 3.26f, 2.42f, 4.21f, 4.21f);
        v12.curveTo(21.09f, 7.8f, 21.639999f, 7.98f, 22.110001f, 7.79f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7.79f, 1.89f);
        v12.lineTo(7.79f, 1.89f);
        v12.curveToRelative(-0.23f, -0.55f, -0.88f, -0.78f, -1.4f, -0.5f);
        v12.curveTo(4.27f, 2.52f, 2.52f, 4.26f, 1.4f, 6.38f);
        v12.curveToRelative(-0.28f, 0.52f, -0.05f, 1.18f, 0.5f, 1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.47f, 0.2f, 1.02f, 0.01f, 1.25f, -0.43f);
        v12.curveToRelative(0.94f, -1.79f, 2.42f, -3.26f, 4.21f, -4.21f);
        v12.curveTo(7.8f, 2.91f, 7.98f, 2.36f, 7.79f, 1.89f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(1.89f, 16.209999f);
        v12.lineTo(1.89f, 16.209999f);
        v12.curveToRelative(-0.55f, 0.23f, -0.78f, 0.88f, -0.5f, 1.4f);
        v12.curveToRelative(1.13f, 2.12f, 2.87f, 3.87f, 5f, 5f);
        v12.curveToRelative(0.52f, 0.28f, 1.17f, 0.04f, 1.4f, -0.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.19f, -0.47f, 0.01f, -1.02f, -0.43f, -1.25f);
        v12.curveToRelative(-1.79f, -0.94f, -3.26f, -2.42f, -4.21f, -4.21f);
        v12.curveTo(2.91f, 16.200001f, 2.36f, 16.02f, 1.89f, 16.209999f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.209999f, 22.110001f);
        v12.lineTo(16.209999f, 22.110001f);
        v12.curveToRelative(0.23f, 0.55f, 0.88f, 0.78f, 1.4f, 0.5f);
        v12.curveToRelative(2.12f, -1.13f, 3.87f, -2.87f, 5f, -5f);
        v12.curveToRelative(0.28f, -0.52f, 0.04f, -1.17f, -0.5f, -1.4f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.47f, -0.19f, -1.02f, -0.01f, -1.25f, 0.43f);
        v12.curveToRelative(-0.94f, 1.79f, -2.42f, 3.26f, -4.21f, 4.21f);
        v12.curveTo(16.200001f, 21.09f, 16.02f, 21.639999f, 16.209999f, 22.110001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SensorOccupiedKt._sensorOccupied = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

