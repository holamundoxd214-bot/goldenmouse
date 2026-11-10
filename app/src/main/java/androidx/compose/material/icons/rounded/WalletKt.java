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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wallet", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Wallet", "Landroidx/compose/material/icons/Icons$Rounded;", "getWallet", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WalletKt {
    private static ImageVector _wallet;

    static {
    }

    public static final ImageVector getWallet(Rounded arg19) {
        ImageVector v0 = WalletKt._wallet;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Wallet", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 4f);
        v12.horizontalLineTo(6f);
        v12.curveTo(3.79f, 4f, 2f, 5.79f, 2f, 8f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.verticalLineTo(8f);
        v12.curveTo(22f, 5.79f, 20.209999f, 4f, 18f, 4f);
        v12.close();
        v12.moveTo(16.139999f, 13.77f);
        v12.curveToRelative(-0.24f, 0.2f, -0.57f, 0.28f, -0.88f, 0.2f);
        v12.lineTo(4.15f, 11.25f);
        v12.curveTo(4.45f, 10.52f, 5.16f, 10f, 6f, 10f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(0.67f, 0f, 1.26f, 0.34f, 1.63f, 0.84f);
        v12.lineTo(16.139999f, 13.77f);
        v12.close();
        v12.moveTo(6f, 6f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(0.55f);
        v12.curveTo(19.41f, 8.21f, 18.73f, 8f, 18f, 8f);
        v12.horizontalLineTo(6f);
        v12.curveTo(5.27f, 8f, 4.59f, 8.21f, 4f, 8.55f);
        v12.verticalLineTo(8f);
        v12.curveTo(4f, 6.9f, 4.9f, 6f, 6f, 6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WalletKt._wallet = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

