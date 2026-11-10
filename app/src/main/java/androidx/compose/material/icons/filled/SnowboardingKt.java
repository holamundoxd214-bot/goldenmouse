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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_snowboarding", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Snowboarding", "Landroidx/compose/material/icons/Icons$Filled;", "getSnowboarding", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SnowboardingKt {
    private static ImageVector _snowboarding;

    static {
    }

    public static final ImageVector getSnowboarding(Filled arg19) {
        ImageVector v0 = SnowboardingKt._snowboarding;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Snowboarding", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(21.4f, 20.09f);
        v12.curveToRelative(-0.23f, -0.05f, -0.46f, 0.02f, -0.64f, 0.17f);
        v12.curveToRelative(-0.69f, 0.6f, -1.64f, 0.88f, -2.6f, 0.67f);
        v12.lineTo(17f, 20.690001f);
        v12.lineToRelative(-1f, -6.19f);
        v12.lineToRelative(-3.32f, -2.67f);
        v12.lineToRelative(1.8f, -2.89f);
        v12.curveTo(15.63f, 10.78f, 17.68f, 12f, 20f, 12f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-1.85f, 0f, -3.44f, -1.12f, -4.13f, -2.72f);
        v12.lineToRelative(-0.52f, -1.21f);
        v12.curveTo(15.16f, 5.64f, 14.61f, 5f, 13.7f, 5f);
        v12.horizontalLineTo(8f);
        v12.lineTo(5.5f, 9f);
        v12.lineToRelative(1.7f, 1.06f);
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
        v12.curveTo(22.059999f, 20.6f, 21.83f, 20.18f, 21.4f, 20.09f);
        v12.close();
        v12.moveTo(8.73f, 18.93f);
        v12.lineToRelative(3.02f, -2.03f);
        v12.lineToRelative(-0.44f, -3.32f);
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

