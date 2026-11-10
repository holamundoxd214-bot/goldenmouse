package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_creditCardOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CreditCardOff", "Landroidx/compose/material/icons/Icons$Filled;", "getCreditCardOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CreditCardOffKt {
    private static ImageVector _creditCardOff;

    static {
    }

    public static final ImageVector getCreditCardOff(Filled arg19) {
        ImageVector v0 = CreditCardOffKt._creditCardOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.CreditCardOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.9f, 21.9f);
        v12.lineTo(2.1f, 2.1f);
        v12.lineTo(0.69f, 3.51f);
        v12.lineToRelative(1.55f, 1.55f);
        v12.curveTo(2.09f, 5.34f, 2.01f, 5.66f, 2.01f, 6f);
        v12.lineTo(2f, 18f);
        v12.curveToRelative(0f, 1.11f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(13.17f);
        v12.lineToRelative(3.31f, 3.31f);
        v12.lineTo(21.9f, 21.9f);
        v12.close();
        v12.moveTo(4f, 12f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(1.17f);
        v12.lineToRelative(4f, 4f);
        v12.horizontalLineTo(4f);
        v12.close();
        v12.moveTo(6.83f, 4f);
        v12.horizontalLineTo(20f);
        v12.curveToRelative(1.11f, 0f, 2f, 0.89f, 2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 0.34f, -0.08f, 0.66f, -0.23f, 0.94f);
        v12.lineTo(14.83f, 12f);
        v12.horizontalLineTo(20f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(-9.17f);
        v12.lineTo(6.83f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CreditCardOffKt._creditCardOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

