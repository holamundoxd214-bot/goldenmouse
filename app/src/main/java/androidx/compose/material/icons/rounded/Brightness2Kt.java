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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_brightness2", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Brightness2", "Landroidx/compose/material/icons/Icons$Rounded;", "getBrightness2", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Brightness2Kt {
    private static ImageVector _brightness2;

    static {
    }

    public static final ImageVector getBrightness2(Rounded arg19) {
        ImageVector v0 = Brightness2Kt._brightness2;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Brightness2", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.43f, 2.3f);
        v12.curveToRelative(-2.38f, -0.59f, -4.68f, -0.27f, -6.63f, 0.64f);
        v12.curveToRelative(-0.35f, 0.16f, -0.41f, 0.64f, -0.1f, 0.86f);
        v12.curveTo(8.3f, 5.6f, 10f, 8.6f, 10f, 12f);
        v12.curveToRelative(0f, 3.4f, -1.7f, 6.4f, -4.3f, 8.2f);
        v12.curveToRelative(-0.32f, 0.22f, -0.26f, 0.7f, 0.09f, 0.86f);
        v12.curveToRelative(1.28f, 0.6f, 2.71f, 0.94f, 4.21f, 0.94f);
        v12.curveToRelative(6.05f, 0f, 10.85f, -5.38f, 9.87f, -11.6f);
        v12.curveToRelative(-0.61f, -3.92f, -3.59f, -7.16f, -7.44f, -8.1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Brightness2Kt._brightness2 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

