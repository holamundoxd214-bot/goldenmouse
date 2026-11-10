package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_icecream", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Icecream", "Landroidx/compose/material/icons/Icons$Filled;", "getIcecream", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class IcecreamKt {
    private static ImageVector _icecream;

    static {
    }

    public static final ImageVector getIcecream(Filled arg19) {
        ImageVector v0 = IcecreamKt._icecream;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Icecream", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.79f, 12.4f);
        v12.lineToRelative(3.26f, 6.22f);
        v12.lineToRelative(3.17f, -6.21f);
        v12.curveToRelative(-0.11f, -0.08f, -0.21f, -0.16f, -0.3f, -0.25f);
        v12.curveTo(14.08f, 12.69f, 13.07f, 13f, 12f, 13f);
        v12.reflectiveCurveToRelative(-2.08f, -0.31f, -2.92f, -0.84f);
        v12.curveTo(8.99f, 12.25f, 8.89f, 12.33f, 8.79f, 12.4f);
        v12.close();
        v12.moveTo(6.83f, 12.99f);
        v12.curveTo(5.25f, 12.9f, 4f, 11.6f, 4f, 10f);
        v12.curveToRelative(0f, -1.49f, 1.09f, -2.73f, 2.52f, -2.96f);
        v12.curveTo(6.75f, 4.22f, 9.12f, 2f, 12f, 2f);
        v12.reflectiveCurveToRelative(5.25f, 2.22f, 5.48f, 5.04f);
        v12.curveTo(18.91f, 7.27f, 20f, 8.51f, 20f, 10f);
        v12.curveToRelative(0f, 1.59f, -1.24f, 2.9f, -2.81f, 2.99f);
        v12.lineTo(12.07f, 23f);
        v12.lineTo(6.83f, 12.99f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        IcecreamKt._icecream = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

