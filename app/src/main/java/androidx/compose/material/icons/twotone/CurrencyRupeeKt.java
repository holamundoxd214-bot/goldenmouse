package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_currencyRupee", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CurrencyRupee", "Landroidx/compose/material/icons/Icons$TwoTone;", "getCurrencyRupee", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CurrencyRupeeKt {
    private static ImageVector _currencyRupee;

    static {
    }

    public static final ImageVector getCurrencyRupee(TwoTone arg19) {
        ImageVector v0 = CurrencyRupeeKt._currencyRupee;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.CurrencyRupee", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.66f, 7f);
        v12.curveTo(13.1f, 5.82f, 11.9f, 5f, 10.5f, 5f);
        v12.lineTo(6f, 5f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(-3.26f, 0f);
        v12.curveToRelative(0.48f, 0.58f, 0.84f, 1.26f, 1.05f, 2f);
        v12.lineTo(18f, 7f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(-2.02f, 0f);
        v12.curveToRelative(-0.25f, 2.8f, -2.61f, 5f, -5.48f, 5f);
        v12.horizontalLineTo(9.77f);
        v12.lineToRelative(6.73f, 7f);
        v12.horizontalLineToRelative(-2.77f);
        v12.lineTo(7f, 14f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(3.5f);
        v12.curveToRelative(1.76f, 0f, 3.22f, -1.3f, 3.46f, -3f);
        v12.lineTo(6f, 9f);
        v12.verticalLineTo(7f);
        v12.lineTo(13.66f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CurrencyRupeeKt._currencyRupee = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

