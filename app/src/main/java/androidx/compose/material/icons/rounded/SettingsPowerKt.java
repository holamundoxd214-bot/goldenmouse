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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsPower", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsPower", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettingsPower", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsPowerKt {
    private static ImageVector _settingsPower;

    static {
    }

    public static final ImageVector getSettingsPower(Rounded arg19) {
        ImageVector v0 = SettingsPowerKt._settingsPower;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SettingsPower", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 24f);
        v12.lineTo(8f, 24f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(7f, 23.549999f, 7.45f, 24f, 8f, 24f);
        v12.close();
        v12.moveTo(12f, 24f);
        v12.lineTo(12f, 24f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(11f, 23.549999f, 11.45f, 24f, 12f, 24f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(3f);
        v12.curveTo(13f, 2.45f, 12.55f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(15.94f, 5.06f);
        v12.lineToRelative(-0.02f, 0.02f);
        v12.curveTo(15.51f, 5.49f, 15.56f, 6.16f, 16f, 6.54f);
        v12.curveToRelative(1.51f, 1.34f, 2.33f, 3.43f, 1.88f, 5.7f);
        v12.curveToRelative(-0.46f, 2.28f, -2.29f, 4.14f, -4.56f, 4.62f);
        v12.curveTo(9.43f, 17.690001f, 6f, 14.74f, 6f, 11f);
        v12.curveToRelative(0f, -1.78f, 0.78f, -3.37f, 2.01f, -4.47f);
        v12.curveToRelative(0.43f, -0.39f, 0.47f, -1.04f, 0.07f, -1.45f);
        v12.lineTo(8.06f, 5.06f);
        v12.curveTo(7.69f, 4.69f, 7.1f, 4.67f, 6.7f, 5.02f);
        v12.curveToRelative(-2.01f, 1.77f, -3.12f, 4.53f, -2.56f, 7.52f);
        v12.curveToRelative(0.59f, 3.15f, 3.11f, 5.7f, 6.26f, 6.31f);
        v12.curveToRelative(5.12f, 0.99f, 9.6f, -2.9f, 9.6f, -7.85f);
        v12.curveToRelative(0f, -2.38f, -1.05f, -4.52f, -2.71f, -5.99f);
        v12.curveTo(16.9f, 4.67f, 16.309999f, 4.69f, 15.94f, 5.06f);
        v12.close();
        v12.moveTo(16f, 24f);
        v12.lineTo(16f, 24f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(15f, 23.549999f, 15.45f, 24f, 16f, 24f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsPowerKt._settingsPower = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

