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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_storm", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Storm", "Landroidx/compose/material/icons/Icons$Rounded;", "getStorm", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StormKt {
    private static ImageVector _storm;

    static {
    }

    public static final ImageVector getStorm(Rounded arg19) {
        ImageVector v0 = StormKt._storm;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Storm", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.93f, 8f);
        v12.curveTo(16.719999f, 4.18f, 11.82f, 2.87f, 8f, 5.07f);
        v12.curveToRelative(-1.41f, 0.82f, -2.48f, 2f, -3.16f, 3.37f);
        v12.curveToRelative(-0.1f, -1.75f, 0.1f, -3.5f, 0.59f, -5.17f);
        v12.curveTo(5.61f, 2.63f, 5.14f, 2f, 4.48f, 2f);
        v12.horizontalLineTo(4.47f);
        v12.curveTo(4.04f, 2f, 3.64f, 2.28f, 3.52f, 2.7f);
        v12.curveTo(2.24f, 7.01f, 2.65f, 11.81f, 5.07f, 16f);
        v12.curveToRelative(1.1f, 1.91f, 2.88f, 3.19f, 4.86f, 3.72f);
        v12.curveToRelative(1.98f, 0.53f, 4.16f, 0.31f, 6.07f, -0.79f);
        v12.curveToRelative(1.41f, -0.82f, 2.48f, -2f, 3.16f, -3.37f);
        v12.curveToRelative(0.1f, 1.75f, -0.09f, 3.5f, -0.58f, 5.18f);
        v12.curveTo(18.4f, 21.370001f, 18.870001f, 22f, 19.530001f, 22f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.44f, 0f, 0.83f, -0.28f, 0.95f, -0.7f);
        v12.curveTo(21.75f, 16.99f, 21.35f, 12.19f, 18.93f, 8f);
        v12.close();
        v12.moveTo(15f, 17.200001f);
        v12.curveToRelative(-2.87f, 1.65f, -6.54f, 0.67f, -8.2f, -2.2f);
        v12.curveToRelative(-0.11f, -0.2f, -0.21f, -0.4f, -0.3f, -0.6f);
        v12.curveTo(5.3f, 11.64f, 6.33f, 8.34f, 9f, 6.8f);
        v12.curveToRelative(2.86f, -1.65f, 6.54f, -0.67f, 8.2f, 2.2f);
        v12.curveToRelative(0.11f, 0.2f, 0.21f, 0.4f, 0.3f, 0.6f);
        v12.curveTo(18.700001f, 12.36f, 17.67f, 15.66f, 15f, 17.200001f);
        v12.close();
        v12.moveTo(12f, 10f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveTo(10.9f, 10f, 12f, 10f);
        v12.moveTo(12f, 8f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveTo(14.21f, 8f, 12f, 8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StormKt._storm = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

