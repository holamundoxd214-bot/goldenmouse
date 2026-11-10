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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cardGiftcard", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CardGiftcard", "Landroidx/compose/material/icons/Icons$Outlined;", "getCardGiftcard", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CardGiftcardKt {
    private static ImageVector _cardGiftcard;

    static {
    }

    public static final ImageVector getCardGiftcard(Outlined arg19) {
        ImageVector v0 = CardGiftcardKt._cardGiftcard;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CardGiftcard", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 6f);
        v12.horizontalLineToRelative(-2.18f);
        v12.curveToRelative(0.11f, -0.31f, 0.18f, -0.65f, 0.18f, -1f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.curveToRelative(-1.05f, 0f, -1.96f, 0.54f, -2.5f, 1.35f);
        v12.lineToRelative(-0.5f, 0.67f);
        v12.lineToRelative(-0.5f, -0.68f);
        v12.curveTo(10.96f, 2.54f, 10.05f, 2f, 9f, 2f);
        v12.curveTo(7.34f, 2f, 6f, 3.34f, 6f, 5f);
        v12.curveToRelative(0f, 0.35f, 0.07f, 0.69f, 0.18f, 1f);
        v12.lineTo(4f, 6f);
        v12.curveToRelative(-1.11f, 0f, -1.99f, 0.89f, -1.99f, 2f);
        v12.lineTo(2f, 19f);
        v12.curveToRelative(0f, 1.11f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.89f, 2f, -2f);
        v12.lineTo(22f, 8f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(15f, 4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.close();
        v12.moveTo(9f, 4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.close();
        v12.moveTo(20f, 19f);
        v12.lineTo(4f, 19f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(20f, 14f);
        v12.lineTo(4f, 14f);
        v12.lineTo(4f, 8f);
        v12.horizontalLineToRelative(5.08f);
        v12.lineTo(7f, 10.83f);
        v12.lineTo(8.62f, 12f);
        v12.lineTo(12f, 7.4f);
        v12.lineToRelative(3.38f, 4.6f);
        v12.lineTo(17f, 10.83f);
        v12.lineTo(14.92f, 8f);
        v12.lineTo(20f, 8f);
        v12.verticalLineToRelative(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CardGiftcardKt._cardGiftcard = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

