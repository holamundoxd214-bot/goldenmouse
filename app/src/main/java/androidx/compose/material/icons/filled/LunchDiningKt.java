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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_lunchDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LunchDining", "Landroidx/compose/material/icons/Icons$Filled;", "getLunchDining", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LunchDiningKt {
    private static ImageVector _lunchDining;

    static {
    }

    public static final ImageVector getLunchDining(Filled arg19) {
        ImageVector v0 = LunchDiningKt._lunchDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.LunchDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 10f);
        v12.curveToRelative(0.32f, -3.28f, -4.28f, -6f, -9.99f, -6f);
        v12.curveTo(6.3f, 4f, 1.7f, 6.72f, 2.02f, 10f);
        v12.horizontalLineTo(22f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(5.35f, 13.5f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.14f, 1.15f, 0.36f);
        v12.curveToRelative(0.45f, 0.27f, 1.07f, 0.64f, 2.18f, 0.64f);
        v12.reflectiveCurveToRelative(1.73f, -0.37f, 2.18f, -0.64f);
        v12.curveToRelative(0.37f, -0.23f, 0.59f, -0.36f, 1.15f, -0.36f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.14f, 1.15f, 0.36f);
        v12.curveToRelative(0.45f, 0.27f, 1.07f, 0.64f, 2.18f, 0.64f);
        v12.curveToRelative(1.11f, 0f, 1.73f, -0.37f, 2.18f, -0.64f);
        v12.curveToRelative(0.37f, -0.23f, 0.59f, -0.36f, 1.15f, -0.36f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.14f, 1.15f, 0.36f);
        v12.curveToRelative(0.45f, 0.27f, 1.07f, 0.63f, 2.17f, 0.64f);
        v12.verticalLineToRelative(-1.98f);
        v12.curveToRelative(0f, 0f, -0.79f, -0.16f, -1.16f, -0.38f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.curveToRelative(-1.11f, 0f, -1.73f, 0.37f, -2.18f, 0.64f);
        v12.curveToRelative(-0.37f, 0.23f, -0.6f, 0.36f, -1.15f, 0.36f);
        v12.reflectiveCurveToRelative(-0.78f, -0.14f, -1.15f, -0.36f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.reflectiveCurveToRelative(-1.73f, 0.37f, -2.18f, 0.64f);
        v12.curveToRelative(-0.37f, 0.23f, -0.59f, 0.36f, -1.15f, 0.36f);
        v12.curveToRelative(-0.55f, 0f, -0.78f, -0.14f, -1.15f, -0.36f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.curveToRelative(-1.11f, 0f, -1.73f, 0.37f, -2.18f, 0.64f);
        v12.curveTo(2.78f, 12.37f, 2.56f, 12.5f, 2f, 12.5f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(1.11f, 0f, 1.73f, -0.37f, 2.21f, -0.64f);
        v12.curveTo(4.58f, 13.63f, 4.8f, 13.5f, 5.35f, 13.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2f, 16f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LunchDiningKt._lunchDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

