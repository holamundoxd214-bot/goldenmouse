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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaWideAngleSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaWideAngleSelect", "Landroidx/compose/material/icons/Icons$Outlined;", "getPanoramaWideAngleSelect", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaWideAngleSelectKt {
    private static ImageVector _panoramaWideAngleSelect;

    static {
    }

    public static final ImageVector getPanoramaWideAngleSelect(Outlined arg19) {
        ImageVector v0 = PanoramaWideAngleSelectKt._panoramaWideAngleSelect;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PanoramaWideAngleSelect", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveTo(8.03f, 4f, 5.15f, 4.63f, 3f, 5f);
        v12.curveToRelative(-0.55f, 1.97f, -1f, 3.92f, -1f, 7f);
        v12.curveToRelative(0f, 3.03f, 0.45f, 5.05f, 1f, 7f);
        v12.curveToRelative(2.15f, 0.37f, 4.98f, 1f, 9f, 1f);
        v12.curveToRelative(3.97f, 0f, 6.85f, -0.63f, 9f, -1f);
        v12.curveToRelative(0.57f, -2.02f, 1f, -3.99f, 1f, -7f);
        v12.curveToRelative(0f, -3.03f, -0.45f, -5.05f, -1f, -7f);
        v12.curveTo(18.85f, 4.63f, 16.02f, 4f, 12f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaWideAngleSelectKt._panoramaWideAngleSelect = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

