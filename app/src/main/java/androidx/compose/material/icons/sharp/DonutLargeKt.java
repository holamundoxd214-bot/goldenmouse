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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_donutLarge", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DonutLarge", "Landroidx/compose/material/icons/Icons$Sharp;", "getDonutLarge", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DonutLargeKt {
    private static ImageVector _donutLarge;

    static {
    }

    public static final ImageVector getDonutLarge(Sharp arg19) {
        ImageVector v0 = DonutLargeKt._donutLarge;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.DonutLarge", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 5.08f);
        v12.curveToRelative(3.06f, 0.44f, 5.48f, 2.86f, 5.92f, 5.92f);
        v12.horizontalLineToRelative(3.03f);
        v12.curveToRelative(-0.47f, -4.72f, -4.23f, -8.48f, -8.95f, -8.95f);
        v12.verticalLineToRelative(3.03f);
        v12.close();
        v12.moveTo(18.92f, 13f);
        v12.curveToRelative(-0.44f, 3.06f, -2.86f, 5.48f, -5.92f, 5.92f);
        v12.verticalLineToRelative(3.03f);
        v12.curveToRelative(4.72f, -0.47f, 8.48f, -4.23f, 8.95f, -8.95f);
        v12.horizontalLineToRelative(-3.03f);
        v12.close();
        v12.moveTo(11f, 18.92f);
        v12.curveToRelative(-3.39f, -0.49f, -6f, -3.4f, -6f, -6.92f);
        v12.reflectiveCurveToRelative(2.61f, -6.43f, 6f, -6.92f);
        v12.verticalLineTo(2.05f);
        v12.curveToRelative(-5.05f, 0.5f, -9f, 4.76f, -9f, 9.95f);
        v12.curveToRelative(0f, 5.19f, 3.95f, 9.45f, 9f, 9.95f);
        v12.verticalLineToRelative(-3.03f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DonutLargeKt._donutLarge = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

