package androidx.compose.material.icons.automirrored.sharp;

import androidx.compose.material.icons.Icons$AutoMirrored$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_volumeUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VolumeUp", "Landroidx/compose/material/icons/Icons$AutoMirrored$Sharp;", "getVolumeUp", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VolumeUpKt {
    private static ImageVector _volumeUp;

    static {
    }

    public static final ImageVector getVolumeUp(Sharp arg19) {
        ImageVector v0 = VolumeUpKt._volumeUp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Sharp.VolumeUp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 9f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(4f);
        v12.lineToRelative(5f, 5f);
        v12.lineTo(12f, 4f);
        v12.lineTo(7f, 9f);
        v12.lineTo(3f, 9f);
        v12.close();
        v12.moveTo(16.5f, 12f);
        v12.curveToRelative(0f, -1.77f, -1.02f, -3.29f, -2.5f, -4.03f);
        v12.verticalLineToRelative(8.05f);
        v12.curveToRelative(1.48f, -0.73f, 2.5f, -2.25f, 2.5f, -4.02f);
        v12.close();
        v12.moveTo(14f, 3.23f);
        v12.verticalLineToRelative(2.06f);
        v12.curveToRelative(2.89f, 0.86f, 5f, 3.54f, 5f, 6.71f);
        v12.reflectiveCurveToRelative(-2.11f, 5.85f, -5f, 6.71f);
        v12.verticalLineToRelative(2.06f);
        v12.curveToRelative(4.01f, -0.91f, 7f, -4.49f, 7f, -8.77f);
        v12.reflectiveCurveToRelative(-2.99f, -7.86f, -7f, -8.77f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VolumeUpKt._volumeUp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

