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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flood", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Flood", "Landroidx/compose/material/icons/Icons$Rounded;", "getFlood", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FloodKt {
    private static ImageVector _flood;

    static {
    }

    public static final ImageVector getFlood(Rounded arg19) {
        ImageVector v0 = FloodKt._flood;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Flood", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.67f, 19f);
        v12.curveToRelative(-1.95f, 0f, -2.09f, 1f, -3.33f, 1f);
        v12.curveToRelative(-1.19f, 0f, -1.42f, -1f, -3.33f, -1f);
        v12.curveToRelative(-1.95f, 0f, -2.1f, 1f, -3.34f, 1f);
        v12.curveToRelative(-1.24f, 0f, -1.38f, -1f, -3.33f, -1f);
        v12.curveToRelative(-1.54f, 0f, -1.96f, 0.62f, -2.67f, 0.88f);
        v12.curveTo(2.27f, 20.030001f, 2f, 20.4f, 2f, 20.83f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.71f, 0.72f, 1.19f, 1.38f, 0.94f);
        v12.curveTo(4.15f, 21.48f, 4.49f, 21f, 5.34f, 21f);
        v12.curveToRelative(1.24f, 0f, 1.38f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.95f, 0f, 2.1f, -1f, 3.34f, -1f);
        v12.curveToRelative(1.22f, 0f, 1.4f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.93f, 0f, 2.1f, -1f, 3.33f, -1f);
        v12.curveToRelative(0.84f, 0f, 1.18f, 0.47f, 1.95f, 0.77f);
        v12.curveToRelative(0.66f, 0.26f, 1.38f, -0.23f, 1.38f, -0.94f);
        v12.verticalLineToRelative(-0.01f);
        v12.curveToRelative(0f, -0.42f, -0.27f, -0.8f, -0.67f, -0.94f);
        v12.curveTo(20.620001f, 19.620001f, 20.209999f, 19f, 18.67f, 19f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.68f, 17.5f);
        v12.curveToRelative(1.95f, 0f, 2.09f, -1f, 3.33f, -1f);
        v12.curveToRelative(1.19f, 0f, 1.42f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.95f, 0f, 2.09f, -1f, 3.33f, -1f);
        v12.curveToRelative(0.82f, 0f, 1.17f, 0.46f, 1.93f, 0.76f);
        v12.curveToRelative(0.66f, 0.26f, 1.38f, -0.23f, 1.38f, -0.94f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.42f, -0.26f, -0.79f, -0.65f, -0.94f);
        v12.curveToRelative(-0.29f, -0.11f, -0.54f, -0.27f, -0.83f, -0.43f);
        v12.lineToRelative(-2.02f, -7.53f);
        v12.lineToRelative(1.17f, 0.47f);
        v12.curveToRelative(0.51f, 0.21f, 1.09f, -0.04f, 1.29f, -0.55f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0.21f, -0.51f, -0.05f, -1.1f, -0.57f, -1.29f);
        v12.lineToRelative(-9.24f, -3.54f);
        v12.curveToRelative(-0.81f, -0.31f, -1.72f, -0.06f, -2.27f, 0.61f);
        v12.lineToRelative(-6.23f, 7.7f);
        v12.curveToRelative(-0.35f, 0.43f, -0.28f, 1.06f, 0.16f, 1.4f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.43f, 0.34f, 1.06f, 0.26f, 1.39f, -0.17f);
        v12.lineToRelative(0.78f, -1f);
        v12.lineToRelative(0.93f, 3.48f);
        v12.curveToRelative(-0.18f, -0.02f, -0.35f, -0.05f, -0.56f, -0.05f);
        v12.curveToRelative(-1.54f, 0f, -1.95f, 0.62f, -2.66f, 0.88f);
        v12.curveTo(2.27f, 15.53f, 2f, 15.91f, 2f, 16.33f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.7f, 0.69f, 1.19f, 1.35f, 0.95f);
        v12.curveToRelative(0.8f, -0.29f, 1.18f, -0.78f, 2f, -0.78f);
        v12.curveTo(6.54f, 16.5f, 6.77f, 17.5f, 8.68f, 17.5f);
        v12.close();
        v12.moveTo(14.04f, 10.18f);
        v12.lineToRelative(1.42f, 5.31f);
        v12.curveToRelative(-1.34f, 0.09f, -1.47f, -0.99f, -3.47f, -0.99f);
        v12.curveToRelative(-0.36f, 0f, -0.65f, 0.04f, -0.91f, 0.1f);
        v12.lineToRelative(-0.91f, -3.39f);
        v12.lineTo(14.04f, 10.18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FloodKt._flood = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

