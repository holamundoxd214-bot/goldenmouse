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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_modeNight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ModeNight", "Landroidx/compose/material/icons/Icons$Outlined;", "getModeNight", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ModeNightKt {
    private static ImageVector _modeNight;

    static {
    }

    public static final ImageVector getModeNight(Outlined arg19) {
        ImageVector v0 = ModeNightKt._modeNight;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.ModeNight", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.5f, 4f);
        v12.curveToRelative(4.41f, 0f, 8f, 3.59f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.59f, 8f, -8f, 8f);
        v12.curveToRelative(-0.34f, 0f, -0.68f, -0.02f, -1.01f, -0.07f);
        v12.curveToRelative(1.91f, -2.16f, 3.01f, -4.98f, 3.01f, -7.93f);
        v12.reflectiveCurveToRelative(-1.1f, -5.77f, -3.01f, -7.93f);
        v12.curveTo(8.82f, 4.02f, 9.16f, 4f, 9.5f, 4f);
        v12.moveTo(9.5f, 2f);
        v12.curveToRelative(-1.82f, 0f, -3.53f, 0.5f, -5f, 1.35f);
        v12.curveToRelative(2.99f, 1.73f, 5f, 4.95f, 5f, 8.65f);
        v12.reflectiveCurveToRelative(-2.01f, 6.92f, -5f, 8.65f);
        v12.curveTo(5.97f, 21.5f, 7.68f, 22f, 9.5f, 22f);
        v12.curveToRelative(5.52f, 0f, 10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(15.02f, 2f, 9.5f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ModeNightKt._modeNight = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

