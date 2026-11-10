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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_water", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Water", "Landroidx/compose/material/icons/Icons$Rounded;", "getWater", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WaterKt {
    private static ImageVector _water;

    static {
    }

    public static final ImageVector getWater(Rounded arg19) {
        ImageVector v0 = WaterKt._water;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Water", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.98f, 14f);
        v12.horizontalLineTo(22f);
        v12.horizontalLineTo(21.98f);
        v12.close();
        v12.moveTo(5.35f, 13f);
        v12.curveToRelative(1.19f, 0f, 1.42f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.95f, 0f, 2.09f, -1f, 3.33f, -1f);
        v12.curveToRelative(1.19f, 0f, 1.42f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.95f, 0f, 2.09f, -1f, 3.33f, -1f);
        v12.curveToRelative(0.93f, 0f, 1.05f, 0.45f, 2.01f, 0.79f);
        v12.curveToRelative(0.63f, 0.22f, 1.3f, -0.24f, 1.3f, -0.91f);
        v12.curveToRelative(0f, -0.52f, -0.23f, -0.83f, -0.64f, -0.97f);
        v12.curveToRelative(-0.6f, -0.22f, -1.15f, -0.9f, -2.69f, -0.9f);
        v12.curveToRelative(-1.95f, 0f, -2.09f, 1f, -3.33f, 1f);
        v12.curveToRelative(-1.19f, 0f, -1.42f, -1f, -3.33f, -1f);
        v12.curveToRelative(-1.95f, 0f, -2.09f, 1f, -3.33f, 1f);
        v12.curveToRelative(-1.19f, 0f, -1.42f, -1f, -3.33f, -1f);
        v12.curveToRelative(-1.54f, 0f, -2.13f, 0.71f, -2.68f, 0.91f);
        v12.curveTo(2.24f, 12.05f, 2f, 12.35f, 2f, 12.89f);
        v12.curveToRelative(0f, 0.67f, 0.66f, 1.13f, 1.29f, 0.91f);
        v12.curveTo(4.35f, 13.44f, 4.39f, 13f, 5.35f, 13f);
        v12.close();
        v12.moveTo(18.67f, 15f);
        v12.curveToRelative(-1.95f, 0f, -2.09f, 1f, -3.33f, 1f);
        v12.curveToRelative(-1.19f, 0f, -1.42f, -1f, -3.33f, -1f);
        v12.curveToRelative(-1.95f, 0f, -2.1f, 1f, -3.34f, 1f);
        v12.curveToRelative(-1.24f, 0f, -1.38f, -1f, -3.33f, -1f);
        v12.curveToRelative(-1.53f, 0f, -2.15f, 0.71f, -2.69f, 0.91f);
        v12.curveTo(2.24f, 16.049999f, 2f, 16.360001f, 2f, 16.889999f);
        v12.curveToRelative(0f, 0.67f, 0.66f, 1.13f, 1.3f, 0.91f);
        v12.curveTo(4.32f, 17.440001f, 4.38f, 17f, 5.34f, 17f);
        v12.curveToRelative(1.24f, 0f, 1.38f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.95f, 0f, 2.1f, -1f, 3.34f, -1f);
        v12.curveToRelative(1.19f, 0f, 1.42f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.94f, 0f, 2.09f, -1f, 3.33f, -1f);
        v12.curveToRelative(0.94f, 0f, 1.06f, 0.46f, 2.03f, 0.8f);
        v12.curveToRelative(0.63f, 0.22f, 1.3f, -0.24f, 1.3f, -0.91f);
        v12.curveToRelative(0f, -0.53f, -0.24f, -0.83f, -0.65f, -0.98f);
        v12.curveTo(20.82f, 15.72f, 20.209999f, 15f, 18.67f, 15f);
        v12.close();
        v12.moveTo(5.35f, 9f);
        v12.curveToRelative(1.19f, 0f, 1.42f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.95f, 0f, 2.09f, -1f, 3.33f, -1f);
        v12.curveToRelative(1.19f, 0f, 1.42f, 1f, 3.33f, 1f);
        v12.curveToRelative(1.95f, 0f, 2.09f, -1f, 3.33f, -1f);
        v12.curveToRelative(0.93f, 0f, 1.05f, 0.45f, 2.01f, 0.79f);
        v12.curveToRelative(0.63f, 0.22f, 1.3f, -0.24f, 1.3f, -0.91f);
        v12.curveToRelative(0f, -0.52f, -0.23f, -0.83f, -0.64f, -0.97f);
        v12.curveTo(20.74f, 7.68f, 20.190001f, 7f, 18.65f, 7f);
        v12.curveToRelative(-1.95f, 0f, -2.09f, 1f, -3.33f, 1f);
        v12.curveToRelative(-1.19f, 0f, -1.42f, -1f, -3.33f, -1f);
        v12.curveTo(10.04f, 7f, 9.9f, 8f, 8.66f, 8f);
        v12.curveTo(7.47f, 8f, 7.24f, 7f, 5.33f, 7f);
        v12.curveTo(3.79f, 7f, 3.2f, 7.71f, 2.65f, 7.91f);
        v12.curveTo(2.24f, 8.05f, 2f, 8.35f, 2f, 8.89f);
        v12.curveToRelative(0f, 0.67f, 0.66f, 1.13f, 1.29f, 0.91f);
        v12.curveTo(4.35f, 9.44f, 4.39f, 9f, 5.35f, 9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WaterKt._water = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

