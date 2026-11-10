package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_screenRotation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenRotation", "Landroidx/compose/material/icons/Icons$Filled;", "getScreenRotation", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScreenRotationKt {
    private static ImageVector _screenRotation;

    static {
    }

    public static final ImageVector getScreenRotation(Filled arg19) {
        ImageVector v0 = ScreenRotationKt._screenRotation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ScreenRotation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.48f, 2.52f);
        v12.curveToRelative(3.27f, 1.55f, 5.61f, 4.72f, 5.97f, 8.48f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveTo(23.440001f, 4.84f, 18.290001f, 0f, 12f, 0f);
        v12.lineToRelative(-0.66f, 0.03f);
        v12.lineToRelative(3.81f, 3.81f);
        v12.lineToRelative(1.33f, -1.32f);
        v12.close();
        v12.moveTo(10.23f, 1.75f);
        v12.curveToRelative(-0.59f, -0.59f, -1.54f, -0.59f, -2.12f, 0f);
        v12.lineTo(1.75f, 8.11f);
        v12.curveToRelative(-0.59f, 0.59f, -0.59f, 1.54f, 0f, 2.12f);
        v12.lineToRelative(12.02f, 12.02f);
        v12.curveToRelative(0.59f, 0.59f, 1.54f, 0.59f, 2.12f, 0f);
        v12.lineToRelative(6.36f, -6.36f);
        v12.curveToRelative(0.59f, -0.59f, 0.59f, -1.54f, 0f, -2.12f);
        v12.lineTo(10.23f, 1.75f);
        v12.close();
        v12.moveTo(14.83f, 21.190001f);
        v12.lineTo(2.81f, 9.17f);
        v12.lineToRelative(6.36f, -6.36f);
        v12.lineToRelative(12.02f, 12.02f);
        v12.lineToRelative(-6.36f, 6.36f);
        v12.close();
        v12.moveTo(7.52f, 21.48f);
        v12.curveTo(4.25f, 19.940001f, 1.91f, 16.76f, 1.55f, 13f);
        v12.lineTo(0.05f, 13f);
        v12.curveTo(0.56f, 19.16f, 5.71f, 24f, 12f, 24f);
        v12.lineToRelative(0.66f, -0.03f);
        v12.lineToRelative(-3.81f, -3.81f);
        v12.lineToRelative(-1.33f, 1.32f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScreenRotationKt._screenRotation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

