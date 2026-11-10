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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_powerSettingsNew", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PowerSettingsNew", "Landroidx/compose/material/icons/Icons$Rounded;", "getPowerSettingsNew", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PowerSettingsNewKt {
    private static ImageVector _powerSettingsNew;

    static {
    }

    public static final ImageVector getPowerSettingsNew(Rounded arg19) {
        ImageVector v0 = PowerSettingsNewKt._powerSettingsNew;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PowerSettingsNew", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.lineTo(13f, 4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(17.139999f, 5.86f);
        v12.curveToRelative(-0.39f, 0.39f, -0.38f, 1f, -0.01f, 1.39f);
        v12.curveToRelative(1.13f, 1.2f, 1.83f, 2.8f, 1.87f, 4.57f);
        v12.curveToRelative(0.09f, 3.83f, -3.08f, 7.13f, -6.91f, 7.17f);
        v12.curveTo(8.18f, 19.049999f, 5f, 15.9f, 5f, 12f);
        v12.curveToRelative(0f, -1.84f, 0.71f, -3.51f, 1.87f, -4.76f);
        v12.curveToRelative(0.37f, -0.39f, 0.37f, -1f, -0.01f, -1.38f);
        v12.curveToRelative(-0.4f, -0.4f, -1.05f, -0.39f, -1.43f, 0.02f);
        v12.curveTo(3.98f, 7.42f, 3.07f, 9.47f, 3f, 11.74f);
        v12.curveToRelative(-0.14f, 4.88f, 3.83f, 9.1f, 8.71f, 9.25f);
        v12.curveToRelative(5.1f, 0.16f, 9.29f, -3.93f, 9.29f, -9f);
        v12.curveToRelative(0f, -2.37f, -0.92f, -4.51f, -2.42f, -6.11f);
        v12.curveToRelative(-0.38f, -0.41f, -1.04f, -0.42f, -1.44f, -0.02f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PowerSettingsNewKt._powerSettingsNew = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

