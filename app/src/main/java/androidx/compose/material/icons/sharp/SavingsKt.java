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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_savings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Savings", "Landroidx/compose/material/icons/Icons$Sharp;", "getSavings", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SavingsKt {
    private static ImageVector _savings;

    static {
    }

    public static final ImageVector getSavings(Sharp arg19) {
        ImageVector v0 = SavingsKt._savings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Savings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.83f, 7.5f);
        v12.lineToRelative(-2.27f, -2.27f);
        v12.curveToRelative(0.07f, -0.42f, 0.18f, -0.81f, 0.32f, -1.15f);
        v12.curveToRelative(0.23f, -0.56f, 0.56f, -1.06f, 0.97f, -1.5f);
        v12.curveTo(18.15f, 2.21f, 17.35f, 2f, 16.5f, 2f);
        v12.curveToRelative(-1.64f, 0f, -3.09f, 0.79f, -4f, 2f);
        v12.lineToRelative(-5f, 0f);
        v12.curveTo(4.46f, 4f, 2f, 6.46f, 2f, 9.5f);
        v12.reflectiveCurveTo(4.5f, 21f, 4.5f, 21f);
        v12.lineToRelative(5.5f, 0f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(5.5f, 0f);
        v12.lineToRelative(1.68f, -5.59f);
        v12.lineTo(22f, 14.47f);
        v12.verticalLineTo(7.5f);
        v12.horizontalLineTo(19.83f);
        v12.close();
        v12.moveTo(13f, 9f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(16f, 11f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(17f, 10.55f, 16.549999f, 11f, 16f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SavingsKt._savings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

