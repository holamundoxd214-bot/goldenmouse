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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_currencyPound", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CurrencyPound", "Landroidx/compose/material/icons/Icons$Rounded;", "getCurrencyPound", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CurrencyPoundKt {
    private static ImageVector _currencyPound;

    static {
    }

    public static final ImageVector getCurrencyPound(Rounded arg19) {
        ImageVector v0 = CurrencyPoundKt._currencyPound;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CurrencyPound", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.209999f, 17.610001f);
        v12.curveToRelative(-0.47f, -0.24f, -1.03f, -0.05f, -1.31f, 0.4f);
        v12.curveTo(15.54f, 18.610001f, 14.93f, 19f, 14f, 19f);
        v12.lineToRelative(-4.9f, 0f);
        v12.curveToRelative(0.83f, -1f, 1.5f, -2.34f, 1.5f, -4f);
        v12.curveToRelative(0f, -0.35f, -0.03f, -0.69f, -0.08f, -1f);
        v12.lineTo(13f, 14f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.lineToRelative(-3.18f, 0f);
        v12.curveTo(9f, 10.42f, 8f, 9.6f, 8f, 8f);
        v12.curveToRelative(0f, -1.93f, 1.57f, -3.5f, 3.5f, -3.5f);
        v12.curveToRelative(1.2f, 0f, 2.26f, 0.61f, 2.89f, 1.53f);
        v12.curveToRelative(0.27f, 0.4f, 0.77f, 0.59f, 1.22f, 0.4f);
        v12.curveToRelative(0.6f, -0.25f, 0.8f, -0.99f, 0.43f, -1.53f);
        v12.curveToRelative(-0.99f, -1.45f, -2.66f, -2.4f, -4.54f, -2.4f);
        v12.curveTo(8.46f, 2.5f, 6f, 4.96f, 6f, 8f);
        v12.curveToRelative(0f, 1.78f, 0.79f, 2.9f, 1.49f, 4f);
        v12.lineTo(7f, 12f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.lineToRelative(1.47f, 0f);
        v12.curveToRelative(0.08f, 0.31f, 0.13f, 0.64f, 0.13f, 1f);
        v12.curveToRelative(0f, 1.9f, -1.29f, 3.11f, -2.06f, 3.66f);
        v12.curveTo(6.2f, 18.9f, 6f, 19.290001f, 6f, 19.709999f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(6f, 20.42f, 6.58f, 21f, 7.29f, 21f);
        v12.horizontalLineTo(14f);
        v12.curveToRelative(1.55f, 0f, 2.95f, -0.76f, 3.63f, -2f);
        v12.curveTo(17.91f, 18.49f, 17.719999f, 17.860001f, 17.209999f, 17.610001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CurrencyPoundKt._currencyPound = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

