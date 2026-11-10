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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_snowboarding", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Snowboarding", "Landroidx/compose/material/icons/Icons$Rounded;", "getSnowboarding", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SnowboardingKt {
    private static ImageVector _snowboarding;

    static {
    }

    public static final ImageVector getSnowboarding(Rounded arg19) {
        ImageVector v0 = SnowboardingKt._snowboarding;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Snowboarding", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 3f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(14f, 4.1f, 14f, 3f);
        v12.close();
        v12.moveTo(6.35f, 9.53f);
        v12.curveToRelative(0.47f, 0.29f, 1.09f, 0.15f, 1.38f, -0.32f);
        v12.lineTo(9.1f, 7f);
        v12.horizontalLineToRelative(2.35f);
        v12.lineToRelative(-2.51f, 3.99f);
        v12.curveToRelative(-0.28f, 0.45f, -0.37f, 1f, -0.25f, 1.52f);
        v12.lineTo(9.5f, 16f);
        v12.lineTo(6f, 18.35f);
        v12.lineToRelative(-0.47f, -0.1f);
        v12.curveToRelative(-0.96f, -0.2f, -1.71f, -0.85f, -2.1f, -1.67f);
        v12.curveToRelative(-0.1f, -0.21f, -0.28f, -0.37f, -0.51f, -0.42f);
        v12.curveToRelative(-0.43f, -0.09f, -0.82f, 0.2f, -0.9f, 0.58f);
        v12.curveTo(1.98f, 16.879999f, 2f, 17.049999f, 2.07f, 17.200001f);
        v12.curveToRelative(0.58f, 1.24f, 1.71f, 2.2f, 3.15f, 2.51f);
        v12.lineToRelative(12.63f, 2.69f);
        v12.curveToRelative(1.44f, 0.31f, 2.86f, -0.11f, 3.9f, -1.01f);
        v12.curveToRelative(0.13f, -0.11f, 0.21f, -0.26f, 0.24f, -0.41f);
        v12.curveToRelative(0.08f, -0.38f, -0.16f, -0.8f, -0.59f, -0.89f);
        v12.curveToRelative(-0.23f, -0.05f, -0.46f, 0.02f, -0.64f, 0.17f);
        v12.curveToRelative(-0.69f, 0.6f, -1.64f, 0.88f, -2.6f, 0.67f);
        v12.lineTo(17f, 20.690001f);
        v12.lineToRelative(-0.88f, -5.43f);
        v12.curveToRelative(-0.08f, -0.49f, -0.34f, -0.93f, -0.72f, -1.24f);
        v12.lineToRelative(-2.72f, -2.19f);
        v12.lineToRelative(1.8f, -2.89f);
        v12.curveToRelative(0.96f, 1.53f, 2.54f, 2.64f, 4.39f, 2.96f);
        v12.curveToRelative(0.6f, 0.11f, 1.13f, -0.39f, 1.13f, -1f);
        v12.curveToRelative(0f, -0.48f, -0.35f, -0.89f, -0.83f, -0.98f);
        v12.curveToRelative(-1.49f, -0.28f, -2.72f, -1.29f, -3.3f, -2.64f);
        v12.lineToRelative(-0.52f, -1.21f);
        v12.curveTo(15.16f, 5.64f, 14.61f, 5f, 13.7f, 5f);
        v12.horizontalLineTo(9.11f);
        v12.curveToRelative(-0.69f, 0f, -1.33f, 0.36f, -1.7f, 0.94f);
        v12.lineTo(6.03f, 8.15f);
        v12.curveTo(5.74f, 8.62f, 5.88f, 9.24f, 6.35f, 9.53f);
        v12.close();
        v12.moveTo(8.73f, 18.93f);
        v12.lineToRelative(2.25f, -1.51f);
        v12.curveToRelative(0.47f, -0.32f, 0.73f, -0.88f, 0.65f, -1.44f);
        v12.lineToRelative(-0.32f, -2.4f);
        v12.lineToRelative(2.84f, 2.02f);
        v12.lineToRelative(0.75f, 4.64f);
        v12.lineTo(8.73f, 18.93f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SnowboardingKt._snowboarding = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

