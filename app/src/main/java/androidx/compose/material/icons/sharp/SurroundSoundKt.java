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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_surroundSound", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SurroundSound", "Landroidx/compose/material/icons/Icons$Sharp;", "getSurroundSound", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SurroundSoundKt {
    private static ImageVector _surroundSound;

    static {
    }

    public static final ImageVector getSurroundSound(Sharp arg19) {
        ImageVector v0 = SurroundSoundKt._surroundSound;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SurroundSound", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 4f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineToRelative(20f);
        v12.verticalLineTo(4f);
        v12.close();
        v12.moveTo(7.76f, 16.24f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.curveTo(4.78f, 16.1f, 4f, 14.05f, 4f, 12f);
        v12.reflectiveCurveToRelative(0.78f, -4.1f, 2.34f, -5.66f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveTo(6.59f, 8.93f, 6f, 10.46f, 6f, 12f);
        v12.reflectiveCurveTo(6.59f, 15.07f, 7.76f, 16.24f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.reflectiveCurveTo(14.21f, 16f, 12f, 16f);
        v12.close();
        v12.moveTo(17.66f, 17.66f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.curveTo(17.41f, 15.07f, 18f, 13.54f, 18f, 12f);
        v12.reflectiveCurveToRelative(-0.59f, -3.07f, -1.76f, -4.24f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.curveTo(19.219999f, 7.9f, 20f, 9.95f, 20f, 12f);
        v12.reflectiveCurveTo(19.219999f, 16.1f, 17.66f, 17.66f);
        v12.close();
        v12.moveTo(12f, 10f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(13.1f, 10f, 12f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SurroundSoundKt._surroundSound = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

