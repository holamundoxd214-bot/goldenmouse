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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_filterDrama", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FilterDrama", "Landroidx/compose/material/icons/Icons$Sharp;", "getFilterDrama", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FilterDramaKt {
    private static ImageVector _filterDrama;

    static {
    }

    public static final ImageVector getFilterDrama(Sharp arg19) {
        ImageVector v0 = FilterDramaKt._filterDrama;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.FilterDrama", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.35f, 10.04f);
        v12.curveTo(18.67f, 6.59f, 15.64f, 4f, 12f, 4f);
        v12.curveTo(9.11f, 4f, 6.61f, 5.64f, 5.36f, 8.04f);
        v12.curveTo(2.35f, 8.36f, 0f, 10.9f, 0f, 14f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f);
        v12.curveToRelative(0f, -2.64f, -2.05f, -4.78f, -4.65f, -4.96f);
        v12.close();
        v12.moveTo(19f, 18f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -2.76f, -1.86f, -5.08f, -4.4f, -5.78f);
        v12.curveTo(8.61f, 6.88f, 10.2f, 6f, 12f, 6f);
        v12.curveToRelative(3.03f, 0f, 5.5f, 2.47f, 5.5f, 5.5f);
        v12.verticalLineToRelative(0.5f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(1.65f, 0f, 3f, 1.35f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.35f, 3f, -3f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FilterDramaKt._filterDrama = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

