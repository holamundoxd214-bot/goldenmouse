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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_shoppingCartCheckout", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ShoppingCartCheckout", "Landroidx/compose/material/icons/Icons$Rounded;", "getShoppingCartCheckout", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ShoppingCartCheckoutKt {
    private static ImageVector _shoppingCartCheckout;

    static {
    }

    public static final ImageVector getShoppingCartCheckout(Rounded arg19) {
        ImageVector v0 = ShoppingCartCheckoutKt._shoppingCartCheckout;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ShoppingCartCheckout", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 18f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.reflectiveCurveTo(5.9f, 22f, 7f, 22f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(8.1f, 18f, 7f, 18f);
        v12.close();
        v12.moveTo(17f, 18f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.reflectiveCurveToRelative(0.89f, 2f, 1.99f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(18.1f, 18f, 17f, 18f);
        v12.close();
        v12.moveTo(19f, 16f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(7f);
        v12.lineToRelative(1.1f, -2f);
        v12.horizontalLineToRelative(7.45f);
        v12.curveToRelative(0.75f, 0f, 1.41f, -0.41f, 1.75f, -1.03f);
        v12.lineToRelative(3.24f, -6.14f);
        v12.curveToRelative(0.25f, -0.48f, 0.08f, -1.08f, -0.4f, -1.34f);
        v12.curveToRelative(-0.49f, -0.27f, -1.1f, -0.08f, -1.36f, 0.41f);
        v12.lineTo(15.55f, 11f);
        v12.horizontalLineTo(8.53f);
        v12.lineTo(4.54f, 2.57f);
        v12.curveTo(4.38f, 2.22f, 4.02f, 2f, 3.64f, 2f);
        v12.horizontalLineTo(2f);
        v12.curveTo(1.45f, 2f, 1f, 2.45f, 1f, 3f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.lineToRelative(3.6f, 7.59f);
        v12.lineToRelative(-1.35f, 2.44f);
        v12.curveTo(4.52f, 15.37f, 5.48f, 17f, 7f, 17f);
        v12.horizontalLineToRelative(11f);
        v12.curveTo(18.549999f, 17f, 19f, 16.549999f, 19f, 16f);
        v12.close();
        v12.moveTo(11.29f, 2.71f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(2.59f, 2.59f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(-2.59f, 2.59f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(12.17f, 7f);
        v12.lineTo(9f, 7f);
        v12.curveTo(8.45f, 7f, 8f, 6.55f, 8f, 6f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.lineToRelative(3.17f, 0f);
        v12.lineToRelative(-0.88f, -0.88f);
        v12.curveTo(10.9f, 3.73f, 10.9f, 3.1f, 11.29f, 2.71f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ShoppingCartCheckoutKt._shoppingCartCheckout = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

