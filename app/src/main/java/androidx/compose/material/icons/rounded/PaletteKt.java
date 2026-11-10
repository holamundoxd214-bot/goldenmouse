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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_palette", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Palette", "Landroidx/compose/material/icons/Icons$Rounded;", "getPalette", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PaletteKt {
    private static ImageVector _palette;

    static {
    }

    public static final ImageVector getPalette(Rounded arg19) {
        ImageVector v0 = PaletteKt._palette;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Palette", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.49f, 2f, 2f, 6.49f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.49f, 10f, 10f, 10f);
        v12.curveToRelative(1.38f, 0f, 2.5f, -1.12f, 2.5f, -2.5f);
        v12.curveToRelative(0f, -0.61f, -0.23f, -1.2f, -0.64f, -1.67f);
        v12.curveToRelative(-0.08f, -0.1f, -0.13f, -0.21f, -0.13f, -0.33f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineTo(16f);
        v12.curveToRelative(3.31f, 0f, 6f, -2.69f, 6f, -6f);
        v12.curveTo(22f, 6.04f, 17.51f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(17.5f, 13f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.curveTo(19f, 12.33f, 18.33f, 13f, 17.5f, 13f);
        v12.close();
        v12.moveTo(14.5f, 9f);
        v12.curveTo(13.67f, 9f, 13f, 8.33f, 13f, 7.5f);
        v12.curveTo(13f, 6.67f, 13.67f, 6f, 14.5f, 6f);
        v12.reflectiveCurveTo(16f, 6.67f, 16f, 7.5f);
        v12.curveTo(16f, 8.33f, 15.33f, 9f, 14.5f, 9f);
        v12.close();
        v12.moveTo(5f, 11.5f);
        v12.curveTo(5f, 10.67f, 5.67f, 10f, 6.5f, 10f);
        v12.reflectiveCurveTo(8f, 10.67f, 8f, 11.5f);
        v12.curveTo(8f, 12.33f, 7.33f, 13f, 6.5f, 13f);
        v12.reflectiveCurveTo(5f, 12.33f, 5f, 11.5f);
        v12.close();
        v12.moveTo(11f, 7.5f);
        v12.curveTo(11f, 8.33f, 10.33f, 9f, 9.5f, 9f);
        v12.reflectiveCurveTo(8f, 8.33f, 8f, 7.5f);
        v12.curveTo(8f, 6.67f, 8.67f, 6f, 9.5f, 6f);
        v12.reflectiveCurveTo(11f, 6.67f, 11f, 7.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PaletteKt._palette = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

