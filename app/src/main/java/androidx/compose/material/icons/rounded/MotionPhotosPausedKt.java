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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_motionPhotosPaused", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MotionPhotosPaused", "Landroidx/compose/material/icons/Icons$Rounded;", "getMotionPhotosPaused", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MotionPhotosPausedKt {
    private static ImageVector _motionPhotosPaused;

    static {
    }

    public static final ImageVector getMotionPhotosPaused(Rounded arg19) {
        ImageVector v0 = MotionPhotosPausedKt._motionPhotosPaused;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MotionPhotosPaused", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 9f);
        v12.lineTo(4f, 9f);
        v12.curveToRelative(0.26f, 0.26f, 0.34f, 0.63f, 0.25f, 0.98f);
        v12.curveToRelative(-0.35f, 1.36f, -0.36f, 2.87f, 0.1f, 4.38f);
        v12.curveToRelative(0.88f, 2.91f, 3.44f, 5.1f, 6.44f, 5.55f);
        v12.curveToRelative(5.52f, 0.81f, 10.19f, -4.06f, 9.03f, -9.62f);
        v12.curveToRelative(-0.65f, -3.13f, -3.23f, -5.61f, -6.37f, -6.16f);
        v12.curveToRelative(-1.21f, -0.21f, -2.38f, -0.15f, -3.46f, 0.13f);
        v12.curveTo(9.64f, 4.35f, 9.26f, 4.26f, 9.01f, 4.01f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(8.45f, 3.45f, 8.73f, 2.52f, 9.48f, 2.32f);
        v12.curveToRelative(1.47f, -0.38f, 3.06f, -0.44f, 4.7f, -0.09f);
        v12.curveToRelative(3.98f, 0.86f, 7.09f, 4.18f, 7.7f, 8.2f);
        v12.curveToRelative(1.04f, 6.81f, -4.82f, 12.58f, -11.64f, 11.42f);
        v12.curveTo(6.23f, 21.16f, 2.98f, 17.99f, 2.2f, 14f);
        v12.curveToRelative(-0.31f, -1.59f, -0.24f, -3.12f, 0.12f, -4.53f);
        v12.curveTo(2.52f, 8.72f, 3.45f, 8.45f, 4f, 9f);
        v12.close();
        v12.moveTo(7f, 5.5f);
        v12.curveTo(7f, 6.33f, 6.33f, 7f, 5.5f, 7f);
        v12.reflectiveCurveTo(4f, 6.33f, 4f, 5.5f);
        v12.reflectiveCurveTo(4.67f, 4f, 5.5f, 4f);
        v12.reflectiveCurveTo(7f, 4.67f, 7f, 5.5f);
        v12.close();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(-3.31f, 0f, -6f, 2.69f, -6f, 6f);
        v12.reflectiveCurveToRelative(2.69f, 6f, 6f, 6f);
        v12.reflectiveCurveToRelative(6f, -2.69f, 6f, -6f);
        v12.reflectiveCurveTo(15.31f, 6f, 12f, 6f);
        v12.close();
        v12.moveTo(10f, 15f);
        v12.lineTo(10f, 15f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveTo(11f, 14.55f, 10.55f, 15f, 10f, 15f);
        v12.close();
        v12.moveTo(14f, 15f);
        v12.lineTo(14f, 15f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveTo(15f, 14.55f, 14.55f, 15f, 14f, 15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MotionPhotosPausedKt._motionPhotosPaused = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

