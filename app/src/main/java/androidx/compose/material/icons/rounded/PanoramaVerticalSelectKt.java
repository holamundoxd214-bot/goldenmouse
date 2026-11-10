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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaVerticalSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaVerticalSelect", "Landroidx/compose/material/icons/Icons$Rounded;", "getPanoramaVerticalSelect", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaVerticalSelectKt {
    private static ImageVector _panoramaVerticalSelect;

    static {
    }

    public static final ImageVector getPanoramaVerticalSelect(Rounded arg19) {
        ImageVector v0 = PanoramaVerticalSelectKt._panoramaVerticalSelect;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PanoramaVerticalSelect", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 12f);
        v12.curveToRelative(0f, -3.89f, 0.84f, -6.95f, 1.43f, -8.69f);
        v12.curveTo(20.15f, 2.67f, 19.67f, 2f, 18.98f, 2f);
        v12.lineTo(5f, 2f);
        v12.curveTo(4.32f, 2f, 3.84f, 2.66f, 4.05f, 3.31f);
        v12.curveTo(4.74f, 5.36f, 5.5f, 8.1f, 5.5f, 12f);
        v12.curveToRelative(0f, 3.87f, -0.76f, 6.66f, -1.45f, 8.69f);
        v12.curveTo(3.84f, 21.34f, 4.32f, 22f, 5f, 22f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(0.68f, 0f, 1.17f, -0.66f, 0.95f, -1.31f);
        v12.curveTo(19.27f, 18.66f, 18.5f, 15.86f, 18.5f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaVerticalSelectKt._panoramaVerticalSelect = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

