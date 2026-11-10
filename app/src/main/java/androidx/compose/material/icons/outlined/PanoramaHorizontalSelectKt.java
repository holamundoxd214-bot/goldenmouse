package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaHorizontalSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaHorizontalSelect", "Landroidx/compose/material/icons/Icons$Outlined;", "getPanoramaHorizontalSelect", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaHorizontalSelectKt {
    private static ImageVector _panoramaHorizontalSelect;

    static {
    }

    public static final ImageVector getPanoramaHorizontalSelect(Outlined arg19) {
        ImageVector v0 = PanoramaHorizontalSelectKt._panoramaHorizontalSelect;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PanoramaHorizontalSelect", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 5.5f);
        v12.curveToRelative(-3.89f, 0f, -6.95f, -0.84f, -8.69f, -1.43f);
        v12.curveTo(2.67f, 3.85f, 2f, 4.33f, 2f, 5.02f);
        v12.lineTo(2f, 19f);
        v12.curveToRelative(0f, 0.68f, 0.66f, 1.17f, 1.31f, 0.95f);
        v12.curveTo(5.36f, 19.26f, 8.1f, 18.5f, 12f, 18.5f);
        v12.curveToRelative(3.87f, 0f, 6.66f, 0.76f, 8.69f, 1.45f);
        v12.curveTo(21.34f, 20.16f, 22f, 19.68f, 22f, 19f);
        v12.lineToRelative(0f, -14f);
        v12.curveToRelative(0f, -0.68f, -0.66f, -1.17f, -1.31f, -0.95f);
        v12.curveTo(18.66f, 4.73f, 15.86f, 5.5f, 12f, 5.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaHorizontalSelectKt._panoramaHorizontalSelect = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

