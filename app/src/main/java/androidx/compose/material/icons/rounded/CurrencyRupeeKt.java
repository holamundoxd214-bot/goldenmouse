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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_currencyRupee", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CurrencyRupee", "Landroidx/compose/material/icons/Icons$Rounded;", "getCurrencyRupee", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CurrencyRupeeKt {
    private static ImageVector _currencyRupee;

    static {
    }

    public static final ImageVector getCurrencyRupee(Rounded arg19) {
        ImageVector v0 = CurrencyRupeeKt._currencyRupee;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CurrencyRupee", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.5f, 14f);
        v12.horizontalLineTo(9.77f);
        v12.lineToRelative(5.1f, 5.31f);
        v12.curveToRelative(0.61f, 0.64f, 0.16f, 1.69f, -0.72f, 1.69f);
        v12.curveToRelative(-0.27f, 0f, -0.53f, -0.11f, -0.72f, -0.31f);
        v12.lineTo(7.4f, 14.41f);
        v12.curveTo(7.14f, 14.15f, 7f, 13.79f, 7f, 13.43f);
        v12.curveTo(7f, 12.64f, 7.64f, 12f, 8.43f, 12f);
        v12.horizontalLineToRelative(2.07f);
        v12.curveToRelative(1.76f, 0f, 3.22f, -1.3f, 3.46f, -3f);
        v12.lineTo(7f, 9f);
        v12.curveTo(6.45f, 9f, 6f, 8.55f, 6f, 8f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.lineToRelative(6.66f, 0f);
        v12.curveTo(13.1f, 5.82f, 11.9f, 5f, 10.5f, 5f);
        v12.lineTo(7f, 5f);
        v12.curveTo(6.45f, 5f, 6f, 4.55f, 6f, 4f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.lineToRelative(-2.26f, 0f);
        v12.curveToRelative(0.48f, 0.58f, 0.84f, 1.26f, 1.05f, 2f);
        v12.lineTo(17f, 7f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.lineToRelative(-1.02f, 0f);
        v12.curveTo(15.72f, 11.8f, 13.36f, 14f, 10.5f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CurrencyRupeeKt._currencyRupee = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

