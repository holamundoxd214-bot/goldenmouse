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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_darkMode", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DarkMode", "Landroidx/compose/material/icons/Icons$Filled;", "getDarkMode", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DarkModeKt {
    private static ImageVector _darkMode;

    static {
    }

    public static final ImageVector getDarkMode(Filled arg19) {
        ImageVector v0 = DarkModeKt._darkMode;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.DarkMode", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 3f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.reflectiveCurveToRelative(4.03f, 9f, 9f, 9f);
        v12.reflectiveCurveToRelative(9f, -4.03f, 9f, -9f);
        v12.curveToRelative(0f, -0.46f, -0.04f, -0.92f, -0.1f, -1.36f);
        v12.curveToRelative(-0.98f, 1.37f, -2.58f, 2.26f, -4.4f, 2.26f);
        v12.curveToRelative(-2.98f, 0f, -5.4f, -2.42f, -5.4f, -5.4f);
        v12.curveToRelative(0f, -1.81f, 0.89f, -3.42f, 2.26f, -4.4f);
        v12.curveTo(12.92f, 3.04f, 12.46f, 3f, 12f, 3f);
        v12.lineTo(12f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DarkModeKt._darkMode = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

