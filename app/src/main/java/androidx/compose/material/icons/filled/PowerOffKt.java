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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_powerOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PowerOff", "Landroidx/compose/material/icons/Icons$Filled;", "getPowerOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PowerOffKt {
    private static ImageVector _powerOff;

    static {
    }

    public static final ImageVector getPowerOff(Filled arg19) {
        ImageVector v0 = PowerOffKt._powerOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PowerOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 14.49f);
        v12.lineTo(18f, 9f);
        v12.curveToRelative(0f, -1f, -1.01f, -2.01f, -2f, -2f);
        v12.lineTo(16f, 3f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(-4f);
        v12.lineTo(10f, 3f);
        v12.lineTo(8f, 3f);
        v12.verticalLineToRelative(2.48f);
        v12.lineToRelative(9.51f, 9.5f);
        v12.lineToRelative(0.49f, -0.49f);
        v12.close();
        v12.moveTo(16.24f, 16.26f);
        v12.lineTo(7.2f, 7.2f);
        v12.lineToRelative(-0.01f, 0.01f);
        v12.lineTo(3.98f, 4f);
        v12.lineTo(2.71f, 5.25f);
        v12.lineToRelative(3.36f, 3.36f);
        v12.curveTo(6.04f, 8.74f, 6f, 8.87f, 6f, 9f);
        v12.verticalLineToRelative(5.48f);
        v12.lineTo(9.5f, 18f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(-3f);
        v12.lineToRelative(0.48f, -0.48f);
        v12.lineTo(19.450001f, 22f);
        v12.lineToRelative(1.26f, -1.28f);
        v12.lineToRelative(-4.47f, -4.46f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PowerOffKt._powerOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

