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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_lightbulb", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Lightbulb", "Landroidx/compose/material/icons/Icons$Outlined;", "getLightbulb", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LightbulbKt {
    private static ImageVector _lightbulb;

    static {
    }

    public static final ImageVector getLightbulb(Outlined arg19) {
        ImageVector v0 = LightbulbKt._lightbulb;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Lightbulb", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 21f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.lineTo(9f, 20f);
        v12.verticalLineToRelative(1f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveTo(8.14f, 2f, 5f, 5.14f, 5f, 9f);
        v12.curveToRelative(0f, 2.38f, 1.19f, 4.47f, 3f, 5.74f);
        v12.lineTo(8f, 17f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2.26f);
        v12.curveToRelative(1.81f, -1.27f, 3f, -3.36f, 3f, -5.74f);
        v12.curveToRelative(0f, -3.86f, -3.14f, -7f, -7f, -7f);
        v12.close();
        v12.moveTo(14.85f, 13.1f);
        v12.lineToRelative(-0.85f, 0.6f);
        v12.lineTo(14f, 16f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-2.3f);
        v12.lineToRelative(-0.85f, -0.6f);
        v12.curveTo(7.8f, 12.16f, 7f, 10.63f, 7f, 9f);
        v12.curveToRelative(0f, -2.76f, 2.24f, -5f, 5f, -5f);
        v12.reflectiveCurveToRelative(5f, 2.24f, 5f, 5f);
        v12.curveToRelative(0f, 1.63f, -0.8f, 3.16f, -2.15f, 4.1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LightbulbKt._lightbulb = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

