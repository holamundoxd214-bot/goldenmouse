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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_radio", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Radio", "Landroidx/compose/material/icons/Icons$Outlined;", "getRadio", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RadioKt {
    private static ImageVector _radio;

    static {
    }

    public static final ImageVector getRadio(Outlined arg20) {
        ImageVector v0 = RadioKt._radio;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Radio", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 6f);
        v12.lineTo(8.3f, 6f);
        v12.lineToRelative(8.26f, -3.34f);
        v12.lineTo(15.88f, 1f);
        v12.lineTo(3.24f, 6.15f);
        v12.curveTo(2.51f, 6.43f, 2f, 7.17f, 2f, 8f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(22f, 8f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(20f, 8f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(18f, 9f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(4f, 11f);
        v12.lineTo(4f, 8f);
        v12.horizontalLineToRelative(16f);
        v12.close();
        v12.moveTo(4f, 20f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(7f);
        v12.lineTo(4f, 20f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8f, 16.48f);
        v12.moveToRelative(-2.5f, 0f);
        v12.arcToRelative(2.5f, 2.5f, 0f, true, true, 5f, 0f);
        v12.arcToRelative(2.5f, 2.5f, 0f, true, true, -5f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RadioKt._radio = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

