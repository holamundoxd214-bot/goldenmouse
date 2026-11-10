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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_ringVolume", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RingVolume", "Landroidx/compose/material/icons/Icons$Sharp;", "getRingVolume", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RingVolumeKt {
    private static ImageVector _ringVolume;

    static {
    }

    public static final ImageVector getRingVolume(Sharp arg19) {
        ImageVector v0 = RingVolumeKt._ringVolume;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.RingVolume", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.16f, 6.26f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(-3.56f, 3.55f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.reflectiveCurveToRelative(3.45f, -3.52f, 3.56f, -3.55f);
        v12.close();
        v12.moveTo(11f, 2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(6.4f, 9.81f);
        v12.lineTo(7.81f, 8.4f);
        v12.lineTo(4.26f, 4.84f);
        v12.lineTo(2.84f, 6.26f);
        v12.curveToRelative(0.11f, 0.03f, 3.56f, 3.55f, 3.56f, 3.55f);
        v12.close();
        v12.moveTo(0f, 17.389999f);
        v12.lineToRelative(3.68f, 3.68f);
        v12.lineToRelative(3.92f, -3.11f);
        v12.verticalLineToRelative(-3.37f);
        v12.curveToRelative(2.85f, -0.93f, 5.94f, -0.93f, 8.8f, 0f);
        v12.verticalLineToRelative(3.38f);
        v12.lineToRelative(3.91f, 3.1f);
        v12.lineTo(24f, 17.389999f);
        v12.curveToRelative(-6.41f, -7.19f, -17.59f, -7.19f, -24f, 0f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RingVolumeKt._ringVolume = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

