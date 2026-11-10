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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_filterVintage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FilterVintage", "Landroidx/compose/material/icons/Icons$Rounded;", "getFilterVintage", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FilterVintageKt {
    private static ImageVector _filterVintage;

    static {
    }

    public static final ImageVector getFilterVintage(Rounded arg19) {
        ImageVector v0 = FilterVintageKt._filterVintage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FilterVintage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.700001f, 12.4f);
        v12.curveToRelative(-0.28f, -0.16f, -0.57f, -0.29f, -0.86f, -0.4f);
        v12.curveToRelative(0.29f, -0.11f, 0.58f, -0.24f, 0.86f, -0.4f);
        v12.curveToRelative(1.92f, -1.11f, 2.99f, -3.12f, 3f, -5.19f);
        v12.curveToRelative(-1.79f, -1.03f, -4.07f, -1.11f, -6f, 0f);
        v12.curveToRelative(-0.28f, 0.16f, -0.54f, 0.35f, -0.78f, 0.54f);
        v12.curveToRelative(0.05f, -0.31f, 0.08f, -0.63f, 0.08f, -0.95f);
        v12.curveToRelative(0f, -2.22f, -1.21f, -4.15f, -3f, -5.19f);
        v12.curveTo(10.21f, 1.85f, 9f, 3.78f, 9f, 6f);
        v12.curveToRelative(0f, 0.32f, 0.03f, 0.64f, 0.08f, 0.95f);
        v12.curveToRelative(-0.24f, -0.2f, -0.5f, -0.39f, -0.78f, -0.55f);
        v12.curveToRelative(-1.92f, -1.11f, -4.2f, -1.03f, -6f, 0f);
        v12.curveToRelative(0f, 2.07f, 1.07f, 4.08f, 3f, 5.19f);
        v12.curveToRelative(0.28f, 0.16f, 0.57f, 0.29f, 0.86f, 0.4f);
        v12.curveToRelative(-0.29f, 0.11f, -0.58f, 0.24f, -0.86f, 0.4f);
        v12.curveToRelative(-1.92f, 1.11f, -2.99f, 3.12f, -3f, 5.19f);
        v12.curveToRelative(1.79f, 1.03f, 4.07f, 1.11f, 6f, 0f);
        v12.curveToRelative(0.28f, -0.16f, 0.54f, -0.35f, 0.78f, -0.54f);
        v12.curveToRelative(-0.05f, 0.32f, -0.08f, 0.64f, -0.08f, 0.96f);
        v12.curveToRelative(0f, 2.22f, 1.21f, 4.15f, 3f, 5.19f);
        v12.curveToRelative(1.79f, -1.04f, 3f, -2.97f, 3f, -5.19f);
        v12.curveToRelative(0f, -0.32f, -0.03f, -0.64f, -0.08f, -0.95f);
        v12.curveToRelative(0.24f, 0.2f, 0.5f, 0.38f, 0.78f, 0.54f);
        v12.curveToRelative(1.92f, 1.11f, 4.2f, 1.03f, 6f, 0f);
        v12.curveToRelative(-0.01f, -2.07f, -1.08f, -4.08f, -3f, -5.19f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.reflectiveCurveToRelative(-1.79f, 4f, -4f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FilterVintageKt._filterVintage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

