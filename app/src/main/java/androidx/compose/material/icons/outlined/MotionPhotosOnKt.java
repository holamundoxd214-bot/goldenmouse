package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_motionPhotosOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MotionPhotosOn", "Landroidx/compose/material/icons/Icons$Outlined;", "getMotionPhotosOn", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MotionPhotosOnKt {
    private static ImageVector _motionPhotosOn;

    static {
    }

    public static final ImageVector getMotionPhotosOn(Outlined arg19) {
        ImageVector v0 = MotionPhotosOnKt._motionPhotosOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.MotionPhotosOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.88f, 7.88f);
        v12.lineToRelative(1.54f, 1.54f);
        v12.curveTo(4.15f, 10.23f, 4f, 11.1f, 4f, 12f);
        v12.curveToRelative(0f, 4.41f, 3.59f, 8f, 8f, 8f);
        v12.reflectiveCurveToRelative(8f, -3.59f, 8f, -8f);
        v12.reflectiveCurveToRelative(-3.59f, -8f, -8f, -8f);
        v12.curveToRelative(-0.9f, 0f, -1.77f, 0.15f, -2.58f, 0.42f);
        v12.lineTo(7.89f, 2.89f);
        v12.curveTo(9.15f, 2.32f, 10.54f, 2f, 12f, 2f);
        v12.curveToRelative(5.52f, 0f, 10f, 4.48f, 10f, 10f);
        v12.reflectiveCurveToRelative(-4.48f, 10f, -10f, 10f);
        v12.reflectiveCurveTo(2f, 17.52f, 2f, 12f);
        v12.curveTo(2f, 10.53f, 2.32f, 9.14f, 2.88f, 7.88f);
        v12.close();
        v12.moveTo(7f, 5.5f);
        v12.curveTo(7f, 6.33f, 6.33f, 7f, 5.5f, 7f);
        v12.reflectiveCurveTo(4f, 6.33f, 4f, 5.5f);
        v12.reflectiveCurveTo(4.67f, 4f, 5.5f, 4f);
        v12.reflectiveCurveTo(7f, 4.67f, 7f, 5.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MotionPhotosOnKt._motionPhotosOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

