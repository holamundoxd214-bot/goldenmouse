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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_grass", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Grass", "Landroidx/compose/material/icons/Icons$Outlined;", "getGrass", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GrassKt {
    private static ImageVector _grass;

    static {
    }

    public static final ImageVector getGrass(Outlined arg19) {
        ImageVector v0 = GrassKt._grass;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Grass", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 20f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(5.75f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(7.02f, 15.19f, 4.81f, 12.99f, 2f, 12.26f);
        v12.curveTo(2.64f, 12.1f, 3.31f, 12f, 4f, 12f);
        v12.curveTo(8.42f, 12f, 12f, 15.58f, 12f, 20f);
        v12.close();
        v12.moveTo(22f, 12.26f);
        v12.curveTo(21.360001f, 12.1f, 20.690001f, 12f, 20f, 12f);
        v12.curveToRelative(-2.93f, 0f, -5.48f, 1.58f, -6.88f, 3.93f);
        v12.curveToRelative(0.29f, 0.66f, 0.53f, 1.35f, 0.67f, 2.07f);
        v12.curveToRelative(0.13f, 0.65f, 0.2f, 1.32f, 0.2f, 2f);
        v12.horizontalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-5.75f);
        v12.curveTo(16.98f, 15.19f, 19.190001f, 12.99f, 22f, 12.26f);
        v12.close();
        v12.moveTo(15.64f, 11.02f);
        v12.curveToRelative(0.78f, -2.09f, 2.23f, -3.84f, 4.09f, -5f);
        v12.curveTo(15.44f, 6.16f, 12f, 9.67f, 12f, 14f);
        v12.curveToRelative(0f, 0.01f, 0f, 0.02f, 0f, 0.02f);
        v12.curveTo(12.95f, 12.75f, 14.2f, 11.72f, 15.64f, 11.02f);
        v12.close();
        v12.moveTo(11.42f, 8.85f);
        v12.curveTo(10.58f, 6.66f, 8.88f, 4.89f, 6.7f, 4f);
        v12.curveTo(8.14f, 5.86f, 9f, 8.18f, 9f, 10.71f);
        v12.curveToRelative(0f, 0.21f, -0.03f, 0.41f, -0.04f, 0.61f);
        v12.curveToRelative(0.43f, 0.24f, 0.83f, 0.52f, 1.22f, 0.82f);
        v12.curveTo(10.39f, 10.96f, 10.83f, 9.85f, 11.42f, 8.85f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GrassKt._grass = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

