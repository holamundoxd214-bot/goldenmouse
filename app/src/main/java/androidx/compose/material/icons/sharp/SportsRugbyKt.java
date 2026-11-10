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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsRugby", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsRugby", "Landroidx/compose/material/icons/Icons$Sharp;", "getSportsRugby", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsRugbyKt {
    private static ImageVector _sportsRugby;

    static {
    }

    public static final ImageVector getSportsRugby(Sharp arg19) {
        ImageVector v0 = SportsRugbyKt._sportsRugby;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SportsRugby", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.49f, 3.51f);
        v12.curveToRelative(-0.56f, -0.56f, -2.15f, -0.97f, -4.16f, -0.97f);
        v12.curveToRelative(-3.08f, 0f, -7.15f, 0.96f, -9.98f, 3.79f);
        v12.curveTo(1.66f, 11.03f, 2.1f, 19.07f, 3.51f, 20.49f);
        v12.curveToRelative(0.56f, 0.56f, 2.15f, 0.97f, 4.16f, 0.97f);
        v12.curveToRelative(3.08f, 0f, 7.15f, -0.96f, 9.98f, -3.79f);
        v12.curveTo(22.34f, 12.97f, 21.9f, 4.93f, 20.49f, 3.51f);
        v12.close();
        v12.moveTo(7.76f, 7.76f);
        v12.curveToRelative(2.64f, -2.64f, 6.35f, -3.12f, 8.03f, -3.19f);
        v12.curveToRelative(-2.05f, 0.94f, -4.46f, 2.45f, -6.61f, 4.61f);
        v12.curveToRelative(-2.16f, 2.16f, -3.67f, 4.58f, -4.61f, 6.63f);
        v12.curveTo(4.66f, 13.33f, 5.44f, 10.07f, 7.76f, 7.76f);
        v12.close();
        v12.moveTo(16.24f, 16.24f);
        v12.curveToRelative(-2.64f, 2.64f, -6.35f, 3.12f, -8.03f, 3.19f);
        v12.curveToRelative(2.05f, -0.94f, 4.46f, -2.45f, 6.61f, -4.61f);
        v12.curveToRelative(2.16f, -2.16f, 3.67f, -4.58f, 4.62f, -6.63f);
        v12.curveTo(19.34f, 10.67f, 18.559999f, 13.93f, 16.24f, 16.24f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsRugbyKt._sportsRugby = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

