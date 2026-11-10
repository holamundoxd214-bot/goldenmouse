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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_volumeOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VolumeOff", "Landroidx/compose/material/icons/Icons$Filled;", "getVolumeOff$annotations", "(Landroidx/compose/material/icons/Icons$Filled;)V", "getVolumeOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VolumeOffKt {
    private static ImageVector _volumeOff;

    static {
    }

    public static final ImageVector getVolumeOff(Filled arg19) {
        ImageVector v0 = VolumeOffKt._volumeOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.VolumeOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.5f, 12f);
        v12.curveToRelative(0f, -1.77f, -1.02f, -3.29f, -2.5f, -4.03f);
        v12.verticalLineToRelative(2.21f);
        v12.lineToRelative(2.45f, 2.45f);
        v12.curveToRelative(0.03f, -0.2f, 0.05f, -0.41f, 0.05f, -0.63f);
        v12.close();
        v12.moveTo(19f, 12f);
        v12.curveToRelative(0f, 0.94f, -0.2f, 1.82f, -0.54f, 2.64f);
        v12.lineToRelative(1.51f, 1.51f);
        v12.curveTo(20.629999f, 14.91f, 21f, 13.5f, 21f, 12f);
        v12.curveToRelative(0f, -4.28f, -2.99f, -7.86f, -7f, -8.77f);
        v12.verticalLineToRelative(2.06f);
        v12.curveToRelative(2.89f, 0.86f, 5f, 3.54f, 5f, 6.71f);
        v12.close();
        v12.moveTo(4.27f, 3f);
        v12.lineTo(3f, 4.27f);
        v12.lineTo(7.73f, 9f);
        v12.lineTo(3f, 9f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(4f);
        v12.lineToRelative(5f, 5f);
        v12.verticalLineToRelative(-6.73f);
        v12.lineToRelative(4.25f, 4.25f);
        v12.curveToRelative(-0.67f, 0.52f, -1.42f, 0.93f, -2.25f, 1.18f);
        v12.verticalLineToRelative(2.06f);
        v12.curveToRelative(1.38f, -0.31f, 2.63f, -0.95f, 3.69f, -1.81f);
        v12.lineTo(19.73f, 21f);
        v12.lineTo(21f, 19.73f);
        v12.lineToRelative(-9f, -9f);
        v12.lineTo(4.27f, 3f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.lineTo(9.91f, 6.09f);
        v12.lineTo(12f, 8.18f);
        v12.lineTo(12f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VolumeOffKt._volumeOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Filled.VolumeOff", replaceWith="<_subannotation>") public static void getVolumeOff$annotations(Filled arg0) {
    }
}

