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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_compassCalibration", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CompassCalibration", "Landroidx/compose/material/icons/Icons$TwoTone;", "getCompassCalibration", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CompassCalibrationKt {
    private static ImageVector _compassCalibration;

    static {
    }

    public static final ImageVector getCompassCalibration(TwoTone arg20) {
        ImageVector v0 = CompassCalibrationKt._compassCalibration;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.CompassCalibration", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.94f, 7.26f);
        v12.lineToRelative(2.21f, 2.21f);
        v12.curveToRelative(1.44f, -0.91f, 3.11f, -1.4f, 4.85f, -1.4f);
        v12.curveToRelative(1.74f, 0f, 3.41f, 0.49f, 4.84f, 1.4f);
        v12.lineToRelative(2.21f, -2.21f);
        v12.curveTo(17f, 5.79f, 14.56f, 5f, 12f, 5f);
        v12.curveToRelative(-2.56f, 0f, -5.01f, 0.79f, -7.06f, 2.26f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 17f);
        v12.moveToRelative(-3f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, 6f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, -6f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 17f);
        v12.curveToRelative(0f, -2.76f, -2.24f, -5f, -5f, -5f);
        v12.reflectiveCurveToRelative(-5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.24f, 5f, -5f);
        v12.close();
        v12.moveTo(9f, 17f);
        v12.curveToRelative(0f, -1.65f, 1.35f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.35f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.35f, 3f, -3f, 3f);
        v12.reflectiveCurveToRelative(-3f, -1.35f, -3f, -3f);
        v12.close();
        v12.moveTo(2f, 7.15f);
        v12.lineToRelative(5f, 5f);
        v12.curveToRelative(1.28f, -1.28f, 3.05f, -2.08f, 5f, -2.08f);
        v12.reflectiveCurveToRelative(3.72f, 0.79f, 5f, 2.07f);
        v12.lineToRelative(5f, -5f);
        v12.curveTo(19.440001f, 4.59f, 15.9f, 3f, 12f, 3f);
        v12.curveTo(8.1f, 3f, 4.56f, 4.59f, 2f, 7.15f);
        v12.close();
        v12.moveTo(16.84f, 9.47f);
        v12.curveToRelative(-1.44f, -0.91f, -3.1f, -1.4f, -4.84f, -1.4f);
        v12.curveToRelative(-1.74f, 0f, -3.41f, 0.49f, -4.85f, 1.41f);
        v12.lineTo(4.94f, 7.26f);
        v12.curveTo(6.99f, 5.79f, 9.44f, 5f, 12f, 5f);
        v12.curveToRelative(2.56f, 0f, 5f, 0.79f, 7.05f, 2.26f);
        v12.lineToRelative(-2.21f, 2.21f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CompassCalibrationKt._compassCalibration = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

