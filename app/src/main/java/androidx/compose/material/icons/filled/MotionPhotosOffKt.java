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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_motionPhotosOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MotionPhotosOff", "Landroidx/compose/material/icons/Icons$Filled;", "getMotionPhotosOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MotionPhotosOffKt {
    private static ImageVector _motionPhotosOff;

    static {
    }

    public static final ImageVector getMotionPhotosOff(Filled arg19) {
        ImageVector v0 = MotionPhotosOffKt._motionPhotosOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.MotionPhotosOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.84f, 20.84f);
        v12.lineTo(3.16f, 3.16f);
        v12.lineTo(1.89f, 4.43f);
        v12.lineToRelative(1.89f, 1.89f);
        v12.curveTo(2.66f, 7.93f, 2f, 9.89f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.curveToRelative(2.11f, 0f, 4.07f, -0.66f, 5.68f, -1.77f);
        v12.lineToRelative(1.89f, 1.89f);
        v12.lineToRelative(1.27f, -1.28f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.curveToRelative(0f, -1.55f, 0.45f, -3f, 1.22f, -4.23f);
        v12.lineToRelative(1.46f, 1.46f);
        v12.curveTo(6.25f, 10.06f, 6f, 11f, 6f, 12f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.curveToRelative(1f, 0f, 1.94f, -0.25f, 2.77f, -0.68f);
        v12.lineToRelative(1.46f, 1.46f);
        v12.curveTo(15f, 19.549999f, 13.55f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(6.32f, 3.77f);
        v12.curveTo(7.93f, 2.66f, 9.89f, 2f, 12f, 2f);
        v12.curveToRelative(5.52f, 0f, 10f, 4.48f, 10f, 10f);
        v12.curveToRelative(0f, 2.11f, -0.66f, 4.07f, -1.77f, 5.68f);
        v12.lineToRelative(-1.45f, -1.45f);
        v12.curveTo(19.549999f, 15f, 20f, 13.55f, 20f, 12f);
        v12.curveToRelative(0f, -4.41f, -3.59f, -8f, -8f, -8f);
        v12.curveToRelative(-1.55f, 0f, -3f, 0.45f, -4.23f, 1.22f);
        v12.lineTo(6.32f, 3.77f);
        v12.close();
        v12.moveTo(18f, 12f);
        v12.curveToRelative(0f, 1f, -0.25f, 1.94f, -0.68f, 2.77f);
        v12.lineTo(9.23f, 6.68f);
        v12.curveTo(10.06f, 6.25f, 11f, 6f, 12f, 6f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MotionPhotosOffKt._motionPhotosOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

