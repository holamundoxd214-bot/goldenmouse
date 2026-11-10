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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addShoppingCart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddShoppingCart", "Landroidx/compose/material/icons/Icons$Outlined;", "getAddShoppingCart", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddShoppingCartKt {
    private static ImageVector _addShoppingCart;

    static {
    }

    public static final ImageVector getAddShoppingCart(Outlined arg20) {
        ImageVector v0 = AddShoppingCartKt._addShoppingCart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AddShoppingCart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 9f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(13f, 6f);
        v12.horizontalLineToRelative(3f);
        v12.lineTo(16f, 4f);
        v12.horizontalLineToRelative(-3f);
        v12.lineTo(13f, 1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(8f, 4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(3f);
        v12.close();
        v12.moveTo(7f, 18f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.reflectiveCurveTo(5.9f, 22f, 7f, 22f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(17f, 18f);
        v12.curveToRelative(-1.1f, 0f, -1.99f, 0.9f, -1.99f, 2f);
        v12.reflectiveCurveToRelative(0.89f, 2f, 1.99f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(8.1f, 13f);
        v12.horizontalLineToRelative(7.45f);
        v12.curveToRelative(0.75f, 0f, 1.41f, -0.41f, 1.75f, -1.03f);
        v12.lineToRelative(3.86f, -7.01f);
        v12.lineTo(19.42f, 4f);
        v12.lineToRelative(-3.87f, 7f);
        v12.lineTo(8.53f, 11f);
        v12.lineTo(4.27f, 2f);
        v12.lineTo(1f, 2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(3.6f, 7.59f);
        v12.lineToRelative(-1.35f, 2.44f);
        v12.curveTo(4.52f, 15.37f, 5.48f, 17f, 7f, 17f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(7f, 15f);
        v12.lineToRelative(1.1f, -2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddShoppingCartKt._addShoppingCart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

