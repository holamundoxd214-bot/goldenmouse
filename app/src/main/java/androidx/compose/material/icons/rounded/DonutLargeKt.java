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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_donutLarge", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DonutLarge", "Landroidx/compose/material/icons/Icons$Rounded;", "getDonutLarge", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DonutLargeKt {
    private static ImageVector _donutLarge;

    static {
    }

    public static final ImageVector getDonutLarge(Rounded arg19) {
        ImageVector v0 = DonutLargeKt._donutLarge;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DonutLarge", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.07f, 5.32f);
        v12.curveTo(16.26f, 6f, 18f, 7.74f, 18.68f, 9.93f);
        v12.curveToRelative(0.19f, 0.63f, 0.76f, 1.07f, 1.41f, 1.07f);
        v12.horizontalLineToRelative(0.04f);
        v12.curveToRelative(1f, 0f, 1.72f, -0.96f, 1.43f, -1.91f);
        v12.curveToRelative(-0.97f, -3.18f, -3.48f, -5.69f, -6.66f, -6.66f);
        v12.curveToRelative(-0.94f, -0.29f, -1.9f, 0.43f, -1.9f, 1.43f);
        v12.verticalLineToRelative(0.04f);
        v12.curveToRelative(0f, 0.66f, 0.44f, 1.23f, 1.07f, 1.42f);
        v12.close();
        v12.moveTo(18.68f, 14.07f);
        v12.curveToRelative(-0.68f, 2.2f, -2.42f, 3.93f, -4.61f, 4.61f);
        v12.curveToRelative(-0.63f, 0.19f, -1.07f, 0.76f, -1.07f, 1.41f);
        v12.verticalLineToRelative(0.04f);
        v12.curveToRelative(0f, 1f, 0.96f, 1.72f, 1.91f, 1.43f);
        v12.curveToRelative(3.18f, -0.97f, 5.69f, -3.48f, 6.66f, -6.66f);
        v12.curveToRelative(0.29f, -0.95f, -0.43f, -1.91f, -1.42f, -1.91f);
        v12.horizontalLineToRelative(-0.05f);
        v12.curveToRelative(-0.66f, 0.01f, -1.23f, 0.45f, -1.42f, 1.08f);
        v12.close();
        v12.moveTo(11f, 20.110001f);
        v12.curveToRelative(0f, -0.67f, -0.45f, -1.24f, -1.09f, -1.44f);
        v12.curveTo(7.07f, 17.780001f, 5f, 15.13f, 5f, 12f);
        v12.reflectiveCurveToRelative(2.07f, -5.78f, 4.91f, -6.67f);
        v12.curveToRelative(0.64f, -0.2f, 1.09f, -0.77f, 1.09f, -1.44f);
        v12.verticalLineToRelative(-0.01f);
        v12.curveToRelative(0f, -1f, -0.97f, -1.74f, -1.93f, -1.44f);
        v12.curveTo(4.98f, 3.69f, 2f, 7.5f, 2f, 12f);
        v12.curveToRelative(0f, 4.5f, 2.98f, 8.31f, 7.07f, 9.56f);
        v12.curveToRelative(0.96f, 0.3f, 1.93f, -0.44f, 1.93f, -1.45f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DonutLargeKt._donutLarge = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

