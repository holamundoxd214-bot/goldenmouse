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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_brightness4", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Brightness4", "Landroidx/compose/material/icons/Icons$Filled;", "getBrightness4", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Brightness4Kt {
    private static ImageVector _brightness4;

    static {
    }

    public static final ImageVector getBrightness4(Filled arg19) {
        ImageVector v0 = Brightness4Kt._brightness4;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Brightness4", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 8.69f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(-4.69f);
        v12.lineTo(12f, 0.69f);
        v12.lineTo(8.69f, 4f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(4.69f);
        v12.lineTo(0.69f, 12f);
        v12.lineTo(4f, 15.31f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(4.69f);
        v12.lineTo(12f, 23.309999f);
        v12.lineTo(15.31f, 20f);
        v12.horizontalLineTo(20f);
        v12.verticalLineToRelative(-4.69f);
        v12.lineTo(23.309999f, 12f);
        v12.lineTo(20f, 8.69f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-0.89f, 0f, -1.74f, -0.2f, -2.5f, -0.55f);
        v12.curveTo(11.56f, 16.5f, 13f, 14.42f, 13f, 12f);
        v12.reflectiveCurveToRelative(-1.44f, -4.5f, -3.5f, -5.45f);
        v12.curveTo(10.26f, 6.2f, 11.11f, 6f, 12f, 6f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Brightness4Kt._brightness4 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

