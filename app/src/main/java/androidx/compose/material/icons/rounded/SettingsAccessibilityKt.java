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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsAccessibility", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsAccessibility", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettingsAccessibility", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsAccessibilityKt {
    private static ImageVector _settingsAccessibility;

    static {
    }

    public static final ImageVector getSettingsAccessibility(Rounded arg19) {
        ImageVector v0 = SettingsAccessibilityKt._settingsAccessibility;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SettingsAccessibility", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.74f, 4.96f);
        v12.curveToRelative(-0.13f, -0.53f, -0.67f, -0.85f, -1.2f, -0.73f);
        v12.curveTo(17.16f, 4.77f, 14.49f, 5f, 12f, 5f);
        v12.reflectiveCurveTo(6.84f, 4.77f, 4.46f, 4.24f);
        v12.curveToRelative(-0.54f, -0.12f, -1.07f, 0.19f, -1.2f, 0.73f);
        v12.lineTo(3.24f, 5.02f);
        v12.curveTo(3.11f, 5.56f, 3.43f, 6.12f, 3.97f, 6.24f);
        v12.curveTo(5.59f, 6.61f, 7.34f, 6.86f, 9f, 7f);
        v12.verticalLineToRelative(11f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(1.66f, -0.14f, 3.41f, -0.39f, 5.03f, -0.76f);
        v12.curveToRelative(0.54f, -0.12f, 0.86f, -0.68f, 0.73f, -1.22f);
        v12.lineTo(20.74f, 4.96f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(10.9f, 4f, 12f, 4f);
        v12.close();
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
        SettingsAccessibilityKt._settingsAccessibility = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

