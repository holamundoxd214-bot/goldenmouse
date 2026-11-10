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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaPhotosphere", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaPhotosphere", "Landroidx/compose/material/icons/Icons$Rounded;", "getPanoramaPhotosphere", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaPhotosphereKt {
    private static ImageVector _panoramaPhotosphere;

    static {
    }

    public static final ImageVector getPanoramaPhotosphere(Rounded arg19) {
        ImageVector v0 = PanoramaPhotosphereKt._panoramaPhotosphere;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PanoramaPhotosphere", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.950001f, 8.15f);
        v12.curveToRelative(-0.29f, -0.16f, -0.61f, -0.31f, -0.93f, -0.46f);
        v12.curveTo(19.4f, 4.33f, 15.98f, 2f, 12f, 2f);
        v12.curveTo(8.02f, 2f, 4.6f, 4.33f, 2.99f, 7.68f);
        v12.curveToRelative(-0.33f, 0.15f, -0.64f, 0.3f, -0.93f, 0.46f);
        v12.curveTo(1.41f, 8.5f, 1f, 9.17f, 1f, 9.91f);
        v12.verticalLineToRelative(4.18f);
        v12.curveToRelative(0f, 0.74f, 0.41f, 1.41f, 1.05f, 1.77f);
        v12.curveToRelative(0.29f, 0.16f, 0.61f, 0.31f, 0.93f, 0.46f);
        v12.curveTo(4.6f, 19.67f, 8.02f, 22f, 12f, 22f);
        v12.curveToRelative(3.98f, 0f, 7.4f, -2.33f, 9.01f, -5.68f);
        v12.curveToRelative(0.33f, -0.15f, 0.64f, -0.3f, 0.93f, -0.46f);
        v12.curveTo(22.59f, 15.5f, 23f, 14.83f, 23f, 14.09f);
        v12.verticalLineTo(9.91f);
        v12.curveTo(23f, 9.17f, 22.59f, 8.5f, 21.950001f, 8.15f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(2.37f, 0f, 4.49f, 1.04f, 5.95f, 2.68f);
        v12.curveTo(16.17f, 6.25f, 14.15f, 6f, 12f, 6f);
        v12.curveTo(9.85f, 6f, 7.83f, 6.25f, 6.05f, 6.68f);
        v12.curveTo(7.51f, 5.04f, 9.63f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-2.37f, 0f, -4.49f, -1.04f, -5.95f, -2.68f);
        v12.curveTo(7.83f, 17.75f, 9.85f, 18f, 12f, 18f);
        v12.reflectiveCurveToRelative(4.17f, -0.25f, 5.95f, -0.68f);
        v12.curveTo(16.49f, 18.959999f, 14.37f, 20f, 12f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaPhotosphereKt._panoramaPhotosphere = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

