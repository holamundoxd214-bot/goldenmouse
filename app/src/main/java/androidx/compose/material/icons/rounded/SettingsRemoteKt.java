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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsRemote", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsRemote", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettingsRemote", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsRemoteKt {
    private static ImageVector _settingsRemote;

    static {
    }

    public static final ImageVector getSettingsRemote(Rounded arg19) {
        ImageVector v0 = SettingsRemoteKt._settingsRemote;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SettingsRemote", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 9f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(10f);
        v12.curveTo(16f, 9.45f, 15.55f, 9f, 15f, 9f);
        v12.close();
        v12.moveTo(12f, 14.25f);
        v12.curveToRelative(-0.69f, 0f, -1.25f, -0.56f, -1.25f, -1.25f);
        v12.reflectiveCurveToRelative(0.56f, -1.25f, 1.25f, -1.25f);
        v12.reflectiveCurveToRelative(1.25f, 0.56f, 1.25f, 1.25f);
        v12.reflectiveCurveTo(12.69f, 14.25f, 12f, 14.25f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7.82f, 6.82f);
        v12.lineTo(7.82f, 6.82f);
        v12.curveToRelative(0.35f, 0.35f, 0.9f, 0.38f, 1.3f, 0.1f);
        v12.curveTo(9.93f, 6.34f, 10.93f, 6f, 12f, 6f);
        v12.curveToRelative(1.07f, 0f, 2.07f, 0.34f, 2.88f, 0.91f);
        v12.curveToRelative(0.4f, 0.28f, 0.95f, 0.26f, 1.3f, -0.09f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.43f, -0.43f, 0.39f, -1.15f, -0.09f, -1.5f);
        v12.curveTo(14.94f, 4.49f, 13.53f, 4f, 12f, 4f);
        v12.curveToRelative(-1.53f, 0f, -2.94f, 0.49f, -4.09f, 1.32f);
        v12.curveTo(7.42f, 5.67f, 7.39f, 6.39f, 7.82f, 6.82f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 0f);
        v12.curveTo(9.36f, 0f, 6.94f, 0.93f, 5.05f, 2.47f);
        v12.curveToRelative(-0.46f, 0.38f, -0.5f, 1.07f, -0.08f, 1.49f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.36f, 0.36f, 0.93f, 0.39f, 1.32f, 0.07f);
        v12.curveTo(7.84f, 2.77f, 9.83f, 2f, 12f, 2f);
        v12.curveToRelative(2.17f, 0f, 4.16f, 0.77f, 5.7f, 2.04f);
        v12.curveToRelative(0.39f, 0.32f, 0.96f, 0.29f, 1.32f, -0.07f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.42f, -0.42f, 0.38f, -1.11f, -0.08f, -1.49f);
        v12.curveTo(17.059999f, 0.93f, 14.64f, 0f, 12f, 0f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsRemoteKt._settingsRemote = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

