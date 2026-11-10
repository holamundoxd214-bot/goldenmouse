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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tsunami", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Tsunami", "Landroidx/compose/material/icons/Icons$Sharp;", "getTsunami", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TsunamiKt {
    private static ImageVector _tsunami;

    static {
    }

    public static final ImageVector getTsunami(Sharp arg19) {
        ImageVector v0 = TsunamiKt._tsunami;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Tsunami", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.67f, 17.629999f);
        v12.curveToRelative(-3.8f, 2.8f, -6.12f, 0.4f, -6.67f, 0f);
        v12.curveToRelative(-0.66f, 0.49f, -2.92f, 2.76f, -6.67f, 0f);
        v12.curveTo(3.43f, 19.030001f, 2.65f, 19f, 2f, 19f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(1.16f, 0f, 2.3f, -0.32f, 3.33f, -0.93f);
        v12.curveToRelative(2.06f, 1.22f, 4.61f, 1.22f, 6.67f, 0f);
        v12.curveToRelative(2.06f, 1.22f, 4.61f, 1.22f, 6.67f, 0f);
        v12.curveTo(19.700001f, 20.68f, 20.84f, 21f, 22f, 21f);
        v12.verticalLineToRelative(-2f);
        v12.curveTo(21.34f, 19f, 20.5f, 18.98f, 18.67f, 17.629999f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.33f, 12f);
        v12.horizontalLineTo(22f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2.67f);
        v12.curveTo(17.5f, 10f, 16f, 8.5f, 16f, 6.67f);
        v12.curveToRelative(0f, -1.02f, 0.38f, -1.74f, 1.09f, -3.34f);
        v12.curveTo(15.72f, 3.12f, 15.09f, 3f, 14f, 3f);
        v12.curveTo(7.36f, 3f, 2.15f, 8.03f, 2.01f, 14.5f);
        v12.curveToRelative(0f, 0f, -0.01f, 2f, -0.01f, 2f);
        v12.curveToRelative(1.16f, 0f, 2.3f, -0.32f, 3.33f, -0.93f);
        v12.curveToRelative(2.06f, 1.22f, 4.61f, 1.22f, 6.67f, 0f);
        v12.curveToRelative(2.06f, 1.22f, 4.61f, 1.22f, 6.67f, 0f);
        v12.curveToRelative(1.03f, 0.61f, 2.17f, 0.93f, 3.33f, 0.93f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-0.66f, 0f, -1.5f, -0.02f, -3.33f, -1.37f);
        v12.curveToRelative(-3.8f, 2.8f, -6.12f, 0.4f, -6.67f, 0f);
        v12.curveToRelative(-0.9f, 0.67f, -0.54f, 0.41f, -0.91f, 0.63f);
        v12.curveTo(10.39f, 12.82f, 10f, 11.7f, 10f, 10.5f);
        v12.curveToRelative(0f, -2.58f, 1.77f, -4.74f, 4.21f, -5.33f);
        v12.curveTo(14.08f, 5.68f, 14f, 6.19f, 14f, 6.67f);
        v12.curveTo(14f, 9.61f, 16.389999f, 12f, 19.33f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TsunamiKt._tsunami = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

