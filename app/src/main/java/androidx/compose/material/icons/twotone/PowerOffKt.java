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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_powerOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PowerOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPowerOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PowerOffKt {
    private static ImageVector _powerOff;

    static {
    }

    public static final ImageVector getPowerOff(TwoTone arg32) {
        ImageVector v0 = PowerOffKt._powerOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.PowerOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(12.12f, 9f);
        v0_1.lineTo(16f, 12.88f);
        v0_1.lineTo(16f, 9f);
        v0_1.close();
        v0_1.moveTo(11.5f, 17.17f);
        v0_1.lineTo(11.5f, 19f);
        v0_1.horizontalLineToRelative(1f);
        v0_1.verticalLineToRelative(-1.83f);
        v0_1.lineToRelative(1.07f, -1.06f);
        v0_1.lineTo(8f, 10.54f);
        v0_1.verticalLineToRelative(3.11f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(10f, 3f);
        v0_1.lineTo(8f, 3f);
        v0_1.verticalLineToRelative(1.88f);
        v0_1.lineToRelative(2f, 2f);
        v0_1.close();
        v0_1.moveTo(16f, 9f);
        v0_1.verticalLineToRelative(3.88f);
        v0_1.lineToRelative(1.8f, 1.8f);
        v0_1.lineToRelative(0.2f, -0.2f);
        v0_1.lineTo(18f, 9f);
        v0_1.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v0_1.lineTo(16f, 3f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.verticalLineToRelative(4f);
        v0_1.horizontalLineToRelative(-3.88f);
        v0_1.lineToRelative(2f, 2f);
        v0_1.lineTo(16f, 9f);
        v0_1.close();
        v0_1.moveTo(4.12f, 3.84f);
        v0_1.lineTo(2.71f, 5.25f);
        v0_1.lineTo(6f, 8.54f);
        v0_1.verticalLineToRelative(5.96f);
        v0_1.lineTo(9.5f, 18f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineToRelative(5f);
        v0_1.verticalLineToRelative(-3f);
        v0_1.lineToRelative(0.48f, -0.48f);
        v0_1.lineToRelative(4.47f, 4.47f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.lineTo(4.12f, 3.84f);
        v0_1.close();
        v0_1.moveTo(12.5f, 17.17f);
        v0_1.lineTo(12.5f, 19f);
        v0_1.horizontalLineToRelative(-1f);
        v0_1.verticalLineToRelative(-1.83f);
        v0_1.lineTo(8f, 13.65f);
        v0_1.verticalLineToRelative(-3.11f);
        v0_1.lineToRelative(5.57f, 5.57f);
        v0_1.lineToRelative(-1.07f, 1.06f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PowerOffKt._powerOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

