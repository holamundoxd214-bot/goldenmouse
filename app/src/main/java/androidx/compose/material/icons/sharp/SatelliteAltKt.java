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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_satelliteAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SatelliteAlt", "Landroidx/compose/material/icons/Icons$Sharp;", "getSatelliteAlt", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SatelliteAltKt {
    private static ImageVector _satelliteAlt;

    static {
    }

    public static final ImageVector getSatelliteAlt(Sharp arg19) {
        ImageVector v0 = SatelliteAltKt._satelliteAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SatelliteAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.44f, 0.59f);
        v12.lineToRelative(-3.18f, 3.18f);
        v12.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0f, 2.83f);
        v12.lineToRelative(1.24f, 1.24f);
        v12.lineToRelative(-0.71f, 0.71f);
        v12.lineToRelative(-2.65f, -2.65f);
        v12.lineToRelative(-4.24f, 4.24f);
        v12.lineToRelative(2.65f, 2.65f);
        v12.lineToRelative(-0.71f, 0.71f);
        v12.lineTo(6.6f, 12.25f);
        v12.curveToRelative(-0.78f, -0.78f, -2.05f, -0.78f, -2.83f, 0f);
        v12.lineToRelative(-3.18f, 3.18f);
        v12.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0f, 2.83f);
        v12.lineToRelative(3.54f, 3.54f);
        v12.curveToRelative(0.78f, 0.78f, 2.05f, 0.78f, 2.83f, 0f);
        v12.lineToRelative(3.18f, -3.18f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineToRelative(-1.24f, -1.24f);
        v12.lineToRelative(0.71f, -0.71f);
        v12.lineToRelative(2.65f, 2.65f);
        v12.lineToRelative(4.24f, -4.24f);
        v12.lineTo(13.84f, 9.6f);
        v12.lineToRelative(0.71f, -0.71f);
        v12.lineToRelative(1.24f, 1.24f);
        v12.curveToRelative(0.78f, 0.78f, 2.05f, 0.78f, 2.83f, 0f);
        v12.lineToRelative(3.18f, -3.18f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineToRelative(-3.54f, -3.54f);
        v12.curveTo(17.48f, -0.2f, 16.219999f, -0.2f, 15.44f, 0.59f);
        v12.close();
        v12.moveTo(6.6f, 19.32f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineTo(2f, 16.85f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(6.6f, 19.32f);
        v12.close();
        v12.moveTo(8.72f, 17.200001f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineToRelative(-3.54f, -3.54f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(8.72f, 17.200001f);
        v12.close();
        v12.moveTo(18.26f, 7.66f);
        v12.lineTo(17.200001f, 8.72f);
        v12.lineToRelative(-3.54f, -3.54f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(18.26f, 7.66f);
        v12.close();
        v12.moveTo(20.379999f, 5.54f);
        v12.lineTo(19.32f, 6.6f);
        v12.lineToRelative(-3.54f, -3.54f);
        v12.lineTo(16.85f, 2f);
        v12.lineTo(20.379999f, 5.54f);
        v12.close();
        v12.moveTo(21f, 14f);
        v12.lineToRelative(2f, 0f);
        v12.curveToRelative(0f, 4.97f, -4.03f, 9f, -9f, 9f);
        v12.lineToRelative(0f, -2f);
        v12.curveTo(17.870001f, 21f, 21f, 17.870001f, 21f, 14f);
        v12.close();
        v12.moveTo(17f, 14f);
        v12.lineToRelative(2f, 0f);
        v12.curveToRelative(0f, 2.76f, -2.24f, 5f, -5f, 5f);
        v12.lineToRelative(0f, -2f);
        v12.curveTo(15.66f, 17f, 17f, 15.66f, 17f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SatelliteAltKt._satelliteAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

