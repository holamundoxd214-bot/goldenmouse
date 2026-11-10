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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_screenSearchDesktop", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenSearchDesktop", "Landroidx/compose/material/icons/Icons$Filled;", "getScreenSearchDesktop", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScreenSearchDesktopKt {
    private static ImageVector _screenSearchDesktop;

    static {
    }

    public static final ImageVector getScreenSearchDesktop(Filled arg19) {
        ImageVector v0 = ScreenSearchDesktopKt._screenSearchDesktop;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ScreenSearchDesktop", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 18f);
        v12.curveTo(21.1f, 18f, 21.99f, 17.1f, 21.99f, 16f);
        v12.lineTo(22f, 6f);
        v12.curveTo(22f, 4.89f, 21.1f, 4f, 20f, 4f);
        v12.lineTo(4f, 4f);
        v12.curveTo(2.89f, 4f, 2f, 4.89f, 2f, 6f);
        v12.lineTo(2f, 16f);
        v12.curveTo(2f, 17.1f, 2.89f, 18f, 4f, 18f);
        v12.lineTo(0f, 18f);
        v12.lineTo(0f, 20f);
        v12.lineTo(24f, 20f);
        v12.lineTo(24f, 18f);
        v12.lineTo(20f, 18f);
        v12.close();
        v12.moveTo(4f, 16f);
        v12.lineTo(4f, 6f);
        v12.lineTo(20f, 6f);
        v12.lineTo(20f, 16f);
        v12.lineTo(20f, 16.01f);
        v12.lineTo(4f, 16f);
        v12.close();
        v12.moveTo(9.097f, 9.953f);
        v12.curveTo(9.097f, 8.926f, 9.933f, 8.089f, 10.961f, 8.089f);
        v12.curveTo(11.988f, 8.089f, 12.825f, 8.926f, 12.825f, 9.953f);
        v12.curveTo(12.825f, 10.98f, 11.988f, 11.817f, 10.961f, 11.817f);
        v12.curveTo(9.933f, 11.817f, 9.097f, 10.98f, 9.097f, 9.953f);
        v12.close();
        v12.moveTo(16.129f, 14.189f);
        v12.lineTo(13.647f, 11.707f);
        v12.curveTo(13.978f, 11.202f, 14.174f, 10.6f, 14.174f, 9.953f);
        v12.curveTo(14.174f, 8.181f, 12.733f, 6.74f, 10.961f, 6.74f);
        v12.curveTo(9.189f, 6.74f, 7.747f, 8.181f, 7.747f, 9.953f);
        v12.curveTo(7.747f, 11.725f, 9.189f, 13.167f, 10.961f, 13.167f);
        v12.curveTo(11.597f, 13.167f, 12.186f, 12.975f, 12.685f, 12.656f);
        v12.lineTo(15.174f, 15.144f);
        v12.lineTo(16.129f, 14.189f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScreenSearchDesktopKt._screenSearchDesktop = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

