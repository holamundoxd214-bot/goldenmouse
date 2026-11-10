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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaVertical", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaVertical", "Landroidx/compose/material/icons/Icons$Filled;", "getPanoramaVertical", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaVerticalKt {
    private static ImageVector _panoramaVertical;

    static {
    }

    public static final ImageVector getPanoramaVertical(Filled arg19) {
        ImageVector v0 = PanoramaVerticalKt._panoramaVertical;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PanoramaVertical", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.940001f, 21.120001f);
        v12.curveToRelative(-1.1f, -2.94f, -1.64f, -6.03f, -1.64f, -9.12f);
        v12.curveToRelative(0f, -3.09f, 0.55f, -6.18f, 1.64f, -9.12f);
        v12.curveToRelative(0.04f, -0.11f, 0.06f, -0.22f, 0.06f, -0.31f);
        v12.curveToRelative(0f, -0.34f, -0.23f, -0.57f, -0.63f, -0.57f);
        v12.horizontalLineTo(4.63f);
        v12.curveToRelative(-0.4f, 0f, -0.63f, 0.23f, -0.63f, 0.57f);
        v12.curveToRelative(0f, 0.1f, 0.02f, 0.2f, 0.06f, 0.31f);
        v12.curveTo(5.16f, 5.82f, 5.71f, 8.91f, 5.71f, 12f);
        v12.curveToRelative(0f, 3.09f, -0.55f, 6.18f, -1.64f, 9.12f);
        v12.curveToRelative(-0.05f, 0.11f, -0.07f, 0.22f, -0.07f, 0.31f);
        v12.curveToRelative(0f, 0.33f, 0.23f, 0.57f, 0.63f, 0.57f);
        v12.horizontalLineToRelative(14.75f);
        v12.curveToRelative(0.39f, 0f, 0.63f, -0.24f, 0.63f, -0.57f);
        v12.curveToRelative(-0.01f, -0.1f, -0.03f, -0.2f, -0.07f, -0.31f);
        v12.close();
        v12.moveTo(6.54f, 20f);
        v12.curveToRelative(0.77f, -2.6f, 1.16f, -5.28f, 1.16f, -8f);
        v12.curveToRelative(0f, -2.72f, -0.39f, -5.4f, -1.16f, -8f);
        v12.horizontalLineToRelative(10.91f);
        v12.curveToRelative(-0.77f, 2.6f, -1.16f, 5.28f, -1.16f, 8f);
        v12.curveToRelative(0f, 2.72f, 0.39f, 5.4f, 1.16f, 8f);
        v12.horizontalLineTo(6.54f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaVerticalKt._panoramaVertical = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

