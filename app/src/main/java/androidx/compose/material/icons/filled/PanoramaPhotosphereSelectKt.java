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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panoramaPhotosphereSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaPhotosphereSelect", "Landroidx/compose/material/icons/Icons$Filled;", "getPanoramaPhotosphereSelect", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanoramaPhotosphereSelectKt {
    private static ImageVector _panoramaPhotosphereSelect;

    static {
    }

    public static final ImageVector getPanoramaPhotosphereSelect(Filled arg19) {
        ImageVector v0 = PanoramaPhotosphereSelectKt._panoramaPhotosphereSelect;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PanoramaPhotosphereSelect", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.49f, 8.51f);
        v12.curveToRelative(-0.47f, -0.23f, -0.93f, -0.44f, -1.4f, -0.64f);
        v12.curveTo(19.52f, 4.41f, 16.049999f, 2f, 12f, 2f);
        v12.reflectiveCurveTo(4.47f, 4.41f, 2.9f, 7.88f);
        v12.curveToRelative(-0.47f, 0.2f, -0.93f, 0.41f, -1.4f, 0.63f);
        v12.curveToRelative(-0.31f, 0.15f, -0.5f, 0.48f, -0.5f, 0.83f);
        v12.verticalLineToRelative(5.32f);
        v12.curveToRelative(0f, 0.35f, 0.19f, 0.68f, 0.51f, 0.83f);
        v12.curveToRelative(0.47f, 0.23f, 0.93f, 0.44f, 1.39f, 0.64f);
        v12.curveToRelative(3.55f, 7.83f, 14.65f, 7.82f, 18.200001f, 0f);
        v12.curveToRelative(0.47f, -0.2f, 0.93f, -0.41f, 1.39f, -0.63f);
        v12.curveToRelative(0.31f, -0.17f, 0.51f, -0.49f, 0.51f, -0.84f);
        v12.verticalLineTo(9.34f);
        v12.curveToRelative(0f, -0.35f, -0.19f, -0.68f, -0.51f, -0.83f);
        v12.close();
        v12.moveTo(12f, 3.8f);
        v12.curveToRelative(2.6f, 0f, 4.91f, 1.23f, 6.41f, 3.12f);
        v12.curveToRelative(-4.1f, -1.19f, -8.48f, -1.26f, -12.83f, 0.01f);
        v12.curveTo(7.08f, 5.03f, 9.4f, 3.8f, 12f, 3.8f);
        v12.close();
        v12.moveTo(5.6f, 17.08f);
        v12.curveToRelative(4.19f, 1.22f, 8.57f, 1.23f, 12.82f, -0.01f);
        v12.curveToRelative(-1.54f, 1.97f, -3.9f, 3.13f, -6.41f, 3.13f);
        v12.curveToRelative(-2.5f, 0f, -4.87f, -1.15f, -6.41f, -3.12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanoramaPhotosphereSelectKt._panoramaPhotosphereSelect = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

