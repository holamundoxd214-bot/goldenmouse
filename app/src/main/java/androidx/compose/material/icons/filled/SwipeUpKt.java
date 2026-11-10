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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeUp", "Landroidx/compose/material/icons/Icons$Filled;", "getSwipeUp", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeUpKt {
    private static ImageVector _swipeUp;

    static {
    }

    public static final ImageVector getSwipeUp(Filled arg19) {
        ImageVector v0 = SwipeUpKt._swipeUp;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SwipeUp", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.06f, 5.56f);
        v12.lineTo(1f, 4.5f);
        v12.lineTo(4.5f, 1f);
        v12.lineTo(8f, 4.5f);
        v12.lineTo(6.94f, 5.56f);
        v12.lineTo(5.32f, 3.94f);
        v12.curveTo(5.11f, 4.76f, 5f, 5.62f, 5f, 6.5f);
        v12.curveToRelative(0f, 2.42f, 0.82f, 4.65f, 2.2f, 6.43f);
        v12.lineTo(6.13f, 14f);
        v12.curveTo(4.49f, 11.95f, 3.5f, 9.34f, 3.5f, 6.5f);
        v12.curveToRelative(0f, -0.92f, 0.1f, -1.82f, 0.3f, -2.68f);
        v12.lineTo(2.06f, 5.56f);
        v12.close();
        v12.moveTo(13.85f, 11.62f);
        v12.lineToRelative(-2.68f, -5.37f);
        v12.curveToRelative(-0.37f, -0.74f, -1.27f, -1.04f, -2.01f, -0.67f);
        v12.curveTo(8.41f, 5.96f, 8.11f, 6.86f, 8.48f, 7.6f);
        v12.lineToRelative(4.81f, 9.6f);
        v12.lineTo(10.05f, 18f);
        v12.curveToRelative(-0.33f, 0.09f, -0.59f, 0.33f, -0.7f, 0.66f);
        v12.lineTo(9f, 19.780001f);
        v12.lineToRelative(6.19f, 2.25f);
        v12.curveToRelative(0.5f, 0.17f, 1.28f, 0.02f, 1.75f, -0.22f);
        v12.lineToRelative(5.51f, -2.75f);
        v12.curveToRelative(0.89f, -0.45f, 1.32f, -1.48f, 1f, -2.42f);
        v12.lineToRelative(-1.43f, -4.27f);
        v12.curveToRelative(-0.27f, -0.82f, -1.04f, -1.37f, -1.9f, -1.37f);
        v12.horizontalLineToRelative(-4.56f);
        v12.curveToRelative(-0.31f, 0f, -0.62f, 0.07f, -0.89f, 0.21f);
        v12.lineTo(13.85f, 11.62f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeUpKt._swipeUp = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

