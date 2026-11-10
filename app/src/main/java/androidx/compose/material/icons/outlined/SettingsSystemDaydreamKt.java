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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsSystemDaydream", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsSystemDaydream", "Landroidx/compose/material/icons/Icons$Outlined;", "getSettingsSystemDaydream", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsSystemDaydreamKt {
    private static ImageVector _settingsSystemDaydream;

    static {
    }

    public static final ImageVector getSettingsSystemDaydream(Outlined arg19) {
        ImageVector v0 = SettingsSystemDaydreamKt._settingsSystemDaydream;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SettingsSystemDaydream", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 17f);
        v12.lineTo(9f, 17f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -1.93f, 1.36f, -3.56f, 3.22f, -3.92f);
        v12.curveTo(9.04f, 7.8f, 10.47f, 7f, 12f, 7f);
        v12.curveToRelative(1.95f, 0f, 3.66f, 1.28f, 4.26f, 3.09f);
        v12.curveToRelative(1.58f, 0.36f, 2.74f, 1.75f, 2.74f, 3.41f);
        v12.curveToRelative(0f, 1.93f, -1.57f, 3.5f, -3.5f, 3.5f);
        v12.close();
        v12.moveTo(8.74f, 11.02f);
        v12.curveTo(7.74f, 11.15f, 7f, 11.99f, 7f, 13f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(6.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineToRelative(-0.87f);
        v12.lineToRelative(-0.17f, -0.86f);
        v12.curveTo(14.29f, 9.92f, 13.23f, 9f, 12f, 9f);
        v12.curveToRelative(-0.96f, 0f, -1.84f, 0.57f, -2.26f, 1.45f);
        v12.lineToRelative(-0.27f, 0.57f);
        v12.horizontalLineToRelative(-0.73f);
        v12.close();
        v12.moveTo(21f, 3f);
        v12.lineTo(3f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(23f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(21f, 19.01f);
        v12.lineTo(3f, 19.01f);
        v12.lineTo(3f, 4.99f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineToRelative(14.02f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsSystemDaydreamKt._settingsSystemDaydream = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

