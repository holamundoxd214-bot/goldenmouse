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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeDown", "Landroidx/compose/material/icons/Icons$Rounded;", "getSwipeDown", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeDownKt {
    private static ImageVector _swipeDown;

    static {
    }

    public static final ImageVector getSwipeDown(Rounded arg19) {
        ImageVector v0 = SwipeDownKt._swipeDown;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SwipeDown", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.83f, 19.1f);
        v12.curveToRelative(-0.26f, -0.6f, 0.09f, -1.28f, 0.73f, -1.41f);
        v12.lineToRelative(3.58f, -0.71f);
        v12.lineTo(8.79f, 7.17f);
        v12.curveToRelative(-0.34f, -0.76f, 0f, -1.64f, 0.76f, -1.98f);
        v12.curveToRelative(0.76f, -0.34f, 1.64f, 0f, 1.98f, 0.76f);
        v12.lineToRelative(2.43f, 5.49f);
        v12.lineToRelative(0.84f, -0.37f);
        v12.curveToRelative(0.28f, -0.13f, 0.59f, -0.18f, 0.9f, -0.17f);
        v12.lineToRelative(4.56f, 0.21f);
        v12.curveToRelative(0.86f, 0.04f, 1.6f, 0.63f, 1.83f, 1.45f);
        v12.lineToRelative(1.23f, 4.33f);
        v12.curveToRelative(0.27f, 0.96f, -0.2f, 1.97f, -1.11f, 2.37f);
        v12.lineToRelative(-5.63f, 2.49f);
        v12.curveToRelative(-0.48f, 0.21f, -1.26f, 0.33f, -1.76f, 0.14f);
        v12.lineToRelative(-5.45f, -2.27f);
        v12.curveTo(9.13f, 19.530001f, 8.93f, 19.34f, 8.83f, 19.1f);
        v12.close();
        v12.moveTo(5.59f, 2.73f);
        v12.curveTo(4.27f, 4.65f, 3.5f, 6.99f, 3.5f, 9.5f);
        v12.curveToRelative(0f, 0.92f, 0.1f, 1.82f, 0.3f, 2.68f);
        v12.lineToRelative(-1.19f, -1.19f);
        v12.curveToRelative(-0.29f, -0.29f, -0.77f, -0.32f, -1.07f, -0.04f);
        v12.curveToRelative(-0.31f, 0.29f, -0.31f, 0.78f, -0.02f, 1.08f);
        v12.lineToRelative(2.26f, 2.26f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(2.24f, -2.24f);
        v12.curveToRelative(0.29f, -0.29f, 0.32f, -0.77f, 0.04f, -1.07f);
        v12.curveToRelative(-0.29f, -0.31f, -0.78f, -0.31f, -1.08f, -0.02f);
        v12.lineToRelative(-1.09f, 1.09f);
        v12.curveTo(5.11f, 11.24f, 5f, 10.38f, 5f, 9.5f);
        v12.curveToRelative(0f, -2.2f, 0.68f, -4.24f, 1.83f, -5.93f);
        v12.curveToRelative(0.2f, -0.3f, 0.17f, -0.7f, -0.09f, -0.95f);
        v12.curveTo(6.41f, 2.28f, 5.86f, 2.34f, 5.59f, 2.73f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeDownKt._swipeDown = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

