package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsInputAntenna", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsInputAntenna", "Landroidx/compose/material/icons/Icons$Sharp;", "getSettingsInputAntenna", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsInputAntennaKt {
    private static ImageVector _settingsInputAntenna;

    static {
    }

    public static final ImageVector getSettingsInputAntenna(Sharp arg19) {
        ImageVector v0 = SettingsInputAntennaKt._settingsInputAntenna;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SettingsInputAntenna", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 5f);
        v12.curveToRelative(-3.87f, 0f, -7f, 3.13f, -7f, 7f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -2.76f, 2.24f, -5f, 5f, -5f);
        v12.reflectiveCurveToRelative(5f, 2.24f, 5f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -3.87f, -3.13f, -7f, -7f, -7f);
        v12.close();
        v12.moveTo(13f, 14.29f);
        v12.curveToRelative(0.88f, -0.39f, 1.5f, -1.26f, 1.5f, -2.29f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.reflectiveCurveTo(9.5f, 10.62f, 9.5f, 12f);
        v12.curveToRelative(0f, 1.02f, 0.62f, 1.9f, 1.5f, 2.29f);
        v12.verticalLineToRelative(3.3f);
        v12.lineTo(7.59f, 21f);
        v12.lineTo(9f, 22.41f);
        v12.lineToRelative(3f, -3f);
        v12.lineToRelative(3f, 3f);
        v12.lineTo(16.41f, 21f);
        v12.lineTo(13f, 17.59f);
        v12.verticalLineToRelative(-3.3f);
        v12.close();
        v12.moveTo(12f, 1f);
        v12.curveTo(5.93f, 1f, 1f, 5.93f, 1f, 12f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -4.97f, 4.03f, -9f, 9f, -9f);
        v12.reflectiveCurveToRelative(9f, 4.03f, 9f, 9f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -6.07f, -4.93f, -11f, -11f, -11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsInputAntennaKt._settingsInputAntenna = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

