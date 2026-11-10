package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_shieldMoon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ShieldMoon", "Landroidx/compose/material/icons/Icons$Sharp;", "getShieldMoon", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ShieldMoonKt {
    private static ImageVector _shieldMoon;

    static {
    }

    public static final ImageVector getShieldMoon(Sharp arg19) {
        ImageVector v0 = ShieldMoonKt._shieldMoon;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ShieldMoon", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.lineTo(4f, 5f);
        v12.verticalLineToRelative(6.09f);
        v12.curveToRelative(0f, 5.05f, 3.41f, 9.76f, 8f, 10.91f);
        v12.curveToRelative(4.59f, -1.15f, 8f, -5.86f, 8f, -10.91f);
        v12.verticalLineTo(5f);
        v12.lineTo(12f, 2f);
        v12.close();
        v12.moveTo(15.97f, 14.41f);
        v12.curveToRelative(-1.84f, 2.17f, -5.21f, 2.1f, -6.96f, -0.07f);
        v12.curveToRelative(-2.19f, -2.72f, -0.65f, -6.72f, 2.69f, -7.33f);
        v12.curveToRelative(0.34f, -0.06f, 0.63f, 0.27f, 0.51f, 0.6f);
        v12.curveToRelative(-0.46f, 1.23f, -0.39f, 2.64f, 0.32f, 3.86f);
        v12.curveToRelative(0.71f, 1.22f, 1.89f, 1.99f, 3.18f, 2.2f);
        v12.curveTo(16.049999f, 13.72f, 16.200001f, 14.14f, 15.97f, 14.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ShieldMoonKt._shieldMoon = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

