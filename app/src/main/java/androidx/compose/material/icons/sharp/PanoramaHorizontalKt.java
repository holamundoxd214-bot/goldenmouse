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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaHorizontal", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaHorizontal", "Landroidx/compose/material/icons/Icons$Sharp;", "getPanoramaHorizontal", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaHorizontalKt {
    private static ImageVector _panoramaHorizontal;

    static {
    }

    public static final ImageVector getPanoramaHorizontal(Sharp arg19) {
        ImageVector v0 = PanoramaHorizontalKt._panoramaHorizontal;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.PanoramaHorizontal", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 6.55f);
        v12.curveToRelative(2.6f, 0.77f, 5.28f, 1.16f, 8f, 1.16f);
        v12.curveToRelative(2.72f, 0f, 5.41f, -0.39f, 8f, -1.16f);
        v12.verticalLineToRelative(10.91f);
        v12.curveToRelative(-2.6f, -0.77f, -5.28f, -1.16f, -8f, -1.16f);
        v12.curveToRelative(-2.72f, 0f, -5.41f, 0.39f, -8f, 1.16f);
        v12.verticalLineTo(6.55f);
        v12.moveTo(2f, 3.77f);
        v12.verticalLineToRelative(16.469999f);
        v12.reflectiveCurveToRelative(0.77f, -0.26f, 0.88f, -0.3f);
        v12.curveTo(5.82f, 18.85f, 8.91f, 18.299999f, 12f, 18.299999f);
        v12.curveToRelative(3.09f, 0f, 6.18f, 0.55f, 9.12f, 1.64f);
        v12.curveToRelative(0.11f, 0.04f, 0.88f, 0.3f, 0.88f, 0.3f);
        v12.verticalLineTo(3.77f);
        v12.reflectiveCurveToRelative(-0.77f, 0.26f, -0.88f, 0.3f);
        v12.curveTo(18.18f, 5.15f, 15.09f, 5.71f, 12f, 5.71f);
        v12.reflectiveCurveToRelative(-6.18f, -0.56f, -9.12f, -1.64f);
        v12.curveToRelative(-0.11f, -0.05f, -0.88f, -0.3f, -0.88f, -0.3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaHorizontalKt._panoramaHorizontal = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

