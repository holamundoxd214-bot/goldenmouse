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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_discount", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Discount", "Landroidx/compose/material/icons/Icons$Filled;", "getDiscount", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DiscountKt {
    private static ImageVector _discount;

    static {
    }

    public static final ImageVector getDiscount(Filled arg19) {
        ImageVector v0 = DiscountKt._discount;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Discount", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.79f, 21f);
        v12.lineTo(3f, 11.21f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.53f, 0.21f, 1.04f, 0.59f, 1.41f);
        v12.lineToRelative(7.79f, 7.79f);
        v12.curveToRelative(0.78f, 0.78f, 2.05f, 0.78f, 2.83f, 0f);
        v12.lineToRelative(6.21f, -6.21f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineTo(12.79f, 21f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11.38f, 17.41f);
        v12.curveToRelative(0.78f, 0.78f, 2.05f, 0.78f, 2.83f, 0f);
        v12.lineToRelative(6.21f, -6.21f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineToRelative(-7.79f, -7.79f);
        v12.curveTo(12.25f, 0.21f, 11.74f, 0f, 11.21f, 0f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 0f, 3f, 0.9f, 3f, 2f);
        v12.verticalLineToRelative(6.21f);
        v12.curveToRelative(0f, 0.53f, 0.21f, 1.04f, 0.59f, 1.41f);
        v12.lineTo(11.38f, 17.41f);
        v12.close();
        v12.moveTo(7.25f, 3f);
        v12.curveTo(7.94f, 3f, 8.5f, 3.56f, 8.5f, 4.25f);
        v12.reflectiveCurveTo(7.94f, 5.5f, 7.25f, 5.5f);
        v12.reflectiveCurveTo(6f, 4.94f, 6f, 4.25f);
        v12.reflectiveCurveTo(6.56f, 3f, 7.25f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DiscountKt._discount = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

