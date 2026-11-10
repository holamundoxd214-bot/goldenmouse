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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bikeScooter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BikeScooter", "Landroidx/compose/material/icons/Icons$Filled;", "getBikeScooter", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BikeScooterKt {
    private static ImageVector _bikeScooter;

    static {
    }

    public static final ImageVector getBikeScooter(Filled arg19) {
        ImageVector v0 = BikeScooterKt._bikeScooter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.BikeScooter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 14f);
        v12.horizontalLineToRelative(0.74f);
        v12.lineTo(8.82f, 5.56f);
        v12.curveTo(8.61f, 4.65f, 7.8f, 4f, 6.87f, 4f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3.87f);
        v12.lineToRelative(1.42f, 6.25f);
        v12.curveToRelative(0f, 0f, -0.01f, 0f, -0.01f, 0f);
        v12.curveTo(6.12f, 12.9f, 4.47f, 14.73f, 4.09f, 17f);
        v12.horizontalLineTo(0f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-1f);
        v12.curveTo(6f, 15.79f, 7.79f, 14f, 10f, 14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19f, 8f);
        v12.horizontalLineToRelative(-0.82f);
        v12.lineToRelative(-1.35f, -3.69f);
        v12.curveTo(16.549999f, 3.52f, 15.8f, 3f, 14.96f, 3f);
        v12.horizontalLineTo(11f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3.96f);
        v12.lineToRelative(1.1f, 3f);
        v12.horizontalLineTo(10.4f);
        v12.lineToRelative(0.46f, 2f);
        v12.horizontalLineTo(15f);
        v12.curveToRelative(-0.43f, 0.58f, -0.75f, 1.25f, -0.9f, 2f);
        v12.horizontalLineToRelative(-2.79f);
        v12.lineToRelative(0.46f, 2f);
        v12.horizontalLineToRelative(2.33f);
        v12.curveToRelative(0.44f, 2.23f, 2.31f, 3.88f, 4.65f, 3.99f);
        v12.curveToRelative(2.8f, 0.13f, 5.25f, -2.19f, 5.25f, -5f);
        v12.curveTo(24f, 10.2f, 21.799999f, 8f, 19f, 8f);
        v12.close();
        v12.moveTo(19f, 16f);
        v12.curveToRelative(-1.68f, 0f, -3f, -1.32f, -3f, -3f);
        v12.curveToRelative(0f, -0.93f, 0.41f, -1.73f, 1.05f, -2.28f);
        v12.lineToRelative(0.96f, 2.64f);
        v12.lineToRelative(1.88f, -0.68f);
        v12.lineToRelative(-0.97f, -2.67f);
        v12.curveToRelative(0.03f, 0f, 0.06f, -0.01f, 0.09f, -0.01f);
        v12.curveToRelative(1.68f, 0f, 3f, 1.32f, 3f, 3f);
        v12.reflectiveCurveTo(20.68f, 16f, 19f, 16f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(10f, 15f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.reflectiveCurveTo(11.66f, 15f, 10f, 15f);
        v12.close();
        v12.moveTo(10f, 19f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(10.55f, 19f, 10f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BikeScooterKt._bikeScooter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

