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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_euro", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Euro", "Landroidx/compose/material/icons/Icons$Sharp;", "getEuro", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EuroKt {
    private static ImageVector _euro;

    static {
    }

    public static final ImageVector getEuro(Sharp arg19) {
        ImageVector v0 = EuroKt._euro;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Euro", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 18.5f);
        v12.curveToRelative(-2.51f, 0f, -4.68f, -1.42f, -5.76f, -3.5f);
        v12.horizontalLineTo(15f);
        v12.lineToRelative(1f, -2f);
        v12.horizontalLineTo(8.58f);
        v12.curveToRelative(-0.05f, -0.33f, -0.08f, -0.66f, -0.08f, -1f);
        v12.reflectiveCurveToRelative(0.03f, -0.67f, 0.08f, -1f);
        v12.horizontalLineTo(15f);
        v12.lineToRelative(1f, -2f);
        v12.horizontalLineTo(9.24f);
        v12.curveTo(10.32f, 6.92f, 12.5f, 5.5f, 15f, 5.5f);
        v12.curveToRelative(1.61f, 0f, 3.09f, 0.59f, 4.23f, 1.57f);
        v12.lineTo(21f, 5.3f);
        v12.curveTo(19.41f, 3.87f, 17.299999f, 3f, 15f, 3f);
        v12.curveToRelative(-3.92f, 0f, -7.24f, 2.51f, -8.48f, 6f);
        v12.horizontalLineTo(3f);
        v12.lineToRelative(-1f, 2f);
        v12.horizontalLineToRelative(4.06f);
        v12.curveTo(6.02f, 11.33f, 6f, 11.66f, 6f, 12f);
        v12.reflectiveCurveToRelative(0.02f, 0.67f, 0.06f, 1f);
        v12.horizontalLineTo(3f);
        v12.lineToRelative(-1f, 2f);
        v12.horizontalLineToRelative(4.52f);
        v12.curveToRelative(1.24f, 3.49f, 4.56f, 6f, 8.48f, 6f);
        v12.curveToRelative(2.31f, 0f, 4.41f, -0.87f, 6f, -2.3f);
        v12.lineToRelative(-1.78f, -1.77f);
        v12.curveTo(18.09f, 17.91f, 16.620001f, 18.5f, 15f, 18.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EuroKt._euro = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

