package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flashOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FlashOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFlashOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlashOffKt {
    private static ImageVector _flashOff;

    static {
    }

    public static final ImageVector getFlashOff(TwoTone arg18) {
        ImageVector v0 = FlashOffKt._flashOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.FlashOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(17f, 10f);
        v0_1.horizontalLineToRelative(-3.61f);
        v0_1.lineToRelative(2.28f, 2.28f);
        v0_1.close();
        v0_1.moveTo(17f, 2f);
        v0_1.lineTo(7f, 2f);
        v0_1.verticalLineToRelative(1.61f);
        v0_1.lineToRelative(6.13f, 6.13f);
        v0_1.close();
        v0_1.moveTo(3.41f, 2.86f);
        v0_1.lineTo(2f, 4.27f);
        v0_1.lineToRelative(5f, 5f);
        v0_1.lineTo(7f, 13f);
        v0_1.horizontalLineToRelative(3f);
        v0_1.verticalLineToRelative(9f);
        v0_1.lineToRelative(3.58f, -6.15f);
        v0_1.lineTo(17.73f, 20f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlashOffKt._flashOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

