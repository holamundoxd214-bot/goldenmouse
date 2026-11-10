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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_currencyRuble", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CurrencyRuble", "Landroidx/compose/material/icons/Icons$Rounded;", "getCurrencyRuble", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CurrencyRubleKt {
    private static ImageVector _currencyRuble;

    static {
    }

    public static final ImageVector getCurrencyRuble(Rounded arg19) {
        ImageVector v0 = CurrencyRubleKt._currencyRuble;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CurrencyRuble", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 21f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(4.5f);
        v12.curveToRelative(3.22f, 0f, 5.79f, -2.76f, 5.47f, -6.04f);
        v12.curveTo(18.700001f, 5.1f, 16.139999f, 3f, 13.26f, 3f);
        v12.lineToRelative(-0.96f, 0f);
        v12.horizontalLineTo(8f);
        v12.curveTo(7.45f, 3f, 7f, 3.45f, 7f, 4f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2f);
        v12.curveTo(7f, 20.549999f, 7.45f, 21f, 8f, 21f);
        v12.close();
        v12.moveTo(13.5f, 12f);
        v12.horizontalLineTo(9f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(4.5f);
        v12.curveTo(15.43f, 5f, 17f, 6.57f, 17f, 8.5f);
        v12.reflectiveCurveTo(15.43f, 12f, 13.5f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CurrencyRubleKt._currencyRuble = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

