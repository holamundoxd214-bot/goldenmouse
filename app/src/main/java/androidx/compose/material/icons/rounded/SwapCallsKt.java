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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swapCalls", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwapCalls", "Landroidx/compose/material/icons/Icons$Rounded;", "getSwapCalls", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwapCallsKt {
    private static ImageVector _swapCalls;

    static {
    }

    public static final ImageVector getSwapCalls(Rounded arg19) {
        ImageVector v0 = SwapCallsKt._swapCalls;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SwapCalls", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.65f, 4.35f);
        v12.lineToRelative(-2.79f, 2.79f);
        v12.curveToRelative(-0.32f, 0.32f, -0.1f, 0.86f, 0.35f, 0.86f);
        v12.horizontalLineTo(17f);
        v12.verticalLineToRelative(6.88f);
        v12.curveToRelative(0f, 1f, -0.67f, 1.93f, -1.66f, 2.09f);
        v12.curveToRelative(-1.25f, 0.21f, -2.34f, -0.76f, -2.34f, -1.97f);
        v12.verticalLineTo(8.17f);
        v12.curveToRelative(0f, -2.09f, -1.53f, -3.95f, -3.61f, -4.15f);
        v12.curveTo(7.01f, 3.79f, 5f, 5.66f, 5f, 8f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineTo(3.21f);
        v12.curveToRelative(-0.45f, 0f, -0.67f, 0.54f, -0.35f, 0.85f);
        v12.lineToRelative(2.79f, 2.79f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(2.79f, -2.79f);
        v12.curveToRelative(0.31f, -0.31f, 0.09f, -0.85f, -0.36f, -0.85f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(8.12f);
        v12.curveToRelative(0f, -1f, 0.67f, -1.93f, 1.66f, -2.09f);
        v12.curveTo(9.91f, 5.82f, 11f, 6.79f, 11f, 8f);
        v12.verticalLineToRelative(6.83f);
        v12.curveToRelative(0f, 2.09f, 1.53f, 3.95f, 3.61f, 4.15f);
        v12.curveTo(16.99f, 19.209999f, 19f, 17.34f, 19f, 15f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(1.79f);
        v12.curveToRelative(0.45f, 0f, 0.67f, -0.54f, 0.35f, -0.85f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveToRelative(-0.19f, -0.2f, -0.51f, -0.2f, -0.7f, -0.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwapCallsKt._swapCalls = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

