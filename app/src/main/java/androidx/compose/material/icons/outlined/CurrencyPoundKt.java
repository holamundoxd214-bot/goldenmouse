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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_currencyPound", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CurrencyPound", "Landroidx/compose/material/icons/Icons$Outlined;", "getCurrencyPound", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CurrencyPoundKt {
    private static ImageVector _currencyPound;

    static {
    }

    public static final ImageVector getCurrencyPound(Outlined arg19) {
        ImageVector v0 = CurrencyPoundKt._currencyPound;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CurrencyPound", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 21f);
        v12.curveToRelative(1.93f, 0f, 3.62f, -1.17f, 4f, -3f);
        v12.lineToRelative(-1.75f, -0.88f);
        v12.curveTo(16f, 18.209999f, 15.33f, 19f, 14f, 19f);
        v12.lineToRelative(-4.9f, 0f);
        v12.curveToRelative(0.83f, -1f, 1.5f, -2.34f, 1.5f, -4f);
        v12.curveToRelative(0f, -0.35f, -0.03f, -0.69f, -0.08f, -1f);
        v12.lineTo(14f, 14f);
        v12.verticalLineToRelative(-2f);
        v12.lineToRelative(-4.18f, 0f);
        v12.curveTo(9f, 10.42f, 8f, 9.6f, 8f, 8f);
        v12.curveToRelative(0f, -1.93f, 1.57f, -3.5f, 3.5f, -3.5f);
        v12.curveToRelative(1.5f, 0f, 2.79f, 0.95f, 3.28f, 2.28f);
        v12.lineTo(16.629999f, 6f);
        v12.curveToRelative(-0.8f, -2.05f, -2.79f, -3.5f, -5.13f, -3.5f);
        v12.curveTo(8.46f, 2.5f, 6f, 4.96f, 6f, 8f);
        v12.curveToRelative(0f, 1.78f, 0.79f, 2.9f, 1.49f, 4f);
        v12.lineTo(6f, 12f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(2.47f, 0f);
        v12.curveToRelative(0.08f, 0.31f, 0.13f, 0.64f, 0.13f, 1f);
        v12.curveToRelative(0f, 2.7f, -2.6f, 4f, -2.6f, 4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CurrencyPoundKt._currencyPound = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

