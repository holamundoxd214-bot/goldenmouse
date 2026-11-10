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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_gesture", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Gesture", "Landroidx/compose/material/icons/Icons$Filled;", "getGesture", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GestureKt {
    private static ImageVector _gesture;

    static {
    }

    public static final ImageVector getGesture(Filled arg19) {
        ImageVector v0 = GestureKt._gesture;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Gesture", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4.59f, 6.89f);
        v12.curveToRelative(0.7f, -0.71f, 1.4f, -1.35f, 1.71f, -1.22f);
        v12.curveToRelative(0.5f, 0.2f, 0f, 1.03f, -0.3f, 1.52f);
        v12.curveToRelative(-0.25f, 0.42f, -2.86f, 3.89f, -2.86f, 6.31f);
        v12.curveToRelative(0f, 1.28f, 0.48f, 2.34f, 1.34f, 2.98f);
        v12.curveToRelative(0.75f, 0.56f, 1.74f, 0.73f, 2.64f, 0.46f);
        v12.curveToRelative(1.07f, -0.31f, 1.95f, -1.4f, 3.06f, -2.77f);
        v12.curveToRelative(1.21f, -1.49f, 2.83f, -3.44f, 4.08f, -3.44f);
        v12.curveToRelative(1.63f, 0f, 1.65f, 1.01f, 1.76f, 1.79f);
        v12.curveToRelative(-3.78f, 0.64f, -5.38f, 3.67f, -5.38f, 5.37f);
        v12.curveToRelative(0f, 1.7f, 1.44f, 3.09f, 3.21f, 3.09f);
        v12.curveToRelative(1.63f, 0f, 4.29f, -1.33f, 4.69f, -6.1f);
        v12.lineTo(21f, 14.88f);
        v12.verticalLineToRelative(-2.5f);
        v12.horizontalLineToRelative(-2.47f);
        v12.curveToRelative(-0.15f, -1.65f, -1.09f, -4.2f, -4.03f, -4.2f);
        v12.curveToRelative(-2.25f, 0f, -4.18f, 1.91f, -4.94f, 2.84f);
        v12.curveToRelative(-0.58f, 0.73f, -2.06f, 2.48f, -2.29f, 2.72f);
        v12.curveToRelative(-0.25f, 0.3f, -0.68f, 0.84f, -1.11f, 0.84f);
        v12.curveToRelative(-0.45f, 0f, -0.72f, -0.83f, -0.36f, -1.92f);
        v12.curveToRelative(0.35f, -1.09f, 1.4f, -2.86f, 1.85f, -3.52f);
        v12.curveToRelative(0.78f, -1.14f, 1.3f, -1.92f, 1.3f, -3.28f);
        v12.curveTo(8.95f, 3.69f, 7.31f, 3f, 6.44f, 3f);
        v12.curveTo(5.12f, 3f, 3.97f, 4f, 3.72f, 4.25f);
        v12.curveToRelative(-0.36f, 0.36f, -0.66f, 0.66f, -0.88f, 0.93f);
        v12.lineToRelative(1.75f, 1.71f);
        v12.close();
        v12.moveTo(13.88f, 18.549999f);
        v12.curveToRelative(-0.31f, 0f, -0.74f, -0.26f, -0.74f, -0.72f);
        v12.curveToRelative(0f, -0.6f, 0.73f, -2.2f, 2.87f, -2.76f);
        v12.curveToRelative(-0.3f, 2.69f, -1.43f, 3.48f, -2.13f, 3.48f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GestureKt._gesture = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

