package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_motionPhotosPaused", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MotionPhotosPaused", "Landroidx/compose/material/icons/Icons$Sharp;", "getMotionPhotosPaused", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MotionPhotosPausedKt {
    private static ImageVector _motionPhotosPaused;

    static {
    }

    public static final ImageVector getMotionPhotosPaused(Sharp arg19) {
        ImageVector v0 = MotionPhotosPausedKt._motionPhotosPaused;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MotionPhotosPaused", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 12f);
        v12.curveToRelative(0f, 5.52f, -4.48f, 10f, -10f, 10f);
        v12.reflectiveCurveTo(2f, 17.52f, 2f, 12f);
        v12.curveToRelative(0f, -1.19f, 0.22f, -2.32f, 0.6f, -3.38f);
        v12.lineTo(4.48f, 9.3f);
        v12.curveTo(4.17f, 10.14f, 4f, 11.05f, 4f, 12f);
        v12.curveToRelative(0f, 4.41f, 3.59f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.59f, 8f, -8f);
        v12.reflectiveCurveToRelative(-3.59f, -8f, -8f, -8f);
        v12.curveToRelative(-0.95f, 0f, -1.85f, 0.17f, -2.69f, 0.48f);
        v12.lineTo(8.63f, 2.59f);
        v12.curveTo(9.69f, 2.22f, 10.82f, 2f, 12f, 2f);
        v12.curveTo(17.52f, 2f, 22f, 6.48f, 22f, 12f);
        v12.close();
        v12.moveTo(5.5f, 4f);
        v12.curveTo(4.67f, 4f, 4f, 4.67f, 4f, 5.5f);
        v12.reflectiveCurveTo(4.67f, 7f, 5.5f, 7f);
        v12.reflectiveCurveTo(7f, 6.33f, 7f, 5.5f);
        v12.reflectiveCurveTo(6.33f, 4f, 5.5f, 4f);
        v12.close();
        v12.moveTo(11f, 16f);
        v12.verticalLineTo(8f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineTo(11f);
        v12.close();
        v12.moveTo(15f, 16f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineTo(15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MotionPhotosPausedKt._motionPhotosPaused = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

