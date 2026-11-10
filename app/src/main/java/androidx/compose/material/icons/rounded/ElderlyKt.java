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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_elderly", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Elderly", "Landroidx/compose/material/icons/Icons$Rounded;", "getElderly", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ElderlyKt {
    private static ImageVector _elderly;

    static {
    }

    public static final ImageVector getElderly(Rounded arg19) {
        ImageVector v0 = ElderlyKt._elderly;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Elderly", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.5f, 3.5f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(11.5f, 4.6f, 11.5f, 3.5f);
        v12.close();
        v12.moveTo(18.530001f, 11f);
        v12.curveToRelative(-1.57f, 0.01f, -2.94f, -0.9f, -3.6f, -2.21f);
        v12.lineToRelative(-0.79f, -1.67f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.17f, -0.35f, -0.44f, -0.65f, -0.8f, -0.85f);
        v12.curveToRelative(-0.62f, -0.36f, -1.35f, -0.34f, -1.94f, -0.03f);
        v12.lineToRelative(0f, -0.01f);
        v12.lineTo(7.01f, 8.73f);
        v12.curveTo(6.39f, 9.08f, 6f, 9.74f, 6f, 10.46f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2.54f);
        v12.lineToRelative(1.5f, -0.85f);
        v12.curveTo(9.18f, 10.71f, 9f, 11.85f, 9f, 13f);
        v12.verticalLineToRelative(5.33f);
        v12.lineTo(7f, 21f);
        v12.curveToRelative(-0.33f, 0.44f, -0.24f, 1.07f, 0.2f, 1.4f);
        v12.curveToRelative(0.44f, 0.33f, 1.07f, 0.24f, 1.4f, -0.2f);
        v12.lineToRelative(2.04f, -2.72f);
        v12.curveToRelative(0.23f, -0.31f, 0.37f, -0.69f, 0.4f, -1.08f);
        v12.lineToRelative(0.18f, -2.94f);
        v12.lineTo(13f, 18f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4.87f);
        v12.curveToRelative(0f, -0.41f, -0.13f, -0.81f, -0.36f, -1.15f);
        v12.lineToRelative(-1.6f, -2.29f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, -0.01f);
        v12.curveToRelative(-0.11f, -1.16f, 0.07f, -2.32f, 0.46f, -3.4f);
        v12.curveToRelative(0.81f, 1.23f, 2.05f, 2.14f, 3.51f, 2.52f);
        v12.verticalLineToRelative(0.03f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveTo(18f, 13.28f, 18f, 13f);
        v12.verticalLineToRelative(-0.16f);
        v12.verticalLineTo(12.5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f);
        v12.verticalLineToRelative(-10f);
        v12.curveTo(20f, 11.68f, 19.34f, 10.99f, 18.530001f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ElderlyKt._elderly = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

