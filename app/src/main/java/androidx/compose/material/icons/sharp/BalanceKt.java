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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_balance", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Balance", "Landroidx/compose/material/icons/Icons$Sharp;", "getBalance", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BalanceKt {
    private static ImageVector _balance;

    static {
    }

    public static final ImageVector getBalance(Sharp arg19) {
        ImageVector v0 = BalanceKt._balance;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Balance", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 7.83f);
        v12.curveToRelative(0.85f, -0.3f, 1.53f, -0.98f, 1.83f, -1.83f);
        v12.horizontalLineTo(18f);
        v12.lineToRelative(-3f, 7f);
        v12.curveToRelative(0f, 1.66f, 1.57f, 3f, 3.5f, 3f);
        v12.reflectiveCurveToRelative(3.5f, -1.34f, 3.5f, -3f);
        v12.lineToRelative(-3f, -7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(-6.17f);
        v12.curveTo(14.42f, 2.83f, 13.31f, 2f, 12f, 2f);
        v12.reflectiveCurveTo(9.58f, 2.83f, 9.17f, 4f);
        v12.lineTo(3f, 4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(-3f, 7f);
        v12.curveToRelative(0f, 1.66f, 1.57f, 3f, 3.5f, 3f);
        v12.reflectiveCurveTo(9f, 14.66f, 9f, 13f);
        v12.lineTo(6f, 6f);
        v12.horizontalLineToRelative(3.17f);
        v12.curveToRelative(0.3f, 0.85f, 0.98f, 1.53f, 1.83f, 1.83f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(20f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-9f);
        v12.verticalLineTo(7.83f);
        v12.close();
        v12.moveTo(20.370001f, 13f);
        v12.horizontalLineToRelative(-3.74f);
        v12.lineToRelative(1.87f, -4.36f);
        v12.lineTo(20.370001f, 13f);
        v12.close();
        v12.moveTo(7.37f, 13f);
        v12.horizontalLineTo(3.63f);
        v12.lineTo(5.5f, 8.64f);
        v12.lineTo(7.37f, 13f);
        v12.close();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(13f, 5.55f, 12.55f, 6f, 12f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BalanceKt._balance = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

