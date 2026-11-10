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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_powerOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PowerOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getPowerOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PowerOffKt {
    private static ImageVector _powerOff;

    static {
    }

    public static final ImageVector getPowerOff(Rounded arg19) {
        ImageVector v0 = PowerOffKt._powerOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PowerOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 13.66f);
        v12.lineTo(18f, 8.99f);
        v12.curveToRelative(0f, -1f, -1.01f, -2f, -2f, -1.99f);
        v12.lineTo(16f, 4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-3.88f);
        v12.lineToRelative(7.63f, 7.63f);
        v12.curveToRelative(0.15f, -0.3f, 0.25f, -0.63f, 0.25f, -0.97f);
        v12.close();
        v12.moveTo(10f, 4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0.88f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(10f, 4f);
        v12.close();
        v12.moveTo(20.15f, 19.860001f);
        v12.lineToRelative(-7.66f, -7.66f);
        v12.lineToRelative(-5.1f, -5.1f);
        v12.lineToRelative(-2.56f, -2.56f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.63f, 2.63f);
        v12.curveToRelative(-0.03f, 0.13f, -0.05f, 0.27f, -0.05f, 0.41f);
        v12.verticalLineToRelative(4.66f);
        v12.curveToRelative(0f, 0.53f, 0.21f, 1.04f, 0.58f, 1.41f);
        v12.lineTo(9.5f, 18f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.lineToRelative(0.48f, -0.48f);
        v12.lineToRelative(3.76f, 3.76f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.03f, 0f, -1.42f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PowerOffKt._powerOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

