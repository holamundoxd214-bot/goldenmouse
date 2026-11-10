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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_invertColors", "Landroidx/compose/ui/graphics/vector/ImageVector;", "InvertColors", "Landroidx/compose/material/icons/Icons$Sharp;", "getInvertColors", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class InvertColorsKt {
    private static ImageVector _invertColors;

    static {
    }

    public static final ImageVector getInvertColors(Sharp arg19) {
        ImageVector v0 = InvertColorsKt._invertColors;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.InvertColors", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4.81f);
        v12.lineTo(12f, 19f);
        v12.curveToRelative(-3.31f, 0f, -6f, -2.63f, -6f, -5.87f);
        v12.curveToRelative(0f, -1.56f, 0.62f, -3.03f, 1.75f, -4.14f);
        v12.lineTo(12f, 4.81f);
        v12.moveTo(6.35f, 7.56f);
        v12.lineTo(6.35f, 7.56f);
        v12.curveTo(4.9f, 8.99f, 4f, 10.96f, 4f, 13.13f);
        v12.curveTo(4f, 17.48f, 7.58f, 21f, 12f, 21f);
        v12.curveToRelative(4.42f, 0f, 8f, -3.52f, 8f, -7.87f);
        v12.curveToRelative(0f, -2.17f, -0.9f, -4.14f, -2.35f, -5.57f);
        v12.lineToRelative(0f, 0f);
        v12.lineTo(12f, 2f);
        v12.lineTo(6.35f, 7.56f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        InvertColorsKt._invertColors = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

