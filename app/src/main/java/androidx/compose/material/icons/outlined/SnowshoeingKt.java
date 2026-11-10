package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_snowshoeing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Snowshoeing", "Landroidx/compose/material/icons/Icons$Outlined;", "getSnowshoeing", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SnowshoeingKt {
    private static ImageVector _snowshoeing;

    static {
    }

    public static final ImageVector getSnowshoeing(Outlined arg19) {
        ImageVector v0 = SnowshoeingKt._snowshoeing;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Snowshoeing", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.5f, 3.5f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(12.5f, 4.6f, 12.5f, 3.5f);
        v12.close();
        v12.moveTo(6.32f, 19.030001f);
        v12.lineToRelative(-1.14f, -1.47f);
        v12.lineTo(4f, 18.5f);
        v12.lineToRelative(2.38f, 3.04f);
        v12.curveToRelative(0.51f, 0.65f, 1.16f, 1.15f, 1.88f, 1.41f);
        v12.curveToRelative(0.28f, 0.1f, 0.53f, 0.04f, 0.72f, -0.11f);
        v12.curveToRelative(0.3f, -0.23f, 0.42f, -0.7f, 0.12f, -1.07f);
        v12.curveToRelative(-0.08f, -0.1f, -0.2f, -0.17f, -0.31f, -0.22f);
        v12.curveToRelative(-0.43f, -0.18f, -0.82f, -0.45f, -1.14f, -0.83f);
        v12.lineToRelative(-0.08f, -0.1f);
        v12.lineTo(11f, 18.200001f);
        v12.lineToRelative(0.89f, -3.22f);
        v12.lineToRelative(2.11f, 2f);
        v12.verticalLineToRelative(4.52f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(23f);
        v12.horizontalLineToRelative(3.87f);
        v12.curveToRelative(0.82f, 0f, 1.61f, -0.21f, 2.26f, -0.61f);
        v12.curveToRelative(0.26f, -0.16f, 0.37f, -0.39f, 0.37f, -0.64f);
        v12.curveToRelative(0f, -0.38f, -0.3f, -0.75f, -0.77f, -0.75f);
        v12.curveToRelative(-0.13f, 0f, -0.26f, 0.04f, -0.37f, 0.1f);
        v12.curveToRelative(-0.4f, 0.23f, -0.87f, 0.37f, -1.36f, 0.4f);
        v12.lineToRelative(0f, -6.02f);
        v12.lineToRelative(-2.11f, -2f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveTo(15.79f, 11.98f, 17.799999f, 13f, 20f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-1.9f, 0f, -3.51f, -1.02f, -4.31f, -2.42f);
        v12.lineToRelative(-1f, -1.58f);
        v12.curveToRelative(-0.4f, -0.6f, -1f, -1f, -1.7f, -1f);
        v12.curveTo(12.24f, 6f, 11.58f, 6.34f, 7f, 8.28f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9.58f);
        v12.lineToRelative(1.79f, -0.7f);
        v12.lineTo(9.2f, 17f);
        v12.lineTo(6.32f, 19.030001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SnowshoeingKt._snowshoeing = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

