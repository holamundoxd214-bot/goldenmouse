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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaHorizontal", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaHorizontal", "Landroidx/compose/material/icons/Icons$Filled;", "getPanoramaHorizontal", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaHorizontalKt {
    private static ImageVector _panoramaHorizontal;

    static {
    }

    public static final ImageVector getPanoramaHorizontal(Filled arg19) {
        ImageVector v0 = PanoramaHorizontalKt._panoramaHorizontal;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PanoramaHorizontal", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 6.54f);
        v12.verticalLineToRelative(10.91f);
        v12.curveToRelative(-2.6f, -0.77f, -5.28f, -1.16f, -8f, -1.16f);
        v12.curveToRelative(-2.72f, 0f, -5.4f, 0.39f, -8f, 1.16f);
        v12.verticalLineTo(6.54f);
        v12.curveToRelative(2.6f, 0.77f, 5.28f, 1.16f, 8f, 1.16f);
        v12.curveToRelative(2.72f, 0.01f, 5.4f, -0.38f, 8f, -1.16f);
        v12.moveTo(21.43f, 4f);
        v12.curveToRelative(-0.1f, 0f, -0.2f, 0.02f, -0.31f, 0.06f);
        v12.curveTo(18.18f, 5.16f, 15.09f, 5.7f, 12f, 5.7f);
        v12.curveToRelative(-3.09f, 0f, -6.18f, -0.55f, -9.12f, -1.64f);
        v12.curveToRelative(-0.11f, -0.04f, -0.22f, -0.06f, -0.31f, -0.06f);
        v12.curveToRelative(-0.34f, 0f, -0.57f, 0.23f, -0.57f, 0.63f);
        v12.verticalLineToRelative(14.75f);
        v12.curveToRelative(0f, 0.39f, 0.23f, 0.62f, 0.57f, 0.62f);
        v12.curveToRelative(0.1f, 0f, 0.2f, -0.02f, 0.31f, -0.06f);
        v12.curveToRelative(2.94f, -1.1f, 6.03f, -1.64f, 9.12f, -1.64f);
        v12.curveToRelative(3.09f, 0f, 6.18f, 0.55f, 9.12f, 1.64f);
        v12.curveToRelative(0.11f, 0.04f, 0.21f, 0.06f, 0.31f, 0.06f);
        v12.curveToRelative(0.33f, 0f, 0.57f, -0.23f, 0.57f, -0.63f);
        v12.verticalLineTo(4.63f);
        v12.curveToRelative(0f, -0.4f, -0.24f, -0.63f, -0.57f, -0.63f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaHorizontalKt._panoramaHorizontal = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

