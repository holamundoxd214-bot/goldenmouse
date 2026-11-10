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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_filterListOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FilterListOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getFilterListOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FilterListOffKt {
    private static ImageVector _filterListOff;

    static {
    }

    public static final ImageVector getFilterListOff(Rounded arg19) {
        ImageVector v0 = FilterListOffKt._filterListOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FilterListOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 7f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(8.83f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(20f);
        v12.curveTo(20.549999f, 8f, 21f, 7.55f, 21f, 7f);
        v12.close();
        v12.moveTo(18f, 12f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3.17f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(17f);
        v12.curveTo(17.549999f, 13f, 18f, 12.55f, 18f, 12f);
        v12.close();
        v12.moveTo(13.98f, 16.809999f);
        v12.curveTo(13.99f, 16.870001f, 14f, 16.940001f, 14f, 17f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.06f, 0f, 0.13f, 0.01f, 0.19f, 0.02f);
        v12.lineTo(10.17f, 13f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(1.17f);
        v12.lineToRelative(-3f, -3f);
        v12.horizontalLineTo(4f);
        v12.curveTo(3.45f, 8f, 3f, 7.55f, 3f, 7f);
        v12.curveToRelative(0f, -0.32f, 0.15f, -0.6f, 0.38f, -0.79f);
        v12.lineTo(2.1f, 4.93f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.reflectiveCurveToRelative(1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(16.969999f, 16.969999f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.reflectiveCurveToRelative(-1.02f, 0.39f, -1.41f, 0f);
        v12.lineTo(13.98f, 16.809999f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FilterListOffKt._filterListOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

