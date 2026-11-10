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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_priceCheck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PriceCheck", "Landroidx/compose/material/icons/Icons$Outlined;", "getPriceCheck", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PriceCheckKt {
    private static ImageVector _priceCheck;

    static {
    }

    public static final ImageVector getPriceCheck(Outlined arg20) {
        ImageVector v0 = PriceCheckKt._priceCheck;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PriceCheck", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 13f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(8.5f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(5f);
        v12.curveTo(4.45f, 4f, 4f, 4.45f, 4f, 5f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.5f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineTo(10f);
        v12.curveTo(10.55f, 14f, 11f, 13.55f, 11f, 13f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(19.59f, 12.52f);
        v0_1.lineToRelative(-5.66f, 5.65f);
        v0_1.lineToRelative(-2.83f, -2.83f);
        v0_1.lineToRelative(-1.41f, 1.42f);
        v0_1.lineToRelative(4.24f, 4.24f);
        v0_1.lineToRelative(7.07f, -7.07f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PriceCheckKt._priceCheck = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

