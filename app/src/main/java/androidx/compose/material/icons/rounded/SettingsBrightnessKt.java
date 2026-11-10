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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsBrightness", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsBrightness", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettingsBrightness", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsBrightnessKt {
    private static ImageVector _settingsBrightness;

    static {
    }

    public static final ImageVector getSettingsBrightness(Rounded arg19) {
        ImageVector v0 = SettingsBrightnessKt._settingsBrightness;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SettingsBrightness", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 4f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 4f, 2f, 4.9f, 2f, 6f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveTo(22f, 4.9f, 21.1f, 4f, 20f, 4f);
        v12.close();
        v12.moveTo(17.15f, 12.35f);
        v12.lineTo(16f, 13.5f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineToRelative(-2f);
        v12.lineToRelative(-1.15f, 1.15f);
        v12.curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f);
        v12.lineTo(10.5f, 16f);
        v12.horizontalLineToRelative(-2f);
        v12.curveTo(8.22f, 16f, 8f, 15.78f, 8f, 15.5f);
        v12.verticalLineToRelative(-2f);
        v12.lineToRelative(-1.15f, -1.15f);
        v12.curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f);
        v12.lineTo(8f, 10.5f);
        v12.verticalLineToRelative(-2f);
        v12.curveTo(8f, 8.22f, 8.22f, 8f, 8.5f, 8f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(1.15f, -1.15f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.lineTo(13.5f, 8f);
        v12.horizontalLineToRelative(2f);
        v12.curveTo(15.78f, 8f, 16f, 8.22f, 16f, 8.5f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(1.15f, 1.15f);
        v12.curveTo(17.34f, 11.84f, 17.34f, 12.16f, 17.15f, 12.35f);
        v12.close();
        v12.moveTo(12f, 9f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.curveTo(15f, 10.34f, 13.66f, 9f, 12f, 9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsBrightnessKt._settingsBrightness = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

