package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_volumeUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VolumeUp", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getVolumeUp", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VolumeUpKt {
    private static ImageVector _volumeUp;

    static {
    }

    public static final ImageVector getVolumeUp(Rounded arg19) {
        ImageVector v0 = VolumeUpKt._volumeUp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.VolumeUp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 10f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3f);
        v12.lineToRelative(3.29f, 3.29f);
        v12.curveToRelative(0.63f, 0.63f, 1.71f, 0.18f, 1.71f, -0.71f);
        v12.lineTo(12f, 6.41f);
        v12.curveToRelative(0f, -0.89f, -1.08f, -1.34f, -1.71f, -0.71f);
        v12.lineTo(7f, 9f);
        v12.lineTo(4f, 9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.close();
        v12.moveTo(16.5f, 12f);
        v12.curveToRelative(0f, -1.77f, -1.02f, -3.29f, -2.5f, -4.03f);
        v12.verticalLineToRelative(8.05f);
        v12.curveToRelative(1.48f, -0.73f, 2.5f, -2.25f, 2.5f, -4.02f);
        v12.close();
        v12.moveTo(14f, 4.45f);
        v12.verticalLineToRelative(0.2f);
        v12.curveToRelative(0f, 0.38f, 0.25f, 0.71f, 0.6f, 0.85f);
        v12.curveTo(17.18f, 6.53f, 19f, 9.06f, 19f, 12f);
        v12.reflectiveCurveToRelative(-1.82f, 5.47f, -4.4f, 6.5f);
        v12.curveToRelative(-0.36f, 0.14f, -0.6f, 0.47f, -0.6f, 0.85f);
        v12.verticalLineToRelative(0.2f);
        v12.curveToRelative(0f, 0.63f, 0.63f, 1.07f, 1.21f, 0.85f);
        v12.curveTo(18.6f, 19.110001f, 21f, 15.84f, 21f, 12f);
        v12.reflectiveCurveToRelative(-2.4f, -7.11f, -5.79f, -8.4f);
        v12.curveToRelative(-0.58f, -0.23f, -1.21f, 0.22f, -1.21f, 0.85f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VolumeUpKt._volumeUp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

