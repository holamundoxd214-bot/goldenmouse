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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Swipe", "Landroidx/compose/material/icons/Icons$Sharp;", "getSwipe", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeKt {
    private static ImageVector _swipe;

    static {
    }

    public static final ImageVector getSwipe(Sharp arg20) {
        ImageVector v0 = SwipeKt._swipe;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Swipe", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.129999f, 3.87f);
        v12.curveTo(18.690001f, 2.17f, 15.6f, 1f, 12f, 1f);
        v12.reflectiveCurveTo(5.31f, 2.17f, 3.87f, 3.87f);
        v12.lineTo(2f, 2f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(5f);
        v12.lineTo(4.93f, 4.93f);
        v12.curveToRelative(1f, -1.29f, 3.7f, -2.43f, 7.07f, -2.43f);
        v12.reflectiveCurveToRelative(6.07f, 1.14f, 7.07f, 2.43f);
        v12.lineTo(17f, 7f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(2f);
        v12.lineTo(20.129999f, 3.87f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(13f, 12.5f);
        v12.verticalLineToRelative(-6f);
        v12.curveTo(13f, 5.67f, 12.33f, 5f, 11.5f, 5f);
        v12.reflectiveCurveTo(10f, 5.67f, 10f, 6.5f);
        v12.verticalLineToRelative(10.74f);
        v12.lineToRelative(-4.04f, -0.85f);
        v12.lineToRelative(-1.21f, 1.23f);
        v12.lineTo(10.13f, 23f);
        v12.horizontalLineToRelative(8.97f);
        v12.lineToRelative(1.09f, -7.64f);
        v12.lineToRelative(-6.11f, -2.86f);
        v12.horizontalLineTo(13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeKt._swipe = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

