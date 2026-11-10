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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsInputAntenna", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsInputAntenna", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettingsInputAntenna", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsInputAntennaKt {
    private static ImageVector _settingsInputAntenna;

    static {
    }

    public static final ImageVector getSettingsInputAntenna(Rounded arg19) {
        ImageVector v0 = SettingsInputAntennaKt._settingsInputAntenna;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SettingsInputAntenna", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 5f);
        v12.curveToRelative(-3.48f, 0f, -6.37f, 2.54f, -6.91f, 5.87f);
        v12.curveToRelative(-0.1f, 0.59f, 0.39f, 1.13f, 1f, 1.13f);
        v12.curveToRelative(0.49f, 0f, 0.9f, -0.36f, 0.98f, -0.85f);
        v12.curveTo(7.48f, 8.79f, 9.53f, 7f, 12f, 7f);
        v12.reflectiveCurveToRelative(4.52f, 1.79f, 4.93f, 4.15f);
        v12.curveToRelative(0.08f, 0.49f, 0.49f, 0.85f, 0.98f, 0.85f);
        v12.curveToRelative(0.61f, 0f, 1.09f, -0.54f, 0.99f, -1.13f);
        v12.curveTo(18.370001f, 7.54f, 15.48f, 5f, 12f, 5f);
        v12.close();
        v12.moveTo(13f, 14.29f);
        v12.curveToRelative(1.07f, -0.48f, 1.76f, -1.66f, 1.41f, -2.99f);
        v12.curveToRelative(-0.22f, -0.81f, -0.87f, -1.47f, -1.68f, -1.7f);
        v12.curveTo(11.04f, 9.12f, 9.5f, 10.38f, 9.5f, 12f);
        v12.curveToRelative(0f, 1.02f, 0.62f, 1.9f, 1.5f, 2.29f);
        v12.verticalLineToRelative(3.3f);
        v12.lineToRelative(-2.71f, 2.7f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(2.3f, -2.3f);
        v12.lineToRelative(2.3f, 2.3f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.reflectiveCurveToRelative(0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(13f, 17.59f);
        v12.verticalLineTo(14.29f);
        v12.close();
        v12.moveTo(12f, 1f);
        v12.curveTo(6.3f, 1f, 1.61f, 5.34f, 1.05f, 10.9f);
        v12.curveTo(1f, 11.49f, 1.46f, 12f, 2.05f, 12f);
        v12.curveToRelative(0.51f, 0f, 0.94f, -0.38f, 0.99f, -0.88f);
        v12.curveTo(3.48f, 6.56f, 7.33f, 3f, 12f, 3f);
        v12.reflectiveCurveToRelative(8.52f, 3.56f, 8.96f, 8.12f);
        v12.curveToRelative(0.05f, 0.5f, 0.48f, 0.88f, 0.99f, 0.88f);
        v12.curveToRelative(0.59f, 0f, 1.06f, -0.51f, 1f, -1.1f);
        v12.curveTo(22.389999f, 5.34f, 17.700001f, 1f, 12f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsInputAntennaKt._settingsInputAntenna = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

