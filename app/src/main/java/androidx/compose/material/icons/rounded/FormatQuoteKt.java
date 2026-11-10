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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_formatQuote", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FormatQuote", "Landroidx/compose/material/icons/Icons$Rounded;", "getFormatQuote", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FormatQuoteKt {
    private static ImageVector _formatQuote;

    static {
    }

    public static final ImageVector getFormatQuote(Rounded arg19) {
        ImageVector v0 = FormatQuoteKt._formatQuote;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FormatQuote", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7.17f, 17f);
        v12.curveToRelative(0.51f, 0f, 0.98f, -0.29f, 1.2f, -0.74f);
        v12.lineToRelative(1.42f, -2.84f);
        v12.curveToRelative(0.14f, -0.28f, 0.21f, -0.58f, 0.21f, -0.89f);
        v12.lineTo(10f, 8f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.lineTo(5f, 7f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(-1.03f, 2.06f);
        v12.curveToRelative(-0.45f, 0.89f, 0.2f, 1.94f, 1.2f, 1.94f);
        v12.close();
        v12.moveTo(17.17f, 17f);
        v12.curveToRelative(0.51f, 0f, 0.98f, -0.29f, 1.2f, -0.74f);
        v12.lineToRelative(1.42f, -2.84f);
        v12.curveToRelative(0.14f, -0.28f, 0.21f, -0.58f, 0.21f, -0.89f);
        v12.lineTo(20f, 8f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(-1.03f, 2.06f);
        v12.curveToRelative(-0.45f, 0.89f, 0.2f, 1.94f, 1.2f, 1.94f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FormatQuoteKt._formatQuote = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

