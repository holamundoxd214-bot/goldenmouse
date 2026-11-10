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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rocket", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rocket", "Landroidx/compose/material/icons/Icons$Rounded;", "getRocket", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RocketKt {
    private static ImageVector _rocket;

    static {
    }

    public static final ImageVector getRocket(Rounded arg19) {
        ImageVector v0 = RocketKt._rocket;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Rocket", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.41f, 2.87f);
        v12.curveToRelative(0.35f, -0.26f, 0.82f, -0.26f, 1.18f, 0f);
        v12.curveTo(13.81f, 3.75f, 16.5f, 6.46f, 16.5f, 13f);
        v12.curveToRelative(0f, 2.16f, -0.78f, 4.76f, -1.36f, 6.35f);
        v12.curveTo(15f, 19.74f, 14.63f, 20f, 14.21f, 20f);
        v12.lineToRelative(-4.41f, 0f);
        v12.curveToRelative(-0.42f, 0f, -0.8f, -0.26f, -0.94f, -0.65f);
        v12.curveTo(8.28f, 17.76f, 7.5f, 15.16f, 7.5f, 13f);
        v12.curveTo(7.5f, 6.46f, 10.19f, 3.75f, 11.41f, 2.87f);
        v12.close();
        v12.moveTo(14f, 11f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveTo(14f, 12.1f, 14f, 11f);
        v12.close();
        v12.moveTo(7.69f, 20.52f);
        v12.curveToRelative(-0.48f, -1.23f, -1.52f, -4.17f, -1.67f, -6.87f);
        v12.lineToRelative(-1.13f, 0.75f);
        v12.curveTo(4.33f, 14.78f, 4f, 15.4f, 4f, 16.07f);
        v12.verticalLineToRelative(4.45f);
        v12.curveToRelative(0f, 0.71f, 0.71f, 1.19f, 1.37f, 0.93f);
        v12.lineTo(7.69f, 20.52f);
        v12.close();
        v12.moveTo(20f, 20.52f);
        v12.verticalLineToRelative(-4.45f);
        v12.curveToRelative(0f, -0.67f, -0.33f, -1.29f, -0.89f, -1.66f);
        v12.lineToRelative(-1.13f, -0.75f);
        v12.curveToRelative(-0.15f, 2.69f, -1.2f, 5.64f, -1.67f, 6.87f);
        v12.lineToRelative(2.32f, 0.93f);
        v12.curveTo(19.290001f, 21.709999f, 20f, 21.23f, 20f, 20.52f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RocketKt._rocket = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

