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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsBar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsBar", "Landroidx/compose/material/icons/Icons$Sharp;", "getSportsBar", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsBarKt {
    private static ImageVector _sportsBar;

    static {
    }

    public static final ImageVector getSportsBar(Sharp arg19) {
        ImageVector v0 = SportsBarKt._sportsBar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SportsBar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 9f);
        v12.horizontalLineToRelative(-3.56f);
        v12.curveTo(17.790001f, 8.41f, 18f, 7.73f, 18f, 7f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.curveToRelative(-0.34f, 0f, -0.66f, 0.05f, -0.98f, 0.13f);
        v12.curveTo(12.2f, 2.45f, 11.16f, 2.02f, 10f, 2.02f);
        v12.curveToRelative(-1.89f, 0f, -3.51f, 1.11f, -4.27f, 2.71f);
        v12.curveTo(4.15f, 5.26f, 3f, 6.74f, 3f, 8.5f);
        v12.curveToRelative(0f, 1.86f, 1.28f, 3.41f, 3f, 3.86f);
        v12.lineTo(6f, 21f);
        v12.horizontalLineToRelative(11f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(7f, 10.5f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -0.85f, 0.55f, -1.6f, 1.37f, -1.88f);
        v12.lineToRelative(0.8f, -0.27f);
        v12.lineToRelative(0.36f, -0.76f);
        v12.curveTo(8f, 4.62f, 8.94f, 4.02f, 10f, 4.02f);
        v12.curveToRelative(0.79f, 0f, 1.39f, 0.35f, 1.74f, 0.65f);
        v12.lineToRelative(0.78f, 0.65f);
        v12.curveToRelative(0f, 0f, 0.64f, -0.32f, 1.47f, -0.32f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 0f, -3f, 0f, -3f, 0f);
        v12.curveTo(9.67f, 7f, 9.15f, 10.5f, 7f, 10.5f);
        v12.close();
        v12.moveTo(19f, 17f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsBarKt._sportsBar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

