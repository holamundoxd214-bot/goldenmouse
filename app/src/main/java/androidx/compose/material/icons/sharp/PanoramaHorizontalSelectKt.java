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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaHorizontalSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaHorizontalSelect", "Landroidx/compose/material/icons/Icons$Sharp;", "getPanoramaHorizontalSelect", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaHorizontalSelectKt {
    private static ImageVector _panoramaHorizontalSelect;

    static {
    }

    public static final ImageVector getPanoramaHorizontalSelect(Sharp arg19) {
        ImageVector v0 = PanoramaHorizontalSelectKt._panoramaHorizontalSelect;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.PanoramaHorizontalSelect", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 5.5f);
        v12.curveToRelative(-5.25f, 0f, -9.01f, -1.54f, -10f, -1.92f);
        v12.lineTo(2f, 20.4f);
        v12.curveToRelative(2.16f, -0.76f, 5.21f, -1.9f, 10f, -1.9f);
        v12.curveToRelative(4.78f, 0f, 7.91f, 1.17f, 10f, 1.9f);
        v12.lineTo(22f, 3.6f);
        v12.curveTo(19.91f, 4.33f, 16.77f, 5.5f, 12f, 5.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaHorizontalSelectKt._panoramaHorizontalSelect = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

