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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_brightness3", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Brightness3", "Landroidx/compose/material/icons/Icons$Rounded;", "getBrightness3", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Brightness3Kt {
    private static ImageVector _brightness3;

    static {
    }

    public static final ImageVector getBrightness3(Rounded arg19) {
        ImageVector v0 = Brightness3Kt._brightness3;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Brightness3", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.93f, 2f);
        v12.curveTo(8.88f, 2f, 8.84f, 2f, 8.79f, 2f);
        v12.curveTo(7.96f, 2.02f, 7.7f, 3.12f, 8.4f, 3.56f);
        v12.curveToRelative(2.78f, 1.77f, 4.63f, 4.89f, 4.63f, 8.44f);
        v12.curveToRelative(0f, 3.55f, -1.84f, 6.66f, -4.62f, 8.43f);
        v12.curveTo(7.7f, 20.889999f, 7.98f, 21.98f, 8.82f, 22f);
        v12.curveToRelative(0.07f, 0f, 0.14f, 0f, 0.21f, 0f);
        v12.curveToRelative(6.05f, 0f, 10.86f, -5.39f, 9.87f, -11.63f);
        v12.curveTo(18.139999f, 5.53f, 13.83f, 1.95f, 8.93f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Brightness3Kt._brightness3 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

