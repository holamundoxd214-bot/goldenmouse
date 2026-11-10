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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_draw", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Draw", "Landroidx/compose/material/icons/Icons$Filled;", "getDraw", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DrawKt {
    private static ImageVector _draw;

    static {
    }

    public static final ImageVector getDraw(Filled arg19) {
        ImageVector v0 = DrawKt._draw;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Draw", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.85f, 10.39f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineTo(18.5f, 5.09f);
        v12.curveToRelative(-0.78f, -0.78f, -2.05f, -0.78f, -2.83f, 0f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineTo(18.85f, 10.39f);
        v12.close();
        v12.moveTo(13.19f, 7.56f);
        v12.lineTo(4f, 16.76f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(4.24f);
        v12.lineToRelative(9.19f, -9.19f);
        v12.lineTo(13.19f, 7.56f);
        v12.close();
        v12.moveTo(19f, 17.5f);
        v12.curveToRelative(0f, 2.19f, -2.54f, 3.5f, -5f, 3.5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.curveToRelative(1.54f, 0f, 3f, -0.73f, 3f, -1.5f);
        v12.curveToRelative(0f, -0.47f, -0.48f, -0.87f, -1.23f, -1.2f);
        v12.lineToRelative(1.48f, -1.48f);
        v12.curveTo(18.32f, 15.45f, 19f, 16.290001f, 19f, 17.5f);
        v12.close();
        v12.moveTo(4.58f, 13.35f);
        v12.curveTo(3.61f, 12.79f, 3f, 12.06f, 3f, 11f);
        v12.curveToRelative(0f, -1.8f, 1.89f, -2.63f, 3.56f, -3.36f);
        v12.curveTo(7.59f, 7.18f, 9f, 6.56f, 9f, 6f);
        v12.curveToRelative(0f, -0.41f, -0.78f, -1f, -2f, -1f);
        v12.curveTo(5.74f, 5f, 5.2f, 5.61f, 5.17f, 5.64f);
        v12.curveTo(4.82f, 6.05f, 4.19f, 6.1f, 3.77f, 5.76f);
        v12.curveTo(3.36f, 5.42f, 3.28f, 4.81f, 3.62f, 4.38f);
        v12.curveTo(3.73f, 4.24f, 4.76f, 3f, 7f, 3f);
        v12.curveToRelative(2.24f, 0f, 4f, 1.32f, 4f, 3f);
        v12.curveToRelative(0f, 1.87f, -1.93f, 2.72f, -3.64f, 3.47f);
        v12.curveTo(6.42f, 9.88f, 5f, 10.5f, 5f, 11f);
        v12.curveToRelative(0f, 0.31f, 0.43f, 0.6f, 1.07f, 0.86f);
        v12.lineTo(4.58f, 13.35f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DrawKt._draw = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

